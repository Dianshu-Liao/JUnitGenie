package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.SetUniqueList;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.assertTrue;

public class list_SetUniqueList_addAll_int_Collection_cfg_path_1_Test {

    private SetUniqueList<String> uniqueList;

    @Before
    public void setUp() {
        List<String> list = new ArrayList<>();
        uniqueList = SetUniqueList.setUniqueList(list); // Corrected line
    }

    @Test(timeout = 4000)
    public void testAddAll() {
        List<String> coll = new ArrayList<>();
        coll.add("Hello");
        coll.add("World");

        try {
            boolean result = uniqueList.addAll(0, coll);
            assertTrue(result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}