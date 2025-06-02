package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;

public class json_WriterBasedJsonGenerator__writeBinary_Base64Variant_InputStream_byte_____cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testWriteBinary() {
        // Arrange
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", false, 'A', 76);
        byte[] readBuffer = new byte[] { (byte) 0xFF, (byte) 0xFE, (byte) 0xFD };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(readBuffer);
        
        WriterBasedJsonGenerator generator = new WriterBasedJsonGenerator(null, 0, null, null);
        
        // Accessing the protected method using reflection
        try {
            // Act
            int bytesWritten = (int) WriterBasedJsonGenerator.class
                    .getDeclaredMethod("_writeBinary", Base64Variant.class, InputStream.class, byte[].class)
                    .invoke(generator, base64Variant, inputStream, readBuffer);
            
            // Assert
            assertEquals(3, bytesWritten);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }


}