package com.prod.vsm;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VsmApplication {

	private static MongoClient mongo;
	private static final String MONGO_URI = "mongodb://rest:rest123@ds137263.mlab.com:37263/vsm";

	public static void main(String[] args) {

		SpringApplication.run(VsmApplication.class, args);
	}

//	public static MongoClient getMongoInstance() {
//	    if (mongo == null) {
//	    	mongo = MongoClients.create(MONGO_URI);
//		}
//		return mongo;
//    }
}
