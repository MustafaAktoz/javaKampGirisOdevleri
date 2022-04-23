package gun4Odev3.business.concretes;

import gun4Odev3.business.abstracts.CampaignService;
import gun4Odev3.dataAccess.abstracts.CampaignDao;
import gun4Odev3.entities.concretes.Campaign;
import gun4Odev3.entities.concretes.Sell;

public class CampaignManager implements CampaignService {

	CampaignDao campaignDao;
	
	public CampaignManager(CampaignDao campaignDao) {
		this.campaignDao = campaignDao;
	}

	@Override
	public void add(Campaign campaign) {
		campaignDao.add(campaign);
		System.out.println("Kampanya eklendi");
	}
	
	@Override
	public void update(Campaign campaign) {
		campaignDao.update(campaign);
		System.out.println("Kampanya güncellendi");
	}

	@Override
	public void delete(Campaign campaign) {
		campaignDao.delete(campaign);
		System.out.println("Kampanya silindi");
	}

	@Override
	public void applyCampaign(Sell sell) {
		var result = campaignDao.getById(sell.getCampaignId());
		sell.setPrice(sell.getPrice()-(sell.getPrice()*result.getDiscountRate()/100));
		System.out.println("Kampanya uygulandý");
	}

	@Override
	public Campaign getById(int id) {
		return campaignDao.getById(id);
	}
}
