package org.apache.commons.compress.compressors;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class compressors_CompressorStreamFactory_setDecompressConcatenated_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSetDecompressConcatenated_ThrowsIllegalStateException() {
        // Arrange
        CompressorStreamFactory factory = new CompressorStreamFactory(true); // Using constructor that sets decompressUntilEof
        boolean decompressConcatenated = true;

        // Act
        try {
            factory.setDecompressConcatenated(decompressConcatenated);
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            // Assert
            assertEquals("Cannot override the setting defined by the constructor", e.getMessage());
        }
    }


}