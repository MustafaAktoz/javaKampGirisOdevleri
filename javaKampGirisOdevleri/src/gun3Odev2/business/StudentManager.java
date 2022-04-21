package gun3Odev2.business;

import gun3Odev2.business.loggers.Logger;
import gun3Odev2.entities.Student;
import gun3Odev2.entities.User;

public class StudentManager extends UserManager {

	public StudentManager(Logger logger) {
		super(logger);
	}
	
	@Override
	public void add() {
		System.out.println("Öðrenci eklendi");
		logger.log("log mesajý");
	}
	
	@Override
	public void update() {
		System.out.println("Öðrenci güncellendi");
		logger.log("log mesajý");
	}
	
	@Override
	public User getById(int id) {
		System.out.println("Öðrenci getirildi");
		return null;
	}

	public Student getByStudentNo(int studentNo){
		System.out.println("Öðrenci getirildi");
		return null;
	}
}
