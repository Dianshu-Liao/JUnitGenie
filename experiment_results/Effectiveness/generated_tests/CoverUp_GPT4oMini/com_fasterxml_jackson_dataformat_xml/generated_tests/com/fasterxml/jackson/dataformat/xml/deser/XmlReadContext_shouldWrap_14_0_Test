package com.fasterxml.jackson.dataformat.xml.deser;

import java.util.HashSet;
import java.util.Set;
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

    private XmlReadContext context;

    @BeforeEach
    public void setUp() {
        context = new XmlReadContext(null, 0, 0, 0, 0);
    }

    @Test
    public void testShouldWrapWithNamesToWrapContainingLocalName() {
        Set<String> namesToWrap = new HashSet<>();
        namesToWrap.add("testName");
        context.setNamesToWrap(namesToWrap);
        assertTrue(context.shouldWrap("testName"), "shouldWrap should return true for names contained in _namesToWrap");
    }

    @Test
    public void testShouldWrapWithNamesToWrapNotContainingLocalName() {
        Set<String> namesToWrap = new HashSet<>();
        namesToWrap.add("anotherName");
        context.setNamesToWrap(namesToWrap);
        assertFalse(context.shouldWrap("testName"), "shouldWrap should return false for names not contained in _namesToWrap");
    }

    @Test
    public void testShouldWrapWithNullNamesToWrap() {
        context.setNamesToWrap(null);
        assertFalse(context.shouldWrap("testName"), "shouldWrap should return false when _namesToWrap is null");
    }

    @Test
    public void testShouldWrapWithEmptyNamesToWrap() {
        Set<String> namesToWrap = new HashSet<>();
        context.setNamesToWrap(namesToWrap);
        assertFalse(context.shouldWrap("testName"), "shouldWrap should return false when _namesToWrap is empty");
    }
}
