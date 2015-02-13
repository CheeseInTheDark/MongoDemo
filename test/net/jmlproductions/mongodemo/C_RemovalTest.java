package net.jmlproductions.mongodemo;

import java.net.UnknownHostException;

import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.Mongo;

public class C_RemovalTest
{

	@Test
	public void removeStuff() throws UnknownHostException
	{
		Mongo localMongo = new Mongo();
		
		DB database = localMongo.getDB("cactus");
		
		database.getCollection("cactus").remove(new BasicDBObject());
	}
}
