package wifiServises;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class wifiTest {
	public static void main(String[] args) throws SQLException {

		wifiJSON wifiJSON = new wifiJSON();


		List<wifi_prameter> arr = new ArrayList<>();
		List<wifi_prameter> locatArr = new ArrayList<>();
		wifiService wifi = new wifiService();
		arr = wifi.findPlace();
		wifi.insertWifiLocat(arr);
		locatArr = wifi.selectWifiLocat();

		for (wifi_prameter x : locatArr) {
			System.out.println(x.getX_SWIFI_MGR_NO());
		}


//		int a = wifi.insertWifi(wifiJSON.getWifiJson());

//		System.out.println(wifi.totalWifi());


		//wifi.selectWifi();
		
		//wifi.selectWifi();


//		wifiJSON.getWifiJson();
		
	}
}