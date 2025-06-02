package org.apache.commons.compress.harmony.unpack200.bytecode;
import org.apache.commons.compress.harmony.unpack200.bytecode.Attribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class harmony_unpack200_bytecode_Attribute_equals_Object_cfg_path_3_Test {

    private static class ConcreteAttribute extends Attribute {
        private final CPUTF8 cpuUtf8;

        public ConcreteAttribute(CPUTF8 cpuUtf8) {
            super(cpuUtf8);
            this.cpuUtf8 = cpuUtf8;
        }

        @Override
        public String toString() {
            return "ConcreteAttribute{" + "cpuUtf8=" + cpuUtf8 + '}';
        }

        @Override
        public int getLength() {
            return 0; // implementation details
        }

        @Override
        public void writeBody(java.io.DataOutputStream dataOutputStream) {
            // implementation details
        }
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        ConcreteAttribute attribute = new ConcreteAttribute(new CPUTF8("Test"));
        Object obj = null;

        try {
            boolean result = attribute.equals(obj);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}