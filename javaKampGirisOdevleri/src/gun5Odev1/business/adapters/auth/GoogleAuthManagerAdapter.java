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
		System.out.println("-Google hesabý ile kayýt olunuyor...");
		
		var user = new User();
		user.setEmail("mustafa_aktoz@hotmail.com");
		user.setFirstName("Mustafa");
		user.setLastName("Aktoz");
		user.setPassword("123456");
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
		
		var user=userService.getByEmail("mustafa_aktoz@hotmail.com");
		
		if(user==null) {
			System.out.println("Google hesabýn kayýtlý deðil");
			System.out.println("Giriþ baþarýsýz");
			return;
		} 
		
		if(!user.isStatus()) {
			System.out.println("Hesabýnýz henüz onaylanmamýþ, lütfen mail kutunuzu kontrol ediniz.");
			System.out.println("Giriþ baþarýsýz");
			return;
		}
		
		System.out.println("Giriþ baþarýlý");
		System.out.println("Hoþ geldin: "+user.getFirstName());
	}
}
