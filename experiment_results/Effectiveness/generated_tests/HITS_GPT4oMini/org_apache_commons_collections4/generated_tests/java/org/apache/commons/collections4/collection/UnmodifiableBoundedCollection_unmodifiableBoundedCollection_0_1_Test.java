package org.apache.commons.collections4.collection;

import org.apache.commons.collections4.BoundedCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;

class UnmodifiableBoundedCollection_unmodifiableBoundedCollection_0_1_Test {

    private static class MockBoundedCollection<E> implements BoundedCollection<E> {

        private final List<E> list;

        private final int maxSize;

        public MockBoundedCollection(int maxSize) {
            this.maxSize = maxSize;
            this.list = new ArrayList<>();
        }

        @Override
        public boolean add(E e) {
            if (list.size() < maxSize) {
                return list.add(e);
            }
            throw new IllegalStateException("Collection is full");
        }

        @Override
        public boolean remove(Object o) {
            return list.remove(o);
        }

        @Override
        public void clear() {
            list.clear();
        }

        @Override
        public int size() {
            return list.size();
        }

        @Override
        public boolean isFull() {
            return list.size() == maxSize;
        }

        @Override
        public boolean isEmpty() {
            return list.isEmpty();
        }

        @Override
        public boolean contains(Object o) {
            return list.contains(o);
        }

        @Override
        public Iterator<E> iterator() {
            return list.iterator();
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            for (E e : c) {
                add(e);
            }
            return true;
        }

        @Override
        public int maxSize() {
            return maxSize;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            boolean modified = false;
            Iterator<E> it = list.iterator();
            while (it.hasNext()) {
                if (!c.contains(it.next())) {
                    it.remove();
                    modified = true;
                }
            }
            return modified;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            boolean modified = false;
            Iterator<E> it = list.iterator();
            while (it.hasNext()) {
                if (c.contains(it.next())) {
                    it.remove();
                    modified = true;
                }
            }
            return modified;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return list.containsAll(c);
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return list.toArray(a);
        }

        @Override
        public Object[] toArray() {
            return list.toArray();
        }
    }
}
