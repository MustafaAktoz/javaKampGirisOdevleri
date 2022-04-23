package gun4Odev3.consoleUI;

import gun4Odev3.business.abstracts.CampaignService;
import gun4Odev3.business.abstracts.PlayerService;
import gun4Odev3.business.abstracts.SellService;
import gun4Odev3.business.checking.concretes.EDevletPlayerCheckAdapter;
import gun4Odev3.business.concretes.CampaignManager;
import gun4Odev3.business.concretes.PlayerManager;
import gun4Odev3.business.concretes.SellManager;
import gun4Odev3.dataAccess.concretes.InMemoryCampaignDao;
import gun4Odev3.dataAccess.concretes.InMemoryPlayerDao;
import gun4Odev3.dataAccess.concretes.InMemorySellDao;
import gun4Odev3.entities.concretes.Campaign;
import gun4Odev3.entities.concretes.Player;
import gun4Odev3.entities.concretes.Sell;

public class Main {

	private static PlayerService playerService;
	private static CampaignService campaignService;
	private static SellService sellService;
	
	static {
		var campaignManager= new CampaignManager(new InMemoryCampaignDao());
		var playerManager=new PlayerManager(new InMemoryPlayerDao(),new EDevletPlayerCheckAdapter());
		var sellManager=new SellManager(new InMemorySellDao(),campaignManager,playerManager);
		
		playerService=playerManager;
		campaignService=campaignManager;
		sellService=sellManager;
	}
	
	public static void main(String[] args) {
		var player=new Player(1,"Mustafa","Aktoz",1998,"12345678910");
		playerOperations(player);
		
		System.out.println("");
		var campaign = new Campaign(1,"Yaz kampanyasý", 35);
		campaignOperations(campaign);
		
		System.out.println("");
		var sell=new Sell(1,1,1,100);
		sellOperations(sell);
		
		System.out.println("");
		deleteOperations(player,campaign);
	}

	private static void playerOperations(Player player) {
		System.out.println("-Oyuncu");
		playerService.add(player);
		playerService.update(new Player(1,"Engin","Demiroð",1986,"10987654321"));
		
	}
	
	private static void campaignOperations(Campaign campaign) {
		System.out.println("-Kampanya");
		campaignService.add(campaign);
		campaignService.update(new Campaign(1,"Kýþ kampanyasý", 49));
	}
	
	private static void sellOperations(Sell sell) {
		System.out.println("-Satýþ");
		sellService.add(sell);
	}
	
	private static void deleteOperations(Player player, Campaign campaign) {
		System.out.println("-Sil");
		playerService.delete(player);
		campaignService.delete(campaign);
	}
}
