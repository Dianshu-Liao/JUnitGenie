package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_JXPathContextReferenceImpl_allocateConditionally_String_String_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testAllocateConditionally_ClassNotFound() {
        String className = "non.existent.ClassName";
        String existenceCheckClassName = "non.existent.ExistenceCheckClassName";

        Object result = JXPathContextReferenceImpl.allocateConditionally(className, existenceCheckClassName);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testAllocateConditionally_ValidClass() {
        String className = "java.lang.String"; // A valid class
        String existenceCheckClassName = "java.lang.String"; // Also a valid class for existence check

        Object result = null;
        try {
            result = JXPathContextReferenceImpl.allocateConditionally(className, existenceCheckClassName);
        } catch (JXPathException ex) {
            fail("Should not have thrown JXPathException: " + ex.getMessage());
        }
        
        assertNotNull(result);
        assertTrue(result instanceof String); // Check if the result is an instance of String
    }

    @Test(timeout = 4000)
    public void testAllocateConditionally_ExceptionThrown() {
        String className = "java.lang.String"; // A valid class
        String existenceCheckClassName = "non.existent.ExistenceCheckClassName"; // Invalid class

        try {
            JXPathContextReferenceImpl.allocateConditionally(className, existenceCheckClassName);
        } catch (JXPathException ex) {
            assertEquals("Cannot allocate java.lang.String", ex.getMessage());
            assertNotNull(ex.getCause());
        }
    }

}