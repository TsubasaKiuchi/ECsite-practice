package model;

import java.io.Serializable;
import java.util.List;

public class CartmodelBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private UserBean userbean;
	private List<CartBean> cartlist;
	private int totalprice;
	private int tax;

	public UserBean getUserbean() {
		return userbean;
	}

	public void setUserbean(UserBean userbean) {
		this.userbean = userbean;
	}

	public List<CartBean> getCartlist() {
		return cartlist;
	}

	public void setCartlist(List<CartBean> cartlist) {
		this.cartlist = cartlist;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

}