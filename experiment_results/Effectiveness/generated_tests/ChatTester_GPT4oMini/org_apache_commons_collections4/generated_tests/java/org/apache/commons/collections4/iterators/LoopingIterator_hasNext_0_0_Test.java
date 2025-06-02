package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Collection;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.ResettableIterator;

public class LoopingIterator_hasNext_0_0_Test {

    private LoopingIterator<String> loopingIterator;

    @BeforeEach
    public void setUp() {
        loopingIterator = new LoopingIterator<>(Arrays.asList("item1", "item2", "item3"));
    }

    @Test
    public void testHasNextWithNonEmptyCollection() {
        assertTrue(loopingIterator.hasNext(), "hasNext() should return true for non-empty collection");
    }

    @Test
    public void testHasNextWithEmptyCollection() {
        loopingIterator = new LoopingIterator<>(Arrays.asList());
        assertFalse(loopingIterator.hasNext(), "hasNext() should return false for empty collection");
    }
}
