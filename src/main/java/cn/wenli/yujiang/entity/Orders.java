package cn.wenli.yujiang.entity;

public class Orders {
	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", username=" + username + "]";
	}
	private int oid;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String username;
}
