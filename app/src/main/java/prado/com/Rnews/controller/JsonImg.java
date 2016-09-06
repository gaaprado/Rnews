package prado.com.Rnews.controller;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


/**
 * Created by Prado on 06/09/2016.
 */

public class JsonImg {

    public JsonImg(){
    }

    public static void getImage(String url){

        HttpClient httpClient = HttpClientBuilder.create().build();

        try {

            HttpPost request = new HttpPost("http://192.168.0.109:8080/returnImage/");
            StringEntity params =new StringEntity("{\"url\":\"https://www.theguardian.com/world/2016/sep/05/philippines-president-rodrigo-duterte-barack-obama-son-whore\"} ");
            request.addHeader("content-type", "application/json");

            request.setEntity(params);
            System.out.println(request.toString());
            HttpResponse response = httpClient.execute(request);
            String json = EntityUtils.toString(response.getEntity());
            JsonParser jsonParser = new JsonParser();
            JsonElement element = jsonParser.parse(json);
            JsonElement aux = element.getAsJsonObject().get("img_url");
            System.out.println(aux.getAsString());

        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            httpClient.getConnectionManager().shutdown(); //Deprecated
        }

       // return null;
    }

}
