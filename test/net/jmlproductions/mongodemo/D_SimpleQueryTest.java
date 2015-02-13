package net.jmlproductions.mongodemo;

import java.net.UnknownHostException;

import org.junit.Before;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class D_SimpleQueryTest
{
	private DBCollection cactus;
	
	@Before
	public void setup() throws UnknownHostException
	{
		cactus = new Mongo().getDB("cactus").getCollection("cactus");
		cactus.remove(new BasicDBObject());
	}
	
	@Test
	public void simpleQuery() throws UnknownHostException
	{
		cactus.insert(buildCactus());
		
		DBCursor cursor = cactus.find(buildQueryCactus());
		
		System.out.println(cursor.next().toString());
	}
	
	private BasicDBObject buildCactus()
	{
		return new BasicDBObject()
			.append("type", "Prickly Pear")
			.append("height", "kind of short");
	}
	
	private BasicDBObject buildQueryCactus()
	{
		return new BasicDBObject()
		.append("type", "Prickly Pear");
	}
}
