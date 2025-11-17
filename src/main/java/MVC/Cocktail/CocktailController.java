package MVC.Cocktail;

import MVC.CocktailDetails.CocktailDetails;
import MVC.CocktailDetails.DetailsController;
import MVC.CocktailDetails.DetailsView;
import MVC.Favorites.Favorite;
import MVC.Favorites.FavoriteController;
import MVC.Favorites.FavoriteView;
import ObserverPattern.Admin;
import ObserverPattern.Subject;
import ObserverPattern.User;
import Singleton.Singleton;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class CocktailController {


    private final CocktailView cocktailView;
    private final Cocktail model;
    public CocktailController(Cocktail model, CocktailView cocktailView){
        this.model = model;
        this.cocktailView = cocktailView;
    }
    //region Getters/Setters
    public void setModelId(int id){this.model.setId(id);}
    public void setModelName(String name){this.model.setName(name);}
    public void setModelImage(String image){this.model.setImage(image);}
    public int getModelId(){return this.model.getId();}
    public String getModelName(){return this.model.getName();}
    public String getModelImage(){return this.model.getImage();}
    //endregion
    public Image UrlImage(String imageString){
        try {
            System.out.println("Get Image from " + imageString);
            URL url = new URL(imageString);
            BufferedImage image = ImageIO.read(url);
            Image newImage = image.getScaledInstance(125,125,Image.SCALE_DEFAULT);
            System.out.println("Load image into frame... \n");
            return newImage;
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return null;
    }
    public void updateView(){this.cocktailView.showCocktailData(getModelId(),getModelName(),UrlImage(getModelImage()));}
    public static void callDetailsController(int id) {
        Subject ssubject = new Subject();
        new User(ssubject);
        new User(ssubject);
        new Admin(ssubject);
        ssubject.setState("Anoi3e parathiro gia na dei ta details enos  coctail  ");
         Singleton singleton = Singleton.getInstance();
         DetailsView detailsView = new DetailsView();
         DetailsController detailsController;
         detailsController = new DetailsController(singleton.cocktailDetailsRepository.getObject(id),detailsView);
        try {
            detailsController.updateView();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public static void callFavoriteController(String name){
        Subject ssubject = new Subject();
        new User(ssubject);
        new User(ssubject);
        new Admin(ssubject);
        ssubject.setState("Anoi3e parathiro gia na valei ena coctail sta favorites ");
        FavoriteView favoriteView= new FavoriteView();
        FavoriteController favoriteController= new FavoriteController(favoriteView,name);
        favoriteController.updateView();
    }
}
