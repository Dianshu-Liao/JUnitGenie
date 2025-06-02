package org.apache.commons.compress.harmony.pack200;

import org.apache.commons.compress.harmony.pack200.PackingOptions;
import java.lang.reflect.Method;
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
        // Invoke the setQuiet method with true
        invokeSetQuietMethod(true);
        // Verify that verbose is set to false
        assertFalse(getVerboseField());
    }

    @Test
    public void testSetQuietFalse() throws Exception {
        // Invoke the setQuiet method with false
        invokeSetQuietMethod(false);
        // Verify that verbose is set to true
        assertTrue(getVerboseField());
    }

    private void invokeSetQuietMethod(boolean quiet) throws Exception {
        Method method = PackingOptions.class.getDeclaredMethod("setQuiet", boolean.class);
        method.setAccessible(true);
        method.invoke(packingOptions, quiet);
    }

    private boolean getVerboseField() throws Exception {
        java.lang.reflect.Field field = PackingOptions.class.getDeclaredField("verbose");
        field.setAccessible(true);
        return (boolean) field.get(packingOptions);
    }
}
