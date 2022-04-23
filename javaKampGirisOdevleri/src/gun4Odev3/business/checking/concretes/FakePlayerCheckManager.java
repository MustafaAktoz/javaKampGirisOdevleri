package gun4Odev3.business.checking.concretes;

import gun4Odev3.business.checking.abstracts.PlayerCheckService;
import gun4Odev3.entities.concretes.Player;

public class FakePlayerCheckManager implements PlayerCheckService{

	@Override
	public boolean check(Player player) {
		return true;
	}

}
