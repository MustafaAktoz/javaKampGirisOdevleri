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
		
		var player=playerService.getById(sell.getPlayerId());
		var campaign = campaignService.getById(sell.getCampaignId());
		System.out.println("'"+player.getFirstName() + "' isimli oyuncu, '" + campaign.getName() + "' isimli kampanyadan yararlanarak, oyunu '" + sell.getPrice() + "' birim fiyattan satýn aldý");
	}
}
