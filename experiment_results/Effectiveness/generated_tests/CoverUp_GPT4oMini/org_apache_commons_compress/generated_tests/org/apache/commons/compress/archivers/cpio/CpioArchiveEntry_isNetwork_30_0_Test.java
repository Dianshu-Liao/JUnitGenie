package org.apache.commons.compress.archivers.cpio;

import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioUtil;
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

class CpioArchiveEntry_isNetwork_30_0_Test {

    private CpioArchiveEntry cpioArchiveEntry;

    @BeforeEach
    void setUp() {
        // Using a default format
        cpioArchiveEntry = new CpioArchiveEntry((short) 0);
    }

    @Test
    void testIsNetwork_WhenModeIsC_ISNWK_ShouldReturnTrue() throws Exception {
        // Set the mode to C_ISNWK (assuming C_ISNWK is defined as 0x0000000C for example)
        long C_ISNWK = 0x0000000C;
        setMode(cpioArchiveEntry, C_ISNWK);
        assertTrue(cpioArchiveEntry.isNetwork());
    }

    @Test
    void testIsNetwork_WhenModeIsNotC_ISNWK_ShouldReturnFalse() throws Exception {
        // Set the mode to a value that is not C_ISNWK
        // For example, C_ISREG
        long notC_ISNWK = 0x00000001;
        setMode(cpioArchiveEntry, notC_ISNWK);
        assertFalse(cpioArchiveEntry.isNetwork());
    }

    private void setMode(CpioArchiveEntry entry, long mode) throws Exception {
        Method setModeMethod = CpioArchiveEntry.class.getDeclaredMethod("setMode", long.class);
        setModeMethod.setAccessible(true);
        setModeMethod.invoke(entry, mode);
    }
}
