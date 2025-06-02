package org.apache.commons.compress.harmony.pack200;

import org.apache.commons.compress.harmony.pack200.PackingOptions;
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

class PackingOptions_setDeflateHint_25_0_Test {

    private PackingOptions packingOptions;

    @BeforeEach
    void setUp() {
        packingOptions = new PackingOptions();
    }

    @Test
    void testSetDeflateHint_ValidKeep() {
        packingOptions.setDeflateHint(PackingOptions.KEEP);
        assertEquals(PackingOptions.KEEP, packingOptions.getDeflateHint());
    }

    @Test
    void testSetDeflateHint_ValidTrue() {
        packingOptions.setDeflateHint("true");
        assertEquals("true", packingOptions.getDeflateHint());
    }

    @Test
    void testSetDeflateHint_ValidFalse() {
        packingOptions.setDeflateHint("false");
        assertEquals("false", packingOptions.getDeflateHint());
    }

    @Test
    void testSetDeflateHint_InvalidValue() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            packingOptions.setDeflateHint("invalid");
        });
        assertEquals("Bad argument: -H invalid ? deflate hint should be either true, false or keep (default)", thrown.getMessage());
    }

    @Test
    void testSetDeflateHint_NullValue() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            packingOptions.setDeflateHint(null);
        });
        assertEquals("Bad argument: -H null ? deflate hint should be either true, false or keep (default)", thrown.getMessage());
    }

    @Test
    void testGetDeflateHint_DefaultValue() {
        assertEquals(PackingOptions.KEEP, packingOptions.getDeflateHint());
    }
}
