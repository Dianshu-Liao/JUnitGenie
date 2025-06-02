package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonPointer;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class JsonPointer_toStringBuilder_int_cfg_path_2_Test {

    private JsonPointer jsonPointer;

    @Before
    public void setUp() throws Exception {
        // Accessing the protected constructor using reflection
        Constructor<JsonPointer> constructor = JsonPointer.class.getDeclaredConstructor(String.class, int.class, String.class, JsonPointer.class);
        constructor.setAccessible(true);
        jsonPointer = constructor.newInstance("exampleString", 5, "exampleSeparator", null);
    }

    @Test(timeout = 4000)
    public void testToStringBuilder() throws Exception {
        // Define slack parameter
        int slack = 10;
        
        // Accessing the protected method using reflection
        Method method = JsonPointer.class.getDeclaredMethod("toStringBuilder", int.class);
        method.setAccessible(true);

        // Create the expected StringBuilder output
        StringBuilder expected = new StringBuilder("exampleString".substring(5) + slack);
        
        // Invoke the method
        StringBuilder actual = (StringBuilder) method.invoke(jsonPointer, slack);

        // Assert the actual output with the expected output
        assertEquals(expected.toString(), actual.toString());
    }

}