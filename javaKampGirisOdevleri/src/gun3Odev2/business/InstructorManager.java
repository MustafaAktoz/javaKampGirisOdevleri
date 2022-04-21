package gun3Odev2.business;

import gun3Odev2.business.loggers.Logger;
import gun3Odev2.entities.User;

public class InstructorManager extends UserManager{

	public InstructorManager(Logger logger) {
		super(logger);
	}

	@Override
	public void add() {
		System.out.println("Eðitmen eklendi");
		logger.log("log mesajý");
	}
	
	@Override
	public void update() {
		System.out.println("Eðitmen güncellendi");
		logger.log("log mesajý");
	}
	
	@Override
	public User getById(int id) {
		System.out.println("Eðitmen getirildi");
		return null;
	}
}
