package Object_Movie;

public class Movie {
    protected String title;
    protected String genre;
    protected int rating;

    void playIt () {
        System.out.println("Проигрывание фильма..." + title);
    }
}