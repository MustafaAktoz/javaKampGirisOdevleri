package gun4Odev3.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import gun4Odev3.dataAccess.abstracts.PlayerDao;
import gun4Odev3.entities.concretes.Player;

public class InMemoryPlayerDao implements PlayerDao {

	List<Player> players;
	
	public InMemoryPlayerDao() {
		this.players = new ArrayList<Player>();
	}

	@Override
	public void add(Player player) {
		players.add(player);
	}

	@Override
	public void update(Player player) {
		for(int i=0;i<players.size();i++) {
			if(players.get(i).getId()==player.getId()) 
				players.set(i, player);
		}
	}

	@Override
	public void delete(Player player) {
		for(int i=0;i<players.size();i++) {
			if(players.get(i).getId()==player.getId()) 
				players.remove(i);
		}
	}

	@Override
	public Player getById(int id) {
		for(Player player:players)
			if(player.getId()==id) return player;
		
		return null;
	}
}
