package Repository;

import MVC.CocktailDetails.CocktailDetails;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CocktailDetailsRepositoryImpl implements Repository<CocktailDetails>{

    private static final String API_URL_TEMPLATE = "https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=";
    
    /**
     * HELPER METHOD: Fetches cocktail details JSON from API
     * Returns the first (and only) drink object from the response
     */
    private JSONObject fetchCocktailDetailsFromAPI(int cocktailId) throws Exception {
        String url = API_URL_TEMPLATE + cocktailId;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'Get' requests to URL :" + url);
        System.out.println("Response Code : " + responseCode);
        
        // Read response
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        
        // Parse and return the first drink object
        JSONObject object = new JSONObject(response.toString());
        JSONArray drinks = new JSONArray(object.getJSONArray("drinks").toString());
        return drinks.getJSONObject(0);
    }
    
    /**
     * HELPER METHOD: Safely gets a string value from JSON
     * Avoids repeating .get().toString() everywhere
     */
    private String getStringValue(JSONObject json, String key) {
        return json.get(key).toString();
    }

    @Override
    public CocktailDetails getObject(int cocktailId){
        try {
            // Fetch the cocktail JSON (only once!)
            JSONObject drink = fetchCocktailDetailsFromAPI(cocktailId);
            
            // Extract all fields - now much cleaner!
            int id = drink.getInt("idDrink");
            String name = drink.getString("strDrink");
            String altName = getStringValue(drink, "strDrinkAlternate");
            String tags = getStringValue(drink, "strTags");
            String video = getStringValue(drink, "strVideo");
            String category = getStringValue(drink, "strCategory");
            String IBA = getStringValue(drink, "strIBA");
            String alcoholic = getStringValue(drink, "strAlcoholic");
            String glass = getStringValue(drink, "strGlass");
            String instructions = getStringValue(drink, "strInstructions");
            String instructionsEs = getStringValue(drink, "strInstructionsES");
            String instructionsDe = getStringValue(drink, "strInstructionsDE");
            String instructionsFr = getStringValue(drink, "strInstructionsFR");
            String instructionsIt = getStringValue(drink, "strInstructionsIT");
            String instructionsZhHANS = getStringValue(drink, "strInstructionsZH-HANS");
            String instructionsZhHANT = getStringValue(drink, "strInstructionsZH-HANT");
            String image = getStringValue(drink, "strDrinkThumb");
            
            // Ingredients
            String ingredient1 = getStringValue(drink, "strIngredient1");
            String ingredient2 = getStringValue(drink, "strIngredient2");
            String ingredient3 = getStringValue(drink, "strIngredient3");
            String ingredient4 = getStringValue(drink, "strIngredient4");
            String ingredient5 = getStringValue(drink, "strIngredient5");
            String ingredient6 = getStringValue(drink, "strIngredient6");
            String ingredient7 = getStringValue(drink, "strIngredient7");
            String ingredient8 = getStringValue(drink, "strIngredient8");
            String ingredient9 = getStringValue(drink, "strIngredient9");
            String ingredient10 = getStringValue(drink, "strIngredient10");
            String ingredient11 = getStringValue(drink, "strIngredient11");
            String ingredient12 = getStringValue(drink, "strIngredient12");
            String ingredient13 = getStringValue(drink, "strIngredient13");
            String ingredient14 = getStringValue(drink, "strIngredient14");
            String ingredient15 = getStringValue(drink, "strIngredient15");
            
            // Measures
            String measure1 = getStringValue(drink, "strMeasure1");
            String measure2 = getStringValue(drink, "strMeasure2");
            String measure3 = getStringValue(drink, "strMeasure3");
            String measure4 = getStringValue(drink, "strMeasure4");
            String measure5 = getStringValue(drink, "strMeasure5");
            String measure6 = getStringValue(drink, "strMeasure6");
            String measure7 = getStringValue(drink, "strMeasure7");
            String measure8 = getStringValue(drink, "strMeasure8");
            String measure9 = getStringValue(drink, "strMeasure9");
            String measure10 = getStringValue(drink, "strMeasure10");
            String measure11 = getStringValue(drink, "strMeasure11");
            String measure12 = getStringValue(drink, "strMeasure12");
            String measure13 = getStringValue(drink, "strMeasure13");
            String measure14 = getStringValue(drink, "strMeasure14");
            String measure15 = getStringValue(drink, "strMeasure15");
            
            // Metadata
            String imageSource = getStringValue(drink, "strImageSource");
            String imageAttribution = getStringValue(drink, "strImageAttribution");
            String creativeCommonsConfirmed = getStringValue(drink, "strCreativeCommonsConfirmed");
            String date = getStringValue(drink, "dateModified");
            
            // Create and return CocktailDetails object
            return new CocktailDetails(id,name,altName,tags,video,category,IBA,alcoholic,glass,
                    instructions,instructionsEs,instructionsDe,instructionsFr,
                    instructionsIt,instructionsZhHANS,instructionsZhHANT,image,
                    ingredient1,ingredient2,ingredient3,ingredient4,ingredient5,
                    ingredient6,ingredient7,ingredient8,ingredient9,ingredient10,
                    ingredient11,ingredient12,ingredient13,ingredient14,ingredient15,
                    measure1,measure2,measure3,measure4,measure5,
                    measure6,measure7,measure8,measure9,measure10,
                    measure11,measure12,measure13,measure14,measure15,
                    imageSource,imageAttribution,creativeCommonsConfirmed,date);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void remove(CocktailDetails cocktailDetails) {
        cocktailDetails=null;
    }
}

