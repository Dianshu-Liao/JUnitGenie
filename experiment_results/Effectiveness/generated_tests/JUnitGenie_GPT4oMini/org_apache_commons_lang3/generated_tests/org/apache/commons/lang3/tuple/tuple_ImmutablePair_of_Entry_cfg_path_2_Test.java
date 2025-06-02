package org.apache.commons.lang3.tuple;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import java.util.Map;

public class tuple_ImmutablePair_of_Entry_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testOf_NullEntry() {
        // Arrange
        Map.Entry<Object, Object> nullEntry = null;

        // Act
        ImmutablePair<Object, Object> result = ImmutablePair.of(nullEntry);

        // Assert
        assertNull(result);
    }


}