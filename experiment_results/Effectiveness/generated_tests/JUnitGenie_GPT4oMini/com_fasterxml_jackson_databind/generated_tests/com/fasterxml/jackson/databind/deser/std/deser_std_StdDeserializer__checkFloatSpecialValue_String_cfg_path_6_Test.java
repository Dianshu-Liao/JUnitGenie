package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNull;

public class deser_std_StdDeserializer__checkFloatSpecialValue_String_cfg_path_6_Test {

    private class TestDeserializer extends StdDeserializer<Float> {
        protected TestDeserializer() {
            super(Float.class);
        }

        @Override
        public Float deserialize(com.fasterxml.jackson.core.JsonParser p, com.fasterxml.jackson.databind.DeserializationContext ctxt) {
            return null; // Implementation not needed for this test
        }
    }

    @Test(timeout = 4000)
    public void testCheckFloatSpecialValue_NegativeInfinity() {
        try {
            TestDeserializer deserializer = new TestDeserializer();
            Method method = StdDeserializer.class.getDeclaredMethod("_checkFloatSpecialValue", String.class);
            method.setAccessible(true);
            Float result = (Float) method.invoke(deserializer, "-Infinity");
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCheckFloatSpecialValue_NegativeInf() {
        try {
            TestDeserializer deserializer = new TestDeserializer();
            Method method = StdDeserializer.class.getDeclaredMethod("_checkFloatSpecialValue", String.class);
            method.setAccessible(true);
            Float result = (Float) method.invoke(deserializer, "-INF");
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}