package gun4Odev2.business.concretes;

import gun4Odev2.business.abstracts.BaseCustomerManager;
import gun4Odev2.business.check.abstracts.CustomerCheckService;
import gun4Odev2.entities.concretes.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager{
	
	CustomerCheckService customerCheckService;
	
	public StarbucksCustomerManager(CustomerCheckService customerCheckService) {
		this.customerCheckService = customerCheckService;
	}
	
	@Override
	public void add(Customer customer) {
		if(!customerCheckService.check(customer)) {
			System.out.println("Kimlik bilgilerinizi kontrol edin");
			return;
		}

		super.add(customer);
	}
}
