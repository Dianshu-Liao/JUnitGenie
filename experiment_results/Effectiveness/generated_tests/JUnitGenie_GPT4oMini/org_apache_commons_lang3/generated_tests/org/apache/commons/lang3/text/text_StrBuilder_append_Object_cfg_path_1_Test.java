package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_append_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAppendWithCharSequence() {
        StrBuilder strBuilder = new StrBuilder();
        CharSequence charSequence = "Test String";
        
        // Execute the focal method
        StrBuilder result = strBuilder.append(charSequence);
        
        // Verify the result
        assertEquals("Test String", result.toString());
    }

    @Test(timeout = 4000)
    public void testAppendWithNonNullObject() {
        StrBuilder strBuilder = new StrBuilder();
        Object obj = new Object() {
            @Override
            public String toString() {
                return "Object String";
            }
        };
        
        // Execute the focal method
        StrBuilder result = strBuilder.append(obj);
        
        // Verify the result
        assertEquals("Object String", result.toString());
    }

    @Test(timeout = 4000)
    public void testAppendWithNull() {
        StrBuilder strBuilder = new StrBuilder();
        
        // Execute the focal method and handle the exception
        try {
            // Explicitly cast null to CharSequence to resolve ambiguity
            StrBuilder result = strBuilder.append((CharSequence) null);
            // If no exception is thrown, we can check the result
            assertEquals("", result.toString());
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }


}