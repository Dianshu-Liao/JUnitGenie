package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

    private LoopingIterator<String> loopingIterator;

    @BeforeEach
    public void setUp() {
        // Initialize the LoopingIterator with a non-empty collection
        List<String> collection = Arrays.asList("A", "B", "C");
        loopingIterator = new LoopingIterator<>(collection);
    }

    @Test
    public void testHasNext_WhenCollectionIsNotEmpty_ShouldReturnTrue() {
        assertTrue(loopingIterator.hasNext(), "Expected hasNext() to return true for non-empty collection");
    }

    @Test
    public void testHasNext_WhenCollectionIsEmpty_ShouldReturnFalse() {
        loopingIterator = new LoopingIterator<>(Collections.emptyList());
        assertFalse(loopingIterator.hasNext(), "Expected hasNext() to return false for empty collection");
    }

    @Test
    public void testHasNext_WhenCollectionContainsNull_ShouldReturnTrue() {
        loopingIterator = new LoopingIterator<>(Arrays.asList(null, "B", "C"));
        assertTrue(loopingIterator.hasNext(), "Expected hasNext() to return true for collection containing null");
    }
}
