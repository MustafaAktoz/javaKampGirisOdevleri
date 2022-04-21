package gun3Odev2.business.loggers;

public class FileLogger extends Logger {
	
	@Override
	public void log(String message) {
		System.out.println("Dosyaya loglandý:" + message);
	}
}
