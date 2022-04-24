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
			System.out.println("Kayýt Baþarýsýz");
			return;
		}
			
		System.out.println("Kayýt Baþarýlý");
		sendConfirmationEmail(user.getId());
	}

	@Override
	public void login(LoginDto loginDto) {
		System.out.println("Giriþ yapýlýyor...");
		
		var user=userService.getByEmail(loginDto.getEmail());
		if(user==null) {
			System.out.println("Eposta yanlýþ");
			System.out.println("Giriþ baþarýsýz");
			return;
		} 
		
		if(user.getPassword()!=loginDto.getPassword()) {
			System.out.println("Þifre yanlýþ");
			System.out.println("Giriþ baþarýsýz");
			return;
		}
		
		if(!user.isStatus()) {
			System.out.println("'"+ user.getEmail() +"' emailine sahip hesap henüz onaylanmamýþ, lütfen mail kutunuzu kontrol ediniz.");
			System.out.println("Giriþ baþarýsýz");
			return;
		}
		
		System.out.println("Giriþ baþarýlý");
		System.out.println("Hoþ geldin: " + user.getFirstName());
	}
}
