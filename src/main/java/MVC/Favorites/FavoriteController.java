package MVC.Favorites;

import Singleton.Singleton;

public class FavoriteController {
    private FavoriteView view;
    private Favorite model;
    private String name;
    public FavoriteController(FavoriteView view,String name){
        this.view = view;
        this.name = name;
    }

    public void updateView(){this.view.showCocktailData(name);}
    public static void setCocktailFavorite(String name,String type){
        Singleton singleton = Singleton.getInstance();
        FavoriteView favoriteView = new FavoriteView();
        singleton.favoriteDao.createFavorite(name,Favorite.valueOf(type));
        favoriteView.showAllFavorites(singleton.favoriteDao.getAllFavorites());
    }
    
    public static void removeFavorite(String cocktailName) {
        Singleton singleton = Singleton.getInstance();
        singleton.favoriteDao.deleteFavoriteByName(cocktailName);
        FavoriteView favoriteView = new FavoriteView();
        favoriteView.showAllFavorites(singleton.favoriteDao.getAllFavorites());
    }

}
