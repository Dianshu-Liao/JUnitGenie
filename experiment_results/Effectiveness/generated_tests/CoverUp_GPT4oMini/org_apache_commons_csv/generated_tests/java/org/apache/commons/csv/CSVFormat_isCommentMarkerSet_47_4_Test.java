package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
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

public class CSVFormat_isCommentMarkerSet_47_4_Test {

    @Test
    public void testIsCommentMarkerSet_NullCommentMarker() throws Exception {
        // Arrange
        CSVFormat csvFormat = CSVFormat.newFormat(',');
        Method setCommentMarkerMethod = CSVFormat.class.getDeclaredMethod("withCommentMarker", Character.class);
        setCommentMarkerMethod.setAccessible(true);
        setCommentMarkerMethod.invoke(csvFormat, (Character) null);
        // Act
        Method method = CSVFormat.class.getDeclaredMethod("isCommentMarkerSet");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(csvFormat);
        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsCommentMarkerSet_SetCommentMarker() throws Exception {
        // Arrange
        CSVFormat csvFormat = CSVFormat.newFormat(',');
        Method setCommentMarkerMethod = CSVFormat.class.getDeclaredMethod("withCommentMarker", Character.class);
        setCommentMarkerMethod.setAccessible(true);
        setCommentMarkerMethod.invoke(csvFormat, '#');
        // Act
        Method method = CSVFormat.class.getDeclaredMethod("isCommentMarkerSet");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(csvFormat);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsCommentMarkerSet_EmptyCommentMarker() throws Exception {
        // Arrange
        CSVFormat csvFormat = CSVFormat.newFormat(',');
        Method setCommentMarkerMethod = CSVFormat.class.getDeclaredMethod("withCommentMarker", Character.class);
        setCommentMarkerMethod.setAccessible(true);
        setCommentMarkerMethod.invoke(csvFormat, ' ');
        // Act
        Method method = CSVFormat.class.getDeclaredMethod("isCommentMarkerSet");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(csvFormat);
        // Assert
        assertTrue(result);
    }
}
