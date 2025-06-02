package org.apache.commons.codec.binary;

import org.apache.commons.codec.CodecPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

class Base16_Base16_5_0_Test {

    private Base16 base16;

    @BeforeEach
    void setUp() {
        base16 = new Base16();
    }

    @Test
    void testBase16ConstructorDefault() {
        assertNotNull(base16);
    }

    @Test
    void testBase16ConstructorWithLowerCase() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<Base16> constructor = Base16.class.getDeclaredConstructor(boolean.class);
        constructor.setAccessible(true);
        Base16 instance = constructor.newInstance(true);
        assertNotNull(instance);
    }

    @Test
    void testBase16ConstructorWithLowerCaseAndEncodeTable() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<Base16> constructor = Base16.class.getDeclaredConstructor(boolean.class, byte[].class, CodecPolicy.class);
        constructor.setAccessible(true);
        Base16 instance = constructor.newInstance(true, new byte[] {}, CodecPolicy.STRICT);
        assertNotNull(instance);
    }

    @Test
    void testBase16ConstructorWithDecodingPolicy() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<Base16> constructor = Base16.class.getDeclaredConstructor(boolean.class, CodecPolicy.class);
        constructor.setAccessible(true);
        Base16 instance = constructor.newInstance(true, CodecPolicy.STRICT);
        assertNotNull(instance);
    }

    @Test
    void testConstructorWithInvalidParameters() {
        assertThrows(IllegalArgumentException.class, () -> {
            Constructor<Base16> constructor = Base16.class.getDeclaredConstructor(boolean.class, byte[].class, CodecPolicy.class);
            constructor.setAccessible(true);
            constructor.newInstance(true, null, null);
        });
    }
}
