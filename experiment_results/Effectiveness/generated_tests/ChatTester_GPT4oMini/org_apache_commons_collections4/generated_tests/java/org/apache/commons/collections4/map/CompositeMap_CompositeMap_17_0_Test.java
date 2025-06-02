package org.apache.commons.collections4.map;

import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.collection.CompositeCollection;
import org.apache.commons.collections4.set.CompositeSet;

public class CompositeMap_CompositeMap_17_0_Test {

    @Test
    public void testCompositeMapConstructor() {
        // Arrange
        CompositeMap<String, String> compositeMap;
        // Act
        compositeMap = new CompositeMap<>();
        // Assert
        assertNotNull(compositeMap);
        assertEquals(0, compositeMap.size(), "The size of the composite map should be 0 after initialization.");
    }
}
