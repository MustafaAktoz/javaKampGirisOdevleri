package gun4Odev3.business.checking.concretes;

import gun4Odev3.business.checking.abstracts.PlayerCheckService;
import gun4Odev3.entities.concretes.Player;

public class EDevletPlayerCheckAdapter implements PlayerCheckService {

	@Override
	public boolean check(Player player) {
		if (player.getFirstName() == "Mustafa" 
				&& player.getLastName() == "Aktoz"
				&& player.getYearOfBirth() == 1998 
				&& player.getNationalityId() == "12345678910") 
			return true;
		
		return false;
	}

}
