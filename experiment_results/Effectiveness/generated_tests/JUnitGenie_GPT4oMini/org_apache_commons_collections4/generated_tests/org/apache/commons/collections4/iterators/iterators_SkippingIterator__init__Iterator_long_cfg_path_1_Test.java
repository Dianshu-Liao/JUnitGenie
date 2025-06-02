package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.SkippingIterator;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class iterators_SkippingIterator__init__Iterator_long_cfg_path_1_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNegativeOffset() {
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        new SkippingIterator<>(iterator, -1); // This should throw IllegalArgumentException
    }

    @Test(timeout = 4000)
    public void testConstructorWithValidOffset() {
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        SkippingIterator<Integer> skippingIterator = new SkippingIterator<>(iterator, 1);
        assertNotNull(skippingIterator); // Ensure the object is created successfully
    }

}