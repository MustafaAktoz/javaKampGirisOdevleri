package gun3Odev2.consoleUI;

import gun3Odev2.business.InstructorManager;
import gun3Odev2.business.StudentManager;
import gun3Odev2.business.UserManager;
import gun3Odev2.business.loggers.FileLogger;

public class Main {

	static FileLogger fileLogger;
	static UserManager[] userManagers;
	
	public static void main(String[] args) {	
		fileLogger=new FileLogger();
		userManagers= new UserManager[] {new StudentManager(fileLogger), new InstructorManager(fileLogger)};
		
		System.out.println("-Ekle");
		runAdds();
		
		System.out.println("");
		System.out.println("-Güncelle");
		runUpdates();
		
		System.out.println("");
		System.out.println("-Getir");
		runGetByIds(1);
	}
	
	static void runAdds() {
		for(UserManager userManager:userManagers) {
			userManager.add();
			System.out.println("---------------------------");
		}
	}
	
	static void runUpdates() {
		for(UserManager userManager:userManagers) {
			userManager.update();
			System.out.println("---------------------------");
		}
	}
	
	static void runGetByIds(int id) {
		for(UserManager userManager:userManagers) {
			userManager.getById(id);
			System.out.println("---------------------------");
		}
	}

}
