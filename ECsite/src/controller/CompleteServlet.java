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
import dao.SalesDao;
import model.CartmodelBean;
import model.CategoryBean;

//セッションからカート情報を取り出す
//カート情報をdaoに送る
//

@WebServlet("/complete")
public class CompleteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int productcd = Integer.parseInt(request.getParameter("procd"));//数量を呼ぶ⇒数量をbeanに格納する

		HttpSession session = request.getSession(false); //セッション継続確認
		if (session == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/view/Login.jsp");//ログイン画面に返還
			rd.forward(request, response);
			return;
		}

		SalesDao salesdao = new SalesDao();
		CartmodelBean cartmodelbean = new CartmodelBean();
		request.setAttribute("insertproductdetail", productdetailbean);//もってきたデータの格納

		CategoryDao categorydao = new CategoryDao();
		CategoryBean categorydetailcatname = categorydao.productdetaicat(productdetailbean.getCatid());
		request.setAttribute("insertproductcategoryname", categorydetailcatname);//もってきたデータの格納


		RequestDispatcher rd = request.getRequestDispatcher("/view/Complete.jsp");
		rd.forward(request, response);
		return;
	}

}
