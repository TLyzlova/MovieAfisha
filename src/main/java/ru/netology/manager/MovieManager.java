package ru.netology.manager;

import ru.netology.domain.MovieItem;

public class MovieManager {
    private MovieItem[] items = new MovieItem[0];
    private int maxAmount = 10;

    public MovieManager() {
    }

    public MovieManager(int maxAmount) {
        if (maxAmount <= 0) {
            return;
        }
        this.maxAmount = maxAmount;
    }

    public void add(MovieItem item) {
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieItem[] getAll() {
        int resultLength;
        if(items.length > maxAmount) {
            resultLength = maxAmount;
        } else {
            resultLength = items.length;
        }
        MovieItem[] result = new MovieItem[resultLength];
        for (int i = 0; i < resultLength; i++) {
            if (items.length > maxAmount) {
                int index = resultLength - i -1 + (items.length - maxAmount);
                result[i] = items[index];
            } else {
                int index = resultLength - i - 1;
                result[i] = items[index];
            }
        }
        return result;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        MovieItem[] tmp = new MovieItem[length];
        int index = 0;
        for (MovieItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
