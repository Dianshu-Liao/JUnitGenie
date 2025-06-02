package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8StreamJsonParser__decodeUtf8_4_86_0_Test extends UTF8StreamJsonParser {

    private ByteQuadsCanonicalizer symbolTable;

    private IOContext ioContext;

    public UTF8StreamJsonParser__decodeUtf8_4_86_0_Test() {
        super(null, 0, null, null, null, null, 0, 0, false);
    }

    @BeforeEach
    public void setUp() {
        symbolTable = ByteQuadsCanonicalizer.createRoot();
        ioContext = new IOContext(null, null, null, null, null, false);
        byte[] inputBuffer = new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x81 };
        this._inputBuffer = inputBuffer;
        this._inputPtr = 0;
        this._inputEnd = inputBuffer.length;
    }

    @Test
    public void testDecodeUtf8_4() throws Exception {
        // Read the first byte (0xF0)
        int firstByte = _inputBuffer[_inputPtr++];
        // Use reflection to access the private method _decodeUtf8_4
        Method decodeMethod = UTF8StreamJsonParser.class.getDeclaredMethod("_decodeUtf8_4", int.class);
        decodeMethod.setAccessible(true);
        // Call the protected method _decodeUtf8_4 directly
        int result = (int) decodeMethod.invoke(this, firstByte & 0xFF);
        // Validate the expected result
        assertEquals(0x1F601, result);
    }
}
