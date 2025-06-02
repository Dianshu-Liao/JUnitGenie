package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.fasterxml.jackson.databind.JavaType;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class introspect_VirtualAnnotatedMember_equals_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        VirtualAnnotatedMember member = new VirtualAnnotatedMember(null, String.class, "testName", null);
        assertTrue(member.equals(member));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        VirtualAnnotatedMember member = new VirtualAnnotatedMember(null, String.class, "testName", null);
        Object differentClassObject = new Object();
        assertFalse(member.equals(differentClassObject));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        VirtualAnnotatedMember member = new VirtualAnnotatedMember(null, String.class, "testName", null);
        assertFalse(member.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentDeclaringClass() {
        VirtualAnnotatedMember member1 = new VirtualAnnotatedMember(null, String.class, "testName", null);
        VirtualAnnotatedMember member2 = new VirtualAnnotatedMember(null, Integer.class, "testName", null);
        assertFalse(member1.equals(member2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentName() {
        VirtualAnnotatedMember member1 = new VirtualAnnotatedMember(null, String.class, "testName1", null);
        VirtualAnnotatedMember member2 = new VirtualAnnotatedMember(null, String.class, "testName2", null);
        assertFalse(member1.equals(member2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameDeclaringClassAndName() {
        VirtualAnnotatedMember member1 = new VirtualAnnotatedMember(null, String.class, "testName", null);
        VirtualAnnotatedMember member2 = new VirtualAnnotatedMember(null, String.class, "testName", null);
        assertTrue(member1.equals(member2));
    }

}