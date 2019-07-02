package com.sopra.java.patterns.model.dao;

import java.util.Collection;

public interface IDao<T> {
	void insert(T elemento);
	T update(T elemento);
	void delete(T elemento);
	Collection<T> list();
	Collection<T> search(T elemento);
}
