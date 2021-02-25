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
import dao.UserDao;
import model.CartmodelBean;
import model.CategoryBean;
import model.UserBean;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		UserBean userbean = new UserBean();
		UserDao userdao = new UserDao();

		String id = request.getParameter("userid");
		String pass = request.getParameter("password");

		if (id.equals("") || pass.equals("")) {
			request.setAttribute("errorm", "名前またはパスワードが入力されていません。");
			RequestDispatcher rd = request.getRequestDispatcher("/view/Login.jsp");
			rd.forward(request, response);
			return;
		}
		userbean = userdao.insertid(id, pass);
		//userbeanに入ったリターンをdaoから再度呼び出す

		//検索してきた結果がある＝ログインできる
		//ない（null）=ログイン出来ない…
		//ので…
		//if (検索結果!=null)でログインさせる?

		//Stringの場合は＝＝じゃなくて　a.equals("")で判定！
		if (!(userbean.getLoginid().equals("")) && !(userbean.getPass().equals(""))) {
			CartmodelBean cartmodel = new CartmodelBean();
			cartmodel.setUserbean(userbean);
			HttpSession session = request.getSession(true);
			session.setAttribute("cartmodel",cartmodel);//セッションにログインIDを格納！

			CategoryDao categorydao = new CategoryDao();
			ArrayList<CategoryBean> categoryList = new ArrayList<CategoryBean>();
			categoryList = categorydao.category();
			//カテゴリーリストを呼び出している
			request.setAttribute("insertCategory", categoryList);
			RequestDispatcher rd = request.getRequestDispatcher("/view/Search.jsp");
			rd.forward(request, response);
			return;

		} else {
			request.setAttribute("errorm", "名前またはパスワードが一致しません。");
			RequestDispatcher rd = request.getRequestDispatcher("/view/Login.jsp");
			rd.forward(request, response);
			return;
		}
	}

}
