package fr.edminecoreteam.proxyapi.fetcher;

import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.UUID;

public class UUIDFetcher
{
    @SuppressWarnings("unused")
    private static final String API_URL = "https://playerdb.co/api/player/minecraft/%s";

    @SuppressWarnings("deprecation")
    public static UUID getUUID(String name) {
        name = name.toLowerCase();
        try {
            HttpURLConnection connection = (HttpURLConnection)new URL(String.format("https://playerdb.co/api/player/minecraft/%s", name)).openConnection();
            connection.setUseCaches(false);
            connection.setDefaultUseCaches(false);
            connection.addRequestProperty("User-Agent", "Mozilla/5.0");
            connection.addRequestProperty("Cache-Control", "no-cache, no-store, must-revalidate");
            connection.addRequestProperty("Pragma", "no-cache");
            connection.setReadTimeout(5000);
            Throwable t = null;
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                try {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        response.append(line);
                    }
                    JsonElement parsed = new JsonParser().parse(response.toString());
                    if (parsed == null || !parsed.isJsonObject()) {
                        return null;
                    }
                    JsonObject data = parsed.getAsJsonObject();
                    return UUID.fromString(data.get("data").getAsJsonObject().get("player").getAsJsonObject().get("id").getAsString());
                }
                finally {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                }
            }
            finally {
                if (t == null) {
                    Throwable exception = null;
                    t = exception;
                }
                else {
                    Throwable exception = null;
                    if (t != exception) {
                        t.addSuppressed(exception);
                    }
                }
            }
        }
        catch (Exception ex) {
            return null;
        }
    }
}
