package Essayer;
import java.util.*;
public interface IDao<T> {
	boolean create (T o);
	boolean delete (T o);
	boolean update (T o);
	T findById(int id);
	List<T> findAll();
	

}
