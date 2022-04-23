package gun4Odev3.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import gun4Odev3.dataAccess.abstracts.CampaignDao;
import gun4Odev3.entities.concretes.Campaign;

public class InMemoryCampaignDao implements CampaignDao {

	private List<Campaign> campaigns;
	
	public InMemoryCampaignDao() {
		this.campaigns = new ArrayList<Campaign>();
	}

	@Override
	public void add(Campaign campaign) {
		campaigns.add(campaign);
	}
	
	@Override
	public void update(Campaign campaign) {
		for(int i=0;i<campaigns.size();i++)
			if(campaigns.get(i).getId()==campaign.getId())
				campaigns.set(i, campaign);
		
	}

	@Override
	public void delete(Campaign campaign) {
		for(int i=0;i<campaigns.size();i++)
			if(campaigns.get(i).getId()==campaign.getId())
				campaigns.remove(i);
	}

	@Override
	public Campaign getById(int id) {
		for(Campaign campaign:campaigns) {
			if(campaign.getId()==id) return campaign;
		}
		
		return null;
	}
}
