package Repository;
import MVC.Cocktail.Cocktail;
import org.json.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
public class CocktailRepositoryImpl implements Repository<Cocktail> {
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
    public List<Cocktail> getAllCocktails(){
        List<Cocktail> cocktailList = new ArrayList<>();
        int i=0;
        while(true){
            if(getObject(i)!=null) {
                cocktailList.add(getObject(i));
                i++;
            }
            else{
                break;
            }
        }
        return cocktailList;
    }
    @Override
    public void remove(Cocktail cocktail) {
        cocktail=null;
    }
}