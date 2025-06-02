package org.apache.commons.jxpath.servlet;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.commons.jxpath.Variables;

@ExtendWith(MockitoExtension.class)
public class KeywordVariables_KeywordVariables_4_0_Test {

    private KeywordVariables keywordVariables;

    @BeforeEach
    public void setUp() {
        // Setting up a valid instance for testing
        keywordVariables = new KeywordVariables("testKeyword", new Object());
    }

    @Test
    public void testConstructor_WithValidArguments() {
        assertNotNull(keywordVariables);
        assertTrue(keywordVariables.isDeclaredVariable("testKeyword"));
        assertNotNull(keywordVariables.getVariable("testKeyword"));
    }

    @Test
    public void testConstructor_ThrowsIllegalArgumentException_WhenKeywordIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new KeywordVariables(null, new Object());
        });
        String expectedMessage = "keyword cannot be null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testConstructor_WithNullObject() {
        KeywordVariables kv = new KeywordVariables("validKeyword", null);
        assertNotNull(kv);
        assertTrue(kv.isDeclaredVariable("validKeyword"));
        assertNull(kv.getVariable("validKeyword"));
    }

    @Test
    public void testConstructor_WithEmptyStringKeyword() {
        KeywordVariables kv = new KeywordVariables("", new Object());
        assertNotNull(kv);
        assertTrue(kv.isDeclaredVariable(""));
        assertNotNull(kv.getVariable(""));
    }

    @Test
    public void testConstructor_WithWhitespaceKeyword() {
        KeywordVariables kv = new KeywordVariables("   ", new Object());
        assertNotNull(kv);
        assertTrue(kv.isDeclaredVariable("   "));
        assertNotNull(kv.getVariable("   "));
    }
}
