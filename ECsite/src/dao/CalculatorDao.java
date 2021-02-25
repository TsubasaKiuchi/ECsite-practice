package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import model.CartBean;

//cartdaoでやること
//商品名の格納　できた！
//合計金額の計算　ビーンから持ってきて計算かな？
//消費税の計算　計算した結果からさらに計算かな？

public class CalculatorDao {
	public void calculate(int addpro) {
	CartBean cartbean = new CartBean();
	int total = cartbean.getTotalprice() + addpro ;
	int totalset = cartbean.setTotalprice();
	cartbean.setTotalprice() =total;
	totalset();
}

}