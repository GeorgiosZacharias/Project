
import OS.LaunchPage;
import OS.OSFactory;
import ObserverPattern.*;

import java.util.List;

public class Main {

    public static void main(String[] args){
        // Create the Subject object
        // It will handle updating all observers
        // as well as deleting and adding the
        // Create an Observer that will be sent updates from Subject



        OSFactory OSFactory = new OSFactory();
        LaunchPage launchPage = new LaunchPage();


        /*for(Favorite favorite : favoriteDao.getAllFavorites()){
            System.out.println("Favorites: [ID: " + favorite.getID() + ", Name: " + favorite.getName() + " Image: " + favorite.getImage() + " ]");
        }*/
/*        FavoriteDaoImplementation daoImplementation = new FavoriteDaoImplementation();
        *//*Favorite favorite = Favorite.Relax;
        daoImplementation.createFavorite("155 Belmont", favorite);
        daoImplementation.createFavorite("Mojito", Favorite.Energizing);*//*
        daoImplementation.createFavorite("hello",Favorite.Energizing);*/
        /*FavoriteView favoriteView= new FavoriteView();
        FavoriteController favoriteController= new FavoriteController(favoriteView);
        favoriteController.updateView();*/
    }
}
