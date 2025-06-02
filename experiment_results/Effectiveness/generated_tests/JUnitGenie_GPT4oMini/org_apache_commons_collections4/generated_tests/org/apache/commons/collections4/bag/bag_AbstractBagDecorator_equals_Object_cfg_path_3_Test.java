package org.apache.commons.collections4.bag;
import org.apache.commons.collections4.bag.AbstractBagDecorator;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class bag_AbstractBagDecorator_equals_Object_cfg_path_3_Test {

    private class ConcreteBagDecorator extends AbstractBagDecorator {
        public ConcreteBagDecorator() {
            super(null); // Using reflection to call the protected constructor
        }

        @Override
        public boolean equals(final Object object) {
            return super.equals(object);
        }
    }

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        ConcreteBagDecorator bagDecorator = new ConcreteBagDecorator();
        assertTrue(bagDecorator.equals(bagDecorator));
    }

}