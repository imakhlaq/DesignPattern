import entities.Movie;
import entities.User;

public interface IMovieService {
    //allow user to search for the movie
    Movie findMovieByName(String name);

    Movie findMovieById(Long id);

    //create a movie only admin should be allowed
    Movie crateMovie(User user);

    //deals with delete update and all
    Movie updateMovie(User user);
}
