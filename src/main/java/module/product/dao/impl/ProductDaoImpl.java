package module.product.dao.impl;

import java.io.IOException;
import java.util.Properties;

import module.common.ErrorCodes;
import module.common.Util;
import module.product.dao.ProductDao;
import module.product.dao.connection.DbConnection;
import module.product.dao.helper.ProductDaoHelper;
import module.product.domain.Product;
import module.product.domain.dto.ProductDto;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class ProductDaoImpl implements ProductDao{
	
	private static ProductDaoImpl m_instance = new ProductDaoImpl();
	public static ProductDaoImpl getInstance(){
		return m_instance;
	}
	
	ProductDaoHelper helper = ProductDaoHelper.getInstance();
	
	public Product findPrice(String id) {
		Properties prop=null;
		Product prod=null;
		try {
			prop = Util.getInstance().readFile();
			DB mongoDb = DbConnection.getConnection();
			if(null!=mongoDb){
				DBCollection dbCollection = mongoDb.getCollection(prop.getProperty("dbname"));
				
				DBObject query = new BasicDBObject();
				query.put("_id",id);
				DBObject data = dbCollection.findOne(query);
				prod = helper.populateData(data,id);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prod;
	}
	@Override
	public Product updateProduct(String id, String toBeUpdate) {
		return null;
	}

}
