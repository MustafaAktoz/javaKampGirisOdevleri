package gun5Odev1.core.utilities.business;

public class BusinessRules {
	public static String run(String... logics) {
		for(String logic:logics)
			if(logic!=null) return logic;
		
		return null;
	}
}
