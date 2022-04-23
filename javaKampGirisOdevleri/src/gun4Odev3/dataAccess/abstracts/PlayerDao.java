package gun4Odev3.dataAccess.abstracts;

import gun4Odev3.entities.concretes.Player;

public interface PlayerDao {
	void add(Player player);
	void update(Player player);
	void delete(Player player);
	
	Player getById(int id);
}
