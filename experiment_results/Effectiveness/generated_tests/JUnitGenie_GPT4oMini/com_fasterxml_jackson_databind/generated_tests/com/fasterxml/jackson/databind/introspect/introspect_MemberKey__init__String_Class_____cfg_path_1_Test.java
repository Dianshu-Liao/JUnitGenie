package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.MemberKey;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class introspect_MemberKey__init__String_Class_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMemberKeyConstructorWithNullArgTypes() {
        String name = "testName";
        Class<?>[] argTypes = null;

        try {
            MemberKey memberKey = new MemberKey(name, argTypes);
            // Verify that _name is set correctly
            assertEquals(name, memberKey._name);
            // Verify that _argTypes is set to NO_CLASSES
            assertArrayEquals(MemberKey.NO_CLASSES, memberKey._argTypes);
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testMemberKeyConstructorWithNonNullArgTypes() {
        String name = "testName";
        Class<?>[] argTypes = {String.class, Integer.class};

        try {
            MemberKey memberKey = new MemberKey(name, argTypes);
            // Verify that _name is set correctly
            assertEquals(name, memberKey._name);
            // Verify that _argTypes is set to the provided argTypes
            assertArrayEquals(argTypes, memberKey._argTypes);
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }

}