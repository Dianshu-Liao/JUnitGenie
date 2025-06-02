package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonPointer;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class JsonPointer_toStringBuilder_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToStringBuilder() {
        try {
            // Use reflection to access the constructor
            Constructor<JsonPointer> constructor = JsonPointer.class.getDeclaredConstructor(String.class, int.class, String.class, JsonPointer.class);
            constructor.setAccessible(true);

            // Initialize the required parameters for the constructor
            JsonPointer pointer = constructor.newInstance("testString", 5, "someString", null);

            // Use reflection to access the protected method 'toStringBuilder'
            Method toStringBuilderMethod = JsonPointer.class.getDeclaredMethod("toStringBuilder", int.class);
            toStringBuilderMethod.setAccessible(true);

            // Call the method with slack = 10
            StringBuilder result = (StringBuilder) toStringBuilderMethod.invoke(pointer, 10);

            // Expected result as _asString is "testString" and _asStringOffset is 5
            String expected = "String"; // as it should skip the first 5 characters

            assertEquals(expected, result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}