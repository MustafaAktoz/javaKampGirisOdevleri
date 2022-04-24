package gun5Odev1.business.abstracts;

import java.util.List;

import gun5Odev1.core.entities.concretes.User;

public interface UserService {
	boolean add(User user);
	void update(User user);
	User getById(int id);
	User getByEmail(String email);
	List<User> getAll();
}
