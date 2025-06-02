package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.lang3.builder.Diff;

public class builder_DiffResult_toString_ToStringStyle_cfg_path_2_Test {

    private class TestToStringStyle extends ToStringStyle {


    }

    @Test(timeout = 4000)
    public void testToStringWhenDiffListIsEmpty() {
        // Given
        List<Diff<?>> emptyDiffList = new ArrayList<>();
        DiffResult diffResult = new DiffResult(new Object(), new Object(), emptyDiffList, new TestToStringStyle(), "Result Format");

        // When
        String result = diffResult.toString();

        // Then
        assertEquals("Expected output when diffList is empty", "OBJECTS_SAME_STRING", result);
    }


}
