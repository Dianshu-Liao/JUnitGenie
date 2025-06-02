package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_EqualsBuilder_append_byte_____byte_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAppendArraysEqual() {
        EqualsBuilder builder = new EqualsBuilder();
        byte[] array1 = {1, 2, 3};
        byte[] array2 = {1, 2, 3};

        EqualsBuilder result = builder.append(array1, array2);
        assertTrue(result.isEquals()); // Use the isEquals() method instead of accessing the field directly
    }

    @Test(timeout = 4000)
    public void testAppendArraysNotEqual() {
        EqualsBuilder builder = new EqualsBuilder();
        byte[] array1 = {1, 2, 3};
        byte[] array2 = {1, 2, 4};

        EqualsBuilder result = builder.append(array1, array2);
        assertFalse(result.isEquals()); // Use the isEquals() method instead of accessing the field directly
    }

    @Test(timeout = 4000)
    public void testAppendArrayWithNull() {
        EqualsBuilder builder = new EqualsBuilder();
        byte[] array1 = null;
        byte[] array2 = {1, 2, 3};

        EqualsBuilder result = builder.append(array1, array2);
        assertFalse(result.isEquals()); // Use the isEquals() method instead of accessing the field directly
    }

    @Test(timeout = 4000)
    public void testAppendArraysDifferentLength() {
        EqualsBuilder builder = new EqualsBuilder();
        byte[] array1 = {1, 2};
        byte[] array2 = {1, 2, 3};

        EqualsBuilder result = builder.append(array1, array2);
        assertFalse(result.isEquals()); // Use the isEquals() method instead of accessing the field directly
    }


}