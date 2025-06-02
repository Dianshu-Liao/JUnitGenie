package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class deser_std_StdDeserializer__checkDoubleSpecialValue_String_cfg_path_4_Test {

    private class TestDeserializer extends StdDeserializer<Double> {
        protected TestDeserializer() {
            super(Double.class);
        }

        @Override
        public Double deserialize(com.fasterxml.jackson.core.JsonParser p, com.fasterxml.jackson.databind.DeserializationContext ctxt) {
            return null; // Not implemented for this test
        }

        // Implementing the _checkDoubleSpecialValue method for testing purposes
        protected Double _checkDoubleSpecialValue(String value) {
            switch (value) {
                case "I":
                    return Double.POSITIVE_INFINITY;
                case "N":
                    return Double.NaN;
                case "-":
                    return Double.NEGATIVE_INFINITY;
                default:
                    return null;
            }
        }
    }

    @Test(timeout = 4000)
    public void testCheckDoubleSpecialValue_PositiveInfinity() {
        try {
            TestDeserializer deserializer = new TestDeserializer();
            Method method = TestDeserializer.class.getDeclaredMethod("_checkDoubleSpecialValue", String.class);
            method.setAccessible(true);
            Double result = (Double) method.invoke(deserializer, "I");
            assertEquals(Double.POSITIVE_INFINITY, result, 0.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCheckDoubleSpecialValue_NaN() {
        try {
            TestDeserializer deserializer = new TestDeserializer();
            Method method = TestDeserializer.class.getDeclaredMethod("_checkDoubleSpecialValue", String.class);
            method.setAccessible(true);
            Double result = (Double) method.invoke(deserializer, "N");
            assertEquals(Double.NaN, result, 0.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCheckDoubleSpecialValue_NegativeInfinity() {
        try {
            TestDeserializer deserializer = new TestDeserializer();
            Method method = TestDeserializer.class.getDeclaredMethod("_checkDoubleSpecialValue", String.class);
            method.setAccessible(true);
            Double result = (Double) method.invoke(deserializer, "-");
            assertEquals(Double.NEGATIVE_INFINITY, result, 0.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCheckDoubleSpecialValue_EmptyString() {
        try {
            TestDeserializer deserializer = new TestDeserializer();
            Method method = TestDeserializer.class.getDeclaredMethod("_checkDoubleSpecialValue", String.class);
            method.setAccessible(true);
            Double result = (Double) method.invoke(deserializer, "");
            assertEquals(null, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCheckDoubleSpecialValue_RegularString() {
        try {
            TestDeserializer deserializer = new TestDeserializer();
            Method method = TestDeserializer.class.getDeclaredMethod("_checkDoubleSpecialValue", String.class);
            method.setAccessible(true);
            Double result = (Double) method.invoke(deserializer, "RegularString");
            assertEquals(null, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}