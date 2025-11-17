package Singleton;

import Dao.FavoriteDaoImplementation;
import Repository.CocktailDetailsRepositoryImpl;
import Repository.CocktailRepositoryImpl;

/**
 * Singleton Pattern Implementation
 * 
 * Purpose: Ensures only ONE instance of important shared objects exists throughout the application.
 * This prevents multiple instances of repositories and DAOs, which would waste memory and cause inconsistencies.
 */
public class Singleton {
    
    // The single instance of Singleton (starts as null, created on first use)
    private static Singleton instance =null ;
    
    // Shared instances that are created ONCE and reused everywhere
    
    /** Handles saving/loading favorites to/from JSON file */
    public final FavoriteDaoImplementation favoriteDao = new FavoriteDaoImplementation();
    
    /** Fetches the list of 100 cocktails from the API */
    public final CocktailRepositoryImpl cocktailRepository = new CocktailRepositoryImpl();
    
    /** Fetches detailed information for a single cocktail from the API */
    public final CocktailDetailsRepositoryImpl cocktailDetailsRepository = new CocktailDetailsRepositoryImpl();

    /**
     * Private Constructor - prevents direct instantiation from outside
     * 
     * You CANNOT do: new Singleton()  
     * You MUST instantiate via getInstance()
     */
    private Singleton(){
        // Constructor is empty because all initialization happens above
    }

    /**
     * getInstance() - The ONLY way to get the Singleton instance
  
     * @return The single shared Singleton instance
     */
    public static Singleton getInstance(){
        if(instance == null){
            // First time only - create the instance
            instance=new Singleton();
        }
        // Always return the same instance
        return instance;
    }
}
