package gun4Odev3.business.abstracts;

import gun4Odev3.entities.concretes.Player;

public interface PlayerService {
	void add(Player player);
	void update(Player player);
	void delete(Player player);
	
	Player getById(int id);
}
