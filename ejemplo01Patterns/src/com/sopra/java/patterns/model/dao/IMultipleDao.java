package com.sopra.java.patterns.model.dao;

import java.util.List;

public interface IMultipleDao<T, U> extends IGenericDao<T> {
	List<T> searchByNames(String name);
	T searchById(U id);
}
