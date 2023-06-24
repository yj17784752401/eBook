package cn.wenli.yujiang.entity;

public class Items {


	private int iid;
	private int oid;
	private int bid;
	private String createdate;
	private int count;
	private String price;
	private String total_price;


	@Override
	public String toString() {
		return "Items [iid=" + iid + ", oid=" + oid + ", bid=" + bid + ", createdate=" + createdate + ", count=" + count
				+ ", price=" + price + ", total_price=" + total_price + "]";
	}
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTotal_price() {
		return total_price;
	}
	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}
	
}
