package org.apache.commons.collections4.map;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.map.MultiValueMap;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.fail;

public class map_MultiValueMap__init__Map_Factory_cfg_path_1_Test {

    // Implementation of the Factory interface to be used in the test
    static class TestFactory<C> implements Factory<C> {
        @Override
        public C create() {
            return null; // Placeholder implementation (Since it's not used)
        }

        @Override
        public C get() {
            return null; // Placeholder implementation (Since it's not used)
        }
    }

    @Test(timeout = 4000)
    public void testMultiValueMapConstructorThrowsExceptionOnNullFactory() {
        try {
            Map<Object, Collection<Object>> map = new HashMap<>(); // Valid map (not null)
            Factory<Object> factory = null; // Null Factory to trigger exception

            // Accessing the protected constructor using reflection
            Constructor<MultiValueMap> constructor = MultiValueMap.class.getDeclaredConstructor(Map.class, Factory.class);
            constructor.setAccessible(true);
            constructor.newInstance(map, factory);

            fail("Expected IllegalArgumentException for null factory");
        } catch (IllegalArgumentException e) {
            // Expected: The factory must not be null
        } catch (Exception e) {
            fail("Expected IllegalArgumentException but caught: " + e);
        }
    }

    @Test(timeout = 4000)
    public void testMultiValueMapConstructorWithValidParameters() {
        try {
            Map<Object, Collection<Object>> map = new HashMap<>(); // Valid map (not null)
            Factory<Object> factory = new TestFactory<>(); // Valid Factory

            // Accessing the protected constructor using reflection
            Constructor<MultiValueMap> constructor = MultiValueMap.class.getDeclaredConstructor(Map.class, Factory.class);
            constructor.setAccessible(true);
            MultiValueMap multiValueMap = constructor.newInstance(map, factory);
            
            // Further assertions can be made to test the behavior of multiValueMap as needed
        } catch (Exception e) {
            fail("Exception occurred while creating MultiValueMap: " + e.getMessage());
        }
    }


}