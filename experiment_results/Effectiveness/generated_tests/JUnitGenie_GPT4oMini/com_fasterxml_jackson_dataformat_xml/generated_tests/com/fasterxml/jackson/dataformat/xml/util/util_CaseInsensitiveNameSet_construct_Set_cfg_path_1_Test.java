package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.util.HashSet;
import java.util.Set;

public class util_CaseInsensitiveNameSet_construct_Set_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testConstruct() {
        // Prepare the input set
        Set<String> names0 = new HashSet<>();
        names0.add("Name1");
        names0.add("name2");
        names0.add("NAME3");

        // Call the focal method
        CaseInsensitiveNameSet result = null;
        try {
            result = CaseInsensitiveNameSet.construct(names0);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        // Validate the result
        assertNotNull(result);
    }

}