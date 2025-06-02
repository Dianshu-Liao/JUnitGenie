package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNull;

public class deser_std_StdDeserializer__checkDoubleSpecialValue_String_cfg_path_7_Test {

    private class TestDeserializer extends StdDeserializer<Double> {
        protected TestDeserializer() {
            super(Double.class);
        }

        @Override
        public Double deserialize(com.fasterxml.jackson.core.JsonParser p, com.fasterxml.jackson.databind.DeserializationContext ctxt) {
            return null; // Implementation not needed for this test
        }
    }

    @Test(timeout = 4000)
    public void testCheckDoubleSpecialValue_ReturnsNull_WhenTextIsEmpty() {
        try {
            TestDeserializer deserializer = new TestDeserializer();
            Method method = StdDeserializer.class.getDeclaredMethod("_checkDoubleSpecialValue", String.class);
            method.setAccessible(true);
            Double result = (Double) method.invoke(deserializer, "");
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}