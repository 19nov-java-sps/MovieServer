import com.revature.models.Movies;
import com.revature.models.Reviews;
import com.revature.models.Users;
import com.revature.services.MovieService;
import com.revature.services.ReviewService;
import com.revature.services.UserService;

import java.sql.SQLException;
public class Driver {
public static void main(String [] args) throws SQLException {
	
	MovieService mvservice= new MovieService();
	
	UserService userservice= new UserService();
	
	ReviewService reservice= new ReviewService();
	Users Jia = new Users("Jia","Li","Jli@aol.com","pass");
	
	
	
	//System.out.print(userservice.Login("Bucci490@hotmail.com", "1234"));
	
	//userservice.createAccount(Jia);
	//int reviewId, int movieId, int userId, String postTitle, String postBody
	
//Reviews review= new Reviews(1, 1, 2, "Harry Potter Rules", "One of the best movies of all time");
//reservice.editReview(2, "Harry Potter is the best", "Great Flick");
	
	//reservice.deleteReviewById(2);
//reservice.createReview(review);
	
	
	//Movies movie= new Movies(5, "Harry Potter and The Sorcerors Stone","01/21/1998","Harry Potter", 95);
	
	//mvservice.addMovie(movie.getMovieId());
	
	//System.out.print(movie.getMovieId());
	
	//int movieId, String title, String releaseDate, String summary, int length
	//Movies Pedro= new Movies(2,"Pedro","01/2009","Pedro",95);
	//System.out.print(mvservice.getMovieById(1));
	//mvservice.addMovie(Pedro);
	
reservice.editReview(2, "Harry Potter and the Deathly Hollows", "Damn Good", "Harry Potter 4");

}
}
