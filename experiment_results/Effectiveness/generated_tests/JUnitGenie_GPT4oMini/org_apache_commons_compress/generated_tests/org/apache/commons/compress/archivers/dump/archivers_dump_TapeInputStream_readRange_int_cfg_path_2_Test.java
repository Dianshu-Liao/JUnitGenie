package org.apache.commons.compress.archivers.dump;
import org.apache.commons.compress.archivers.dump.TapeInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class archivers_dump_TapeInputStream_readRange_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testReadRange() {
        try {
            // Prepare the input stream with some data
            byte[] data = new byte[]{1, 2, 3, 4, 5};
            ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
            TapeInputStream tapeInputStream = new TapeInputStream(inputStream);

            // Access the private method using reflection
            Method method = TapeInputStream.class.getDeclaredMethod("readRange", int.class);
            method.setAccessible(true);

            // Call the method with a valid length
            byte[] result = (byte[]) method.invoke(tapeInputStream, 5);
            assertArrayEquals(data, result);

        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }


}