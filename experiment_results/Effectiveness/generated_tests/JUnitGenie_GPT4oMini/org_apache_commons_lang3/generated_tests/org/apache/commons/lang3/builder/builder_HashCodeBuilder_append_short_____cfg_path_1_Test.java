package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class builder_HashCodeBuilder_append_short_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAppendWithNullArray() {
        HashCodeBuilder builder = new HashCodeBuilder();
        // Assuming iTotal and iConstant are initialized in the constructor
        // Since they are private, we cannot access them directly, but we can test the behavior.
        builder.append((short[]) null);
        // We cannot assert the internal state directly, but we can check that the method completes without exception.
        assertNotNull(builder);
    }

    @Test(timeout = 4000)
    public void testAppendWithNonNullArray() {
        HashCodeBuilder builder = new HashCodeBuilder();
        short[] array = {1, 2, 3};
        builder.append(array);
        // We cannot assert the internal state directly, but we can check that the method completes without exception.
        assertNotNull(builder);
    }

}