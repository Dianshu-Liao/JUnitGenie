package org.apache.commons.codec.net;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;
import org.junit.Assert;
import java.util.BitSet;
import java.io.ByteArrayOutputStream;

public class net_URLCodec_encodeUrl_BitSet_byte_____cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testEncodeUrl() {
        // Given
        BitSet urlsafe = new BitSet(256);
        for (int i = 0; i < 256; i++) {
            if (i >= 'a' && i <= 'z' || i >= 'A' && i <= 'Z' || i >= '0' && i <= '9' || i == '-' || i == '_' || i == '.' || i == '~' || i == ' ') {
                urlsafe.set(i);
            }
        }
        byte[] bytes = new byte[] {'a', 'b', 'c', ' ', 'd'}; // Test input contains a space

        // When
        byte[] result = URLCodec.encodeUrl(urlsafe, bytes);

        // Then
        byte[] expected = new byte[] {'a', 'b', 'c', '+', 'd'}; // Expected result with space encoded as '+'
        Assert.assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testEncodeUrlWithNullBytes() {
        // Given
        BitSet urlsafe = new BitSet(256);
        for (int i = 0; i < 256; i++) {
            if (i >= 'a' && i <= 'z' || i >= 'A' && i <= 'Z' || i >= '0' && i <= '9' || i == '-' || i == '_' || i == '.' || i == '~' || i == ' ') {
                urlsafe.set(i);
            }
        }
        byte[] bytes = null; // Test with null bytes

        // When
        byte[] result = URLCodec.encodeUrl(urlsafe, bytes);

        // Then
        Assert.assertNull(result); // Should return null if input bytes are null
    }

    @Test(timeout = 4000)
    public void testEncodeUrlWithDefaultUrlSafe() {
        // Given
        byte[] bytes = new byte[] {'#', ' ', 'a'}; // Test input has characters not in urlsafe

        // When
        byte[] result = null;
        try {
            BitSet urlsafe = new BitSet(256);
            for (int i = 0; i < 256; i++) {
                if (i >= 'a' && i <= 'z' || i >= 'A' && i <= 'Z' || i >= '0' && i <= '9' || i == '-' || i == '_' || i == '.' || i == '~' || i == ' ') {
                    urlsafe.set(i);
                }
            }
            result = URLCodec.encodeUrl(urlsafe, bytes); // Using default url safe (WWW_FORM_URL_SAFE)
        } catch (Exception e) {
            Assert.fail("Exception thrown: " + e.getMessage());
        }

        // Then
        byte[] expected = new byte[] {'%', '2', '3', '+', 'a'}; // Encoding of '#' as "%23" and space as '+'
        Assert.assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testHexDigitWithSupportedInteger() {
        // Given
        int input = 45; // Valid integer within 0 to 255

        // When
        char hexValue = Utils.hexDigit(input); // Using the Utils class's hexDigit method

        // Then
        Assert.assertEquals('D', hexValue); // Expected hex representation of 45 is 'D'
    }

    // Additional test cases can be added to cover further scenarios.


}