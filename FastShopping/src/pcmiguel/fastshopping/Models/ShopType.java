package pcmiguel.fastshopping.Models;

import javafx.scene.paint.Color;

public enum ShopType {
	
	ROUPA("Roupa", Color.GREEN, "../Images/clothes_50px.png"),
	RESTAURANTE("Restaurante", Color.RED, "../Images/restaurant_50px.png"),
	DESPORTO("Desporto", Color.BLUE, "../Images/barbell_50px.png"),
	BRINQUEDOS("Brinquedos", Color.ORANGE, "../Images/teddy_bear_filled_50px.png");
	
	private final String type;
	private final Color color;
	private final String image;
	
	private ShopType(String type, Color color, String image) {
		this.type = type;
		this.color = color;
		this.image = image;
	}
	
	public String getType() {
		return type;
	}
	
	public Color getColor() {
		return color;
	}
	
	public String getImage() {
		return image;
	}

}
