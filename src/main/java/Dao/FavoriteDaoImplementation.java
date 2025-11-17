package Dao;
import MVC.Favorites.Favorite;
import ObserverPattern.Admin;
import ObserverPattern.Subject;
import ObserverPattern.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class FavoriteDaoImplementation implements FavoriteDao{
    public FavoriteDaoImplementation(){}
    @Override
    public Favorite getFavorite(int rollNo) {
        return null;
    }

    public List<String> getAllFavorites(){
        List<String> favorites = new ArrayList<>();
        try {
            String resourceName = "D:/Json/favorites.json";
            BufferedReader in = new BufferedReader(new FileReader(resourceName));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            in.close();
            org.json.JSONObject object = new org.json.JSONObject(response.toString());
            org.json.JSONArray drinks = new org.json.JSONArray(object.getJSONArray("Favorites").toString());
            for(int i=0;i<drinks.length();i++) {
                String favoriteType = drinks.getJSONObject(i).getString("Type of Favorite");
                String cocktailName = drinks.getJSONObject(i).getString("Cocktail Name");
                favorites.add(cocktailName);
                favorites.add(favoriteType);
            }
            return favorites;
        } catch (Exception e) {
            System.out.println(e);
        }
        return favorites;
    }
    @Override
    public void createFavorite(String cocktailName, Favorite favoriteType) {
        try {
            String resourceName = "D:/Json/favorites.json";
            BufferedReader in = new BufferedReader(new FileReader(resourceName));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            int flag = 0;
            if(!response.isEmpty()) {
                org.json.JSONObject object = new org.json.JSONObject(response.toString());
                org.json.JSONArray favorites = new org.json.JSONArray(object.getJSONArray("Favorites").toString());
                for (int i = 0; i < favorites.length(); i++) {
                    org.json.JSONObject object1 = favorites.getJSONObject(i);
                    if (!(Objects.equals(object1.toString(), "{}"))) {
                        String favorite = object1.getString("Type of Favorite");
                        String name = object1.getString("Cocktail Name");
                        if (Objects.equals(favorite, favoriteType.toString()) && Objects.equals(name, cocktailName))
                            flag++;
                    } else {
                        favorites.put(new org.json.JSONObject("{Type of Favorite:" + favoriteType + ", Cocktail Name:" + cocktailName + "},"));
                        object.put("Favorites", favorites);
                        try {
                            FileWriter file = new FileWriter("D:/Json/favorites.json");
                            file.append(object.toString());
                            file.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (flag == 0) {

                    favorites.put(new org.json.JSONObject("{Type of Favorite:" + favoriteType + ", Cocktail Name:" + cocktailName + "},"));
                    object.put("Favorites", favorites);
                    Subject ssubject = new Subject();
                    new User(ssubject);
                    new User(ssubject);
                    new Admin(ssubject);
                    ssubject.setState("O xristis evale kainourgio cocktail stin lista ");
                    try {
                        FileWriter file = new FileWriter("D:/Json/favorites.json");
                        file.append(object.toString());
                        file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            else{
                createJson();
                createFavorite(cocktailName,favoriteType);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createJson() {
        try {
            String resourceName = "D:/Json/favorites.json";
            BufferedReader in = new BufferedReader(new FileReader(resourceName));
            String inputLine;
            StringBuffer response = new StringBuffer();
            boolean flag = false;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                System.out.println(inputLine);
                flag = true;
            }
            in.close();
            if (!flag) {
                JSONObject fav = new JSONObject();
                JSONArray brackets = new JSONArray();
                fav.put("Favorites", brackets);
                try {
                    FileWriter file = new FileWriter("D:/Json/favorites.json");
                    file.append(fav.toString());
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateFavorite(Favorite favorite) {
        /*favorites.get(favorite.getID()).setName(favorite.getName());
        System.out.println("Favorite with Id: " + favorite.getID() + ", update in the database");*/
    }

    @Override
    public void deleteFavorite(Favorite favorite) {
        /*favorites.remove(favorite.getID());
        System.out.println("Favorite with Id: " + favorite.getID() + ", deleted from database");*/
    }
}

