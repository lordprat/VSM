package com.prod.persistence;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.ConnectionString;


public class MongoConnectivity {

    private static final String MONGO_URI = "mongodb://rest:rest123@ds137263.mlab.com:37263/vsm";

    private MongoClient mongoClient;
    private static MongoConnectivity SINGLE_INSTANCE = new MongoConnectivity();


    private MongoConnectivity() {
        mongoClient = MongoClients.create(new ConnectionString(MONGO_URI));
    }

    public static MongoConnectivity getInstance() {
        return SINGLE_INSTANCE;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

}
