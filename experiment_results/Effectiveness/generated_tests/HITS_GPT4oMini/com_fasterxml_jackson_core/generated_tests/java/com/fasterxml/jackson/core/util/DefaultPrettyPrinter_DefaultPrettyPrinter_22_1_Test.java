package com.fasterxml.jackson.core.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.SerializedString;

@ExtendWith(MockitoExtension.class)
public class DefaultPrettyPrinter_DefaultPrettyPrinter_22_1_Test {

    @Test
    public void testDefaultPrettyPrinterWithSerializedStringRootSeparator() {
        SerializedString serializedString = new SerializedString("||");
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter(serializedString);
        assertNotNull(printer._rootSeparator);
        assertEquals("||", printer._rootSeparator.getValue());
    }
}
