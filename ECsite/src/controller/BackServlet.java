package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import model.CategoryBean;

@WebServlet("/back")
public class BackServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			CategoryDao categorydao = new CategoryDao();
			ArrayList<CategoryBean> categoryList = new ArrayList<CategoryBean>();
			categoryList = categorydao.category();
			//カテゴリーリストを呼び出し
			request.setAttribute("insertCategory", categoryList);
			RequestDispatcher rd = request.getRequestDispatcher("/view/Search.jsp");
			rd.forward(request, response);
			return;

	}

}
