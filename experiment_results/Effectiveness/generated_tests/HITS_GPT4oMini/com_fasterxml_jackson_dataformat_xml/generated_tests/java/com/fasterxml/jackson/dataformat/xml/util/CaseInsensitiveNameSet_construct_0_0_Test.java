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
    public void testConstructWithSingleName() {
        Set<String> input = new HashSet<>();
        input.add("TestName");
        CaseInsensitiveNameSet result = CaseInsensitiveNameSet.construct(input);
        assertNotNull(result);
    }

    @Test
    public void testConstructWithMultipleNames() {
        Set<String> input = new HashSet<>();
        input.add("NameOne");
        input.add("NameTwo");
        input.add("NameThree");
        CaseInsensitiveNameSet result = CaseInsensitiveNameSet.construct(input);
        assertNotNull(result);
    }

    @Test
    public void testConstructWithDuplicateNames() {
        Set<String> input = new HashSet<>();
        input.add("DuplicateName");
        // Duplicate in different case
        input.add("duplicatename");
        CaseInsensitiveNameSet result = CaseInsensitiveNameSet.construct(input);
        assertNotNull(result);
    }

    @Test
    public void testConstructWithMixedCaseNames() {
        Set<String> input = new HashSet<>();
        input.add("MixedCaseName");
        input.add("mixedcasename");
        input.add("MIXEDCASENAME");
        CaseInsensitiveNameSet result = CaseInsensitiveNameSet.construct(input);
        assertNotNull(result);
    }

    @Test
    public void testConstructWithNullInput() {
        assertThrows(NullPointerException.class, () -> {
            CaseInsensitiveNameSet.construct(null);
        });
    }
}
