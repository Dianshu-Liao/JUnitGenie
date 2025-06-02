package org.apache.commons.collections4.keyvalue;
import org.apache.commons.collections4.keyvalue.DefaultKeyValue;
import org.junit.Test;

public class keyvalue_DefaultKeyValue_setKey_Object_cfg_path_2_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testSetKey_ThrowsIllegalArgumentException_WhenKeyIsSelf() {
        DefaultKeyValue<Object, Object> keyValue = new DefaultKeyValue<>();
        keyValue.setKey(keyValue); // This should throw IllegalArgumentException
    }

}