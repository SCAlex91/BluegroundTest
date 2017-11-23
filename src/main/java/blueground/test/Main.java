package blueground.test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Formatter;


public class Main {

    public static void main(String[] args) throws Exception {

        /* calls a method called getData to parse JSON data from the url */
        JsonObject data = ParseJsonDataFromUrl.getData("http://api.wunderground.com/api/9d40c688d922f7a7/history_20171030/q/NY/New_York.json");

        /* print the JSON Response */
        System.out.println("JSON Response: "+data.toString());


        JsonArray dailysummaryArray = data.get("history").getAsJsonObject().get("dailysummary").getAsJsonArray();
        Formatter formatter = new Formatter();

        String DataTable = formatter.format("%25s%15s%15s%20s \r\n", "Max percentage humidity2", "Max Temp in C", "Min Temp in C", "Precipitation in mm").toString();


      /* For Each Element under dailysummary Array */
        for (JsonElement jsonElement : dailysummaryArray) {

            JsonObject dailysummary = jsonElement.getAsJsonObject();

            String maxHumidity = dailysummary.get("maxhumidity").getAsString();

            String maxTempM = dailysummary.get("maxtempm").getAsString();

            String minTempM = dailysummary.get("mintempm").getAsString();

            String precipM = dailysummary.get("precipm").getAsString();

        //Print Metrics into formatting table
            Formatter fmt = new Formatter();

            DataTable+="\n"+fmt.format("%13s%23s%13s%18s \r\n", maxHumidity, maxTempM, minTempM, precipM).toString();


        }
        /* Generate output in a table format */
        FileGenerator.createFile(DataTable);

    }

}


