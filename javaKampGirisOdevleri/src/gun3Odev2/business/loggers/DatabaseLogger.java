package gun3Odev2.business.loggers;

public class DatabaseLogger extends Logger {
	
	@Override
	public void log(String message) {
		System.out.println("Veritabanýna loglandý:" + message);
	}
}
