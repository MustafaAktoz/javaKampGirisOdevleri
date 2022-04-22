package gun4Odev2.business.check.concretes;

import gun4Odev2.business.check.abstracts.CustomerCheckService;
import gun4Odev2.entities.concretes.Customer;

public class FakeCustomerCheckManager implements CustomerCheckService {

	@Override
	public boolean check(Customer customer) {
		return true;
	}
	
}
