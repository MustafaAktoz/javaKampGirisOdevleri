package gun4Odev3.business.concretes;

import gun4Odev3.business.abstracts.PlayerService;
import gun4Odev3.business.checking.abstracts.PlayerCheckService;
import gun4Odev3.dataAccess.abstracts.PlayerDao;
import gun4Odev3.entities.concretes.Player;

public class PlayerManager implements PlayerService {

	private PlayerDao playerDao;
	private PlayerCheckService playerCheckService;
	
	public PlayerManager(PlayerDao playerDao, PlayerCheckService playerCheckService) {
		this.playerCheckService = playerCheckService;
		this.playerDao=playerDao;
	}

	@Override
	public void add(Player player) {
		if(!playerCheckService.check(player)) {
			System.out.println("Kimlik bilgilerinizi kontrol ediniz.");
			return;
		}
		
		playerDao.add(player);
		System.out.println("Oyuncu eklendi");
	}

	@Override
	public void update(Player player) {
		playerDao.update(player);
		System.out.println("Oyuncu güncellendi");
	}

	@Override
	public void delete(Player player) {
		playerDao.delete(player);
		System.out.println("Oyuncu silindi");
	}

	@Override
	public Player getById(int id) {
		return playerDao.getById(id);
	}
}
