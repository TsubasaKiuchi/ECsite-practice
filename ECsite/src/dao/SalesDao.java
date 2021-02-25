package dao;
//購入テーブルアクセス用

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import model.CategoryBean;

//servletから受け取ったカート情報からsalesテーブルに情報入力、productテーブルの在庫を減らす
public class SalesDao {
	public CategoryBean productdetaicat(int catid) {
		CategoryBean categorybean = new CategoryBean();

		String url = "jdbc:mysql://localhost/ecsite?useSSL=false";
		String id = "root";
		String pass = "Ikemen22";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, id, pass);
			String sql = "select * from category where cat_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, catid);
			rs = ps.executeQuery();
			// rs=参照結果を確認したコンテナオブジェクト

			if(rs.next()) {
				categorybean.setCategory(rs.getString("cat_name"));
				categorybean.setCategoryid(rs.getInt("cat_id"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return  categorybean;
	}


}
