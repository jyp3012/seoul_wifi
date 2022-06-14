package wifiServises;

import java.sql.*;
import java.util.List;

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

	public static int insertWifi(List<wifi_prameter> wiList) throws SQLException {
		int inserted = 0;

		for (int i = 0; i < wiList.size(); i++) {
			wifi_prameter wi = wiList.get(i);
			final String sql = "INSERT INTO seoul_wifi     (" + "\n"
					+ "    X_SWIFI_MGR_NO,                  " + "\n"
					+ "    X_SWIFI_WRDOFC,                  " + "\n"
					+ "    X_SWIFI_MAIN_NM,                 " + "\n"
					+ "    X_SWIFI_ADRES1,                  " + "\n"
					+ "    X_SWIFI_ADRES2,                  " + "\n"
					+ "    X_SWIFI_INSTL_FLOOR,             " + "\n"
					+ "    X_SWIFI_INSTL_TY,                " + "\n"
					+ "    X_SWIFI_INSTL_MBY,               " + "\n"
					+ "    X_SWIFI_SVC_SE,                  " + "\n"
					+ "    X_SWIFI_CMCWR,                   " + "\n"
					+ "    X_SWIFI_CNSTC_YEAR,              " + "\n"
					+ "    X_SWIFI_INOUT_DOOR,              " + "\n"
					+ "    X_SWIFI_REMARS3,                 " + "\n"
					+ "    LAT,                             " + "\n"
					+ "    LNT,                             " + "\n"
					+ "    WORK_DTTM                       " + "\n"
					+ ") VALUES (                           " + "\n"
					+ "    ?,                               " + "\n"
					+ "    ?,                               " + "\n"
					+ "    ?,                               " + "\n"
					+ "    ?,                               " + "\n"
					+ "    ?,                               " + "\n"
					+ "    ?,                               " + "\n"
					+ "    ?,                               " + "\n"
					+ "    ?,                               " + "\n"
					+ "    ?,                               " + "\n"
					+ "    ?,                               " + "\n"
					+ "    ?,                               " + "\n"
					+ "    ?,                               " + "\n"
					+ "    ?,                               " + "\n"
					+ "    ?,                               " + "\n"
					+ "    ?,                               " + "\n"
					+ "    ?                                " + "\n"
					+ ")";

			String dpFile = "/Users/junyongpark/Desktop/eclipes-workspace/seoul_wifi/wifiDb/wifiTest";
			Connection con = null;
			con = DriverManager.getConnection("jdbc:sqlite:" + dpFile);
			PreparedStatement pstmt = null;


			try {
				//prepareStatement 생송
				pstmt = con.prepareStatement(sql);

				pstmt.setObject(1, wi.getX_SWIFI_MGR_NO());
				pstmt.setObject(2, wi.getX_SWIFI_WRDOFC());
				pstmt.setObject(3, wi.getX_SWIFI_MAIN_NM());
				pstmt.setObject(4, wi.getX_SWIFI_ADRES1());
				pstmt.setObject(5, wi.getX_SWIFI_ADRES2());
				pstmt.setObject(6, wi.getX_SWIFI_INSTL_FLOOR());
				pstmt.setObject(7, wi.getX_SWIFI_INSTL_TY());
				pstmt.setObject(8, wi.getX_SWIFI_INSTL_MBY());
				pstmt.setObject(9, wi.getX_SWIFI_SVC_SE());
				pstmt.setObject(10, wi.getX_SWIFI_CMCWR());
				pstmt.setObject(11, wi.getX_SWIFI_CNSTC_YEAR());
				pstmt.setObject(12, wi.getX_SWIFI_INOUT_DOOR());
				pstmt.setObject(13, wi.getX_SWIFI_REMARS3());
				pstmt.setObject(14, wi.getLAT());
				pstmt.setObject(15, wi.getLNT());
				pstmt.setObject(16, wi.getWORK_DTTM());

				//쿼리 실행
				pstmt.executeUpdate();

				//입력 건수 조회
				inserted = pstmt.getUpdateCount();

				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());

				if (con != null) {
					con.rollback();
				}

				inserted = -1;
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return inserted;
	}
}