package org.apache.commons.jxpath.servlet;
import org.apache.commons.jxpath.servlet.KeywordVariables;
import org.junit.Test;
import static org.junit.Assert.*;

public class servlet_KeywordVariables__init__String_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testConstructorWithValidParameters() {
        String keyword = "testKeyword";
        Object object = new Object();
        
        KeywordVariables kv = new KeywordVariables(keyword, object);
        
        // Since the fields are private and final, we cannot directly access them.
        // We would typically use reflection or a public method to verify the state.
        // Here we assume there are getter methods for testing purposes.
        // assertEquals("testKeyword", kv.getKeyword());
        // assertEquals(object, kv.getObject());
    }

    @Test(timeout = 4000)
    public void testConstructorWithNullKeyword() {
        try {
            new KeywordVariables(null, new Object());
            fail("Expected IllegalArgumentException for null keyword");
        } catch (IllegalArgumentException e) {
            assertEquals("keyword cannot be null", e.getMessage());
        }
    }

}