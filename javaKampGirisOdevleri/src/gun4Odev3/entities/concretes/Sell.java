package gun4Odev3.entities.concretes;

public class Sell {
	private int id;
	private int playerId;
	private int campaignId;
	private double price;

	public Sell(int id, int playerId, int campaignId, double price) {
		this.id = id;
		this.playerId = playerId;
		this.campaignId = campaignId;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
