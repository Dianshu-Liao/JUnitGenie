package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class filter_JsonPointerBasedFilter_includeProperty_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIncludeProperty_ReturnsNull_WhenNextIsNull() {
        // Arrange
        JsonPointer jsonPointerMock = JsonPointer.compile(""); // Use the compile method to create a JsonPointer
        JsonPointerBasedFilter filter = new JsonPointerBasedFilter(jsonPointerMock);

        // Act
        TokenFilter result = filter.includeProperty("nonExistingProperty");

        // Assert
        assertNull(result);
    }


}