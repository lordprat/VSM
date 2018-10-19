package com.prod.persistence;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoOperations {

    private static final String DB_NAME = "vsm";
    private static MongoDatabase mongoDatabase;
    public MongoCollection getCollection(String collectionName) {
        getDatabase();
        return mongoDatabase.getCollection(collectionName);
    }

    public static MongoDatabase getDatabase() {
        if (mongoDatabase == null) {
            MongoClient mongoClient = MongoConnectivity.getInstance().getMongoClient();
            mongoDatabase = mongoClient.getDatabase(DB_NAME);
        }
        return mongoDatabase;
    }

    public <T> void storeDocument(T data, String collectionName) {
        MongoOperations mongoOperations = new MongoOperations();
        mongoOperations.getCollection(collectionName).insertOne(data);
    }
}
