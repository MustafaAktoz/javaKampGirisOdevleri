package gun4Odev3.business.concretes;

import gun4Odev3.business.abstracts.CampaignService;
import gun4Odev3.business.abstracts.PlayerService;
import gun4Odev3.business.abstracts.SellService;
import gun4Odev3.dataAccess.abstracts.SellDao;
import gun4Odev3.entities.concretes.Sell;

public class SellManager implements SellService {

	SellDao sellDao;
	CampaignService campaignService;
	PlayerService playerService;

	public SellManager(SellDao sellDao, CampaignService campaignService, PlayerService playerService) {
		this.sellDao = sellDao;
		this.campaignService = campaignService;
		this.playerService = playerService;
	}

	@Override
	public void add(Sell sell) {
		campaignService.applyCampaign(sell);
		sellDao.add(sell);
		System.out.println("Oyun, '" + playerService.getById(sell.getPlayerId()).getFirstName() + "' adlý oyuncuya, '" + campaignService.getById(sell.getCampaignId()).getName() + "' isimli kampanya uygulanarak " + sell.getPrice() + " birim fiyattan satýldý");
	}
}
