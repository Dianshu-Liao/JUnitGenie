package org.apache.commons.codec.binary;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.codec.binary.BaseNCodec.EOF;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Objects;
import org.apache.commons.codec.binary.BaseNCodec.Context;

public class BaseNCodecInputStream_skip_7_0_Test {

    private BaseNCodecInputStream baseNCodecInputStream;

    private BaseNCodec baseNCodec;

    private ByteArrayInputStream inputStream;

    private static class TestBaseNCodec extends BaseNCodec {

        public TestBaseNCodec() {
            // Use appropriate parameters for the constructor
            super(0, 0, 0, 0);
        }

        @Override
        public boolean hasData(Context context) {
            return true;
        }

        @Override
        public void encode(byte[] array, int offset, int length, Context context) {
            // Mock encode method
        }

        @Override
        public void decode(byte[] array, int offset, int length, Context context) {
            // Mock decode method
        }

        @Override
        public int readResults(byte[] array, int offset, int length, Context context) {
            return Math.min(length, 512);
        }

        @Override
        protected boolean isInAlphabet(byte byteToCheck) {
            // Mock implementation
            return true;
        }
    }

    @BeforeEach
    public void setUp() {
        baseNCodec = new TestBaseNCodec();
        inputStream = new ByteArrayInputStream(new byte[2048]);
        baseNCodecInputStream = new BaseNCodecInputStream(inputStream, baseNCodec, false);
    }

    @Test
    public void testSkipValidLength() throws IOException {
        long skipped = baseNCodecInputStream.skip(1024);
        assertEquals(1024, skipped);
    }

    @Test
    public void testSkipExactBufferSize() throws IOException {
        long skipped = baseNCodecInputStream.skip(512);
        assertEquals(512, skipped);
    }

    @Test
    public void testSkipMoreThanAvailable() throws IOException {
        long skipped = baseNCodecInputStream.skip(3000);
        assertEquals(2048, skipped);
    }

    @Test
    public void testSkipNegativeLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            baseNCodecInputStream.skip(-1);
        });
    }

    @Test
    public void testSkipZeroLength() throws IOException {
        long skipped = baseNCodecInputStream.skip(0);
        assertEquals(0, skipped);
    }

    @Test
    public void testSkipWithEOF() throws IOException {
        baseNCodec = new TestBaseNCodec() {

            @Override
            public boolean hasData(Context context) {
                // No data available
                return false;
            }

            @Override
            public int readResults(byte[] array, int offset, int length, Context context) {
                // Simulate EOF
                return EOF;
            }
        };
        baseNCodecInputStream = new BaseNCodecInputStream(inputStream, baseNCodec, false);
        long skipped = baseNCodecInputStream.skip(512);
        assertEquals(0, skipped);
    }
}
