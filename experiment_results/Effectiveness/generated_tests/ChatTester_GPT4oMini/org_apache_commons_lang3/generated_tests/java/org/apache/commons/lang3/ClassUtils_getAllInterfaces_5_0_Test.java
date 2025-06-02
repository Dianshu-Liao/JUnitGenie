// Test method
package org.apache.commons.lang3;

import java.util.List;
import java.util.Set;
import java.util.Collection;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.lang3.mutable.MutableObject;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ClassUtils_getAllInterfaces_5_0_Test {

    @Test
    public void testGetAllInterfaces_NullClass() {
        List<Class<?>> result = ClassUtils.getAllInterfaces(null);
        assertNull(result);
    }

    @Test
    public void testGetAllInterfaces_NoInterfaces() {
        List<Class<?>> result = ClassUtils.getAllInterfaces(String.class);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void testGetAllInterfaces_WithInterfaces() {
        List<Class<?>> result = ClassUtils.getAllInterfaces(Set.class);
        Assertions.assertTrue(result.contains(Iterable.class));
        Assertions.assertTrue(result.contains(Collection.class));
        Assertions.assertTrue(result.contains(Set.class));
    }

    @Test
    public void testGetAllInterfaces_WithMultipleInheritance() {
        List<Class<?>> result = ClassUtils.getAllInterfaces(ChildClass.class);
        Assertions.assertTrue(result.contains(ParentInterface.class));
        Assertions.assertTrue(result.contains(AnotherInterface.class));
    }

    private static class ParentInterface {
    }

    private static interface AnotherInterface {
    }

    private static class ChildClass extends ParentInterface implements AnotherInterface {
    }
}
