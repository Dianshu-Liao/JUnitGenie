package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_AbstractHashedMap__init__int_float_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testConstructorWithValidParameters() {
        try {
            // Using reflection to access the protected constructor
            Class<?> clazz = AbstractHashedMap.class;
            java.lang.reflect.Constructor<?> constructor = clazz.getDeclaredConstructor(int.class, float.class);
            constructor.setAccessible(true);
            AbstractHashedMap map = (AbstractHashedMap) constructor.newInstance(10, 0.75f);
            assertNotNull(map);
        } catch (Exception e) {
            fail("Exception should not have been thrown for valid parameters: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithNegativeInitialCapacity() {
        try {
            // Using reflection to access the protected constructor
            Class<?> clazz = AbstractHashedMap.class;
            java.lang.reflect.Constructor<?> constructor = clazz.getDeclaredConstructor(int.class, float.class);
            constructor.setAccessible(true);
            constructor.newInstance(-1, 0.75f);
            fail("Expected IllegalArgumentException for negative initial capacity");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getClass().getName());
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithZeroLoadFactor() {
        try {
            // Using reflection to access the protected constructor
            Class<?> clazz = AbstractHashedMap.class;
            java.lang.reflect.Constructor<?> constructor = clazz.getDeclaredConstructor(int.class, float.class);
            constructor.setAccessible(true);
            constructor.newInstance(10, 0.0f);
            fail("Expected IllegalArgumentException for zero load factor");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getClass().getName());
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithNaNLoadFactor() {
        try {
            // Using reflection to access the protected constructor
            Class<?> clazz = AbstractHashedMap.class;
            java.lang.reflect.Constructor<?> constructor = clazz.getDeclaredConstructor(int.class, float.class);
            constructor.setAccessible(true);
            constructor.newInstance(10, Float.NaN);
            fail("Expected IllegalArgumentException for NaN load factor");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getClass().getName());
        }
    }

}