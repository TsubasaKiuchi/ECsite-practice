package model;

//カート情報格納用クラス
public class CartBean {
	private int procd;
	private int quanity;
	private int proprice;
	private int totalprice;
	private int totaltax;
	private String proname = "";

	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public int getTotaltax() {
		return totaltax;
	}

	public void setTotaltax(int totaltax) {
		this.totaltax = totaltax;
	}

	public int getProcd() {
		return procd;
	}

	public void setProcd(int procd) {
		this.procd = procd;
	}

	public int getProprice() {
		return proprice;
	}

	public void setProprice(int proprice) {
		this.proprice = proprice;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

}