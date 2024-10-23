package theater.project.MovieTheater.Exception;

public class ShowingNotFoundException extends RuntimeException{
    public ShowingNotFoundException (String message){
        super(message);
    }
}
