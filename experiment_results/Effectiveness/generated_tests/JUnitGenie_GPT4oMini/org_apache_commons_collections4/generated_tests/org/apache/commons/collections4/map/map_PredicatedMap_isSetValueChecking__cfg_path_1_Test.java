package org.apache.commons.collections4.map;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.map.PredicatedMap;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;

public class map_PredicatedMap_isSetValueChecking__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsSetValueCheckingWhenValuePredicateIsNull() {
        // Create an instance of PredicatedMap using reflection
        try {
            Constructor<PredicatedMap> constructor = PredicatedMap.class.getDeclaredConstructor(java.util.Map.class, Predicate.class, Predicate.class);
            constructor.setAccessible(true);
            PredicatedMap<Object, Object> predicatedMap = constructor.newInstance(new java.util.HashMap<>(), null, null);

            // Access the protected method isSetValueChecking using reflection
            Method isSetValueCheckingMethod = PredicatedMap.class.getDeclaredMethod("isSetValueChecking");
            isSetValueCheckingMethod.setAccessible(true);

            // Invoke the method and assert the result
            boolean result = (boolean) isSetValueCheckingMethod.invoke(predicatedMap);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}