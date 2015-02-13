package net.jmlproductions.mongodemo;

import java.net.UnknownHostException;

import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.Mongo;

public class B_InsertTest
{
	@Test
	public void insertStuff() throws UnknownHostException
	{
		Mongo localMongo = new Mongo();
		DB database = localMongo.getDB("cactus");
		
		database.getCollection("cactus").insert(buildDocument());
		
		// Printing the write result doesn't seem to work
	}
	
	private BasicDBObject buildDocument()
	{
		return new BasicDBObject()
			.append("stuff", "things")
			.append("document", new BasicDBObject("x", "y"));
	}
}
