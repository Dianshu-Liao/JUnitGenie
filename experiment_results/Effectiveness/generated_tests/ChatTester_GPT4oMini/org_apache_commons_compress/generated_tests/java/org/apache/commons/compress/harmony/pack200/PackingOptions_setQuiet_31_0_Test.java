// Test method
package org.apache.commons.compress.harmony.pack200;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.objectweb.asm.Attribute;

public class PackingOptions_setQuiet_31_0_Test {

    private PackingOptions packingOptions;

    @BeforeEach
    public void setUp() {
        packingOptions = new PackingOptions();
    }

    @Test
    public void testSetQuietTrue() throws Exception {
        // Invoke the method with `true`
        invokeSetQuiet(true);
        // Assert that verbose is set to false
        assertFalse(getVerboseFieldValue());
    }

    @Test
    public void testSetQuietFalse() throws Exception {
        // Invoke the method with `false`
        invokeSetQuiet(false);
        // Assert that verbose is set to true
        assertTrue(getVerboseFieldValue());
    }

    private void invokeSetQuiet(boolean quiet) throws Exception {
        Method method = PackingOptions.class.getDeclaredMethod("setQuiet", boolean.class);
        method.setAccessible(true);
        method.invoke(packingOptions, quiet);
    }

    private boolean getVerboseFieldValue() throws Exception {
        Field field = PackingOptions.class.getDeclaredField("verbose");
        field.setAccessible(true);
        return (boolean) field.get(packingOptions);
    }
}
