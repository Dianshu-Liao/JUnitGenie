package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_JXPathContextReferenceImpl_allocateConditionally_String_String_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testAllocateConditionally() {
        String className = "java.lang.String"; // Example class to allocate
        String existenceCheckClassName = "java.lang.String"; // Class to check existence

        try {
            Object result = JXPathContextReferenceImpl.allocateConditionally(className, existenceCheckClassName);
            assertNotNull("Expected non-null result for existing class", result);
            assertTrue("Expected result to be an instance of String", result instanceof String);
        } catch (Exception ex) {
            fail("Exception should not have been thrown: " + ex.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAllocateConditionally_ClassNotFound() {
        String className = "non.existent.Class"; // Non-existent class
        String existenceCheckClassName = "java.lang.String"; // Class to check existence

        try {
            Object result = JXPathContextReferenceImpl.allocateConditionally(className, existenceCheckClassName);
            assertNull("Expected null result for non-existent class", result);
        } catch (Exception ex) {
            fail("Exception should not have been thrown: " + ex.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAllocateConditionally_ThrowsException() {
        String className = "java.lang.String"; // Example class to allocate
        String existenceCheckClassName = "non.existent.Class"; // Non-existent class to trigger exception

        try {
            JXPathContextReferenceImpl.allocateConditionally(className, existenceCheckClassName);
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException ex) {
            assertTrue("Exception message should contain className", ex.getMessage().contains(className));
        } catch (Exception ex) {
            fail("Expected JXPathException but got: " + ex.getClass().getSimpleName());
        }
    }

}