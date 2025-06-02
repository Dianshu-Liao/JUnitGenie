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

public class CSVFormat_containsLineBreak_2_0_Test {

    @Test
    public void testContainsLineBreak() throws Exception {
        // Accessing the private method using reflection
        Method method = CSVFormat.class.getDeclaredMethod("containsLineBreak", String.class);
        method.setAccessible(true);
        // Test cases for the containsLineBreak method
        // Contains LF
        assertTrue((Boolean) method.invoke(null, "Line1\nLine2"));
        // Contains CR
        assertTrue((Boolean) method.invoke(null, "Line1\rLine2"));
        // Contains CR and LF
        assertTrue((Boolean) method.invoke(null, "Line1\r\nLine2"));
        // No line breaks
        assertFalse((Boolean) method.invoke(null, "Line1Line2"));
        // Empty string
        assertFalse((Boolean) method.invoke(null, ""));
        // Null string
        assertFalse((Boolean) method.invoke(null, null));
    }
}
