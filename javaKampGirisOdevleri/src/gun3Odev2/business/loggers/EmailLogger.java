package gun3Odev2.business.loggers;

public class EmailLogger extends Logger {
	
	@Override
	public void log(String message) {
		System.out.println("Emaile loglandý:" + message);
	}
}
