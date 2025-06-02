package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class deser_std_StdDeserializer__checkDoubleSpecialValue_String_cfg_path_6_Test {

    private static class TestDeserializer extends StdDeserializer<Double> {
        protected TestDeserializer() {
            super(Double.class);
        }

        @Override
        public Double deserialize(com.fasterxml.jackson.core.JsonParser p, com.fasterxml.jackson.databind.DeserializationContext ctxt) {
            return null; // Method not tested here
        }

        protected Double checkDoubleSpecialValue(String text) throws Exception {
            Method method = StdDeserializer.class.getDeclaredMethod("_checkDoubleSpecialValue", String.class);
            method.setAccessible(true);
            return (Double) method.invoke(this, text);
        }

        // Removed the _isNegInf method as it cannot override the final method in StdDeserializer
    }

    @Test(timeout = 4000)
    public void testCheckDoubleSpecialValue_NegativeInfinity() throws Exception {
        TestDeserializer deserializer = new TestDeserializer();
        String testInput = "-Infinity"; // This input should not cause _isNegInf to return true
        Double result = deserializer.checkDoubleSpecialValue(testInput);
        assertNull(result); // We expect the return value to be null
    }


}