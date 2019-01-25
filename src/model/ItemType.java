package model;

public class ItemType {

	private int itemTypeId;
	private String itemTypeName;
	
	
	public int getItemTypeId() {
		return itemTypeId;
	}
	public void setItemTypeId(int itemTypeId) {
		this.itemTypeId = itemTypeId;
	}
	public String getItemTypeName() {
		return itemTypeName;
	}
	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}
	
	public ItemType(int itemTypeId, String itemTypeName) {
		setItemTypeId(itemTypeId);
		setItemTypeName(itemTypeName);
		
	}
	public ItemType() {
		
	}
	
	
	
	
}
