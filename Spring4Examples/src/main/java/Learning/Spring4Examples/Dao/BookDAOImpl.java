package Learning.Spring4Examples.Dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;

import Learning.Spring4Examples.Dao.BookDAO;
import Learning.Spring4Examples.Model.Book;


@Repository
public class BookDAOImpl implements  BookDAO {
 
	
	private MongoOperations mongoOps;
	
	 public void setMongoOps(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	public BookDAOImpl(MongoOperations mongoOps){
	        this.mongoOps=mongoOps;
	    }
    private static final String Book_COLLECTION = "book";

 
    public BookDAOImpl(){
        
    }
    
    /* (non-Javadoc)
	 * @see SpringFrame.Example.Dao.BookDAO#create(SpringFrame.Example.Model.Book)
	 */
    @Override
    public void create(Book p) {
    	this.mongoOps.insert(p, Book_COLLECTION);
    }
 
    /* (non-Javadoc)
	 * @see SpringFrame.Example.Dao.BookDAO#readById(java.lang.String)
	 */
    @Override
    public Book readById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return this.mongoOps.findOne(query, Book.class, Book_COLLECTION);
    }
 
    /* (non-Javadoc)
	 * @see SpringFrame.Example.Dao.BookDAO#update(SpringFrame.Example.Model.Book)
	 */
    @Override
    public void update(Book p) {
    	this.mongoOps.save(p, Book_COLLECTION);
    }
 
 
 
}