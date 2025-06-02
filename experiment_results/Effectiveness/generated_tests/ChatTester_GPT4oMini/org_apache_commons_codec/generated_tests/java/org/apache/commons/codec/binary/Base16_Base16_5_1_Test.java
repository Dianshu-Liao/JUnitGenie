package org.apache.commons.codec.binary;

import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

class Base16_Base16_5_1_Test {

    private Base16 base16;

    @BeforeEach
    void setUp() {
        base16 = new Base16();
    }

    @Test
    void testBase16DefaultConstructor() {
        assertNotNull(base16, "Base16 instance should not be null");
        // Additional assertions can be added here to check the state of the object if necessary.
    }

    @Test
    void testBase16ConstructorWithLowerCase() throws Exception {
        Base16 base16LowerCase = (Base16) Base16.class.getDeclaredConstructor(boolean.class).newInstance(true);
        assertNotNull(base16LowerCase, "Base16 instance with lower case should not be null");
        // Additional assertions can be added here to check the state of the object if necessary.
    }

    @Test
    void testBase16ConstructorWithUpperCase() throws Exception {
        Base16 base16UpperCase = (Base16) Base16.class.getDeclaredConstructor(boolean.class).newInstance(false);
        assertNotNull(base16UpperCase, "Base16 instance with upper case should not be null");
        // Additional assertions can be added here to check the state of the object if necessary.
    }

    @Test
    void testBase16ConstructorWithDefaultValues() {
        // Testing the default constructor
        assertNotNull(base16, "Base16 instance should not be null");
        // Check if the default constructor initializes the encodeTable and decodeTable correctly
        // Since the tables are private, we will need to use reflection to access them
        try {
            Field encodeTableField = Base16.class.getDeclaredField("encodeTable");
            Field decodeTableField = Base16.class.getDeclaredField("decodeTable");
            encodeTableField.setAccessible(true);
            decodeTableField.setAccessible(true);
            byte[] encodeTable = (byte[]) encodeTableField.get(base16);
            byte[] decodeTable = (byte[]) decodeTableField.get(base16);
            assertNotNull(encodeTable, "Encode table should not be null");
            assertNotNull(decodeTable, "Decode table should not be null");
            assertEquals(16, encodeTable.length, "Encode table should have 16 entries");
            assertEquals(256, decodeTable.length, "Decode table should have 256 entries");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection access failed: " + e.getMessage());
        }
    }
}
