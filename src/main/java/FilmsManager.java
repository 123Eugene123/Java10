import java.lang.reflect.Constructor;

public class FilmsManager {
    private String[] films = new String[0];
    private int limit;

    public FilmsManager() {
        this.limit = 6;
    }

    public FilmsManager(int limit) {
        this.limit = limit;
    }

    public void addFilm(String film) {
        String[] tmp = new String[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];

        }
        tmp[tmp.length - 1] = film;
        this.films = tmp;
    }

    public String[] findAll() {
        return films;

    }

    public String[] findLast() {
        int resultlength;
        if (films.length < limit) {
            resultlength = films.length;
        } else {
            resultlength = limit;
        }
        String[] las = new String[resultlength];
        for (int i = 0; i < las.length; i++) {
            las[i] = films[films.length - 1 - i];
        }
        return las;
    }
}