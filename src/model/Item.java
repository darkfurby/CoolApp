package model;

public class Item {

	private int itemId;
	private String itemName;
	private int itemPrice;
	private int itemType;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemType() {
		return itemType;
	}
	public void setItemType(int itemType) {
		this.itemType = itemType;
	}
	
	public Item() {
		
	}
	public Item(int itemId, String itemName, int itemPrice, int itemType) {
		setItemId(itemId);
		setItemName(itemName);
		setItemPrice(itemPrice);
		setItemType(itemType);
	}
}
