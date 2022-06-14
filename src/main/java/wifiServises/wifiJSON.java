package wifiServises;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.*;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.text.ParseException;

public class wifiJSON {


    final static String ServiceKey = "576c74574f70707036314d62445451";

    public wifi_prameter getWifiJson () {

        String wifiUrl = "http://openapi.seoul.go.kr:8088/"+ ServiceKey+ "/json/TbPublicWifiInfo/1/2";

        wifi_prameter wi = new wifi_prameter();
        try {
            URL url = new URL(wifiUrl);

            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));

            String line = "";
            String result = "";

            while ((line = bf.readLine()) != null) {
                result = result.concat(line);
            }

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
            JSONObject wifiListResult = (JSONObject)jsonObject.get("TbPublicWifiInfo");
            JSONObject wifiInfo = (JSONObject)jsonObject.get("row");


            for (int i = 0; i < wifiInfo.size(); i++) {
                wi.setX_SWIFI_MGR_NO(wifiInfo.get("X_SWIFI_MGR_NO").toString());
                wi.setX_SWIFI_WRDOFC(wifiInfo.get("X_SWIFI_WRDOFC").toString());
                wi.setX_SWIFI_MAIN_NM(wifiInfo.get("X_SWIFI_MAIN_NM").toString());
                wi.setX_SWIFI_ADRES1(wifiInfo.get("X_SWIFI_ADRES1").toString());
                wi.setX_SWIFI_ADRES2(wifiInfo.get("X_SWIFI_ADRES2").toString());
                wi.setX_SWIFI_INSTL_FLOOR(wifiInfo.get("X_SWIFI_INSTL_FLOOR").toString());
                wi.setX_SWIFI_INSTL_TY(wifiInfo.get("X_SWIFI_INSTL_TY").toString());
                wi.setX_SWIFI_INSTL_MBY(wifiInfo.get("X_SWIFI_INSTL_MBY").toString());
                wi.setX_SWIFI_SVC_SE(wifiInfo.get("X_SWIFI_SVC_SE").toString());
                wi.setX_SWIFI_CMCWR(wifiInfo.get("X_SWIFI_CMCWR").toString());
                wi.setX_SWIFI_CNSTC_YEAR(wifiInfo.get("X_SWIFI_CNSTC_YEAR").toString());
                wi.setX_SWIFI_INOUT_DOOR(wifiInfo.get("X_SWIFI_INOUT_DOOR").toString());
                wi.setX_SWIFI_REMARS3(wifiInfo.get("X_SWIFI_REMARS3").toString());
                wi.setLAT(wifiInfo.get("LAT").toString());
                wi.setLNT(wifiInfo.get("LNT").toString());
                wi.setWORK_DTTM(wifiInfo.get("WORK_DTTM").toString());
            }
        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException : " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("ParseException : " + e.getMessage());
        }

        return wi;
    }

}
