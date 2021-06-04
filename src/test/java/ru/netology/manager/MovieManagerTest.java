package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    private MovieManager manager = new MovieManager();
    private MovieItem first = new MovieItem(1, 1-1, "First");
    private MovieItem second = new MovieItem(2, 2-2, "Second");
    private MovieItem third = new MovieItem(3, 3-3, "Third");
    private MovieItem fourth = new MovieItem(4, 4-4, "Fourth");
    private MovieItem fifth = new MovieItem(5, 5-5, "Fifth");
    private MovieItem sixth = new MovieItem(6, 6-6, "Sixth");
    private MovieItem seventh = new MovieItem(7, 7-7, "Seventh");
    private MovieItem eighth = new MovieItem(8, 8-8, "Eighth");
    private MovieItem ninth = new MovieItem(9, 9-9, "Ninth");
    private MovieItem tenth = new MovieItem(10, 10-10, "Tenth");
    private MovieItem eleventh = new MovieItem(11, 11-11, "Eleventh");



    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
    }

    @Test
    public void shouldShowNull() {
        manager = new MovieManager();

        MovieItem[] expected = new MovieItem[]{};
        MovieItem [] actual = manager.getAll();
    }

    @Test
    public void shouldShowNine() {

        MovieItem item = new MovieItem();
        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowEleven() {
        manager.add(tenth);
        manager.add(eleventh);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);

    }


    @Test
    public void shouldShowMinus() {
        MovieManager manager = new MovieManager(-5);

        MovieItem[] expected = new MovieItem[] {};
        MovieItem[] actual = manager.getAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveExisting() {
        int idToRemove = 8;
        manager.removeById(idToRemove);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{ninth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldChangeMaxAmount() {
        MovieManager manager = new MovieManager(4);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = new MovieItem[]{eighth,seventh, sixth, fifth};

        assertArrayEquals(expected, actual);

    }
}
