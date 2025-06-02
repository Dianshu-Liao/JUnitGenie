package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_appendSeparator_char_char_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAppendSeparatorWithNonEmptyBuilder() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder("Hello");
        char standard = '-';
        char defaultIfEmpty = '*';

        // Act
        StrBuilder result = strBuilder.appendSeparator(standard, defaultIfEmpty);

        // Assert
        assertEquals("Hello-", result.toString());
    }

    @Test(timeout = 4000)
    public void testAppendSeparatorWithEmptyBuilder() {
        // Arrange
        StrBuilder strBuilder = new StrBuilder("");
        char standard = '-';
        char defaultIfEmpty = '*';

        // Act
        StrBuilder result = strBuilder.appendSeparator(standard, defaultIfEmpty);

        // Assert
        assertEquals("*", result.toString());
    }

}