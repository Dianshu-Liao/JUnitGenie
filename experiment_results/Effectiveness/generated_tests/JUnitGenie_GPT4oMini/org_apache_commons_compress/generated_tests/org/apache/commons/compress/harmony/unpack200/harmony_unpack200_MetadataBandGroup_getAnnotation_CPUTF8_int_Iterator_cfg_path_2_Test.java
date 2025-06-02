package org.apache.commons.compress.harmony.unpack200;
import org.apache.commons.compress.harmony.unpack200.MetadataBandGroup;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.apache.commons.compress.harmony.unpack200.bytecode.AnnotationsAttribute.Annotation;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.assertNotNull;

public class harmony_unpack200_MetadataBandGroup_getAnnotation_CPUTF8_int_Iterator_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetAnnotation() {
        // Arrange
        MetadataBandGroup metadataBandGroup = new MetadataBandGroup("test", null);
        CPUTF8 type = new CPUTF8("testType");
        int pairCount = 2;

        // Create an iterator for names
        CPUTF8 name1 = new CPUTF8("name1");
        CPUTF8 name2 = new CPUTF8("name2");
        Iterator<CPUTF8> namesIterator = new Iterator<CPUTF8>() {
            private int index = 0;
            private final CPUTF8[] names = {name1, name2};

            @Override
            public boolean hasNext() {
                return index < names.length;
            }

            @Override
            public CPUTF8 next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return names[index++];
            }
        };

        // Act
        try {
            // Change the method access to public or use setAccessible(true) if you cannot change the method
            java.lang.reflect.Method method = MetadataBandGroup.class.getDeclaredMethod("getAnnotation", CPUTF8.class, int.class, Iterator.class);
            method.setAccessible(true); // Allow access to private method
            Annotation annotation = (Annotation) method.invoke(metadataBandGroup, type, pairCount, namesIterator);

            // Assert
            assertNotNull(annotation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}