package model;

public class ItemCart {

	private int userId;
	private int itemId;
	private int tranId;
	
	public int getTranId() {
		return tranId;
	}
	public void setTranId(int tranId) {
		this.tranId = tranId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public ItemCart(int userId, int itemId) {
		setUserId(userId);
		setItemId(itemId);
	}
	public ItemCart(int userId, int itemId, int tranId) {
		setUserId(userId);
		setItemId(itemId);
		setTranId(tranId);
	}
	public ItemCart() {};
	
}
