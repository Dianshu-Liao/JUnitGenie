package org.joda.time.format;
import org.joda.time.format.PeriodFormatterBuilder;
import org.junit.Test;

public class format_PeriodFormatterBuilder_appendSuffix_String_____String_____cfg_path_3_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testAppendSuffix_NullRegularExpressions() {
        PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
        builder.appendSuffix(null, new String[]{"suffix1"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendSuffix_NullSuffixes() {
        PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
        builder.appendSuffix(new String[]{"regex1"}, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendSuffix_EmptyRegularExpressions() {
        PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
        builder.appendSuffix(new String[]{}, new String[]{});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendSuffix_MismatchedLengths() {
        PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
        builder.appendSuffix(new String[]{"regex1"}, new String[]{"suffix1", "suffix2"});
    }

}