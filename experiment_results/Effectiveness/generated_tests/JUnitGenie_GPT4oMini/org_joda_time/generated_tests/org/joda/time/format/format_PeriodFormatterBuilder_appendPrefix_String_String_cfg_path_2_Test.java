package org.joda.time.format;
import org.joda.time.format.PeriodFormatterBuilder;
import org.junit.Test;

public class format_PeriodFormatterBuilder_appendPrefix_String_String_cfg_path_2_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testAppendPrefix_NullSingularText() {
        PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
        builder.appendPrefix(null, "plural");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppendPrefix_NullPluralText() {
        PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
        builder.appendPrefix("singular", null);
    }

}