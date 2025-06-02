package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_AbstractHashedMap__init__int_float_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testConstructorWithNegativeInitialCapacity() {
        try {
            // Attempt to create an instance with a negative initial capacity
            AbstractHashedMap map = (AbstractHashedMap) AbstractHashedMap.class
                .getDeclaredConstructor(int.class, float.class)
                .newInstance(-1, 0.75f);
            fail("Expected IllegalArgumentException for negative initial capacity");
        } catch (IllegalArgumentException e) {
            assertEquals("Initial capacity must be a non negative number", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithZeroLoadFactor() {
        try {
            // Attempt to create an instance with a load factor of zero
            AbstractHashedMap map = (AbstractHashedMap) AbstractHashedMap.class
                .getDeclaredConstructor(int.class, float.class)
                .newInstance(10, 0.0f);
            fail("Expected IllegalArgumentException for load factor of zero");
        } catch (IllegalArgumentException e) {
            assertEquals("Load factor must be greater than 0", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithNaNLoadFactor() {
        try {
            // Attempt to create an instance with a NaN load factor
            AbstractHashedMap map = (AbstractHashedMap) AbstractHashedMap.class
                .getDeclaredConstructor(int.class, float.class)
                .newInstance(10, Float.NaN);
            fail("Expected IllegalArgumentException for NaN load factor");
        } catch (IllegalArgumentException e) {
            assertEquals("Load factor must be greater than 0", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

}