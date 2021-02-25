package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//購入確認機能制御用クラス
@WebServlet("/confirmation")
public class ConfirmationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	request.setCharacterEncoding("UTF-8");//文字セット

	HttpSession session = request.getSession(false); //セッション継続確認
	if (session == null) {
		RequestDispatcher rd = request.getRequestDispatcher("/view/Login.jsp");//ログイン画面に返還
		rd.forward(request, response);
		return;//returnがないと下の処理をしてしまう。
	}

	RequestDispatcher rd = request.getRequestDispatcher("/view/Confirmation.jsp");
	rd.forward(request, response);
	return;
	}

}

