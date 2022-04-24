package gun5Odev1.business.concoretes;

import gun5Odev1.business.abstracts.BaseAuthManager;
import gun5Odev1.business.abstracts.UserService;
import gun5Odev1.core.entities.concretes.User;
import gun5Odev1.entities.dtos.LoginDto;
import gun5Odev1.entities.dtos.RegisterDto;

public class AuthManager extends BaseAuthManager {

	public AuthManager(UserService userService) {
		super(userService);
	}

	@Override
	public void register(RegisterDto registerDto) {

		var user = new User();
		user.setEmail(registerDto.getEmail());
		user.setFirstName(registerDto.getFirstName());
		user.setLastName(registerDto.getLastName());
		user.setPassword(registerDto.getPassword());
		user.setStatus(false);
		
		var isSuccess=userService.add(user);
		if(!isSuccess) {
			System.out.println("Kay�t Ba�ar�s�z");
			return;
		}
			
		System.out.println("Kay�t Ba�ar�l�");
		sendConfirmationEmail(user.getId());
	}

	@Override
	public void login(LoginDto loginDto) {
		System.out.println("Giri� yap�l�yor...");
		
		var user=userService.getByEmail(loginDto.getEmail());
		if(user==null) {
			System.out.println("Eposta yanl��");
			System.out.println("Giri� ba�ar�s�z");
			return;
		} 
		
		if(user.getPassword()!=loginDto.getPassword()) {
			System.out.println("�ifre yanl��");
			System.out.println("Giri� ba�ar�s�z");
			return;
		}
		
		if(!user.isStatus()) {
			System.out.println("'"+ user.getEmail() +"' emailine sahip hesap hen�z onaylanmam��, l�tfen mail kutunuzu kontrol ediniz.");
			System.out.println("Giri� ba�ar�s�z");
			return;
		}
		
		System.out.println("Giri� ba�ar�l�");
		System.out.println("Ho� geldin: " + user.getFirstName());
	}
}
