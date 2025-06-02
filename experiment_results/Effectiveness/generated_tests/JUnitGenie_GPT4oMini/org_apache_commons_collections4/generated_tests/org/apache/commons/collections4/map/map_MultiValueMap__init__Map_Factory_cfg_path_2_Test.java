package org.apache.commons.collections4.map;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.map.MultiValueMap;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.fail;

public class map_MultiValueMap__init__Map_Factory_cfg_path_2_Test {

    private static class TestFactory implements Factory<Map<String, Object>> {
        @Override
        public Map<String, Object> create() {
            return new HashMap<>();
        }

        @Override
        public Map<String, Object> get() {
            return new HashMap<>();
        }
    }

    @Test(timeout = 4000)
    public void testMultiValueMapConstructor() {
        Map<String, Object> map = new HashMap<>();
        Factory<Map<String, Object>> factory = new TestFactory();

        try {
            // Using reflection to access the protected constructor
            java.lang.reflect.Constructor<MultiValueMap> constructor = MultiValueMap.class.getDeclaredConstructor(Map.class, Factory.class);
            constructor.setAccessible(true);
            MultiValueMap multiValueMap = constructor.newInstance(map, factory);
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException was thrown: " + e.getMessage());
        } catch (Exception e) {
            fail("An exception was thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testMultiValueMapConstructorWithNullFactory() {
        Map<String, Object> map = new HashMap<>();
        Factory<Map<String, Object>> factory = null;

        try {
            // Using reflection to access the protected constructor
            java.lang.reflect.Constructor<MultiValueMap> constructor = MultiValueMap.class.getDeclaredConstructor(Map.class, Factory.class);
            constructor.setAccessible(true);
            constructor.newInstance(map, factory);
            fail("Expected IllegalArgumentException for null factory");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("An unexpected exception was thrown: " + e.getMessage());
        }
    }

}