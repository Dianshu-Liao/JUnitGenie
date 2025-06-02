package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.filter.JsonPointerBasedFilter;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.junit.Test;
import static org.junit.Assert.*;

public class filter_JsonPointerBasedFilter_includeProperty_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIncludeProperty() {
        // Setup
        String matchingPropertyName = "testProperty";
        JsonPointer jsonPointer = JsonPointer.compile("/" + matchingPropertyName);
        JsonPointerBasedFilter filter = new JsonPointerBasedFilter(jsonPointer);
        
        // Test case where the property name matches
        TokenFilter result = filter.includeProperty(matchingPropertyName);
        assertNotNull(result);
        assertEquals(TokenFilter.INCLUDE_ALL, result);

        // Test case where the property name does not match
        result = filter.includeProperty("nonMatchingProperty");
        assertNull(result);
        
        // Test case where the property name is null
        result = filter.includeProperty(null);
        assertNull(result);
    }

}