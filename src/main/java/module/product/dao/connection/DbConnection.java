package module.product.dao.connection;

import java.io.IOException;
import java.util.Properties;
import module.common.Util;
import com.mongodb.DB;
import com.mongodb.MongoClient;


public class DbConnection {
	private static Properties prop = null;
	private DbConnection(){}

	private static DbConnection m_instance = new DbConnection();
	public static DbConnection getInstance() {
		return m_instance;
	}

	public static DB getConnection() throws IOException{
		MongoClient mongoClient=null;
		DB mongoDb=null;
				prop = Util.getInstance().readFile();
				mongoClient = new MongoClient( prop.getProperty("dbhost") ,Integer.parseInt(prop.getProperty("dbport")));
				mongoDb = mongoClient.getDB(prop.getProperty("dbname"));
			
		return mongoDb;
	}

}
