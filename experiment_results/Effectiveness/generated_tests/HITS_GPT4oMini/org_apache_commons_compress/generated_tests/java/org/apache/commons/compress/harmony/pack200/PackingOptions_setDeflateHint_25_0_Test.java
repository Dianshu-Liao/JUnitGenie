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

public class PackingOptions_setDeflateHint_25_0_Test {

    @Test
    public void testSetDeflateHint_Keep() {
        PackingOptions options = new PackingOptions();
        options.setDeflateHint(PackingOptions.KEEP);
        // Assert that the deflateHint was set correctly
        assertEquals(PackingOptions.KEEP, options.getDeflateHint());
    }

    @Test
    public void testSetDeflateHint_True() {
        PackingOptions options = new PackingOptions();
        options.setDeflateHint("true");
        // Assert that the deflateHint was set correctly
        assertEquals("true", options.getDeflateHint());
    }

    @Test
    public void testSetDeflateHint_False() {
        PackingOptions options = new PackingOptions();
        options.setDeflateHint("false");
        // Assert that the deflateHint was set correctly
        assertEquals("false", options.getDeflateHint());
    }

    @Test
    public void testSetDeflateHint_InvalidValue() {
        PackingOptions options = new PackingOptions();
        // Assert that IllegalArgumentException is thrown for invalid values
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            options.setDeflateHint("invalid");
        });
        assertEquals("Bad argument: -H invalid ? deflate hint should be either true, false or keep (default)", exception.getMessage());
    }

    @Test
    public void testSetDeflateHint_NullValue() {
        PackingOptions options = new PackingOptions();
        // Assert that IllegalArgumentException is thrown for null value
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            options.setDeflateHint(null);
        });
        assertEquals("Bad argument: -H null ? deflate hint should be either true, false or keep (default)", exception.getMessage());
    }
}
