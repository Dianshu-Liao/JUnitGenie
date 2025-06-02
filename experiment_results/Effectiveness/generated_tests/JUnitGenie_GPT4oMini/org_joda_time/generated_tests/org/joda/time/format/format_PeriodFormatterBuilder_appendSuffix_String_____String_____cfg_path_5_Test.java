package org.joda.time.format;
import org.joda.time.format.PeriodFormatterBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class format_PeriodFormatterBuilder_appendSuffix_String_____String_____cfg_path_5_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testAppendSuffixWithNullRegularExpressions() {
        PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
        builder.appendSuffix(null, new String[]{"suffix1"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendSuffixWithNullSuffixes() {
        PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
        builder.appendSuffix(new String[]{"regex1"}, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendSuffixWithEmptyRegularExpressions() {
        PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
        builder.appendSuffix(new String[]{}, new String[]{});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendSuffixWithMismatchedLengths() {
        PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
        builder.appendSuffix(new String[]{"regex1"}, new String[]{"suffix1", "suffix2"});
    }

    @Test(timeout = 4000)
    public void testAppendSuffixWithValidInputs() {
        PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
        // Add a field to the builder before appending suffix
        builder.appendHours(); // Example of adding a field
        PeriodFormatterBuilder result = builder.appendSuffix(new String[]{"regex1"}, new String[]{"suffix1"});
        assertNotNull(result); // Ensure that the result is not null
    }


}