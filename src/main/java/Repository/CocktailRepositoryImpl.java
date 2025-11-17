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
    // Thread pool with 10 worker threads for async operations
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);
    private static final String API_URL = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail";
    
    /**
     * HELPER METHOD: Fetches and parses ALL cocktails from API
     * This method is reused by getObject(), getObjectAsync(), and getAllCocktails()
     * to avoid code duplication.
     */
    private JSONArray fetchAllCocktailsFromAPI() throws Exception {
        // Make HTTP GET request
        URL obj = new URL(API_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'Get' requests to URL :" + API_URL);
        System.out.println("Response Code : " + responseCode);
        
        // Read response
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        
        // Parse and return drinks array
        JSONObject object = new JSONObject(response.toString());
        return new JSONArray(object.getJSONArray("drinks").toString());
    }
    
    /**
     * HELPER METHOD: Converts a single JSON object to Cocktail
     * Extracts name, image, and id from JSON
     */
    private Cocktail jsonToCocktail(JSONObject cocktailJson) {
        String name = cocktailJson.getString("strDrink");
        String image = cocktailJson.getString("strDrinkThumb");
        int id = cocktailJson.getInt("idDrink");
        return new Cocktail(name, image, id);
    }
    
    /**
     * Fetches a single cocktail by index (synchronous version)
     * 
     * NOTE: Still inefficient because it fetches ALL cocktails but returns only one.
     * Consider using getAllCocktails() and getting the cocktail from the list instead.
     */
    @Override
    public Cocktail getObject(int i){
        try {
            JSONArray drinks = fetchAllCocktailsFromAPI();
            if (i >= drinks.length()) return null;
            return jsonToCocktail(drinks.getJSONObject(i));
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    /**
     * Async version using CompletableFuture
     * Runs in background thread, returns immediately
     */
    public CompletableFuture<Cocktail> getObjectAsync(int i){
        return CompletableFuture.supplyAsync(() -> {
            try {
                JSONArray drinks = fetchAllCocktailsFromAPI();
                if (i >= drinks.length()) return null;
                return jsonToCocktail(drinks.getJSONObject(i));
            } catch (Exception e) {
                System.out.println(e);
                return null;
            }
        }, executor);
    }
    
    /**
     * OPTIMIZED: Fetches all cocktails in a single API call
     * This is the most efficient way to get cocktail data.
     */
    public List<Cocktail> getAllCocktails(){
        List<Cocktail> cocktailList = new ArrayList<>();
        
        try {
            JSONArray drinks = fetchAllCocktailsFromAPI();
            System.out.println("Total cocktails to load: " + drinks.length());
            
            // Convert each JSON object to Cocktail
            for (int i = 0; i < drinks.length(); i++) {
                cocktailList.add(jsonToCocktail(drinks.getJSONObject(i)));
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