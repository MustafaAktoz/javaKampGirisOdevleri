package gun5Odev1.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import gun5Odev1.core.entities.concretes.User;
import gun5Odev1.dataAccess.abstracts.UserDao;

public class InMemoryUserDao implements UserDao {
	
	private List<User> users;
	
	public InMemoryUserDao() {
		users=new ArrayList<User>();
	}
	
	@Override
	public void add(User user) {
		users.add(user);
	}

	@Override
	public void update(User user) {
		for(int i=0;i<users.size();i++)
			if(users.get(i).getId()==user.getId())
				users.set(i, user);
	}

	@Override
	public User getById(int id) {
		for(User user:users)
			if(user.getId()==id)
				return user;
		
		return null;
	}

	@Override
	public User getByEmail(String email) {
		for(User user:users)
			if(user.getEmail()==email)
				return user;
		
		return null;
	}

	@Override
	public List<User> getAll() {
		return users;
	}
}
