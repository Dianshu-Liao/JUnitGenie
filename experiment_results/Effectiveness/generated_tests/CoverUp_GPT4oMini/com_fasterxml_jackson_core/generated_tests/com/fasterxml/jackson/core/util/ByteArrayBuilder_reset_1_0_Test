package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.BufferRecycler;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import java.util.*;

public class ByteArrayBuilder_reset_1_0_Test {

    private ByteArrayBuilder byteArrayBuilder;

    @BeforeEach
    public void setUp() {
        byteArrayBuilder = new ByteArrayBuilder(new BufferRecycler());
    }

    private void setPrivateField(String fieldName, Object value) throws Exception {
        Field field = ByteArrayBuilder.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(byteArrayBuilder, value);
    }

    private Object getPrivateField(String fieldName) throws Exception {
        Field field = ByteArrayBuilder.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(byteArrayBuilder);
    }

    @Test
    public void testReset_WhenPastBlocksNotEmpty() throws Exception {
        // Arrange
        byte[] block1 = new byte[100];
        byte[] block2 = new byte[200];
        byte[] block3 = new byte[300];
        // Simulating adding blocks to _pastBlocks
        setPrivateField("_pastBlocks", new LinkedList<>(Arrays.asList(block1, block2, block3)));
        setPrivateField("_pastLen", 3);
        setPrivateField("_currBlockPtr", 50);
        // Act
        byteArrayBuilder.reset();
        // Assert
        assertEquals(0, getPrivateField("_pastLen"));
        assertEquals(0, getPrivateField("_currBlockPtr"));
        assertTrue(((LinkedList<byte[]>) getPrivateField("_pastBlocks")).isEmpty());
    }

    @Test
    public void testReset_WhenPastBlocksEmpty() throws Exception {
        // Arrange
        setPrivateField("_pastLen", 0);
        setPrivateField("_currBlockPtr", 10);
        // Act
        byteArrayBuilder.reset();
        // Assert
        assertEquals(0, getPrivateField("_pastLen"));
        assertEquals(0, getPrivateField("_currBlockPtr"));
        assertTrue(((LinkedList<byte[]>) getPrivateField("_pastBlocks")).isEmpty());
    }
}
