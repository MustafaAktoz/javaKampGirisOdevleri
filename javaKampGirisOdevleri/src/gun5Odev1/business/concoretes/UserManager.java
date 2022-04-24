package gun5Odev1.business.concoretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gun5Odev1.business.abstracts.UserService;
import gun5Odev1.core.entities.concretes.User;
import gun5Odev1.core.utilities.business.BusinessRules;
import gun5Odev1.dataAccess.abstracts.UserDao;

public class UserManager implements UserService{

	private UserDao userDao;
	
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean add(User user) {
		
		var result=BusinessRules.run(
				checkIfPasswordExceededLimit(user.getPassword()),
				checkIfEmailIsInCorrectFormat(user.getEmail()),
				checkIfCheckIfEmailHasBeenUsedBefore(user.getEmail()),
				checkLengthOfFirstName(user.getFirstName()),
				checkLengthOfLastName(user.getLastName())
				);
		
		if(result!=null) {
			System.out.println(result);
			return false;
		}
		
		setId(user);
		userDao.add(user);
		System.out.println("'"+user.getFirstName()+"' isimli kullanýcý eklendi");
		return true;
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public User getById(int id) {
		return userDao.getById(id);
	}

	@Override
	public User getByEmail(String email) {
		return userDao.getByEmail(email);
	}
	
	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}
	
	
	private String checkIfPasswordExceededLimit(String password){
		if(password.length()<6) return "Parola en az 6 karakterden oluþmalýdýr";
		
		return null;
	}
	
	private String checkIfEmailIsInCorrectFormat(String email) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if(!matcher.matches()) return "Emaili yanlýþ formatta girdiniz";
		
		return null;
	}
	
	private String checkIfCheckIfEmailHasBeenUsedBefore(String email) {
		var result=userDao.getByEmail(email);
		if(result!=null) return "Email zaten kullanýlýyor";
		
		return null;
	}
	
	private String checkLengthOfFirstName(String firstName) {
		if(firstName.length()<2) return "Ýsim en az 2 karakterden oluþmalýdýr";
		
		return null;
	}
	
	private String checkLengthOfLastName(String lastName) {
		if(lastName.length()<2) return "Soyisim en az 2 karakterden oluþmalýdýr";
		
		return null;
	}
	
	private void setId(User user) {
		var users = userDao.getAll();
		int biggestId=0;
		for(User currentUser:users)
			if(currentUser.getId()>biggestId)
				biggestId=currentUser.getId();
		
		user.setId(biggestId+1);
	}
}
