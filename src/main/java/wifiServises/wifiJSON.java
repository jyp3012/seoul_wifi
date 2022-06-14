package wifiServises;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class wifiJSON {
    final static String ServiceKey = "576c74574f70707036314d62445451";

    public static List<wifi_prameter> getWifiJson () {

        List<wifi_prameter> wiList = new ArrayList<>();

        Long startNum = 1L;
        Long lastNum = 1000L;
        Long totalNum = 0L;
        while (true)
            {

            String wifiUrl = "http://openapi.seoul.go.kr:8088/" + ServiceKey + "/json/TbPublicWifiInfo/"+ startNum + "/" + lastNum;


            try {
                URL url = new URL(wifiUrl);

                BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

                String line = "";
                String result = "";

                while ((line = bf.readLine()) != null) {
                    result = result.concat(line);
                }

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
                JSONObject wifiListResult = (JSONObject) jsonObject.get("TbPublicWifiInfo");
                totalNum = (Long) wifiListResult.get("list_total_count");
                JSONArray wifiInfo = (JSONArray) wifiListResult.get("row");

                for (int i = 0; i < wifiInfo.size(); i++) {
                    wifi_prameter wi = new wifi_prameter();
                    JSONObject obj = (JSONObject) wifiInfo.get(i);
                    wi.setX_SWIFI_MGR_NO(obj.get("X_SWIFI_MGR_NO").toString());
                    wi.setX_SWIFI_WRDOFC(obj.get("X_SWIFI_WRDOFC").toString());
                    wi.setX_SWIFI_MAIN_NM(obj.get("X_SWIFI_MAIN_NM").toString());
                    wi.setX_SWIFI_ADRES1(obj.get("X_SWIFI_ADRES1").toString());
                    wi.setX_SWIFI_ADRES2(obj.get("X_SWIFI_ADRES2").toString());
                    wi.setX_SWIFI_INSTL_FLOOR(obj.get("X_SWIFI_INSTL_FLOOR").toString());
                    wi.setX_SWIFI_INSTL_TY(obj.get("X_SWIFI_INSTL_TY").toString());
                    wi.setX_SWIFI_INSTL_MBY(obj.get("X_SWIFI_INSTL_MBY").toString());
                    wi.setX_SWIFI_SVC_SE(obj.get("X_SWIFI_SVC_SE").toString());
                    wi.setX_SWIFI_CMCWR(obj.get("X_SWIFI_CMCWR").toString());
                    wi.setX_SWIFI_CNSTC_YEAR(obj.get("X_SWIFI_CNSTC_YEAR").toString());
                    wi.setX_SWIFI_INOUT_DOOR(obj.get("X_SWIFI_INOUT_DOOR").toString());
                    wi.setX_SWIFI_REMARS3(obj.get("X_SWIFI_REMARS3").toString());
                    wi.setLAT(obj.get("LAT").toString());
                    wi.setLNT(obj.get("LNT").toString());
                    wi.setWORK_DTTM(obj.get("WORK_DTTM").toString());

                    wiList.add(wi);
                }
            } catch (MalformedURLException e) {
                System.out.println("MalformedURLException : " + e.getMessage());
            } catch (IOException e) {
                System.out.println("IOException : " + e.getMessage());
            } catch (org.json.simple.parser.ParseException e) {
                System.out.println("ParseException : " + e.getMessage());
            }

            if (lastNum + 1000 < totalNum) {
                startNum = lastNum + 1;
                lastNum = lastNum + 1000;
            } else {
                startNum = lastNum + 1;
                lastNum = totalNum;
            }

                if (totalNum < startNum) {
                    break;
                }


            }
        return wiList;
    }

}
