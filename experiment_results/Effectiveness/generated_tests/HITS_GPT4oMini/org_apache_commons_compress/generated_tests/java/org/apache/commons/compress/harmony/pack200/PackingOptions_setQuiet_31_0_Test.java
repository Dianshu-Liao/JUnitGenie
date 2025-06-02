package org.apache.commons.compress.harmony.pack200;

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

    @Test
    public void testSetQuietTrue() {
        PackingOptions options = new PackingOptions();
        options.setQuiet(true);
        assertFalse(options.isVerbose(), "Expected verbose to be false when setQuiet(true) is called.");
    }

    @Test
    public void testSetQuietFalse() {
        PackingOptions options = new PackingOptions();
        options.setQuiet(false);
        assertTrue(options.isVerbose(), "Expected verbose to be true when setQuiet(false) is called.");
    }
}
