package org.apache.commons.compress.archivers.cpio;

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

public class CpioArchiveEntry_getMode_17_0_Test {

    private CpioArchiveEntry entryRegular;

    private CpioArchiveEntry entryDirectory;

    private CpioArchiveEntry entryTrailer;

    private CpioArchiveEntry entryWithMode;

    // Example mode for regular file
    private static final long C_ISREG = 0x8000;

    // Example mode for directory
    private static final long C_ISDIR = 0x4000;

    // Example trailer name
    private static final String CPIO_TRAILER = "TRAILER!!!";

    @BeforeEach
    public void setUp() {
        entryRegular = new CpioArchiveEntry("regularFile");
        entryRegular.setMode(C_ISREG);
        entryDirectory = new CpioArchiveEntry("directory");
        entryDirectory.setMode(C_ISDIR);
        entryTrailer = new CpioArchiveEntry(CPIO_TRAILER);
        // Set mode to 0 for trailer entry
        entryTrailer.setMode(0);
        entryWithMode = new CpioArchiveEntry("fileWithMode");
        // Arbitrary mode
        entryWithMode.setMode(0x1234);
    }

    @Test
    public void testGetModeRegularFile() {
        assertEquals(C_ISREG, entryRegular.getMode(), "The mode for a regular file should be C_ISREG.");
    }

    @Test
    public void testGetModeDirectory() {
        assertEquals(C_ISDIR, entryDirectory.getMode(), "The mode for a directory should be C_ISDIR.");
    }

    @Test
    public void testGetModeTrailer() {
        assertEquals(0, entryTrailer.getMode(), "The mode for a trailer entry should be 0.");
    }

    @Test
    public void testGetModeWithSetMode() {
        assertEquals(0x1234, entryWithMode.getMode(), "The mode should be the one explicitly set.");
    }

    @Test
    public void testGetModeWhenModeIsZeroButNotTrailer() {
        CpioArchiveEntry entry = new CpioArchiveEntry("someFile");
        // mode is zero but it's not a trailer
        entry.setMode(0);
        assertEquals(C_ISREG, entry.getMode(), "The mode should default to C_ISREG when mode is zero and not a trailer.");
    }
}
