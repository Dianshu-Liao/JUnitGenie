package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Collections;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.ResettableIterator;

public class LoopingIterator_hasNext_0_0_Test {

    private LoopingIterator<String> iteratorWithElements;

    private LoopingIterator<String> emptyIterator;

    @BeforeEach
    public void setUp() {
        iteratorWithElements = new LoopingIterator<>(Arrays.asList("element1", "element2", "element3"));
        emptyIterator = new LoopingIterator<>(Collections.emptyList());
    }

    @Test
    public void testHasNext_WithElements_ReturnsTrue() {
        assertTrue(iteratorWithElements.hasNext(), "Expected hasNext() to return true for non-empty collection");
    }

    @Test
    public void testHasNext_EmptyCollection_ReturnsFalse() {
        assertFalse(emptyIterator.hasNext(), "Expected hasNext() to return false for empty collection");
    }
}
