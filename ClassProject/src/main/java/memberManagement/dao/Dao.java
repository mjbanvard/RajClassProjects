package memberManagement.dao;

import java.util.List;

import memberManagement.model.Member;

public interface Dao<T> {

	Member get(int id);

	List<T> getAll();

	void save(T t);

	void update(T t, String[] params);

	void delete(T t);
}
