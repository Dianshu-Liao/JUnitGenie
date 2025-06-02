package org.apache.commons.compress.archivers.dump;

import java.io.IOException;
import java.lang.reflect.Field;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Date;
import java.util.Objects;

public class DumpArchiveSummary_isMetaDataOnly_15_0_Test {

    private DumpArchiveSummary summaryWithMetaDataOnly;

    private DumpArchiveSummary summaryWithoutMetaData;

    @BeforeEach
    public void setUp() throws IOException, NoSuchFieldException, IllegalAccessException {
        byte[] bufferWithMetaData = new byte[0];
        ZipEncoding encoding = null;
        summaryWithMetaDataOnly = new DumpArchiveSummary(bufferWithMetaData, encoding);
        setFlags(summaryWithMetaDataOnly, 0x0100);
        byte[] bufferWithoutMetaData = new byte[0];
        summaryWithoutMetaData = new DumpArchiveSummary(bufferWithoutMetaData, encoding);
        setFlags(summaryWithoutMetaData, 0x0000);
    }

    private void setFlags(DumpArchiveSummary summary, int flags) throws NoSuchFieldException, IllegalAccessException {
        Field flagsField = DumpArchiveSummary.class.getDeclaredField("flags");
        flagsField.setAccessible(true);
        flagsField.setInt(summary, flags);
    }

    @Test
    public void testIsMetaDataOnly_ReturnsTrue_WhenFlagsIndicateMetaDataOnly() {
        assertTrue(summaryWithMetaDataOnly.isMetaDataOnly(), "Expected isMetaDataOnly to return true when flags indicate metadata only.");
    }

    @Test
    public void testIsMetaDataOnly_ReturnsFalse_WhenFlagsDoNotIndicateMetaDataOnly() {
        assertFalse(summaryWithoutMetaData.isMetaDataOnly(), "Expected isMetaDataOnly to return false when flags do not indicate metadata only.");
    }
}
