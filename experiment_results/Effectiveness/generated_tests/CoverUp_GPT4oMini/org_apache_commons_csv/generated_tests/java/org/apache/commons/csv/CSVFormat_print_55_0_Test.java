package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.apache.commons.io.IOUtils.EOF;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
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

class CSVFormat_print_55_0_Test {

    @Test
    void testPrint() throws Exception {
        // Arrange
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        StringWriter writer = new StringWriter();
        // Act
        CSVPrinter printer = csvFormat.print(writer);
        // Assert
        assertNotNull(printer);
    }

    @Test
    void testPrintThrowsIOException() throws Exception {
        // Arrange
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        Appendable faultyAppendable = new Appendable() {

            @Override
            public Appendable append(CharSequence csq) throws IOException {
                throw new IOException("Forced IOException");
            }

            @Override
            public Appendable append(CharSequence csq, int start, int end) throws IOException {
                throw new IOException("Forced IOException");
            }

            @Override
            public Appendable append(char c) throws IOException {
                throw new IOException("Forced IOException");
            }
        };
        // Act & Assert
        assertThrows(IOException.class, () -> {
            Method method = CSVFormat.class.getDeclaredMethod("print", Appendable.class);
            method.setAccessible(true);
            method.invoke(csvFormat, faultyAppendable);
        });
    }
}
