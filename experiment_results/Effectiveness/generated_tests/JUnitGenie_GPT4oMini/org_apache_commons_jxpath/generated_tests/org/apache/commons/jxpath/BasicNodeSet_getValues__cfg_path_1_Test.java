package org.apache.commons.jxpath;
import org.apache.commons.jxpath.BasicNodeSet;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.util.List;

public class BasicNodeSet_getValues__cfg_path_1_Test {
    private BasicNodeSet basicNodeSet;

    @Before
    public void setUp() {
        basicNodeSet = new BasicNodeSet();
    }

    @Test(timeout = 4000)
    public void testGetValuesWhenValuesIsNull() {
        // This test will cover the path where values is null and will be initialized
        List result = null;
        try {
            result = basicNodeSet.getValues();
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
        assertNotNull("The result should not be null when values is initialized", result);
    }

}