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

public class CSVFormat_copy_3_0_Test {

    @Test
    public void testCopyWithNonNullFormat() throws Exception {
        // Use a predefined format
        CSVFormat originalFormat = CSVFormat.DEFAULT;
        CSVFormat copiedFormat = invokeCopy(originalFormat);
        assertNotNull(copiedFormat, "Copied format should not be null");
    }

    @Test
    public void testCopyWithNullFormat() throws Exception {
        CSVFormat copiedFormat = invokeCopy(null);
        assertNull(copiedFormat, "Copied format should be null when input is null");
    }

    private CSVFormat invokeCopy(CSVFormat format) throws Exception {
        Method copyMethod = CSVFormat.class.getDeclaredMethod("copy", CSVFormat.class);
        copyMethod.setAccessible(true);
        return (CSVFormat) copyMethod.invoke(null, format);
    }
}
