package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.AbstractListDecorator;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class list_AbstractListDecorator_equals_Object_cfg_path_3_Test {

    private class ConcreteListDecorator extends AbstractListDecorator {
        public ConcreteListDecorator(java.util.List list) {
            super(list);
        }
    }

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        ConcreteListDecorator decorator = new ConcreteListDecorator(new java.util.ArrayList());
        assertTrue(decorator.equals(decorator));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentObject() {
        ConcreteListDecorator decorator1 = new ConcreteListDecorator(new java.util.ArrayList());
        ConcreteListDecorator decorator2 = new ConcreteListDecorator(new java.util.ArrayList());
        assertTrue(!decorator1.equals(decorator2));
    }

}