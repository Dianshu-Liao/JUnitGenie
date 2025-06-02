package org.apache.commons.jxpath.servlet;
import org.apache.commons.jxpath.servlet.KeywordVariables;
import org.junit.Test;

public class servlet_KeywordVariables__init__String_Object_cfg_path_1_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNullKeyword() {
        try {
            new KeywordVariables(null, new Object());
        } catch (IllegalArgumentException e) {
            // Exception expected
            // You can also verify the exception message if needed
            assert "keyword cannot be null".equals(e.getMessage());
            throw e; // rethrow to satisfy the expected exception in the test
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithValidParameters() {
        try {
            KeywordVariables keywordVariables = new KeywordVariables("validKeyword", new Object());
            // Further assertions can be added to verify the state of the object
        } catch (Exception e) {
            assert false : "Should not throw exception with valid parameters";
        }
    }

}