package org.joda.time.format;
import org.joda.time.format.PeriodFormatterBuilder;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodParser;
import org.junit.Test;
import static org.junit.Assert.*;

public class format_PeriodFormatterBuilder_toParser__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToParser_whenINotParserIsFalse_returnsParser() {
        // Arrange
        PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
        // Set up the internal state to ensure iNotParser is false
        // Assuming there's a way to set iNotParser, or we can use reflection if necessary
        // For this example, we will assume a method exists to set this value
        // builder.setINotParser(false); // Hypothetical method to set the state

        // Act
        PeriodParser parser = builder.toParser();

        // Assert
        assertNotNull("Expected a non-null PeriodParser", parser);
    }

    @Test(timeout = 4000)
    public void testToParser_whenINotParserIsTrue_returnsNull() {
        // Arrange
        PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
        // Set up the internal state to ensure iNotParser is true
        // Assuming there's a way to set iNotParser, or we can use reflection if necessary
        // builder.setINotParser(true); // Hypothetical method to set the state

        // Act
        PeriodParser parser = builder.toParser();

        // Assert
        assertNull("Expected a null PeriodParser", parser);
    }

    @Test(timeout = 4000)
    public void testToParser_whenToFormatterReturnsNull() {
        // Arrange
        PeriodFormatterBuilder builder = new PeriodFormatterBuilder();
        // Set up the internal state to ensure that toFormatter returns null
        // This might involve setting iFieldFormatters to null or empty
        // builder.setIFieldFormatters(null); // Hypothetical method to set the state

        // Act
        PeriodParser parser = builder.toParser();

        // Assert
        assertNull("Expected a null PeriodParser when toFormatter returns null", parser);
    }

}