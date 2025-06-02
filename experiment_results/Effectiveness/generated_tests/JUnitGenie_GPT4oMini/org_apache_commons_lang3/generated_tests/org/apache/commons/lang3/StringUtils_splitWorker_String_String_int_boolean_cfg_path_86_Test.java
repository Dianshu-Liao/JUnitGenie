package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class StringUtils_splitWorker_String_String_int_boolean_cfg_path_86_Test {

    @Test(timeout = 4000)
    public void testSplitWorkerWithNullString() {
        try {
            Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
            method.setAccessible(true);
            String[] result = (String[]) method.invoke(null, null, null, 0, false);
            assertArrayEquals(null, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSplitWorkerWithEmptyString() {
        try {
            Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
            method.setAccessible(true);
            String[] result = (String[]) method.invoke(null, "", null, 0, false);
            assertArrayEquals(new String[0], result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}