package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import com.fasterxml.jackson.core.*;

public class DupDetector_isDup_6_1_Test {

    private DupDetector dupDetector;

    @BeforeEach
    public void setUp() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<DupDetector> constructor = DupDetector.class.getDeclaredConstructor(Object.class);
        constructor.setAccessible(true);
        dupDetector = constructor.newInstance(new Object());
    }

    @Test
    public void testIsDup_FirstNameIsNull() throws JsonParseException {
        // Test case where _firstName is null
        assertFalse(dupDetector.isDup("Alice"));
        // _firstName should now be "Alice"
    }

    @Test
    public void testIsDup_FirstNameMatches() throws JsonParseException {
        dupDetector.isDup("Alice");
        // Test case where the name matches _firstName
        assertTrue(dupDetector.isDup("Alice"));
    }

    @Test
    public void testIsDup_SecondNameIsNull() throws JsonParseException {
        dupDetector.isDup("Alice");
        // Test case where _secondName is null
        assertFalse(dupDetector.isDup("Bob"));
        // _secondName should now be "Bob"
    }

    @Test
    public void testIsDup_SecondNameMatches() throws JsonParseException {
        dupDetector.isDup("Alice");
        dupDetector.isDup("Bob");
        // Test case where the name matches _secondName
        assertTrue(dupDetector.isDup("Bob"));
    }

    @Test
    public void testIsDup_SeenIsNull() throws JsonParseException {
        dupDetector.isDup("Alice");
        dupDetector.isDup("Bob");
        // Test case where _seen is null, should initialize and add _firstName and _secondName
        assertFalse(dupDetector.isDup("Charlie"));
    }

    @Test
    public void testIsDup_NameAlreadySeen() throws JsonParseException {
        dupDetector.isDup("Alice");
        dupDetector.isDup("Bob");
        dupDetector.isDup("Charlie");
        // Test case where the name has already been added to _seen
        assertTrue(dupDetector.isDup("Alice"));
        assertTrue(dupDetector.isDup("Bob"));
        assertTrue(dupDetector.isDup("Charlie"));
    }

    @Test
    public void testIsDup_NewUniqueName() throws JsonParseException {
        dupDetector.isDup("Alice");
        dupDetector.isDup("Bob");
        dupDetector.isDup("Charlie");
        // Test case for a new unique name not previously seen
        assertFalse(dupDetector.isDup("David"));
    }

    @Test
    public void testIsDup_SameNameRepeated() throws JsonParseException {
        dupDetector.isDup("Alice");
        dupDetector.isDup("Bob");
        // Test case for the same name repeated
        assertTrue(dupDetector.isDup("Alice"));
        assertTrue(dupDetector.isDup("Bob"));
    }
}
