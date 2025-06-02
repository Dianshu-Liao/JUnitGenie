package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.AbstractListDecorator;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Constructor;

public class list_AbstractListDecorator_equals_Object_cfg_path_1_Test {

    private static class ConcreteListDecorator extends AbstractListDecorator<Object> {
        protected ConcreteListDecorator(List<Object> list) {
            super(list);
        }
    }

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        try {
            ConcreteListDecorator decorator = new ConcreteListDecorator(new ArrayList<>());
            assertTrue(decorator.equals(decorator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEquals_NonEqualObject() {
        try {
            List<Object> list1 = new ArrayList<>();
            list1.add(new Object());
            ConcreteListDecorator decorator1 = new ConcreteListDecorator(list1);

            List<Object> list2 = new ArrayList<>();
            list2.add(new Object());
            ConcreteListDecorator decorator2 = new ConcreteListDecorator(list2);

            assertFalse(decorator1.equals(decorator2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEquals_EqualDecoratedList() {
        try {
            List<Object> list = new ArrayList<>();
            list.add(new Object()); // Add an object to the list

            ConcreteListDecorator decorator = new ConcreteListDecorator(list);
            List<Object> equalList = new ArrayList<>(list); // Make another list with the same content

            assertFalse(decorator.equals(equalList)); // 'equalList' should not be considered the same
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}