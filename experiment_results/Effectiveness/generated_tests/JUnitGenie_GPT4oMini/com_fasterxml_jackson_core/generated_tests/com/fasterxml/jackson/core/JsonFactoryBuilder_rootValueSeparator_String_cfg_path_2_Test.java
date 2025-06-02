package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.core.SerializableString;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class JsonFactoryBuilder_rootValueSeparator_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRootValueSeparatorWithNull() {
        JsonFactoryBuilder builder = new JsonFactoryBuilder();
        builder.rootValueSeparator((SerializableString) null); // Cast to SerializableString to resolve ambiguity
        
        // Verify that _rootValueSeparator is set to null
        try {
            SerializableString result = (SerializableString) getFieldValue(builder, "_rootValueSeparator");
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object getFieldValue(JsonFactoryBuilder builder, String fieldName) throws Exception {
        java.lang.reflect.Field field = JsonFactoryBuilder.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(builder);
    }


}