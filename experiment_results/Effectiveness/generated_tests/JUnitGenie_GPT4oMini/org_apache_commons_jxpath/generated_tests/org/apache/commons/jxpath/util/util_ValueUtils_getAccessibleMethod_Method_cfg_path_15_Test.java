package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNull;

public class util_ValueUtils_getAccessibleMethod_Method_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testGetAccessibleMethod_NullMethod() {
        // Test case for when the input method is null
        Method method = null;
        Method result = ValueUtils.getAccessibleMethod(method);
        assertNull(result);
    }

}