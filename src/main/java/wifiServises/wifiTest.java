package wifiServises;

import java.sql.SQLException;

public class wifiTest {
	public static void main(String[] args) throws SQLException {
		
		wifiService wifi = new wifiService();
		wifiJSON wifiJSON = new wifiJSON();


		wifi.insertWifi(wifiJSON.getWifiJson());

		//wifi.selectWifi();
		
		//wifi.selectWifi();


//		wifiJSON.getWifiJson();
		
	}
}