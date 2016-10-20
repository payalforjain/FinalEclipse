package Learning.Spring4Examples.Dao;

import Learning.Spring4Examples.Model.Book;

public interface BookDAO {

	void create(Book p);

	Book readById(String id);

	void update(Book p);

}