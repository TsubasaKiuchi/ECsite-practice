package controller;

import java.io.IOException;
import java.util.ArrayList;

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

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//文字セット
		String word = request.getParameter("ken");//引っ張ってきた検索ワードをwordとして呼ぶ
		int categoryid = Integer.parseInt(request.getParameter("category"));//選択したカテゴリーidをcategoryidとして呼ぶ

		HttpSession session = request.getSession(false); //セッション継続確認
		if (session == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/view/Login.jsp");//ログイン画面に返還
			rd.forward(request, response);
			return;//returnがないと下の処理をしてしまう。
		}

		ProductDao productdao = new ProductDao();
		ArrayList<ProductBean> productlist = new ArrayList<ProductBean>();
		ArrayList<CategoryBean> categoryList = new ArrayList<CategoryBean>();
		CategoryDao categorydao = new CategoryDao();

		categoryList = categorydao.category();
		request.setAttribute("insertCategory", categoryList);//カテゴリーリストの再度追加

		productlist = productdao.product(word, categoryid);
		if (productlist.size() == 0) {
			request.setAttribute("errorm", "検索結果がありません。");
		}
		//リストに何も入っていない状態の時にエラーメッセージを出す

		else {
			request.setAttribute("insertproduct", productlist);//検索結果の格納
		}

		RequestDispatcher rd = request.getRequestDispatcher("/view/Search.jsp");
		rd.forward(request, response);
		return;
	}
}