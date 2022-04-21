package gun3Odev2.business;

import gun3Odev2.business.loggers.Logger;
import gun3Odev2.entities.User;

public class InstructorManager extends UserManager{

	public InstructorManager(Logger logger) {
		super(logger);
	}

	@Override
	public void add() {
		System.out.println("E�itmen eklendi");
		logger.log("log mesaj�");
	}
	
	@Override
	public void update() {
		System.out.println("E�itmen g�ncellendi");
		logger.log("log mesaj�");
	}
	
	@Override
	public User getById(int id) {
		System.out.println("E�itmen getirildi");
		return null;
	}
}
