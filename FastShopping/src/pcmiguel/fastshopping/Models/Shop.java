package pcmiguel.fastshopping.Models;

public class Shop {
	
	private int shopId;
	private String shopName;
	private String coord;
	private String owner;
	private String type;
	
	public Shop(int shopId, String shopName, String coord, String owner, String type) {
		this.shopId = shopId;
		this.shopName = shopName;
		this.coord = coord;
		this.owner = owner;
		this.type = type;
	}

	public int getShopId() {
		return shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public String getCoord() {
		return coord;
	}

	public String getOwner() {
		return owner;
	}

	public String getType() {
		return type;
	}
	
	
	
	

}
