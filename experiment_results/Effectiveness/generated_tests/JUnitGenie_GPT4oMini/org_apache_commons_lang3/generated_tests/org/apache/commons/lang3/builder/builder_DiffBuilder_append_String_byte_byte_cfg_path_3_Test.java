package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class builder_DiffBuilder_append_String_byte_byte_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAppendWithEqualBytes() {
        DiffBuilder diffBuilder = new DiffBuilder(new Object(), new Object(), ToStringStyle.DEFAULT_STYLE);
        DiffBuilder result = diffBuilder.append("fieldName", (byte) 1, (byte) 1);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentBytes() {
        DiffBuilder diffBuilder = new DiffBuilder(new Object(), new Object(), ToStringStyle.DEFAULT_STYLE);
        DiffBuilder result = diffBuilder.append("fieldName", (byte) 1, (byte) 2);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendWithEqualsTrue() {
        DiffBuilder diffBuilder = new DiffBuilder(new Object(), new Object(), ToStringStyle.DEFAULT_STYLE);
        // Setting the equals field to true for testing
        try {
            java.lang.reflect.Field field = DiffBuilder.class.getDeclaredField("equals");
            field.setAccessible(true);
            field.set(diffBuilder, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DiffBuilder result = diffBuilder.append("fieldName", (byte) 1, (byte) 2);
        assertNotNull(result);
    }

}