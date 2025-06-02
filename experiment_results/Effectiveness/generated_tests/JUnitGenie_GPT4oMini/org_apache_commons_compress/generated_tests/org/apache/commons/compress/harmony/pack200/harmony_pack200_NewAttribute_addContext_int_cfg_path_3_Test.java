package org.apache.commons.compress.harmony.pack200;
import org.junit.Test;
import org.apache.commons.compress.harmony.pack200.NewAttribute;
import static org.junit.Assert.assertTrue;

public class harmony_pack200_NewAttribute_addContext_int_cfg_path_3_Test {

    private NewAttribute newAttribute;

    @org.junit.Before
    public void setUp() {
        newAttribute = new NewAttribute("Test", "Test", 1);
    }

    @Test(timeout = 4000)
    public void testAddContextWithContextCode() {
        // Act
        newAttribute.addContext(AttributeDefinitionBands.CONTEXT_CODE);
        
        // Verify
        // Access the private field contextCode using reflection
        try {
            java.lang.reflect.Field field = NewAttribute.class.getDeclaredField("contextCode");
            field.setAccessible(true);
            boolean contextCodeValue = (boolean) field.get(newAttribute);
            assertTrue(contextCodeValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}