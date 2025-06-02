package com.fasterxml.jackson.dataformat.xml.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;

public class CaseInsensitiveNameSet_construct_0_0_Test {

    @Test
    public void testConstructWithEmptySet() {
        Set<String> input = new HashSet<>();
        CaseInsensitiveNameSet result = CaseInsensitiveNameSet.construct(input);
        assertNotNull(result);
    }

    @Test
    public void testConstructWithSingleElement() {
        Set<String> input = new HashSet<>();
        input.add("Test");
        CaseInsensitiveNameSet result = CaseInsensitiveNameSet.construct(input);
        assertNotNull(result);
    }

    @Test
    public void testConstructWithMultipleElements() {
        Set<String> input = new HashSet<>();
        input.add("Test");
        input.add("Example");
        CaseInsensitiveNameSet result = CaseInsensitiveNameSet.construct(input);
        assertNotNull(result);
    }

    @Test
    public void testConstructWithCaseInsensitivity() {
        Set<String> input = new HashSet<>();
        input.add("Test");
        input.add("test");
        CaseInsensitiveNameSet result = CaseInsensitiveNameSet.construct(input);
        assertNotNull(result);
    }

    @Test
    public void testConstructWithNullElement() {
        Set<String> input = new HashSet<>();
        input.add(null);
        CaseInsensitiveNameSet result = CaseInsensitiveNameSet.construct(input);
        assertNotNull(result);
    }
}
