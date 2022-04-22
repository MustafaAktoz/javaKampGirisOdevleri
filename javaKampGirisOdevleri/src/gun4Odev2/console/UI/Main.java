package gun4Odev2.console.UI;

import gun4Odev2.business.abstracts.CustomerService;
import gun4Odev2.business.check.concretes.FakeCustomerCheckManager;
import gun4Odev2.business.check.concretes.MernisCustomerCheckAdapter;
import gun4Odev2.business.concretes.NeroCustomerManager;
import gun4Odev2.business.concretes.StarbucksCustomerManager;
import gun4Odev2.entities.concretes.Customer;

public class Main {

	public static void main(String[] args) {
		CustomerService customerService=new StarbucksCustomerManager(new MernisCustomerCheckAdapter());
		customerService.add(new Customer(1,"Mustafa","Aktoz",1998,"12345678910"));
	}

}
