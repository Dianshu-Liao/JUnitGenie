package org.apache.commons.compress.archivers.cpio;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.utils.ExactMath;
import org.apache.commons.compress.utils.TimeUtils;

public class CpioArchiveEntry_checkNewFormat_0_0_Test {

    // Example value for new format mask
    private static final short FORMAT_NEW_MASK = 0x01;

    // Example value for old format mask
    private static final short FORMAT_OLD_MASK = 0x00;

    @Test
    public void testCheckNewFormatThrowsExceptionWhenFormatIsOld() throws Exception {
        CpioArchiveEntry entry = new CpioArchiveEntry(FORMAT_OLD_MASK);
        Method method = CpioArchiveEntry.class.getDeclaredMethod("checkNewFormat");
        // Make the private method accessible
        method.setAccessible(true);
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> method.invoke(entry));
        assertNotNull(exception);
    }

    @Test
    public void testCheckNewFormatDoesNotThrowExceptionWhenFormatIsNew() throws Exception {
        CpioArchiveEntry entry = new CpioArchiveEntry(FORMAT_NEW_MASK);
        Method method = CpioArchiveEntry.class.getDeclaredMethod("checkNewFormat");
        // Make the private method accessible
        method.setAccessible(true);
        assertDoesNotThrow(() -> method.invoke(entry));
    }
}
