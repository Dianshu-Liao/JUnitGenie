package org.apache.commons.collections4.splitmap;
import org.apache.commons.collections4.splitmap.AbstractIterableGetMapDecorator;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class splitmap_AbstractIterableGetMapDecorator_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        AbstractIterableGetMapDecorator decorator = new AbstractIterableGetMapDecorator(new java.util.HashMap<>());
        assertTrue(decorator.equals(decorator));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentObject() {
        AbstractIterableGetMapDecorator decorator1 = new AbstractIterableGetMapDecorator(new java.util.HashMap<>());
        AbstractIterableGetMapDecorator decorator2 = new AbstractIterableGetMapDecorator(new java.util.HashMap<>());
        assertFalse(decorator1.equals(decorator2));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        AbstractIterableGetMapDecorator decorator = new AbstractIterableGetMapDecorator(new java.util.HashMap<>());
        assertFalse(decorator.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_ValidMap() {
        AbstractIterableGetMapDecorator decorator = new AbstractIterableGetMapDecorator(new java.util.HashMap<>());
        java.util.Map<Object, Object> map = new java.util.HashMap<>();
        map.put("key", "value");
        AbstractIterableGetMapDecorator decoratorWithMap = new AbstractIterableGetMapDecorator(map);
        
        // This should return false as the maps are different
        assertFalse(decorator.equals(decoratorWithMap));
    }

}