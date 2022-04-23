package gun4Odev2.business.abstracts;

import gun4Odev2.entities.concretes.Customer;

public class BaseCustomerManager implements CustomerService {

	@Override
	public void add(Customer customer) {
		System.out.println(customer.getFirstName() + ": Ýsimli müþteri veritabanýna eklendi");
	}

}
