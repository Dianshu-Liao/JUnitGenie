package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember;
import org.junit.Test;
import static org.junit.Assert.*;

public class introspect_VirtualAnnotatedMember_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        VirtualAnnotatedMember member = new VirtualAnnotatedMember(null, null, "testName", null);
        assertTrue(member.equals(member));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        VirtualAnnotatedMember member1 = new VirtualAnnotatedMember(null, String.class, "testName", null);
        String notAMember = "I am not a VirtualAnnotatedMember";
        assertFalse(member1.equals(notAMember));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentDeclaringClass() {
        VirtualAnnotatedMember member1 = new VirtualAnnotatedMember(null, Integer.class, "testName", null);
        VirtualAnnotatedMember member2 = new VirtualAnnotatedMember(null, String.class, "testName", null);
        assertFalse(member1.equals(member2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameNameDifferentDeclaringClass() {
        VirtualAnnotatedMember member1 = new VirtualAnnotatedMember(null, Integer.class, "testName", null);
        VirtualAnnotatedMember member2 = new VirtualAnnotatedMember(null, Integer.class, "testName", null);
        assertTrue(member1.equals(member2));
    }

    @Test(timeout = 4000)
    public void testEquals_Null() {
        VirtualAnnotatedMember member = new VirtualAnnotatedMember(null, null, "testName", null);
        assertFalse(member.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentName() {
        VirtualAnnotatedMember member1 = new VirtualAnnotatedMember(null, Integer.class, "testName1", null);
        VirtualAnnotatedMember member2 = new VirtualAnnotatedMember(null, Integer.class, "testName2", null);
        assertFalse(member1.equals(member2));
    }

}