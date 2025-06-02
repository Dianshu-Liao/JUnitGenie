package org.apache.commons.collections4.map;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.map.PredicatedMap;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class map_PredicatedMap_isSetValueChecking__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsSetValueCheckingWhenValuePredicateIsNull() {
        try {
            // Create an instance of PredicatedMap using reflection as it's a protected constructor
            Class<PredicatedMap> clazz = PredicatedMap.class;
            Constructor<PredicatedMap> constructor = clazz.getDeclaredConstructor(java.util.Map.class, Predicate.class, Predicate.class);
            constructor.setAccessible(true);
            PredicatedMap<Object, Object> predicatedMap = constructor.newInstance(new java.util.HashMap<>(), null, null);

            // Access the protected method using reflection
            Method method = clazz.getDeclaredMethod("isSetValueChecking");
            method.setAccessible(true);
            boolean result = (Boolean) method.invoke(predicatedMap);

            // Assert that the result is false since valuePredicate is null
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}