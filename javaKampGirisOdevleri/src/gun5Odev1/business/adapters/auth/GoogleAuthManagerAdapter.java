package gun5Odev1.business.adapters.auth;

import gun5Odev1.business.abstracts.BaseAuthManager;
import gun5Odev1.business.abstracts.UserService;
import gun5Odev1.core.entities.concretes.User;
import gun5Odev1.entities.dtos.LoginDto;
import gun5Odev1.entities.dtos.RegisterDto;

public class GoogleAuthManagerAdapter extends BaseAuthManager {
	
	public GoogleAuthManagerAdapter(UserService userService) {
		super(userService);
	}

	@Override
	public void register(RegisterDto registerDto) {
		System.out.println("-Google hesab� ile kay�t olunuyor...");
		
		var user = new User();
		user.setEmail("mustafa_aktoz@hotmail.com");
		user.setFirstName("Mustafa");
		user.setLastName("Aktoz");
		user.setPassword("123456");
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
		
		var user=userService.getByEmail("mustafa_aktoz@hotmail.com");
		
		if(user==null) {
			System.out.println("Google hesab�n kay�tl� de�il");
			System.out.println("Giri� ba�ar�s�z");
			return;
		} 
		
		if(!user.isStatus()) {
			System.out.println("Hesab�n�z hen�z onaylanmam��, l�tfen mail kutunuzu kontrol ediniz.");
			System.out.println("Giri� ba�ar�s�z");
			return;
		}
		
		System.out.println("Giri� ba�ar�l�");
		System.out.println("Ho� geldin: "+user.getFirstName());
	}
}
