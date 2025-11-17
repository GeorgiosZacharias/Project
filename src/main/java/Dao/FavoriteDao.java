package Dao;

import MVC.Favorites.Favorite;

import java.util.List;

public interface FavoriteDao {
    public Favorite getFavorite(int rollNo);
    public void createFavorite(String name, Favorite favoriteType);
    public void updateFavorite(Favorite favorite);
    public void deleteFavorite(Favorite favorite);
}
