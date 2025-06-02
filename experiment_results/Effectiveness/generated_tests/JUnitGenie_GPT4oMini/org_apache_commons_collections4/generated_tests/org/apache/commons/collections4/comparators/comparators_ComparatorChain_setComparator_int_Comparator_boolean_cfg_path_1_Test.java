package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.junit.Test;
import java.util.Comparator;

public class comparators_ComparatorChain_setComparator_int_Comparator_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSetComparatorWithReverse() {
        ComparatorChain<String> comparatorChain = new ComparatorChain<>();
        Comparator<String> comparator = Comparator.naturalOrder();
        int index = 0;
        boolean reverse = true;

        // Ensure the comparatorChain has enough comparators before setting one
        comparatorChain.addComparator(comparator); // Add a comparator to avoid IndexOutOfBoundsException

        try {
            comparatorChain.setComparator(index, comparator, reverse);
            // Additional assertions can be added here to verify the state of comparatorChain
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSetComparatorWithoutReverse() {
        ComparatorChain<String> comparatorChain = new ComparatorChain<>();
        Comparator<String> comparator = Comparator.naturalOrder();
        int index = 0;
        boolean reverse = false;

        // Ensure the comparatorChain has enough comparators before setting one
        comparatorChain.addComparator(comparator); // Add a comparator to avoid IndexOutOfBoundsException

        try {
            comparatorChain.setComparator(index, comparator, reverse);
            // Additional assertions can be added here to verify the state of comparatorChain
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

}