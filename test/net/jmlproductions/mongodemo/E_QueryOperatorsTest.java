package net.jmlproductions.mongodemo;

import java.net.UnknownHostException;
import java.util.function.Consumer;

import org.junit.Before;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class E_QueryOperatorsTest
{
	private DBCollection cactus;
	
	@Before
	public void setup() throws UnknownHostException
	{
		cactus = new Mongo().getDB("cactus").getCollection("cactus");
		cactus.remove(new BasicDBObject());
	}
	
	@Test
	public void queryWithOperators() throws UnknownHostException
	{
		cactus.insert(buildSaguaroCactus());
		cactus.insert(buildTinyCactusOfUnknownType());
		cactus.insert(buildNegativeHeightCactusOfUnknownType());
		
		DBCursor cursor = cactus.find(buildQueryCactus());
		
		cursor.forEach(printObject());
	}
	
	private Consumer<? super DBObject> printObject()
	{
		return (DBObject object) -> System.out.println(object.toString());
	}
	
	private BasicDBObject buildSaguaroCactus()
	{
		return new BasicDBObject()
			.append("type", "Saguaro")
			.append("height", "really stupid large");
	}
	
	private BasicDBObject buildTinyCactusOfUnknownType()
	{
		return new BasicDBObject()
			.append("height", "really freaking small...Whatever it is.");
	}
	
	private BasicDBObject buildNegativeHeightCactusOfUnknownType()
	{
		return new BasicDBObject()
			.append("height", "This one actually grows INTO the ground?  Wat.");
	}
	
	private BasicDBObject buildQueryCactus()
	{
		return new BasicDBObject()
		.append("type", new BasicDBObject("$exists", false));
	}
}
