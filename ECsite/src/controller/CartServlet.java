package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CartBean;
import model.CartmodelBean;

//やること
//商品名、単価、税、合計金額をjspに送る

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//文字セット
		int addcart = Integer.parseInt(request.getParameter("addcart"));//カートに挿入した数量を挿入
		String cartproname = request.getParameter("cartproname");//カートに挿入した商品の名前を挿入
		int productprice = Integer.parseInt(request.getParameter("cartproprice"));

		HttpSession session = request.getSession(false); //セッション継続確認
		if (session == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/view/Login.jsp");//ログイン画面に返還
			rd.forward(request, response);
			return;//returnがないと下の処理をしてしまう。
		}

		CartmodelBean cartmodel = (CartmodelBean) session.getAttribute("cartmodel");
		List<CartBean> cartlist = cartmodel.getCartlist();
//		@SuppressWarnings("unchecked")
//		ArrayList<CartBean> cartlist =  (ArrayList<CartBean>) session.getAttribute("cartinfo");
		if (cartlist == null) {
			cartlist = new ArrayList<CartBean>();
		}
			CartBean cartbean = new CartBean();
			cartbean.setQuanity(addcart);
			cartbean.setProprice(productprice);
			cartbean.setProname(cartproname);
			cartlist.add(cartbean);
			cartmodel.setCartlist(cartlist);

			int subtotal = productprice*addcart ;//商品小計
			cartmodel.setTotalprice(subtotal + cartmodel.getTotalprice());//合計金額セット
			int totaltax = (int)(cartmodel.getTotalprice()* 0.1) ;//合計消費税セット
			cartmodel.setTax(totaltax);

			session.setAttribute("cartmodel", cartmodel);

		RequestDispatcher rd = request.getRequestDispatcher("/view/Cart.jsp");
		rd.forward(request, response);
		return;
	}

}