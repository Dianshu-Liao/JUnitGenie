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

public class CpioArchiveEntry_isNetwork_30_0_Test {

    private CpioArchiveEntry entryRegular;

    private CpioArchiveEntry entryNetwork;

    // Regular file
    private static final long C_ISREG = 0x8000;

    // Network file
    private static final long C_ISNWK = 0x2000;

    @BeforeEach
    public void setUp() {
        entryRegular = new CpioArchiveEntry((short) 1);
        entryNetwork = new CpioArchiveEntry((short) 1);
    }

    @Test
    public void testIsNetwork_WhenModeIsNetwork_ReturnsTrue() {
        entryNetwork.setMode(C_ISNWK);
        assertTrue(entryNetwork.isNetwork(), "Expected isNetwork() to return true for network mode.");
    }

    @Test
    public void testIsNetwork_WhenModeIsRegular_ReturnsFalse() {
        entryRegular.setMode(C_ISREG);
        assertFalse(entryRegular.isNetwork(), "Expected isNetwork() to return false for regular mode.");
    }

    @Test
    public void testIsNetwork_WhenModeIsZero_ReturnsFalse() {
        entryRegular.setMode(0);
        assertFalse(entryRegular.isNetwork(), "Expected isNetwork() to return false for mode zero.");
    }

    @Test
    public void testIsNetwork_WhenModeIsInvalid_ReturnsFalse() {
        // Invalid mode
        entryRegular.setMode(0xFFFF);
        assertFalse(entryRegular.isNetwork(), "Expected isNetwork() to return false for invalid mode.");
    }
}
