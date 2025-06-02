package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.SetUniqueList;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collection;

public class list_SetUniqueList_addAll_int_Collection_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAddAll() {
        // Create a SetUniqueList instance
        SetUniqueList<String> setUniqueList = SetUniqueList.setUniqueList(new ArrayList<>());

        // Prepare the collection to add
        Collection<String> collectionToAdd = new ArrayList<>();
        collectionToAdd.add("A");
        collectionToAdd.add("B");
        collectionToAdd.add("C");

        // Call the addAll method
        boolean result = false;
        try {
            result = setUniqueList.addAll(0, collectionToAdd);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Verify the result
        assertTrue(result);
    }

}