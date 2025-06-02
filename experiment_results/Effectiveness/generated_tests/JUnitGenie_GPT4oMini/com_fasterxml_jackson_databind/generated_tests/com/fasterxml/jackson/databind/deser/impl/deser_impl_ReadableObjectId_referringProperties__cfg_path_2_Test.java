package com.fasterxml.jackson.databind.deser.impl;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class deser_impl_ReadableObjectId_referringProperties__cfg_path_2_Test {
    private ReadableObjectId readableObjectId;


    @Test(timeout = 4000)
    public void testReferringPropertiesReturnsEmptyIteratorWhenNull() {
        Iterator<?> iterator = readableObjectId.referringProperties(); // Use wildcard for unknown type
        assertNotNull(iterator);
        assertFalse(iterator.hasNext());
    }

    @Test(timeout = 4000)
    public void testReferringPropertiesReturnsIteratorWhenNotNull() {
        // Initialize _referringProperties with a non-null LinkedList
        try {
            java.lang.reflect.Field field = ReadableObjectId.class.getDeclaredField("_referringProperties");
            field.setAccessible(true);
            List<Object> referringList = new LinkedList<>(); // Use Object as a placeholder
            field.set(readableObjectId, referringList);
        } catch (Exception e) {
            fail("Failed to set up _referringProperties: " + e.getMessage());
        }

        Iterator<?> iterator = readableObjectId.referringProperties(); // Use wildcard for unknown type
        assertNotNull(iterator);
        // Since we added no elements, it should still be false
        assertFalse(iterator.hasNext());
    }

}
