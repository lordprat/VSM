package com.prod.persistence;

import com.google.gson.Gson;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MongoOperations {

    private static final String DB_NAME = "vsm";
    private static MongoDatabase mongoDatabase;
    private Gson gson;

    public MongoOperations()
    {
        gson = new Gson();
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
        String json = gson.toJson(data);
        getCollection(collectionName).insertOne(Document.parse(json));
    }


    public <T> T getDocumentById(Map<String, String> filterIds)
    {
        return null;
    }




    public <T> List<T> getAllDocuments(List<T> documentList, Class<T> clazz, String collectionName)
    {
        MongoCursor<Document> cursor =  getCollection(collectionName).find().iterator();
        try {
            while (cursor.hasNext()) {
                String json = cursor.next().toJson();
                T document = gson.fromJson(json, clazz);
                documentList.add(document);
            }
        } finally {
            cursor.close();
        }

        return documentList;
    }
}
