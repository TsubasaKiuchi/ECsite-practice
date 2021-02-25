package model;

import java.io.Serializable;

public class ProductBean implements Serializable {

	private int procd ;
	private String proname = "";
	private int stockno ;
	private int proprice ;
	private int catid ;
	private String proimg = "";
	private String promsg = "";
	public int getProcd() {
		return procd;
	}
	public void setProcd(int procd) {
		this.procd = procd;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public int getStockno() {
		return stockno;
	}
	public void setStockno(int stockno) {
		this.stockno = stockno;
	}
	public int getProprice() {
		return proprice;
	}
	public void setProprice(int proprice) {
		this.proprice = proprice;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getProimg() {
		return proimg;
	}
	public void setProimg(String proimg) {
		this.proimg = proimg;
	}
	public String getPromsg() {
		return promsg;
	}
	public void setPromsg(String promsg) {
		this.promsg = promsg;
	}


}
