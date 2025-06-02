package org.apache.commons.lang3;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LocaleUtils_isNumericAreaCode_8_0_Test {

    @Test
    public void testIsNumericAreaCode_ValidNumericCode() throws Exception {
        // Arrange
        String validCode = "123";
        // Act
        boolean result = invokeIsNumericAreaCode(validCode);
        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void testIsNumericAreaCode_InvalidLength() throws Exception {
        // Arrange
        // Length is not 3
        String invalidCode = "12";
        // Act
        boolean result = invokeIsNumericAreaCode(invalidCode);
        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void testIsNumericAreaCode_ContainsNonNumeric() throws Exception {
        // Arrange
        // Contains non-numeric character
        String invalidCode = "12A";
        // Act
        boolean result = invokeIsNumericAreaCode(invalidCode);
        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void testIsNumericAreaCode_EmptyString() throws Exception {
        // Arrange
        // Empty string
        String emptyCode = "";
        // Act
        boolean result = invokeIsNumericAreaCode(emptyCode);
        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void testIsNumericAreaCode_NullInput() throws Exception {
        // Arrange
        // Null input
        String nullCode = null;
        // Act
        boolean result = invokeIsNumericAreaCode(nullCode);
        // Assert
        Assertions.assertFalse(result);
    }

    private boolean invokeIsNumericAreaCode(String str) throws Exception {
        Method method = LocaleUtils.class.getDeclaredMethod("isNumericAreaCode", String.class);
        method.setAccessible(true);
        return (boolean) method.invoke(null, str);
    }
}
