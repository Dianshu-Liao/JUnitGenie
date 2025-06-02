package org.apache.commons.codec.binary;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

public class Base16_Base16_6_0_Test {

    private Base16 base16;

    @BeforeEach
    public void setUp() {
        // Initialize the Base16 object with the default constructor
        base16 = new Base16();
    }

    @Test
    public void testConstructorLowerCaseTrue() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // Use reflection to invoke the private constructor
        Constructor<Base16> constructor = Base16.class.getDeclaredConstructor(boolean.class);
        constructor.setAccessible(true);
        Base16 instance = constructor.newInstance(true);
        assertNotNull(instance);
        // Check if the decodeTable is the lower case table
        byte[] expectedDecodeTable = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15 };
        Field decodeTableField = Base16.class.getDeclaredField("decodeTable");
        decodeTableField.setAccessible(true);
        byte[] decodeTable = (byte[]) decodeTableField.get(instance);
        assertArrayEquals(expectedDecodeTable, decodeTable);
    }

    @Test
    public void testConstructorLowerCaseFalse() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // Use reflection to invoke the private constructor
        Constructor<Base16> constructor = Base16.class.getDeclaredConstructor(boolean.class);
        constructor.setAccessible(true);
        Base16 instance = constructor.newInstance(false);
        assertNotNull(instance);
        // Check if the decodeTable is the upper case table
        byte[] expectedDecodeTable = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15 };
        Field decodeTableField = Base16.class.getDeclaredField("decodeTable");
        decodeTableField.setAccessible(true);
        byte[] decodeTable = (byte[]) decodeTableField.get(instance);
        assertArrayEquals(expectedDecodeTable, decodeTable);
    }
}
