package org.apache.commons.compress.harmony.unpack200.bytecode;
import org.apache.commons.compress.harmony.unpack200.bytecode.Attribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class harmony_unpack200_bytecode_Attribute_equals_Object_cfg_path_4_Test {

    private class ConcreteAttribute extends Attribute {
        private final String attributeName;

        public ConcreteAttribute(CPUTF8 name) {
            super(name); // Call the superclass constructor with the CPUTF8 argument
            this.attributeName = name.toString();
        }

        @Override
        public String toString() {
            return attributeName;
        }

        @Override
        public int getLength() {
            return attributeName.length();
        }

        @Override
        public void writeBody(java.io.DataOutputStream out) {
            // Implementation not needed for this test
        }
    }

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        ConcreteAttribute attribute = new ConcreteAttribute(new CPUTF8("test"));
        assertTrue(attribute.equals(attribute));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        ConcreteAttribute attribute = new ConcreteAttribute(new CPUTF8("test"));
        assertFalse(attribute.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        ConcreteAttribute attribute = new ConcreteAttribute(new CPUTF8("test"));
        String differentObject = "Not an Attribute";
        assertFalse(attribute.equals(differentObject));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentAttributeName() {
        ConcreteAttribute attribute1 = new ConcreteAttribute(new CPUTF8("test1"));
        ConcreteAttribute attribute2 = new ConcreteAttribute(new CPUTF8("test2"));
        assertFalse(attribute1.equals(attribute2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameAttributeName() {
        ConcreteAttribute attribute1 = new ConcreteAttribute(new CPUTF8("test"));
        ConcreteAttribute attribute2 = new ConcreteAttribute(new CPUTF8("test"));
        assertTrue(attribute1.equals(attribute2));
    }


}