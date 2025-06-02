package org.apache.commons.collections4.set;
import org.apache.commons.collections4.set.UnmodifiableSet;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertNotNull;

public class set_UnmodifiableSet_unmodifiableSet_Set_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testUnmodifiableSetWithMutableSet() {
        Set<String> mutableSet = new HashSet<>();
        mutableSet.add("element1");
        mutableSet.add("element2");

        try {
            Set<String> resultSet = UnmodifiableSet.unmodifiableSet(mutableSet);
            assertNotNull(resultSet);
            // further assertions can be done to verify the properties of the resultSet
        } catch (Exception e) {
            // handle exception if necessary
            e.printStackTrace();
        }
    }

}