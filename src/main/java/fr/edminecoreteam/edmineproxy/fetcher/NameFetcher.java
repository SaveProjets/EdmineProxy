package fr.edminecoreteam.edmineproxy.fetcher;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.io.InputStream;
import com.google.gson.JsonParser;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

public class NameFetcher
{
    @SuppressWarnings("deprecation")
    public static String fetchName(UUID uuid) throws Exception {
        URL url = new URL("https://api.mojang.com/user/profiles/" + uuid.toString().replace("-", "") + "/names");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.connect();
        if (connection.getResponseCode() == 400) {
            System.err.println("There is no player with the UUID \"" + uuid.toString() + "\"!");
            return null;
        }
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        JsonElement element = new JsonParser().parse((Reader)bufferedReader);
        JsonArray array = element.getAsJsonArray();
        int i = 0;
        if (i < array.size()) {
            JsonObject object = array.get(i).getAsJsonObject();
            return object.get("name").getAsString();
        }
        return null;
    }
}
