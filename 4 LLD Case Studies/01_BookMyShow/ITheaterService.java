import entities.Movie;
import entities.Theater;
import entities.User;

import java.util.List;

public interface ITheaterService {

    //user can find theater base on the name
    List<Theater> findTheaterByName(String name);

    //user can find theater base on the zip code
    List<Theater> findTheaterByZipCode(String zipCode);

    //allowing user to find movies in theater
    List<Movie> findMoviesInTheater(String theaterByName);

    //add movie to theater
    boolean addMoviesToTheater(String theaterName, long movieId, User user);

    //remove movie from theater
    boolean removeMoviesFromTheater(String theaterName, long movieId, User user);
}
