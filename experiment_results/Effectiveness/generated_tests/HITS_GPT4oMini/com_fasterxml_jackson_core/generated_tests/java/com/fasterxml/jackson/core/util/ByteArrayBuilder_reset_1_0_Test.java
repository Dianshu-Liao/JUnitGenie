package com.fasterxml.jackson.core.util;

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
        byteArrayBuilder = new ByteArrayBuilder();
    }

    private void setState(int pastLen, int currBlockPtr, byte[] block) throws Exception {
        // Using reflection to set private fields
        Field pastLenField = ByteArrayBuilder.class.getDeclaredField("_pastLen");
        pastLenField.setAccessible(true);
        pastLenField.set(byteArrayBuilder, pastLen);
        Field currBlockPtrField = ByteArrayBuilder.class.getDeclaredField("_currBlockPtr");
        currBlockPtrField.setAccessible(true);
        currBlockPtrField.set(byteArrayBuilder, currBlockPtr);
        Field pastBlocksField = ByteArrayBuilder.class.getDeclaredField("_pastBlocks");
        pastBlocksField.setAccessible(true);
        LinkedList<byte[]> pastBlocks = (LinkedList<byte[]>) pastBlocksField.get(byteArrayBuilder);
        if (block != null) {
            pastBlocks.add(block);
        }
    }

    @Test
    public void testReset_WhenCalled_ResetsPastLenAndCurrBlockPtr() throws Exception {
        // Arrange
        setState(10, 5, new byte[100]);
        // Act
        byteArrayBuilder.reset();
        // Assert
        assertEquals(0, getPrivateField(byteArrayBuilder, "_pastLen"), "Expected past length to be reset to 0");
        assertEquals(0, getPrivateField(byteArrayBuilder, "_currBlockPtr"), "Expected current block pointer to be reset to 0");
        assertTrue(getPrivatePastBlocks(byteArrayBuilder).isEmpty(), "Expected past blocks to be cleared");
    }

    @Test
    public void testReset_WhenNoPastBlocks_ResetsPastLenAndCurrBlockPtr() throws Exception {
        // Arrange
        setState(5, 3, null);
        // Act
        byteArrayBuilder.reset();
        // Assert
        assertEquals(0, getPrivateField(byteArrayBuilder, "_pastLen"), "Expected past length to be reset to 0");
        assertEquals(0, getPrivateField(byteArrayBuilder, "_currBlockPtr"), "Expected current block pointer to be reset to 0");
        assertTrue(getPrivatePastBlocks(byteArrayBuilder).isEmpty(), "Expected past blocks to be cleared");
    }

    private int getPrivateField(ByteArrayBuilder builder, String fieldName) throws Exception {
        Field field = ByteArrayBuilder.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return (int) field.get(builder);
    }

    private LinkedList<byte[]> getPrivatePastBlocks(ByteArrayBuilder builder) throws Exception {
        Field field = ByteArrayBuilder.class.getDeclaredField("_pastBlocks");
        field.setAccessible(true);
        return (LinkedList<byte[]>) field.get(builder);
    }
}
