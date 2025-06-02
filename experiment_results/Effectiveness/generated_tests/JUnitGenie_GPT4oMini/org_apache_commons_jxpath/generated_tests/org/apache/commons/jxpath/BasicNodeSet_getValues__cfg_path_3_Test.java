package org.apache.commons.jxpath;
import org.apache.commons.jxpath.BasicNodeSet;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class BasicNodeSet_getValues__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetValues() {
        // Arrange
        BasicNodeSet nodeSet = new BasicNodeSet();
        // Adding pointers to the private final list
        List<Pointer> pointers = new ArrayList<>();
        pointers.add(new Pointer("Value1"));
        pointers.add(new Pointer("Value2"));
        // Using reflection to set the private final pointers field
        try {
            java.lang.reflect.Field pointersField = BasicNodeSet.class.getDeclaredField("pointers");
            pointersField.setAccessible(true);
            pointersField.set(nodeSet, pointers);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Act
        List<String> values = nodeSet.getValues();

        // Assert
        assertNotNull(values);
        assertEquals(2, values.size());
        assertEquals("Value1", values.get(0));
        assertEquals("Value2", values.get(1));
    }

    // Mock Pointer class for testing
    private static class Pointer {
        private String value;

        public Pointer(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }


}