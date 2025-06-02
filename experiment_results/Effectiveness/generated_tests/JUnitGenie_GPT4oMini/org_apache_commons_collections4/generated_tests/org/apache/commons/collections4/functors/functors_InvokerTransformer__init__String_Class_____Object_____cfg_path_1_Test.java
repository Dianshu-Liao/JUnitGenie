package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.InvokerTransformer;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class functors_InvokerTransformer__init__String_Class_____Object_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testInvokerTransformerInitialization() {
        String methodName = "sampleMethod";
        Class<?>[] paramTypes = {String.class, Integer.class};
        Object[] args = {"arg1", 2};

        // Constructing the InvokerTransformer
        InvokerTransformer transformer = null;
        try {
            transformer = new InvokerTransformer(methodName, paramTypes, args);
        } catch (Exception e) {
            // Handle exception if any
            e.printStackTrace();
        }

        // Verify that the constructed object is not null
        assertNotNull(transformer);
    }

}