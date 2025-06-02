package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.CharTypes;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

class UTF8DataInputJsonParser__nextAfterName_19_0_Test extends UTF8DataInputJsonParser {

    private static final int DEFAULT_BUFFER_SIZE = 64;

    private static final int DEFAULT_SEED = 0;

    public UTF8DataInputJsonParser__nextAfterName_19_0_Test() {
        super(createIoContext(), DEFAULT_BUFFER_SIZE, null, null, createByteQuadsCanonicalizer(), 0);
    }

    private static IOContext createIoContext() {
        return new IOContext(null, null, true);
    }

    private static ByteQuadsCanonicalizer createByteQuadsCanonicalizer() {
        return ByteQuadsCanonicalizer.createRoot();
    }

    protected JsonToken callNextAfterName() throws Exception {
        Method method = UTF8DataInputJsonParser.class.getDeclaredMethod("_nextAfterName");
        method.setAccessible(true);
        return (JsonToken) method.invoke(this);
    }

    @Test
    void testNextAfterName_InvalidateNameCopyState() throws Exception {
        this._nameCopied = true;
        this._nextToken = JsonToken.FIELD_NAME;
        JsonToken result = callNextAfterName();
        assertFalse(this._nameCopied, "The name copied state should be invalidated (set to false).");
        assertEquals(JsonToken.FIELD_NAME, result, "The returned token should match the expected token.");
    }

    @Test
    void testNextAfterName_StartArrayContext() throws Exception {
        this._nextToken = JsonToken.START_ARRAY;
        JsonToken result = callNextAfterName();
        assertEquals(JsonToken.START_ARRAY, result, "The returned token should match the START_ARRAY token.");
    }

    @Test
    void testNextAfterName_StartObjectContext() throws Exception {
        this._nextToken = JsonToken.START_OBJECT;
        JsonToken result = callNextAfterName();
        assertEquals(JsonToken.START_OBJECT, result, "The returned token should match the START_OBJECT token.");
    }

    @Test
    void testNextAfterName_NullToken() throws Exception {
        this._nextToken = null;
        JsonToken result = callNextAfterName();
        assertNull(result, "The returned token should be null when _nextToken is null.");
    }
}
