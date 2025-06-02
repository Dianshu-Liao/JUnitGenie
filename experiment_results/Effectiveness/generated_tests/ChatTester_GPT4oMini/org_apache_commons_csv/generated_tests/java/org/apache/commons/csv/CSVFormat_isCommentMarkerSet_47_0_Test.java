package org.apache.commons.csv;

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

public class CSVFormat_isCommentMarkerSet_47_0_Test {

    private CSVFormat csvFormatWithCommentMarker;

    private CSVFormat csvFormatWithoutCommentMarker;

    @BeforeEach
    public void setUp() {
        // Using reflection to set the private fields for testing
        csvFormatWithCommentMarker = createCSVFormatWithCommentMarker('!');
        csvFormatWithoutCommentMarker = createCSVFormatWithoutCommentMarker();
    }

    private CSVFormat createCSVFormatWithCommentMarker(Character commentMarker) {
        // Use reflection to create a CSVFormat instance with a specific commentMarker
        try {
            java.lang.reflect.Constructor<CSVFormat> constructor = CSVFormat.class.getDeclaredConstructor(CSVFormat.Builder.class);
            constructor.setAccessible(true);
            CSVFormat.Builder builder = CSVFormat.Builder.create();
            // Set the comment marker using reflection
            java.lang.reflect.Field field = CSVFormat.class.getDeclaredField("commentMarker");
            field.setAccessible(true);
            field.set(builder, commentMarker);
            return constructor.newInstance(builder);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private CSVFormat createCSVFormatWithoutCommentMarker() {
        // Use reflection to create a CSVFormat instance without a commentMarker
        try {
            java.lang.reflect.Constructor<CSVFormat> constructor = CSVFormat.class.getDeclaredConstructor(CSVFormat.Builder.class);
            constructor.setAccessible(true);
            CSVFormat.Builder builder = CSVFormat.Builder.create();
            // Set the comment marker to null using reflection
            java.lang.reflect.Field field = CSVFormat.class.getDeclaredField("commentMarker");
            field.setAccessible(true);
            field.set(builder, null);
            return constructor.newInstance(builder);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testIsCommentMarkerSet_WhenCommentMarkerIsSet() {
        assertTrue(csvFormatWithCommentMarker.isCommentMarkerSet(), "Expected comment marker to be set.");
    }

    @Test
    public void testIsCommentMarkerSet_WhenCommentMarkerIsNotSet() {
        assertFalse(csvFormatWithoutCommentMarker.isCommentMarkerSet(), "Expected comment marker to not be set.");
    }
}
