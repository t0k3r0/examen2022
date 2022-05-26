import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.mod;

import java.util.Arrays;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;



public class Consulta30 {
	/*
	 * Requires the MongoDB Java Driver.
	 * https://mongodb.github.io/mongo-java-driver
	 */
	public static void main(String[] args) {
	Bson filter = mod("grades.score", 7L, 0L);
	Bson project = and(eq("restaurant_id", 1L), eq("name", 1L), eq("grades", 1L));
	Bson sort = eq("restaurant_id", 1L);

	String user = "root"; // the user name
	String source = "admin"; // the name of the database in which the user is defined
	char[] password = {'s','e','c','r','e','t'}; // the password as a character array
	// ...
	MongoCredential credential = MongoCredential.createCredential(user, source, password);
	MongoClient mongoClient = MongoClients.create(
	        MongoClientSettings.builder()
	                .applyToClusterSettings(builder -> 
	                        builder.hosts(Arrays.asList(new ServerAddress("localhost", 27017))))
	                .credential(credential)
	                .build());
	MongoDatabase database = mongoClient.getDatabase("restaurants");
	MongoCollection<Document> collection = database.getCollection("restaurants");
	MongoCursor<Document> result = collection.find(filter)
	    .projection(project)
	    .sort(sort).iterator();
	try {
	    while (result.hasNext()) {
	        System.out.println(result.next().toJson());
	    }
	} finally {
	    result.close();
	}

	}
}
