package com.nasa.rover.util;

import java.util.ArrayList;

public class CircularArrayList<T> extends ArrayList<T> {
    public T getNext(int index) {
        if (index >= 0 && index < size() - 1) {
            return get(index + 1);
        } else if (index == size() - 1) {
            return get(0);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public T getPrevious(int index) {
        if (index > 0 && index < size()) {
            return get(index - 1);
        } else if (index == 0) {
            return get(size() - 1);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
