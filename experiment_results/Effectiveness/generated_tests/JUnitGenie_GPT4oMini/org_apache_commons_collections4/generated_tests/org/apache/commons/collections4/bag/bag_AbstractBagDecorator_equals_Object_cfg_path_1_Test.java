package org.apache.commons.collections4.bag;
import org.apache.commons.collections4.bag.AbstractBagDecorator;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;
import org.junit.Test;
import static org.junit.Assert.*;

public class bag_AbstractBagDecorator_equals_Object_cfg_path_1_Test {

    private class TestBagDecorator extends AbstractBagDecorator {
        protected TestBagDecorator(Bag bag) {
            super(bag);
        }
    }

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        TestBagDecorator bagDecorator = new TestBagDecorator(new org.apache.commons.collections4.bag.HashBag());
        assertTrue(bagDecorator.equals(bagDecorator));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentObject() {
        TestBagDecorator bagDecorator1 = new TestBagDecorator(new org.apache.commons.collections4.bag.HashBag());
        TestBagDecorator bagDecorator2 = new TestBagDecorator(new org.apache.commons.collections4.bag.HashBag());
        assertFalse(bagDecorator1.equals(bagDecorator2));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        TestBagDecorator bagDecorator = new TestBagDecorator(new org.apache.commons.collections4.bag.HashBag());
        assertFalse(bagDecorator.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualDecoratedBag() {
        Bag bag = new org.apache.commons.collections4.bag.HashBag();
        bag.add("item", 1);
        TestBagDecorator bagDecorator1 = new TestBagDecorator(bag);
        TestBagDecorator bagDecorator2 = new TestBagDecorator(bag);
        assertTrue(bagDecorator1.equals(bagDecorator2));
    }

    @Test(timeout = 4000)
    public void testEquals_DecoratedBagNotEqual() {
        Bag bag1 = new org.apache.commons.collections4.bag.HashBag();
        Bag bag2 = new org.apache.commons.collections4.bag.HashBag();
        bag1.add("item1", 1);
        bag2.add("item2", 1);
        TestBagDecorator bagDecorator1 = new TestBagDecorator(bag1);
        TestBagDecorator bagDecorator2 = new TestBagDecorator(bag2);
        assertFalse(bagDecorator1.equals(bagDecorator2));
    }

}