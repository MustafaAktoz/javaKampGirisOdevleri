package gun4Odev2.business.check.concretes;

import gun4Odev2.business.check.abstracts.CustomerCheckService;
import gun4Odev2.entities.concretes.Customer;

public class MernisCustomerCheckAdapter implements CustomerCheckService {

	@Override
	public boolean check(Customer customer) {
		if (customer.getFirstName() == "Mustafa" 
				&& customer.getLastName() == "Aktoz"
				&& customer.getYearOfBirth() == 1998 
				&& customer.getNationalityId() == "12345678910") 
			return true;
		
		return false;
	}

}
