package SpringFrame.Example.Dao;

import SpringFrame.Example.Model.Book;

public interface BookDAO {

	void create(Book p);

	Book readById(String id);

	void update(Book p);

}