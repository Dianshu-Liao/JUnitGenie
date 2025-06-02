package org.apache.commons.compress.compressors.bzip2;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class compressors_bzip2_BZip2CompressorOutputStream_write0_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWrite0() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BZip2CompressorOutputStream compressorOutputStream = null;

        try {
            compressorOutputStream = new BZip2CompressorOutputStream(outputStream);
            
            // Accessing the private method write0 using reflection
            Method write0Method = BZip2CompressorOutputStream.class.getDeclaredMethod("write0", int.class);
            write0Method.setAccessible(true);

            // Test case where currentChar is -1
            write0Method.invoke(compressorOutputStream, 100);
            // Verify the internal state
            assertEquals(100 & 0xff, getCurrentChar(compressorOutputStream));
            assertEquals(1, getRunLength(compressorOutputStream));

            // Test case where currentChar is not -1
            write0Method.invoke(compressorOutputStream, 100);
            assertEquals(100 & 0xff, getCurrentChar(compressorOutputStream));
            assertEquals(2, getRunLength(compressorOutputStream));

            // Test case where currentChar is equal to b
            write0Method.invoke(compressorOutputStream, 100);
            assertEquals(100 & 0xff, getCurrentChar(compressorOutputStream));
            assertEquals(3, getRunLength(compressorOutputStream));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (compressorOutputStream != null) {
                try {
                    compressorOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private int getCurrentChar(BZip2CompressorOutputStream compressorOutputStream) throws Exception {
        java.lang.reflect.Field currentCharField = BZip2CompressorOutputStream.class.getDeclaredField("currentChar");
        currentCharField.setAccessible(true);
        return (int) currentCharField.get(compressorOutputStream);
    }

    private int getRunLength(BZip2CompressorOutputStream compressorOutputStream) throws Exception {
        java.lang.reflect.Field runLengthField = BZip2CompressorOutputStream.class.getDeclaredField("runLength");
        runLengthField.setAccessible(true);
        return (int) runLengthField.get(compressorOutputStream);
    }


}