package gun3Odev2.consoleUI;

import gun3Odev2.business.InstructorManager;
import gun3Odev2.business.StudentManager;
import gun3Odev2.business.UserManager;
import gun3Odev2.business.loggers.FileLogger;

public class Main {

	static FileLogger fileLogger;
	static UserManager[] userManagers;
	
	static {
		fileLogger=new FileLogger();
		userManagers= new UserManager[] {new StudentManager(fileLogger), new InstructorManager(fileLogger)};
	}
	
	public static void main(String[] args) {
		runAdds();
		
		System.out.println("");
		runUpdates();
		
		System.out.println("");
		runGetByIds(1);
	}
	
	static void runAdds() {
		System.out.println("-Ekle");
		for(UserManager userManager:userManagers) {
			userManager.add();
			System.out.println("---------------------------");
		}
	}
	
	static void runUpdates() {
		System.out.println("-Güncelle");
		for(UserManager userManager:userManagers) {
			userManager.update();
			System.out.println("---------------------------");
		}
	}
	
	static void runGetByIds(int id) {
		System.out.println("-Getir");
		for(UserManager userManager:userManagers) {
			userManager.getById(id);
			System.out.println("---------------------------");
		}
	}

}
