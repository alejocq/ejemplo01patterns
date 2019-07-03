package com.sopra.java.patterns.model.dao;

import java.util.Collection;

public interface IDao<T> extends IGenericDao<T> {
	Collection<T> search(T elemento);
}
