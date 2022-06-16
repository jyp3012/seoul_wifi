package wifiServises;

import java.sql.SQLException;

public class wifiTest {
	public static void main(String[] args) throws SQLException {
		
		wifiService wifi = new wifiService();
		wifiJSON wifiJSON = new wifiJSON();


//		int a = wifi.insertWifi(wifiJSON.getWifiJson());

		System.out.println(wifi.totalWifi());


		//wifi.selectWifi();
		
		//wifi.selectWifi();


//		wifiJSON.getWifiJson();
		
	}
}