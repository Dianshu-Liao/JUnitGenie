package org.apache.commons.collections4.sequence;
import org.apache.commons.collections4.sequence.SequencesComparator;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertNotNull;

public class sequence_SequencesComparator_buildSnake_int_int_int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testBuildSnake() {
        try {
            // Prepare the input parameters
            int start = 0;
            int diag = 1;
            int end1 = 5;
            int end2 = 3;

            // Create an instance of SequencesComparator
            List<String> sequence1 = Arrays.asList("A", "B", "C", "D", "E");
            List<String> sequence2 = Arrays.asList("A", "B", "C", "X", "Y");
            SequencesComparator<String> comparator = new SequencesComparator<>(sequence1, sequence2);

            // Access the private method using reflection
            Method method = SequencesComparator.class.getDeclaredMethod("buildSnake", int.class, int.class, int.class, int.class);
            method.setAccessible(true);

            // Adjust the end parameters to prevent ArrayIndexOutOfBoundsException
            if (end1 > sequence1.size()) {
                end1 = sequence1.size();
            }
            if (end2 > sequence2.size()) {
                end2 = sequence2.size();
            }

            // Invoke the method
            Object result = method.invoke(comparator, start, diag, end1, end2);

            // Assert that the result is not null
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}