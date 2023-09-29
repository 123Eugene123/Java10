import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilmsManagerTest {
    FilmsManager manager = new FilmsManager(5);
    @BeforeEach
    public void setup() {
        manager.addFilm("Film 1");
        manager.addFilm("Film 2");
        manager.addFilm("Film 3");
    }

    @Test
    public void shouldAddFilms() {
        String[] expected = {"Film 1", "Film 2", "Film 3"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastKnowLimit() {
        manager.addFilm("Film 1");
        manager.addFilm("Film 2");
        manager.addFilm("Film 3");
        manager.addFilm("Film 4");
        manager.addFilm("Film 5");
        String[] expected = {"Film 5", "Film 4", "Film 3", "Film 2", "Film 1"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastUnknowLimit() {
        FilmsManager manager = new FilmsManager();
        manager.addFilm("Film 1");
        manager.addFilm("Film 2");
        manager.addFilm("Film 3");
        String[] expected = {"Film 3", "Film 2", "Film 1"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindEqualLimit() {
        manager.addFilm("Film 4");
        manager.addFilm("Film 5");
        String[] expected = {"Film 5", "Film 4", "Film 3", "Film 2", "Film 1"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindBelowLimit(){
        String [] expected = {"Film 3", "Film 2", "Film 1"};
        String [] actual = manager.findLast();
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldFindAboveLimit(){
        manager.addFilm("Film 4");
        manager.addFilm("Film 5");
        manager.addFilm("Film 6");
        manager.addFilm("Film 7");
        String [] expected = {"Film 7", "Film 6", "Film 5", "Film 4", "Film 3"};
        String []actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}