package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class deser_std_StdDeserializer__checkDoubleSpecialValue_String_cfg_path_3_Test {

    private class TestDeserializer extends StdDeserializer<Double> {
        protected TestDeserializer() {
            super(Double.class);
        }

        @Override
        public Double deserialize(com.fasterxml.jackson.core.JsonParser p, com.fasterxml.jackson.databind.DeserializationContext ctxt) {
            return null; // Not used for this test
        }
    }

    @Test(timeout = 4000)
    public void testCheckDoubleSpecialValue_PositiveInfinity() {
        try {
            // Create an instance of the TestDeserializer
            Constructor<TestDeserializer> constructor = TestDeserializer.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            TestDeserializer deserializer = constructor.newInstance();

            // Access the protected method _checkDoubleSpecialValue using reflection
            Method method = StdDeserializer.class.getDeclaredMethod("_checkDoubleSpecialValue", String.class);
            method.setAccessible(true);

            // Call the method with the input that should return Double.POSITIVE_INFINITY
            Double result = (Double) method.invoke(deserializer, "Infinity");
            assertEquals(Double.POSITIVE_INFINITY, result, 0.0); // Specify delta for double comparison
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}