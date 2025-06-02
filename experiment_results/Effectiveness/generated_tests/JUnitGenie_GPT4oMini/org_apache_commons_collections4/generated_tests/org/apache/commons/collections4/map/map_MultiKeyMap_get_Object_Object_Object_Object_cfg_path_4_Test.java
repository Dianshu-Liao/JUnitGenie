package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_get_Object_Object_Object_Object_cfg_path_4_Test {



    @Test(timeout = 4000)
    public void testGetWithNonExistentKeys() {
        MultiKeyMap<Object, Object> multiKeyMap = new MultiKeyMap<>();
        Object result = multiKeyMap.get("nonExistentKey1", "nonExistentKey2", "nonExistentKey3", "nonExistentKey4");
        assertNull(result);
    }


}
