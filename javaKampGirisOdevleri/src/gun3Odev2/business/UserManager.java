package gun3Odev2.business;

import gun3Odev2.business.loggers.Logger;
import gun3Odev2.entities.User;

public class UserManager {
	
	Logger logger;
	
	public UserManager(Logger logger) {
		this.logger = logger;
	}

	public void add() {
		System.out.println("Kullan�c� eklendi");
		logger.log("log mesaj�");
	}
	
	public void update() {
		System.out.println("Kullan�c� g�ncellendi");
		logger.log("log mesaj�");
	}
	
	public User getById(int id) {
		System.out.println("Kullan�c� getirildi");
		return null;
	}
}
