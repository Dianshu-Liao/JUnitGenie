package org.apache.commons.codec.digest;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

public class HmacUtils_hmac_43_0_Test {

    @Test
    public void testHmac() {
        // Arrange
        String algorithm = "HmacSHA256";
        String key = "secretKey";
        String message = "Hello, World!";
        // Convert key to byte array
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        HmacUtils hmacUtils = new HmacUtils(algorithm, keyBytes);
        // Convert message to ByteBuffer
        ByteBuffer valueToDigest = ByteBuffer.wrap(message.getBytes(StandardCharsets.UTF_8));
        // Act
        byte[] hmacResult = hmacUtils.hmac(valueToDigest);
        // Assert
        // Expected HMAC value (calculated externally for the given input)
        // Replace with actual expected value
        String expectedHmacHex = "expected_hmac_value_here";
        String actualHmacHex = Hex.encodeHexString(hmacResult);
        Assertions.assertEquals(expectedHmacHex, actualHmacHex);
    }
}
