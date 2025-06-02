package com.fasterxml.jackson.dataformat.xml.deser;

import java.util.HashSet;
import java.util.Set;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.ContentReference;

public class XmlReadContext_shouldWrap_14_0_Test {

    private XmlReadContext xmlReadContext;

    @BeforeEach
    public void setUp() {
        // Initialize the XmlReadContext with a parent and other parameters
        xmlReadContext = new XmlReadContext(null, 0, 0, 0, 0);
    }

    @Test
    public void testShouldWrapWithNullNamesToWrap() {
        // Test when _namesToWrap is null
        assertFalse(xmlReadContext.shouldWrap("testName"));
    }

    @Test
    public void testShouldWrapWithEmptyNamesToWrap() {
        // Test when _namesToWrap is empty
        Set<String> emptySet = new HashSet<>();
        setNamesToWrap(emptySet);
        assertFalse(xmlReadContext.shouldWrap("testName"));
    }

    @Test
    public void testShouldWrapWithNameInNamesToWrap() {
        // Test when the name is in _namesToWrap
        Set<String> namesSet = new HashSet<>();
        namesSet.add("testName");
        setNamesToWrap(namesSet);
        assertTrue(xmlReadContext.shouldWrap("testName"));
    }

    @Test
    public void testShouldWrapWithNameNotInNamesToWrap() {
        // Test when the name is not in _namesToWrap
        Set<String> namesSet = new HashSet<>();
        namesSet.add("otherName");
        setNamesToWrap(namesSet);
        assertFalse(xmlReadContext.shouldWrap("testName"));
    }

    private void setNamesToWrap(Set<String> namesToWrap) {
        try {
            // Use reflection to set the private field _namesToWrap
            Field field = XmlReadContext.class.getDeclaredField("_namesToWrap");
            field.setAccessible(true);
            field.set(xmlReadContext, namesToWrap);
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }
}
