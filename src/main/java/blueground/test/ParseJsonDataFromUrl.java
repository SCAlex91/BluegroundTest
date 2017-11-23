package blueground.test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class ParseJsonDataFromUrl {





        /**
         * @author charisis
         */

        //method to read all from JSON text
        private static String readAll(Reader rd) throws IOException {
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            return sb.toString();
        }

        //method to parse JSON data from the url
        public static JsonObject getData(String url) throws Exception {
            InputStream is = new URL(url).openStream();
            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                String jsonText = readAll(rd);
                JsonObject json =new Gson().fromJson(jsonText,JsonObject.class);
                return json;
            } finally {
                is.close();
            }
        }
}
