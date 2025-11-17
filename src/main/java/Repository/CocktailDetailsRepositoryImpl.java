package Repository;

import MVC.CocktailDetails.CocktailDetails;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CocktailDetailsRepositoryImpl implements Repository<CocktailDetails>{

    @Override
    public CocktailDetails getObject(int cocktailId){
        try {
            String url = "https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=" + cocktailId;
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
            JSONObject object=new JSONObject(response.toString());
            JSONArray drinks=new JSONArray(object.getJSONArray("drinks").toString());
            int id = drinks.getJSONObject(0).getInt("idDrink");
            String name = drinks.getJSONObject(0).getString("strDrink");
            String altName =  drinks.getJSONObject(0).get("strDrinkAlternate").toString();
            String tags = drinks.getJSONObject(0).get("strTags").toString();
            String video = drinks.getJSONObject(0).get("strVideo").toString();
            String category = drinks.getJSONObject(0).get("strCategory").toString();
            String IBA = drinks.getJSONObject(0).get("strIBA").toString();
            String alcoholic = drinks.getJSONObject(0).get("strAlcoholic").toString();
            String glass = drinks.getJSONObject(0).get("strGlass").toString();
            String instructions = drinks.getJSONObject(0).get("strInstructions").toString();
            String instructionsEs = drinks.getJSONObject(0).get("strInstructionsES").toString();
            String instructionsDe = drinks.getJSONObject(0).get("strInstructionsDE").toString();
            String instructionsFr = drinks.getJSONObject(0).get("strInstructionsFR").toString();
            String instructionsIt = drinks.getJSONObject(0).get("strInstructionsIT").toString();
            String instructionsZhHANS = drinks.getJSONObject(0).get("strInstructionsZH-HANS").toString();
            String instructionsZhHANT = drinks.getJSONObject(0).get("strInstructionsZH-HANT").toString();
            String image = drinks.getJSONObject(0).get("strDrinkThumb").toString();
            String ingredient1 = drinks.getJSONObject(0).get("strIngredient1").toString();
            String ingredient2 = drinks.getJSONObject(0).get("strIngredient2").toString();
            String ingredient3 = drinks.getJSONObject(0).get("strIngredient3").toString();
            String ingredient4 = drinks.getJSONObject(0).get("strIngredient4").toString();
            String ingredient5 = drinks.getJSONObject(0).get("strIngredient5").toString();
            String ingredient6 = drinks.getJSONObject(0).get("strIngredient6").toString();
            String ingredient7 = drinks.getJSONObject(0).get("strIngredient7").toString();
            String ingredient8 = drinks.getJSONObject(0).get("strIngredient8").toString();
            String ingredient9 = drinks.getJSONObject(0).get("strIngredient9").toString();
            String ingredient10 = drinks.getJSONObject(0).get("strIngredient10").toString();
            String ingredient11 = drinks.getJSONObject(0).get("strIngredient11").toString();
            String ingredient12 = drinks.getJSONObject(0).get("strIngredient12").toString();
            String ingredient13 = drinks.getJSONObject(0).get("strIngredient13").toString();
            String ingredient14 = drinks.getJSONObject(0).get("strIngredient14").toString();
            String ingredient15 = drinks.getJSONObject(0).get("strIngredient15").toString();
            String measure1 = drinks.getJSONObject(0).get("strMeasure1").toString();
            String measure2 = drinks.getJSONObject(0).get("strMeasure2").toString();
            String measure3 = drinks.getJSONObject(0).get("strMeasure3").toString();
            String measure4 = drinks.getJSONObject(0).get("strMeasure4").toString();
            String measure5 = drinks.getJSONObject(0).get("strMeasure5").toString();
            String measure6 = drinks.getJSONObject(0).get("strMeasure6").toString();
            String measure7 = drinks.getJSONObject(0).get("strMeasure7").toString();
            String measure8 = drinks.getJSONObject(0).get("strMeasure8").toString();
            String measure9 = drinks.getJSONObject(0).get("strMeasure9").toString();
            String measure10 = drinks.getJSONObject(0).get("strMeasure10").toString();
            String measure11 = drinks.getJSONObject(0).get("strMeasure11").toString();
            String measure12 = drinks.getJSONObject(0).get("strMeasure12").toString();
            String measure13 = drinks.getJSONObject(0).get("strMeasure13").toString();
            String measure14 = drinks.getJSONObject(0).get("strMeasure14").toString();
            String measure15 = drinks.getJSONObject(0).get("strMeasure15").toString();
            String imageSource = drinks.getJSONObject(0).get("strImageSource").toString();
            String imageAttribution = drinks.getJSONObject(0).get("strImageAttribution").toString();
            String creativeCommonsConfirmed = drinks.getJSONObject(0).get("strCreativeCommonsConfirmed").toString();
            String date = drinks.getJSONObject(0).get("dateModified").toString();
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

