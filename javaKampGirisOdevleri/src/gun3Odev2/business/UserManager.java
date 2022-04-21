package gun3Odev2.business;

import gun3Odev2.business.loggers.Logger;
import gun3Odev2.entities.User;

public class UserManager {
	
	Logger logger;
	
	public UserManager(Logger logger) {
		this.logger = logger;
	}

	public void add() {
		System.out.println("Kullanýcý eklendi");
		logger.log("log mesajý");
	}
	
	public void update() {
		System.out.println("Kullanýcý güncellendi");
		logger.log("log mesajý");
	}
	
	public User getById(int id) {
		System.out.println("Kullanýcý getirildi");
		return null;
	}
}
