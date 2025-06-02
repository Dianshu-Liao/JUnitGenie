// Test method
package org.apache.commons.compress.archivers.dump;

import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
// Fixed import
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DumpArchiveSummary_isExtendedAttributes_14_0_Test {

    private DumpArchiveSummary dumpArchiveSummary;

    @BeforeEach
    public void setUp() throws IOException {
        // Assuming a valid byte array and ZipEncoding instance are provided
        // Replace with actual byte array as needed
        byte[] buffer = new byte[0];
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding("UTF-8");
        dumpArchiveSummary = new DumpArchiveSummary(buffer, encoding);
    }

    @Test
    public void testIsExtendedAttributes_WhenFlagsHaveExtendedAttributes() throws Exception {
        // Set flags to 0x8000 to simulate extended attributes
        setPrivateField(dumpArchiveSummary, "flags", 0x8000);
        assertTrue(dumpArchiveSummary.isExtendedAttributes());
    }

    @Test
    public void testIsExtendedAttributes_WhenFlagsDoNotHaveExtendedAttributes() throws Exception {
        // Set flags to 0x0000 to simulate no extended attributes
        setPrivateField(dumpArchiveSummary, "flags", 0x0000);
        assertFalse(dumpArchiveSummary.isExtendedAttributes());
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
