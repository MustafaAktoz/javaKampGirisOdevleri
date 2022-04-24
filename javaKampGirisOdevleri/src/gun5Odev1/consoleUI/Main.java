package gun5Odev1.consoleUI;

import gun5Odev1.business.abstracts.BaseAuthManager;
import gun5Odev1.business.abstracts.UserService;
import gun5Odev1.business.adapters.auth.GoogleAuthManagerAdapter;
import gun5Odev1.business.concoretes.AuthManager;
import gun5Odev1.business.concoretes.UserManager;
import gun5Odev1.core.entities.concretes.User;
import gun5Odev1.dataAccess.concretes.InMemoryUserDao;
import gun5Odev1.entities.dtos.LoginDto;
import gun5Odev1.entities.dtos.RegisterDto;

public class Main {
	
	private static UserService userService;
	private static BaseAuthManager authManager;
	
	static {
		userService = new UserManager(new InMemoryUserDao());
		authManager = new AuthManager(userService);
	}

	public static void main(String[] args) {
		authManager.register(new RegisterDto("Mustafa","Aktoz","mustafa@hotmail.com","123456"));
		
		System.out.println("");
		
		authManager.login(new LoginDto("mustafa@hotmail.com","123456"));
	}
	
	private static void listUsers() {
		var users=userService.getAll();
		for(User user:users)
			System.out.println(user.getId()+" "+ user.getFirstName()+ " "+user.isStatus());
	}
}
