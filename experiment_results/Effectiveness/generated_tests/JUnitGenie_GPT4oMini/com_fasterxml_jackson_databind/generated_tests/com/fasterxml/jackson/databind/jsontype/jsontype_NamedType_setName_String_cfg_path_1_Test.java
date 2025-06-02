package com.fasterxml.jackson.databind.jsontype;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

public class jsontype_NamedType_setName_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSetNameWithNull() {
        NamedType namedType = new NamedType(String.class);
        namedType.setName(null);
        assertNull(namedType._name);
    }

    @Test(timeout = 4000)
    public void testSetNameWithEmptyString() {
        NamedType namedType = new NamedType(String.class);
        namedType.setName("");
        assertNull(namedType._name);
    }

    @Test(timeout = 4000)
    public void testSetNameWithValidString() {
        NamedType namedType = new NamedType(String.class);
        String validName = "ValidName";
        namedType.setName(validName);
        assertEquals(validName, namedType._name);
    }

}