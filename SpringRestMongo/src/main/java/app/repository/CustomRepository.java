package app.repository;

import app.model.Book;


public interface CustomRepository {

	Book readById(String id);

}