package gun4Odev3.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import gun4Odev3.dataAccess.abstracts.SellDao;
import gun4Odev3.entities.concretes.Sell;

public class InMemorySellDao implements SellDao {

	List<Sell> sells;
	
	public InMemorySellDao() {
		this.sells = new ArrayList<Sell>();
	}

	@Override
	public void add(Sell sell) {
		sells.add(sell);
	}
}
