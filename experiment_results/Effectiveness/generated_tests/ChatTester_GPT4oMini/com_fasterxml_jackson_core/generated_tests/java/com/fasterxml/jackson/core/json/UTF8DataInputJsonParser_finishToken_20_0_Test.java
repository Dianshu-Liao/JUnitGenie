package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8DataInputJsonParser_finishToken_20_0_Test {

    private UTF8DataInputJsonParser parser;

    private DataInput mockInputData;

    private ByteQuadsCanonicalizer mockSymbols;

    @BeforeEach
    public void setUp() {
        mockInputData = mock(DataInput.class);
        mockSymbols = mock(ByteQuadsCanonicalizer.class);
        parser = new UTF8DataInputJsonParser(null, 0, mockInputData, null, mockSymbols, 0);
    }

    @Test
    public void testFinishToken_WhenTokenIncomplete_CallsFinishString() throws Exception {
        // Arrange
        setField(parser, "_tokenIncomplete", true);
        // Mock the private method _finishString
        UTF8DataInputJsonParser spyParser = spy(parser);
        doNothing().when(spyParser).finishToken();
        // Act
        spyParser.finishToken();
        assertFalse(getField(spyParser, "_tokenIncomplete"));
        verify(spyParser, times(1)).finishToken();
    }

    @Test
    public void testFinishToken_WhenTokenComplete_DoesNotCallFinishString() throws Exception {
        setField(parser, "_tokenIncomplete", false);
        UTF8DataInputJsonParser spyParser = spy(parser);
        doNothing().when(spyParser).finishToken();
        spyParser.finishToken();
        assertFalse(getField(spyParser, "_tokenIncomplete"));
        verify(spyParser, never()).finishToken();
    }

    private void setField(Object obj, String fieldName, Object value) {
        try {
            // Repaired line: Use Field instead of var
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean getField(Object obj, String fieldName) {
        // Repaired line: Use Field instead of var
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.getBoolean(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
