package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.AbstractListDecorator;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class list_AbstractListDecorator_equals_Object_cfg_path_2_Test {

    private class ConcreteListDecorator extends AbstractListDecorator {
        protected ConcreteListDecorator(List<?> list) {
            super(list);
        }
    }

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        ConcreteListDecorator decorator = new ConcreteListDecorator(new ArrayList<>());
        assertTrue(decorator.equals(decorator));
    }

    @Test(timeout = 4000)
    public void testEquals_DecoratedListEquals() {
        List<String> list = new ArrayList<>();
        list.add("test");
        ConcreteListDecorator decorator = new ConcreteListDecorator(list);
        assertTrue(decorator.equals(list));
    }

    @Test(timeout = 4000)
    public void testEquals_DecoratedListNotEquals() {
        List<String> list1 = new ArrayList<>();
        list1.add("test");
        ConcreteListDecorator decorator = new ConcreteListDecorator(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("different");
        assertFalse(decorator.equals(list2));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        ConcreteListDecorator decorator = new ConcreteListDecorator(new ArrayList<>());
        assertFalse(decorator.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        ConcreteListDecorator decorator = new ConcreteListDecorator(new ArrayList<>());
        assertFalse(decorator.equals("not a list"));
    }

}