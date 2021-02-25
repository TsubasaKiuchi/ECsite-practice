package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDao;
import dao.ProductDao;
import model.CategoryBean;
import model.ProductBean;

@WebServlet("/productdetails")
public class ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int productcd = Integer.parseInt(request.getParameter("procd"));//数量を呼ぶ⇒数量をbeanに格納する

		HttpSession session = request.getSession(false); //セッション継続確認
		if (session == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/view/Login.jsp");//ログイン画面に返還
			rd.forward(request, response);
			return;
		}

		ProductDao productdao = new ProductDao();
		ProductBean productdetailbean = productdao.productdetail(productcd);
		request.setAttribute("insertproductdetail", productdetailbean);//もってきたデータの格納

		CategoryDao categorydao = new CategoryDao();
		CategoryBean categorydetailcatname = categorydao.productdetaicat(productdetailbean.getCatid());
		request.setAttribute("insertproductcategoryname", categorydetailcatname);//もってきたデータの格納

		RequestDispatcher rd = request.getRequestDispatcher("/view/ProductDetails.jsp");
		rd.forward(request, response);
		return;//returnがないと下の処理をしてしまう。
	}
}