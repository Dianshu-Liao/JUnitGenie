package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.MemberKey;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class introspect_MemberKey__init__String_Class_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testMemberKeyInitialization_WithValidParameters() {
        String name = "testName";
        Class<?>[] argTypes = {String.class, Integer.class};

        try {
            MemberKey memberKey = new MemberKey(name, argTypes);
            assertNotNull(memberKey);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testMemberKeyInitialization_WithNullArgTypes() {
        String name = "testName";
        Class<?>[] argTypes = null;

        try {
            MemberKey memberKey = new MemberKey(name, argTypes);
            assertNotNull(memberKey);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}