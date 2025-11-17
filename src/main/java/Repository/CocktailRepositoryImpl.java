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
        // First call to get the count
        Cocktail firstCocktail = getObject(0);
        if (firstCocktail == null) return cocktailList;
        
        cocktailList.add(firstCocktail);
        
        // Create async tasks for remaining cocktails
        List<CompletableFuture<Cocktail>> futures = new ArrayList<>();
        for (int i = 1; i < 100; i++) { // Limit to avoid too many requests
            final int index = i;
            futures.add(getObjectAsync(index));
        }
        
        // Wait for all to complete and collect results
        List<Cocktail> asyncResults = futures.stream()
            .map(CompletableFuture::join)
            .filter(cocktail -> cocktail != null)
            .collect(Collectors.toList());
        
        cocktailList.addAll(asyncResults);
        return cocktailList;
    }
    @Override
    public void remove(Cocktail cocktail) {
        cocktail=null;
    }
}