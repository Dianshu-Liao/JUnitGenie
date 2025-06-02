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
    void testIsNumericAreaCode() throws Exception {
        LocaleUtils localeUtils = new LocaleUtils();
        // Test valid numeric area codes
        assertTrue(invokeIsNumericAreaCode(localeUtils, "123"));
        assertTrue(invokeIsNumericAreaCode(localeUtils, "456"));
        assertTrue(invokeIsNumericAreaCode(localeUtils, "789"));
        // Test invalid numeric area codes
        // too short
        assertFalse(invokeIsNumericAreaCode(localeUtils, "12"));
        // too long
        assertFalse(invokeIsNumericAreaCode(localeUtils, "1234"));
        // non-numeric
        assertFalse(invokeIsNumericAreaCode(localeUtils, "abc"));
        // mixed
        assertFalse(invokeIsNumericAreaCode(localeUtils, "12a"));
        // empty
        assertFalse(invokeIsNumericAreaCode(localeUtils, ""));
        // null
        assertFalse(invokeIsNumericAreaCode(localeUtils, null));
    }

    private boolean invokeIsNumericAreaCode(LocaleUtils localeUtils, String areaCode) throws Exception {
        Method method = LocaleUtils.class.getDeclaredMethod("isNumericAreaCode", String.class);
        method.setAccessible(true);
        return (boolean) method.invoke(localeUtils, areaCode);
    }
}
