package dataAccessObj;

import java.util.ArrayList;

public interface DAO<T> {
    public int add(T t);

    public int update(T t);

    public int delete(T t);

    public ArrayList<T> selectAll();

    public T selectByID(T t);

    public ArrayList<T> selectByCondition(String condition);
}
