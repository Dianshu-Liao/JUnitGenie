package org.apache.commons.jxpath.ri.compiler;
import org.apache.commons.jxpath.ri.compiler.CoreFunction;
import org.apache.commons.jxpath.JXPathInvalidSyntaxException;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class ri_compiler_CoreFunction_assertArgRange_int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAssertArgRangeThrowsException() {
        try {
            // Create an instance of CoreFunction with a valid constructor
            CoreFunction coreFunction = new CoreFunction(0, new org.apache.commons.jxpath.ri.compiler.Expression[0]);

            // Use reflection to access the private method assertArgRange
            Method method = CoreFunction.class.getDeclaredMethod("assertArgRange", int.class, int.class);
            method.setAccessible(true);

            // Define min and max values
            int min = 1;
            int max = 5;

            // Call the method with a valid state that should throw an exception
            method.invoke(coreFunction, min, max);
            fail("Expected JXPathInvalidSyntaxException to be thrown");
        } catch (JXPathInvalidSyntaxException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

}