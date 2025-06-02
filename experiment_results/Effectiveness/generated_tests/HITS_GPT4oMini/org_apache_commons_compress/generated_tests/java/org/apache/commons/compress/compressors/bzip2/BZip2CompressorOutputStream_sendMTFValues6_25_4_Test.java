package org.apache.commons.compress.compressors.bzip2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorOutputStream;

public class BZip2CompressorOutputStream_sendMTFValues6_25_4_Test {

    private OutputStream outputStream;

    private BZip2CompressorOutputStream bzip2CompressorOutputStream;

    @BeforeEach
    public void setUp() throws IOException {
        outputStream = new ByteArrayOutputStream();
        bzip2CompressorOutputStream = new BZip2CompressorOutputStream(outputStream);
    }
}
