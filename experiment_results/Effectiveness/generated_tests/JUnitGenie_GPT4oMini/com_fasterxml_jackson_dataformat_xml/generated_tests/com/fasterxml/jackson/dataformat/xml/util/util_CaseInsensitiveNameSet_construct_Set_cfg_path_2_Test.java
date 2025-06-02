package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertNotNull;

public class util_CaseInsensitiveNameSet_construct_Set_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testConstructWithLowercaseNames() {
        // Arrange
        Set<String> names0 = new HashSet<>();
        names0.add("apple");
        names0.add("banana");
        names0.add("cherry");

        // Act
        CaseInsensitiveNameSet result = null;
        try {
            result = CaseInsensitiveNameSet.construct(names0);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testConstructWithMixedCaseNames() {
        // Arrange
        Set<String> names0 = new HashSet<>();
        names0.add("Apple");
        names0.add("Banana");
        names0.add("Cherry");

        // Act
        CaseInsensitiveNameSet result = null;
        try {
            result = CaseInsensitiveNameSet.construct(names0);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testConstructWithEmptySet() {
        // Arrange
        Set<String> names0 = new HashSet<>();

        // Act
        CaseInsensitiveNameSet result = null;
        try {
            result = CaseInsensitiveNameSet.construct(names0);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertNotNull(result);
    }

}