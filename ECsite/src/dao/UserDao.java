package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

//selectでサーチする
import model.UserBean;

public class UserDao {
//メソッドを作る今回はinsertidのdao
	public UserBean insertid(String idx,String passx) {

		UserBean userbean = new UserBean();
		String url = "jdbc:mysql://localhost/ecsite?useSSL=false";
		String id = "root";
		String pass = "Ikemen22";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, id, pass);
			String sql = "select * from user where login_id = ? and login_pw = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, idx);
			ps.setString(2, passx);
			rs = ps.executeQuery();
			// rs=参照結果を確認したコンテナオブジェクト

			if(rs.next()) {
				//userbean. setBean名(rs.getString("カラム名"));でほしい情報をbeanに送る
				userbean. setUserid(rs.getInt("user_id"));
				userbean. setLoginid(rs.getString("login_id"));
				userbean. setPass(rs.getString("login_pw"));
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
		return userbean;
	}

}