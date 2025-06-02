package org.apache.commons.collections4.keyvalue;
import org.apache.commons.collections4.keyvalue.DefaultKeyValue;
import org.junit.Test;
import static org.junit.Assert.*;

public class keyvalue_DefaultKeyValue_setKey_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSetKey_ValidKey() {
        DefaultKeyValue<String, String> keyValue = new DefaultKeyValue<>("initialKey", "initialValue");
        String newKey = "newKey";
        keyValue.setKey(newKey);
        assertEquals(newKey, keyValue.getKey());
    }

    @Test(timeout = 4000)
    public void testSetKey_SelfReference() {
        DefaultKeyValue<String, String> keyValue = new DefaultKeyValue<>("initialKey", "initialValue");
        try {
            // Attempting to set the key to its own value (not the object itself)
            keyValue.setKey(keyValue.getKey());
            fail("Expected IllegalArgumentException for self-reference key");
        } catch (IllegalArgumentException e) {
            assertEquals("DefaultKeyValue may not contain itself as a key.", e.getMessage());
        }
    }


}