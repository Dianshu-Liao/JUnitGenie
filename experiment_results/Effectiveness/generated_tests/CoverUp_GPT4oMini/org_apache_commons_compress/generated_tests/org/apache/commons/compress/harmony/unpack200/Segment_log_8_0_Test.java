package org.apache.commons.compress.harmony.unpack200;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


public class Segment_log_8_0_Test {

    private Segment segment;

    private ByteArrayOutputStream logStream;

    @BeforeEach
    public void setUp() {
        segment = new Segment();
        logStream = new ByteArrayOutputStream();
        segment.setLogStream(logStream);
    }

    @Test
    public void testLogWithVerboseLevel() {
        segment.setLogLevel(Segment.LOG_LEVEL_VERBOSE);
        segment.log(Segment.LOG_LEVEL_VERBOSE, "Verbose log message");
        String output = logStream.toString();
        assertEquals("Verbose log message\n", output);
    }

    @Test
    public void testLogWithStandardLevel() {
        segment.setLogLevel(Segment.LOG_LEVEL_STANDARD);
        segment.log(Segment.LOG_LEVEL_STANDARD, "Standard log message");
        String output = logStream.toString();
        assertEquals("Standard log message\n", output);
    }

    @Test
    public void testLogWithQuietLevel() {
        segment.setLogLevel(Segment.LOG_LEVEL_QUIET);
        segment.log(Segment.LOG_LEVEL_VERBOSE, "This should not be logged");
        String output = logStream.toString();
        assertEquals("", output);
    }

    @Test
    public void testLogLevelThreshold() {
        segment.setLogLevel(Segment.LOG_LEVEL_STANDARD);
        segment.log(Segment.LOG_LEVEL_VERBOSE, "This should not be logged");
        String output = logStream.toString();
        assertEquals("", output);
    }

    @Test
    public void testLogLevelEqual() {
        segment.setLogLevel(Segment.LOG_LEVEL_STANDARD);
        segment.log(Segment.LOG_LEVEL_STANDARD, "Logged at standard level");
        String output = logStream.toString();
        assertEquals("Logged at standard level\n", output);
    }
}
