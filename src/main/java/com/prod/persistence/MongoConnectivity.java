package com.prod.persistence;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoConnectivity {
    private static MongoConnectivity SINGLE_INSTANCE = new MongoConnectivity();

    private MongoClient mongoClient;

    private static final String MONGO_URI = "mongodb://rest:rest123@ds137263.mlab.com:37263/vsm";

    private MongoConnectivity() {
        mongoClient = MongoClients.create(MONGO_URI);
    }

    public static MongoConnectivity getInstance() {
        return SINGLE_INSTANCE;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }
}
