package org.apache.commons.compress.harmony.unpack200;
import org.apache.commons.compress.harmony.unpack200.Segment;
import org.junit.Before;
import org.junit.Test;
import java.io.PrintWriter;
import java.io.StringWriter;
import static org.junit.Assert.assertEquals;

public class harmony_unpack200_Segment_log_int_String_cfg_path_1_Test {
    private Segment segment;
    private StringWriter stringWriter;
    private PrintWriter printWriter;

    @Before
    public void setUp() {
        stringWriter = new StringWriter();
        printWriter = new PrintWriter(stringWriter);
        segment = new Segment();
        // Set the private fields using reflection
        try {
            java.lang.reflect.Field logLevelField = Segment.class.getDeclaredField("logLevel");
            logLevelField.setAccessible(true);
            logLevelField.setInt(segment, 5); // Set logLevel to 5 for testing

            java.lang.reflect.Field logPrintWriterField = Segment.class.getDeclaredField("logPrintWriter");
            logPrintWriterField.setAccessible(true);
            logPrintWriterField.set(segment, printWriter); // Set logPrintWriter to our PrintWriter
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testLogMessageIsPrinted() {
        segment.log(3, "Test message");
        printWriter.flush();
        assertEquals("Test message\n", stringWriter.toString());
    }

    @Test(timeout = 4000)
    public void testLogMessageIsNotPrinted() {
        segment.log(6, "This message should not be printed");
        printWriter.flush();
        assertEquals("", stringWriter.toString());
    }

}