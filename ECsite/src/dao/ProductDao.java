package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import model.ProductBean;

public class ProductDao {
	public ArrayList<ProductBean> product(String word, int catid) {
		ArrayList<ProductBean> productList = new ArrayList<ProductBean>();

		String url = "jdbc:mysql://localhost/ecsite?useSSL=false";
		String id = "root";
		String pass = "Ikemen22";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, id, pass);
			//パターン１
			if (word.equals("") && catid == 0) {
				String sql = "select * from product";
				pstmt = conn.prepareStatement(sql);
			}
			//パターン２
			else if (!(word.equals("")) && catid == 0) {
				String sql = "select * from product where pro_name like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
			}
			//パターン３
			else if (word.equals("") && catid != 0) {
				String sql = "select * from product where cat_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, catid);
			}
			//パターン４
			else {
				String sql = "select * from product where pro_name like ? and cat_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word + "%");
				pstmt.setInt(2, catid);
			}
			// rs=参照結果を確認したコンテナオブジェクト
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductBean productbean = new ProductBean();//newすることで上書きしない同じ名前のbeanを作る
				productbean.setProcd(rs.getInt("pro_cd"));
				productbean.setProname(rs.getString("pro_name"));
				productbean.setStockno(rs.getInt("stock_no"));
				productbean.setProprice(rs.getInt("pro_price"));
				productbean.setCatid(rs.getInt("cat_id"));
				productList.add(productbean);
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
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return productList;
	}

	public ProductBean productdetail(int procd) {

		ProductBean productbean = new ProductBean();
		String url = "jdbc:mysql://localhost/ecsite?useSSL=false";
		String id = "root";
		String pass = "Ikemen22";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, id, pass);
			String sql = "select * from product where pro_cd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, procd);
			// rs=参照結果を確認したコンテナオブジェクト
			rs = pstmt.executeQuery();

			while (rs.next()) {
				productbean.setProcd(rs.getInt("pro_cd"));
				productbean.setProname(rs.getString("pro_name"));
				productbean.setStockno(rs.getInt("stock_no"));
				productbean.setProprice(rs.getInt("pro_price"));
				productbean.setCatid(rs.getInt("cat_id"));
				productbean.setProimg(rs.getString("pro_img"));
				productbean.setPromsg(rs.getString("pro_msg"));
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
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return productbean;
	}
}
