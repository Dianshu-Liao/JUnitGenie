package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.ConstructorDetector;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import org.junit.Test;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class SerializationConfig_with_ConstructorDetector_cfg_path_1_Test {


    @Test(timeout = 4000)
    public void testWithSameConstructorDetector() {
        // Creating an instance of SerializationConfig.
        SerializationConfig originalConfig = new SerializationConfig(null, null, null, null, null, null);

        // The same ConstructorDetector instance.
        ConstructorDetector sameCtorDetector = originalConfig._ctorDetector; // Accessing protected variable directly.

        // Call the method under test.
        SerializationConfig resultConfig = originalConfig.with(sameCtorDetector);

        // Validate that the returned instance is the same as the original instance.
        assertSame(originalConfig, resultConfig);
    }


}
