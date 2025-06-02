package org.apache.commons.compress.utils;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ServiceConfigurationError;
import org.junit.Test;
import static org.junit.Assert.*;

public class utils_ServiceLoaderIterator_hasNext__cfg_path_38_Test {

    private class MockIterator<E> implements Iterator<E> {
        private final E[] elements;
        private int index = 0;

        public MockIterator(E... elements) {
            this.elements = elements;
        }

        @Override
        public boolean hasNext() {
            return index < elements.length;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elements[index++];
        }
    }






}
