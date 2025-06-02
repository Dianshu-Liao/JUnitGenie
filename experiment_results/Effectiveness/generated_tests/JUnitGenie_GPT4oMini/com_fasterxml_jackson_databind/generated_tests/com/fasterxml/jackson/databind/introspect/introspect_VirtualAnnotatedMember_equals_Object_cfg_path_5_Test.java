package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class introspect_VirtualAnnotatedMember_equals_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        VirtualAnnotatedMember member = new VirtualAnnotatedMember(null, Object.class, "name", null);
        assertTrue(member.equals(member));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        VirtualAnnotatedMember member = new VirtualAnnotatedMember(null, Object.class, "name", null);
        String differentObject = "Not a VirtualAnnotatedMember";
        assertFalse(member.equals(differentObject));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualMembers() {
        VirtualAnnotatedMember member1 = new VirtualAnnotatedMember(null, Object.class, "name", null);
        VirtualAnnotatedMember member2 = new VirtualAnnotatedMember(null, Object.class, "name", null);
        assertTrue(member1.equals(member2));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        VirtualAnnotatedMember member = new VirtualAnnotatedMember(null, Object.class, "name", null);
        assertFalse(member.equals(null));
    }

}