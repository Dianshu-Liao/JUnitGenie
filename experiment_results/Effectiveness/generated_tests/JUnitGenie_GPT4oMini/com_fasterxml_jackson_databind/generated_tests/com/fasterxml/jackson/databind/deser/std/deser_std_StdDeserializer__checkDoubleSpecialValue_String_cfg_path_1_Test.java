package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class deser_std_StdDeserializer__checkDoubleSpecialValue_String_cfg_path_1_Test {

    private class TestDeserializer extends StdDeserializer<Double> {
        protected TestDeserializer() {
            super(Double.class);
        }

        @Override
        public Double deserialize(com.fasterxml.jackson.core.JsonParser p, com.fasterxml.jackson.databind.DeserializationContext ctxt) {
            return null; // Not implemented for this test
        }

        public Double checkDoubleSpecialValue(String text) {
            try {
                // Accessing the protected method using reflection
                java.lang.reflect.Method method = StdDeserializer.class.getDeclaredMethod("_checkDoubleSpecialValue", String.class);
                method.setAccessible(true);
                return (Double) method.invoke(this, text);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @Test(timeout = 4000)
    public void testCheckDoubleSpecialValue_NaN() {
        TestDeserializer deserializer = new TestDeserializer();
        Double result = deserializer.checkDoubleSpecialValue("NaN");
        assertEquals(Double.valueOf(Double.NaN), result); // Use Double.valueOf to avoid ambiguity
    }


}