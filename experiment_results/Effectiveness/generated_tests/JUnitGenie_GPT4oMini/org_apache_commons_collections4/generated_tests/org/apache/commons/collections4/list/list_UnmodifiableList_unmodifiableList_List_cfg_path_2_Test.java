package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.UnmodifiableList;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class list_UnmodifiableList_unmodifiableList_List_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testUnmodifiableListWithModifiableList() {
        List<String> modifiableList = new ArrayList<>();
        modifiableList.add("element1");
        modifiableList.add("element2");

        List<String> unmodifiableList = UnmodifiableList.unmodifiableList(modifiableList);

        // Verify that the unmodifiable list contains the same elements
        assertEquals(modifiableList, unmodifiableList);
    }

    @Test(timeout = 4000)
    public void testUnmodifiableListWithUnmodifiableList() {
        List<String> modifiableList = new ArrayList<>();
        modifiableList.add("element1");
        modifiableList.add("element2");
        List<String> unmodifiableList = UnmodifiableList.unmodifiableList(Collections.unmodifiableList(modifiableList));

        // Verify that the unmodifiable list is the same as the input
        assertEquals(unmodifiableList, unmodifiableList);
    }

}