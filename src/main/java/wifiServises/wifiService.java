package wifiServises;

import java.sql.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class wifiService {

    public List<wifi_prameter> selectWifi() {

        List<wifi_prameter> wifiPramList = new ArrayList<>();


        Connection con = null;

        try {

            Class.forName("org.sqlite.JDBC");

            String dpFile = "/Users/junyongpark/Desktop/eclipes-workspace/seoul_wifi/wifiDb/wifiTest";
            con = DriverManager.getConnection("jdbc:sqlite:" + dpFile);

            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * from seoul_wifi");
            while (rs.next()) {
                wifi_prameter wifiPram = new wifi_prameter();
                wifiPram.setX_SWIFI_MGR_NO(rs.getString("X_SWIFI_MGR_NO"));
                wifiPram.setX_SWIFI_WRDOFC(rs.getString("X_SWIFI_WRDOFC"));
                wifiPram.setX_SWIFI_MAIN_NM(rs.getString("X_SWIFI_MAIN_NM"));
                wifiPram.setX_SWIFI_ADRES1(rs.getString("X_SWIFI_ADRES1"));
                wifiPram.setX_SWIFI_ADRES2(rs.getString("X_SWIFI_ADRES2"));
                wifiPram.setX_SWIFI_INSTL_FLOOR(rs.getString("X_SWIFI_INSTL_FLOOR"));
                wifiPram.setX_SWIFI_INSTL_TY(rs.getString("X_SWIFI_INSTL_TY"));
                wifiPram.setX_SWIFI_INSTL_MBY(rs.getString("X_SWIFI_INSTL_MBY"));
                wifiPram.setX_SWIFI_SVC_SE(rs.getString("X_SWIFI_SVC_SE"));
                wifiPram.setX_SWIFI_CMCWR(rs.getString("X_SWIFI_CMCWR"));
                wifiPram.setX_SWIFI_CNSTC_YEAR(rs.getString("X_SWIFI_CNSTC_YEAR"));
                wifiPram.setX_SWIFI_INOUT_DOOR(rs.getString("X_SWIFI_INOUT_DOOR"));
                wifiPram.setX_SWIFI_REMARS3(rs.getString("X_SWIFI_REMARS3"));
                wifiPram.setLAT(rs.getString("LAT"));
                wifiPram.setLNT(rs.getString("LNT"));
                wifiPram.setWORK_DTTM(rs.getString("WORK_DTTM"));

                wifiPramList.add(wifiPram);
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
        return wifiPramList;
    }

    public List<wifi_prameter> selectWifiLocat() {

        List<wifi_prameter> wifiPramList = new ArrayList<>();


        Connection con = null;

        try {

            Class.forName("org.sqlite.JDBC");

            String dpFile = "/Users/junyongpark/Desktop/eclipes-workspace/seoul_wifi/wifiDb/wifiTest";
            con = DriverManager.getConnection("jdbc:sqlite:" + dpFile);

            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * from wifi_location");
            while (rs.next()) {
                wifi_prameter wifiPram = new wifi_prameter();
                wifiPram.setX_SWIFI_MGR_NO(rs.getString("X_SWIFI_MGR_NO"));
                wifiPram.setX_SWIFI_WRDOFC(rs.getString("X_SWIFI_WRDOFC"));
                wifiPram.setX_SWIFI_MAIN_NM(rs.getString("X_SWIFI_MAIN_NM"));
                wifiPram.setX_SWIFI_ADRES1(rs.getString("X_SWIFI_ADRES1"));
                wifiPram.setX_SWIFI_ADRES2(rs.getString("X_SWIFI_ADRES2"));
                wifiPram.setX_SWIFI_INSTL_FLOOR(rs.getString("X_SWIFI_INSTL_FLOOR"));
                wifiPram.setX_SWIFI_INSTL_TY(rs.getString("X_SWIFI_INSTL_TY"));
                wifiPram.setX_SWIFI_INSTL_MBY(rs.getString("X_SWIFI_INSTL_MBY"));
                wifiPram.setX_SWIFI_SVC_SE(rs.getString("X_SWIFI_SVC_SE"));
                wifiPram.setX_SWIFI_CMCWR(rs.getString("X_SWIFI_CMCWR"));
                wifiPram.setX_SWIFI_CNSTC_YEAR(rs.getString("X_SWIFI_CNSTC_YEAR"));
                wifiPram.setX_SWIFI_INOUT_DOOR(rs.getString("X_SWIFI_INOUT_DOOR"));
                wifiPram.setX_SWIFI_REMARS3(rs.getString("X_SWIFI_REMARS3"));
                wifiPram.setLAT(rs.getString("LAT"));
                wifiPram.setLNT(rs.getString("LNT"));
                wifiPram.setWORK_DTTM(rs.getString("WORK_DTTM"));

                wifiPramList.add(wifiPram);
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
        return wifiPramList;
    }

//	public List<wifiLocation> selectWifiLocation() {
//
//		List<wifiLocation> wifiLocationList = new ArrayList<>();
//		wifiLocation wifiLocations = new wifiLocation();
//		Connection con = null;
//
//		try {
//
//			Class.forName("org.sqlite.JDBC");
//
//			String dpFile = "/Users/junyongpark/Desktop/eclipes-workspace/seoul_wifi/wifiDb/wifiTest";
//			con = DriverManager.getConnection("jdbc:sqlite:" + dpFile);
//
//			Statement stat = con.createStatement();
//			ResultSet rs = stat.executeQuery("SELECT LAT, LNT from seoul_wifi");
//			while (rs.next()) {
//				wifiLocations.setLat(rs.getString("LAT"));
//				wifiLocations.setLng(rs.getString("LNT"));
//
//				wifiLocationList.add(wifiLocations);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//				}
//			}
//		}
//		return wifiLocationList;
//	}

    public String totalWifi() {

        Connection con = null;
        String MGR_NO = null;

        try {

            Class.forName("org.sqlite.JDBC");

            String dpFile = "/Users/junyongpark/Desktop/eclipes-workspace/seoul_wifi/wifiDb/wifiTest";
            con = DriverManager.getConnection("jdbc:sqlite:" + dpFile);

            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT COUNT(X_SWIFI_MGR_NO) from seoul_wifi");
            while (rs.next()) {
                MGR_NO = rs.getString("COUNT(X_SWIFI_MGR_NO)");
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
        return MGR_NO;
    }

    public int insertWifi(List<wifi_prameter> wiList) throws SQLException {
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

    public int insertWifiLocat(List<wifi_prameter> wiList) throws SQLException {
        int inserted = 0;

        for (int i = 0; i < wiList.size(); i++) {
            wifi_prameter wi = wiList.get(i);
            final String sql = "INSERT INTO wifi_location    (" + "\n"
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

    public List<gps_parameter> listUpGps() {

        Connection con = null;
        gps_parameter gps = new gps_parameter();
        List<gps_parameter> gpsList = new ArrayList<>();

        try {

            Class.forName("org.sqlite.JDBC");

            String dpFile = "/Users/junyongpark/Desktop/eclipes-workspace/seoul_wifi/wifiDb/wifiTest";
            con = DriverManager.getConnection("jdbc:sqlite:" + dpFile);

            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * from gps_hstiory;");
            while (rs.next()) {
                gps.setLat(rs.getString("lat"));
                gps.setLng(rs.getString("lng"));

                gpsList.add(gps);
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
        return gpsList;
    }

    public List<wifi_prameter> findPlace() {
        List<wifi_prameter> wifiParm = selectWifi();
        List<gps_parameter> gpsParm = listUpGps();
        List<wifi_prameter> resultWifi = new ArrayList<>();
        List<Double> locat = new ArrayList<>();
        int cnt = 0;


        double gpsX = 0; //위도
        double gpsY = 0; //경도
        double wifiX = 0;
        double wifiY = 0;
        double minLocat = 0;
        int cntNum = 19;

        for (gps_parameter gps_parameter : gpsParm) {
            gpsX = Double.parseDouble(gps_parameter.getLat());
            gpsY = Double.parseDouble(gps_parameter.getLng());
        }

        for (wifi_prameter wifi : wifiParm) {
            wifiX = Double.parseDouble(wifi.getLAT());
            wifiY = Double.parseDouble(wifi.getLNT());

            if (cnt < 20) {
                resultWifi.add(wifi);
                locat.add(dist(gpsX, gpsY, wifiX, wifiY));
                cnt++;
            }

            minLocat = Collections.min(locat);

            if (cnt == 20) {
                double location = dist(gpsX, gpsY, wifiX, wifiY);
                if (minLocat > location) {
                    locat.remove(minLocat);
                    locat.add(location);
                    resultWifi.remove(cntNum--);
                    resultWifi.add(wifi);
                    if (cntNum == 0) {
                        cntNum = 19;
                    }
                }
            }

        }
        return resultWifi;
    }

    public void deleteWifiLocat() throws SQLException {

        Connection con = null;
		final String sql = "DELETE FROM wifi_location;";
		String dpFile = "/Users/junyongpark/Desktop/eclipes-workspace/seoul_wifi/wifiDb/wifiTest";
		con = DriverManager.getConnection("jdbc:sqlite:" + dpFile);
		PreparedStatement pstmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();

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

    public double dist(double gpsX, double gpsY, double wifiX, double wifiY) {
        double locat = 0;

        double pi = 3.14159265358979323846;
        double gpsLat = gpsX * (pi / 180);
        double gpslng = gpsY * (pi / 180);
        double wifiLat = wifiX * (pi / 180);
        double wifiLng = wifiY * (pi / 180);

        locat = 6378.137 * Math.acos(Math.cos(gpsLat) * Math.cos(gpslng) * Math.cos(wifiLng - gpslng) + Math.sin(gpsLat) * Math.sin(wifiLat));


        return locat;
    }


}