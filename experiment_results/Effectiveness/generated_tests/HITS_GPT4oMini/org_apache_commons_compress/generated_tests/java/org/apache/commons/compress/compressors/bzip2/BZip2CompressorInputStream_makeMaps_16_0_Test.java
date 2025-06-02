package org.apache.commons.compress.compressors.bzip2;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import java.nio.ByteOrder;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.BitInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.CloseShieldInputStream;

class BZip2CompressorInputStream_makeMaps_16_0_Test {

    private BZip2CompressorInputStream bzip2CompressorInputStream;

    @BeforeEach
    void setUp() throws IOException {
        byte[] mockInput = new byte[] { 0, 1, 2, 3, 4, 5 };
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mockInput);
        bzip2CompressorInputStream = new BZip2CompressorInputStream(byteArrayInputStream);
    }

    private void invokeMakeMaps() throws Exception {
        Method makeMapsMethod = BZip2CompressorInputStream.class.getDeclaredMethod("makeMaps");
        makeMapsMethod.setAccessible(true);
        makeMapsMethod.invoke(bzip2CompressorInputStream);
    }

    private void setDataField(Data data) throws Exception {
        Field dataField = BZip2CompressorInputStream.class.getDeclaredField("data");
        dataField.setAccessible(true);
        dataField.set(bzip2CompressorInputStream, data);
    }

    private Data createData() {
        return new Data();
    }

    private int getNInUse() throws Exception {
        Field nInUseField = BZip2CompressorInputStream.class.getDeclaredField("nInUse");
        nInUseField.setAccessible(true);
        return (int) nInUseField.get(bzip2CompressorInputStream);
    }

    private byte[] getSeqToUnseq() throws Exception {
        Field seqToUnseqField = BZip2CompressorInputStream.class.getDeclaredField("seqToUnseq");
        seqToUnseqField.setAccessible(true);
        return (byte[]) seqToUnseqField.get(bzip2CompressorInputStream);
    }

    @Test
    void testMakeMapsWithNoInUse() throws Exception {
        Data data = createData();
        data.inUse = new boolean[256];
        setDataField(data);
        invokeMakeMaps();
        assertEquals(0, getNInUse());
        assertArrayEquals(new byte[0], Arrays.copyOf(getSeqToUnseq(), 256));
    }

    @Test
    void testMakeMapsWithSomeInUse() throws Exception {
        Data data = createData();
        data.inUse = new boolean[256];
        data.inUse[0] = true;
        data.inUse[1] = true;
        setDataField(data);
        invokeMakeMaps();
        assertEquals(2, getNInUse());
        assertArrayEquals(new byte[] { 0, 1 }, Arrays.copyOf(getSeqToUnseq(), 2));
    }

    @Test
    void testMakeMapsWithAllInUse() throws Exception {
        Data data = createData();
        data.inUse = new boolean[256];
        Arrays.fill(data.inUse, true);
        setDataField(data);
        invokeMakeMaps();
        assertEquals(256, getNInUse());
        byte[] expectedSeqToUnseq = new byte[256];
        for (int i = 0; i < 256; i++) {
            expectedSeqToUnseq[i] = (byte) i;
        }
        assertArrayEquals(expectedSeqToUnseq, Arrays.copyOf(getSeqToUnseq(), 256));
    }

    public static class Data {

        boolean[] inUse = new boolean[256];
    }
}
