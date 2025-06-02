package com.fasterxml.jackson.core;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.*;

public class JsonFactory__checkInvalidCopy_3_0_Test {

    // Test case for valid copy
    @Test
    public void testCheckInvalidCopy_ValidClass() {
        JsonFactory jsonFactory = new JsonFactory();
        assertDoesNotThrow(() -> jsonFactory._checkInvalidCopy(JsonFactory.class));
    }

    // Test case for invalid copy
    @Test
    public void testCheckInvalidCopy_InvalidClass() {
        JsonFactory jsonFactory = new JsonFactory();
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            jsonFactory._checkInvalidCopy(String.class);
        });
        String expectedMessage = "Failed copy(): " + jsonFactory.getClass().getName() + " (version: " + jsonFactory.version() + ") does not override copy(); it has to";
        assertEquals(expectedMessage, exception.getMessage());
    }
}
