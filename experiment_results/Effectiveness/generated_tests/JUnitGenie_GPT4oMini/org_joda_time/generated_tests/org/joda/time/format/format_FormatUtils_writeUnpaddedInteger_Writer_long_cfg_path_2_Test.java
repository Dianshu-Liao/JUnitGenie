package org.joda.time.format;
import org.joda.time.format.FormatUtils;
import org.junit.Test;
import java.io.StringWriter;
import java.io.Writer;
import java.io.IOException;

public class format_FormatUtils_writeUnpaddedInteger_Writer_long_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWriteUnpaddedInteger_withIntValue() {
        Writer writer = new StringWriter();
        long value = 123; // This value can be cast to int without loss
        try {
            FormatUtils.writeUnpaddedInteger(writer, value);
            // Verify the output
            assert writer.toString().equals("123");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteUnpaddedInteger_withLongValue() {
        Writer writer = new StringWriter();
        long value = 12345678901L; // This value cannot be cast to int
        try {
            FormatUtils.writeUnpaddedInteger(writer, value);
            // Verify the output
            assert writer.toString().equals("12345678901");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}