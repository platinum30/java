package app.core.dao;

import java.util.List;

public interface Dao<T, ID> {

	String DBURL = "jdbc:mysql://localhost:3306/db10";
	String DBUSER = "root";
	String DBPASS = "1234";

	ID create(T bean) throws Exception;

	T findById(ID id) throws Exception;

	List<T> findAll() throws Exception;

	void update(T bean) throws Exception;

	boolean delete(ID id) throws Exception;
}
