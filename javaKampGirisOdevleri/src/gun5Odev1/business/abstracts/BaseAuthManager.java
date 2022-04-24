package gun5Odev1.business.abstracts;

import java.util.Random;

import javax.swing.JOptionPane;

import gun5Odev1.entities.dtos.LoginDto;
import gun5Odev1.entities.dtos.RegisterDto;

public abstract class BaseAuthManager {
	
	protected String confirmationCode;
	protected UserService userService;
	
	public BaseAuthManager(UserService userService) {
		this.userService = userService;
	}
	
	public abstract void register(RegisterDto registerDto);
	public abstract void login(LoginDto loginDto);
	
	public void sendConfirmationEmail(int userId) {
		confirmationCode = String.valueOf(new Random().nextInt(9999));
		
		var user = userService.getById(userId);
		
		System.out.println(user.getEmail() + " adresine doðrulama epostasý gönderildi.");
		System.out.println("Onay Kodunuz:" + confirmationCode);
		
		String enteredConfirmationCode = JOptionPane.showInputDialog("Onay Kodunu Giriniz");
		
		if (enteredConfirmationCode == null) enteredConfirmationCode = "";
		
		if (enteredConfirmationCode.hashCode() != confirmationCode.hashCode()) {
			System.out.println("Onay kodu hatalý, tekrar deneyin");
			return;
		}
		
		user.setStatus(true);
		userService.update(user);
		System.out.println("Eposta doðrulandý, hesap aktifleþtirildi");
	}
}
