package Singleton;

/*
import Dao.FavoriteDaoImplementation;
*/
import Dao.FavoriteDaoImplementation;
import Repository.CocktailDetailsRepositoryImpl;
import Repository.CocktailRepositoryImpl;

public class Singleton {
    private static Singleton instance =null ;
    public final FavoriteDaoImplementation favoriteDao = new FavoriteDaoImplementation();
    public final CocktailRepositoryImpl cocktailRepository = new CocktailRepositoryImpl();
    public final CocktailDetailsRepositoryImpl cocktailDetailsRepository = new CocktailDetailsRepositoryImpl();

    private Singleton(){
    }

    public static Singleton getInstance(){
        if(instance == null){
            instance=new Singleton();
        }
        return instance;
    }
}
