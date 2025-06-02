package org.apache.commons.codec.binary;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

public class Base64_Base64_27_0_Test {

    private Base64 base64;

    @BeforeEach
    public void setUp() {
        base64 = new Base64();
    }

    @Test
    public void testBase64Constructor() {
        // Test the default constructor
        assertNotNull(base64);
    }
}
