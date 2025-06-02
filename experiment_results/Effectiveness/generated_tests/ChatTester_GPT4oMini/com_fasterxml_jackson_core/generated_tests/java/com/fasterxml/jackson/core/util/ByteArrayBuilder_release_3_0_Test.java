package com.fasterxml.jackson.core.util;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import java.util.*;

class ByteArrayBuilder_release_3_0_Test {

    private ByteArrayBuilder byteArrayBuilder;

    private BufferRecycler mockBufferRecycler;

    @BeforeEach
    void setUp() {
        mockBufferRecycler = Mockito.mock(BufferRecycler.class);
        byteArrayBuilder = new ByteArrayBuilder(mockBufferRecycler);
    }

    @Test
    void testRelease_WithBufferRecyclerAndCurrBlock() throws Exception {
        // Arrange
        byte[] initialBlock = new byte[ByteArrayBuilder.DEFAULT_BLOCK_ARRAY_SIZE];
        setCurrBlock(initialBlock);
        // Act
        byteArrayBuilder.release();
        // Assert
        Mockito.verify(mockBufferRecycler).releaseByteBuffer(BufferRecycler.BYTE_WRITE_CONCAT_BUFFER, initialBlock);
        assertNull(getCurrBlock());
    }

    @Test
    void testRelease_WithNullBufferRecycler() throws Exception {
        // Arrange
        byteArrayBuilder = new ByteArrayBuilder(null);
        setCurrBlock(new byte[10]);
        // Act
        byteArrayBuilder.release();
        // Assert
        // currBlock should remain unchanged
        assertNotNull(getCurrBlock());
    }

    @Test
    void testRelease_WithNullCurrBlock() throws Exception {
        // Arrange
        byteArrayBuilder = new ByteArrayBuilder(mockBufferRecycler);
        // Act
        byteArrayBuilder.release();
        // Assert
        Mockito.verify(mockBufferRecycler, Mockito.never()).releaseByteBuffer(Mockito.anyInt(), Mockito.any());
        assertNull(getCurrBlock());
    }

    // Reflection methods to access private fields
    private byte[] getCurrBlock() throws Exception {
        Method getCurrBlockMethod = ByteArrayBuilder.class.getDeclaredMethod("getCurrentSegment");
        getCurrBlockMethod.setAccessible(true);
        return (byte[]) getCurrBlockMethod.invoke(byteArrayBuilder);
    }

    private void setCurrBlock(byte[] block) throws Exception {
        Method setCurrBlockMethod = ByteArrayBuilder.class.getDeclaredMethod("setCurrentSegmentLength", int.class);
        setCurrBlockMethod.setAccessible(true);
        byteArrayBuilder.setCurrentSegmentLength(block.length);
        // Assuming we can set the current segment directly through reflection
        Method setCurrBlockMethodReflection = ByteArrayBuilder.class.getDeclaredMethod("setCurrentSegment", byte[].class);
        setCurrBlockMethodReflection.setAccessible(true);
        setCurrBlockMethodReflection.invoke(byteArrayBuilder, block);
    }
}
