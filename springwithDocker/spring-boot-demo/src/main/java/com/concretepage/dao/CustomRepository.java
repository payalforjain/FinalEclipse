package com.concretepage.dao;

import com.concretepage.entity.Book;


public interface CustomRepository {

	Book readById(String id);

}