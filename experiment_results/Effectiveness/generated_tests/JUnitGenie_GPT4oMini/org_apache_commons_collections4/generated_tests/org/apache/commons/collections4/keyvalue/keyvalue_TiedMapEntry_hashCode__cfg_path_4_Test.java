package org.apache.commons.collections4.keyvalue;
import org.apache.commons.collections4.keyvalue.TiedMapEntry;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class keyvalue_TiedMapEntry_hashCode__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testHashCodeWithNullKeyAndNonNullValue() {
        // Arrange
        java.util.Map<Object, Object> map = new java.util.HashMap<>();
        Object value = new Object(); // Non-null value
        TiedMapEntry entry = new TiedMapEntry(map, null); // Key is null

        // Mocking the getValue method to return the non-null value
        // Assuming we have a way to mock or set the value for testing
        // This is a placeholder for the actual implementation
        entry.setValue(value); // Hypothetical method to set value for testing

        // Act
        int result = entry.hashCode();

        // Assert
        int expectedHashCode = 0 ^ value.hashCode(); // Key is null, so hashCode should be value.hashCode()
        assertEquals(expectedHashCode, result);
    }

    @Test(timeout = 4000)
    public void testHashCodeWithNullKeyAndNullValue() {
        // Arrange
        java.util.Map<Object, Object> map = new java.util.HashMap<>();
        TiedMapEntry entry = new TiedMapEntry(map, null); // Both key and value are null

        // Act
        int result = entry.hashCode();

        // Assert
        assertEquals(0, result); // Both key and value are null, so hashCode should be 0
    }

}