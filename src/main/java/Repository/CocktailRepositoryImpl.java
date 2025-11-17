package Repository;
import MVC.Cocktail.Cocktail;
import org.json.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CocktailRepositoryImpl implements Repository<Cocktail> {
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);
    @Override
    public Cocktail getObject(int i){
        try {
            String url = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'Get' requests to URL :" + url);
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONObject object = new JSONObject(response.toString());
            JSONArray drinks = new JSONArray(object.getJSONArray("drinks").toString());
            String name = drinks.getJSONObject(i).getString("strDrink");
            String image = drinks.getJSONObject(i).getString("strDrinkThumb");
            int id = drinks.getJSONObject(i).getInt("idDrink");
            return new Cocktail(name, image, id);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    // Async version using CompletableFuture
    public CompletableFuture<Cocktail> getObjectAsync(int i){
        return CompletableFuture.supplyAsync(() -> {
            try {
                String url = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail";
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                int responseCode = con.getResponseCode();
                System.out.println("\nSending 'Get' requests to URL :" + url);
                System.out.println("Response Code : " + responseCode);
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                JSONObject object = new JSONObject(response.toString());
                JSONArray drinks = new JSONArray(object.getJSONArray("drinks").toString());
                if (i >= drinks.length()) return null;
                String name = drinks.getJSONObject(i).getString("strDrink");
                String image = drinks.getJSONObject(i).getString("strDrinkThumb");
                int id = drinks.getJSONObject(i).getInt("idDrink");
                return new Cocktail(name, image, id);
            } catch (Exception e) {
                System.out.println(e);
                return null;
            }
        }, executor);
    }
    
    public List<Cocktail> getAllCocktails(){
        List<Cocktail> cocktailList = new ArrayList<>();
        
        try {
            // Single API call to get all cocktails
            String url = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'Get' requests to URL :" + url);
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONObject object = new JSONObject(response.toString());
            JSONArray drinks = new JSONArray(object.getJSONArray("drinks").toString());
            
            System.out.println("Total cocktails to load: " + drinks.length());
            
            // Parse all cocktails directly (no threading needed for parsing JSON)
            for (int i = 0; i < drinks.length(); i++) {
                String name = drinks.getJSONObject(i).getString("strDrink");
                String image = drinks.getJSONObject(i).getString("strDrinkThumb");
                int id = drinks.getJSONObject(i).getInt("idDrink");
                cocktailList.add(new Cocktail(name, image, id));
            }
            
            System.out.println("Loaded " + cocktailList.size() + " cocktails");
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return cocktailList;
    }
    @Override
    public void remove(Cocktail cocktail) {
        cocktail=null;
    }
}