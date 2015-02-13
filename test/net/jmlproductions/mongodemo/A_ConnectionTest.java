package net.jmlproductions.mongodemo;

import java.net.UnknownHostException;

import org.junit.Test;

import com.mongodb.Mongo;


public class A_ConnectionTest
{

	@Test
	public void tryConnecting() throws UnknownHostException
	{
		Mongo localMongo = new Mongo();
		
		for(String databaseName : localMongo.getDatabaseNames())
		{
			System.out.println(databaseName);
		}		
	}
}
