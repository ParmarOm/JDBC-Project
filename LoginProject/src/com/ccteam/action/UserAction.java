package com.ccteam.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserAction {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	public UserAction() {
		super();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String checkLogin(String uname, String upwd) {
		String status = "";
		try {
			rs = st.executeQuery("select * from reg_user where UNAME='" + uname + "'and UPWD='" + upwd + "'");
			boolean b = rs.next();
			if (b == true) {
				status = "SUCCESS";
			} else {
				status = "FAILURE";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
