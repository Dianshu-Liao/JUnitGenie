package org.apache.commons.csv;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.apache.commons.io.IOUtils.EOF;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.commons.codec.binary.Base64OutputStream;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.function.IOStream;
import org.apache.commons.io.function.Uncheck;
import org.apache.commons.io.output.AppendableOutputStream;

public class CSVFormat_trim_11_0_Test {

    @Test
    public void testTrim_String() throws Exception {
        String input = "  Hello World  ";
        CharSequence result = invokeTrim(input);
        assertEquals("Hello World", result.toString());
    }

    @Test
    public void testTrim_EmptyString() throws Exception {
        String input = "   ";
        CharSequence result = invokeTrim(input);
        assertEquals("", result.toString());
    }

    @Test
    public void testTrim_Null() throws Exception {
        CharSequence result = invokeTrim(null);
        assertNull(result);
    }

    @Test
    public void testTrim_CharSequence() throws Exception {
        CharSequence input = new StringBuilder("  Hello World  ");
        CharSequence result = invokeTrim(input);
        assertEquals("Hello World", result.toString());
    }

    @Test
    public void testTrim_NoTrimNeeded() throws Exception {
        CharSequence input = "Hello World";
        CharSequence result = invokeTrim(input);
        assertSame(input, result);
    }

    @Test
    public void testTrim_OnlyTrimChars() throws Exception {
        String input = "   ";
        CharSequence result = invokeTrim(input);
        assertEquals("", result.toString());
    }

    private CharSequence invokeTrim(CharSequence charSequence) throws Exception {
        Method method = CSVFormat.class.getDeclaredMethod("trim", CharSequence.class);
        method.setAccessible(true);
        return (CharSequence) method.invoke(null, charSequence);
    }
}
