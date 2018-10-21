package com.prod.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.*;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class MongoOperations {

    private static final String DB_NAME = "vsm";
    private static MongoDatabase mongoDatabase;
    private ObjectMapper mapper;

    public MongoOperations()
    {
        mapper = new ObjectMapper();
    }

    private static void getDatabase() {
        if (mongoDatabase == null) {
            MongoClient mongoClient = MongoConnectivity.getInstance().getMongoClient();
            mongoDatabase = mongoClient.getDatabase(DB_NAME);
        }
    }

    private MongoCollection getCollection(String collectionName) {
        getDatabase();
        return mongoDatabase.getCollection(collectionName);
    }


    public <T> void storeDocument(T data, String collectionName) {

        String json = "";
        try {
            json = mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        getCollection(collectionName).insertOne(Document.parse(json));
    }


    public <T> List<T> getDocumentById(Bson query, Class<T> clazz, String collectionName)
    {
        List<T> resultList = new ArrayList<T>();
        if (query != null) {
            MongoCursor<Document> cursor = getCollection(collectionName).find(query).projection(Projections.excludeId()).iterator();
            try {
                while (cursor.hasNext()) {
                    String json = cursor.next().toJson();
                    T document = mapper.readValue(json, clazz);
                    resultList.add(document);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                cursor.close();
            }
        }
        return resultList;
    }




    public <T> List<T> getAllDocuments(List<T> documentList, Class<T> clazz, String collectionName)
    {
        MongoCursor<Document> cursor =  getCollection(collectionName).find().projection(Projections.excludeId()).iterator();
        try {
            while (cursor.hasNext()) {
                String json = cursor.next().toJson();
                T document = mapper.readValue(json, clazz);
                documentList.add(document);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }

        return documentList;
    }
}
