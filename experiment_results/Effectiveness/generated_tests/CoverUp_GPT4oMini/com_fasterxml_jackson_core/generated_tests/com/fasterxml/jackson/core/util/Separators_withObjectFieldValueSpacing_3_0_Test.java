package com.fasterxml.jackson.core.util;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Objects;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class Separators_withObjectFieldValueSpacing_3_0_Test {

    private Separators separators;

    private Separators.Spacing spacing1;

    private Separators.Spacing spacing2;

    @BeforeEach
    public void setUp() {
        spacing1 = mock(Separators.Spacing.class);
        spacing2 = mock(Separators.Spacing.class);
        separators = new Separators(":", 'a', spacing1, 'b', mock(Separators.Spacing.class), "empty", 'c', mock(Separators.Spacing.class), "arrayEmpty");
    }

    @Test
    public void testWithObjectFieldValueSpacing_SameSpacing() {
        Separators result = separators.withObjectFieldValueSpacing(spacing1);
        assertSame(separators, result, "Expected the same instance when spacing is the same");
    }

    @Test
    public void testWithObjectFieldValueSpacing_DifferentSpacing() {
        Separators result = separators.withObjectFieldValueSpacing(spacing2);
        assertNotSame(separators, result, "Expected a new instance when spacing is different");
    }
}
