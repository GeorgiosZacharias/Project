package Repository;

import java.util.List;

/**
 * Repository Pattern - Generic Repository Interface
 * 
 * WHAT IT DOES:
 * Defines a contract (interface) for data access operations.
 * Acts as an abstraction layer between your business logic and data sources.
 * 
 * WHY USE IT:
 * - Separates data access logic from business logic
 * - Hides implementation details (API, database, file, etc.)
 * - Makes code easier to test (can create mock repositories)
 * - Makes it easy to swap data sources (change from API to database without
 * changing business logic)
 * 
 * GENERIC TYPE <T>:
 * T is a placeholder for any type (Cocktail, CocktailDetails, etc.)
 * This makes the interface reusable for different data types
 *
 */
public interface Repository<T> {
    /**
     * Retrieves an object by its index or ID
     * 
     * @param index Position or unique identifier of the object
     * @return Object of type T, or null if not found
     * 
     *         Example: repository.getObject(5) might return the 5th cocktail or
     *         cocktail with ID 5
     */
    T getObject(int index);

    /**
     * Removes an object from the repository
     * 
     * @param t The object to remove
     * 
     *          Note: Currently just sets the object to null in implementations
     *          Could be expanded to actually delete from a database or API
     */
    void remove(T t);

}
