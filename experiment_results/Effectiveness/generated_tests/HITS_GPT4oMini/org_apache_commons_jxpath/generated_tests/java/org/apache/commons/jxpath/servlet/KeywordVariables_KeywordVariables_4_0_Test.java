package org.apache.commons.jxpath.servlet;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.Variables;

public class KeywordVariables_KeywordVariables_4_0_Test {

    @Test
    public void testConstructorWithValidParameters() {
        String keyword = "testKeyword";
        Object object = new Object();
        KeywordVariables keywordVariables = new KeywordVariables(keyword, object);
        assertNotNull(keywordVariables);
    }

    @Test
    public void testConstructorWithNullKeyword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new KeywordVariables(null, new Object());
        });
        assertEquals("keyword cannot be null", exception.getMessage());
    }

    @Test
    public void testConstructorWithEmptyKeyword() {
        String keyword = "";
        Object object = new Object();
        KeywordVariables keywordVariables = new KeywordVariables(keyword, object);
        assertNotNull(keywordVariables);
    }

    @Test
    public void testConstructorWithNullObject() {
        String keyword = "testKeyword";
        KeywordVariables keywordVariables = new KeywordVariables(keyword, null);
        assertNotNull(keywordVariables);
    }
}
