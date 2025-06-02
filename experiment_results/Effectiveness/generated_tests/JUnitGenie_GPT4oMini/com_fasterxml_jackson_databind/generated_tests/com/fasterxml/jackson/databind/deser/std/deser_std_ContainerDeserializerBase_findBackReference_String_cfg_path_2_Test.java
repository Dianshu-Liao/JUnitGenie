package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.junit.Test;
import static org.junit.Assert.*;

public class deser_std_ContainerDeserializerBase_findBackReference_String_cfg_path_2_Test {

    private static class TestContainerDeserializer extends ContainerDeserializerBase<Object> {
        protected TestContainerDeserializer() {
            super(TypeFactory.defaultInstance().constructType(Object.class)); // Use TypeFactory to construct JavaType
        }

        @Override
        public Object deserialize(com.fasterxml.jackson.core.JsonParser p, com.fasterxml.jackson.databind.DeserializationContext ctxt) {
            return null; // Implementation not needed for this test
        }

        @Override
        public JsonDeserializer<Object> getContentDeserializer() {
            return null; // This will trigger the exception in the test
        }
    }

    @Test(timeout = 4000)
    public void testFindBackReferenceThrowsIllegalArgumentException() {
        TestContainerDeserializer deserializer = new TestContainerDeserializer();
        String refName = "testRef";

        try {
            deserializer.findBackReference(refName);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Cannot handle managed/back reference 'testRef': type: container deserializer of type " +
                         deserializer.getClass().getName() + " returned null for 'getContentDeserializer()'", e.getMessage());
        }
    }

}