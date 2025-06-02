package org.apache.commons.compress.archivers.cpio;

import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.EOFException;
import java.io.IOException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;

public class CpioArchiveInputStream_CpioArchiveInputStream_21_0_Test {

    @Test
    public void testConstructorWithValidParameters() {
        InputStream inputStream = new ByteArrayInputStream(new byte[10]);
        int blockSize = 512;
        String encoding = "UTF-8";
        CpioArchiveInputStream cpioArchiveInputStream = new CpioArchiveInputStream(inputStream, blockSize, encoding);
        // Additional assertions can be added here to verify the state of the object if needed.
    }

    @Test
    public void testConstructorWithZeroBlockSize() {
        InputStream inputStream = new ByteArrayInputStream(new byte[10]);
        String encoding = "UTF-8";
        assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveInputStream(inputStream, 0, encoding);
        });
    }

    @Test
    public void testConstructorWithNegativeBlockSize() {
        InputStream inputStream = new ByteArrayInputStream(new byte[10]);
        String encoding = "UTF-8";
        assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveInputStream(inputStream, -1, encoding);
        });
    }

    @Test
    public void testConstructorWithNullInputStream() {
        int blockSize = 512;
        String encoding = "UTF-8";
        assertThrows(NullPointerException.class, () -> {
            new CpioArchiveInputStream(null, blockSize, encoding);
        });
    }

    @Test
    public void testConstructorWithNullEncoding() {
        InputStream inputStream = new ByteArrayInputStream(new byte[10]);
        int blockSize = 512;
        assertThrows(NullPointerException.class, () -> {
            new CpioArchiveInputStream(inputStream, blockSize, null);
        });
    }
}
