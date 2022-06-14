package wifiServises;

import java.sql.*;

public class wifiService {

	public void selectWifi() {

		Connection con = null;

		try {

			Class.forName("org.sqlite.JDBC");

			String dpFile = "/Users/junyongpark/Desktop/eclipes-workspace/seoul_wifi/wifiDb/wifiTest";
			con = DriverManager.getConnection("jdbc:sqlite:" + dpFile);

			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("SELECT X_SWIFI_MGR_NO from seoul_wifi");
			while (rs.next()) {
				String MGR_NO = rs.getString("X_SWIFI_MGR_NO");

				System.out.println("와이파이 관리 번호:" + MGR_NO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
	}
}