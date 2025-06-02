package org.joda.time.format;
import org.joda.time.format.PeriodFormatterBuilder;
import org.joda.time.format.PeriodFormatterBuilder.PluralAffix;
import org.junit.Test;
import static org.junit.Assert.*;

public class format_PeriodFormatterBuilder_appendPrefix_String_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAppendPrefix_ValidInputs() {
        PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
        String singularText = "hour";
        String pluralText = "hours";
        
        try {
            PeriodFormatterBuilder result = builder.appendPrefix(singularText, pluralText);
            assertNotNull(result);
        } catch (Exception e) {
            fail("Exception should not have been thrown for valid inputs");
        }
    }

    @Test(timeout = 4000)
    public void testAppendPrefix_NullSingularText() {
        PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
        String singularText = null;
        String pluralText = "hours";
        
        try {
            builder.appendPrefix(singularText, pluralText);
            fail("Expected IllegalArgumentException for null singularText");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected IllegalArgumentException, but got a different exception");
        }
    }

    @Test(timeout = 4000)
    public void testAppendPrefix_NullPluralText() {
        PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
        String singularText = "hour";
        String pluralText = null;
        
        try {
            builder.appendPrefix(singularText, pluralText);
            fail("Expected IllegalArgumentException for null pluralText");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected IllegalArgumentException, but got a different exception");
        }
    }

}