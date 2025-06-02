package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.UnmodifiableList;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class list_UnmodifiableList_unmodifiableList_List_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testUnmodifiableList_NonUnmodifiableInput() {
        // Given
        List<String> modifiableList = new ArrayList<>();
        modifiableList.add("test");

        // When
        List<String> result = UnmodifiableList.unmodifiableList(modifiableList);

        // Then
        assertTrue(result instanceof UnmodifiableList);
    }

    @Test(timeout = 4000)
    public void testUnmodifiableList_WithUnmodifiableInput() {
        // Given
        List<String> unmodifiableList = UnmodifiableList.unmodifiableList(new ArrayList<>());

        try {
            // When
            List<String> result = UnmodifiableList.unmodifiableList(unmodifiableList);

            // Then
            assertTrue(result instanceof UnmodifiableList);
        } catch (Exception e) {
            // This is to handle any unexpected exceptions 
            e.printStackTrace();
        }
    }

}