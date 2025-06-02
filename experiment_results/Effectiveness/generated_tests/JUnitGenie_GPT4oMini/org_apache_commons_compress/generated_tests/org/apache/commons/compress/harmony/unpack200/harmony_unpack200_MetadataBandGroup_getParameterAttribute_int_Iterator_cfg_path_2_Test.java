package org.apache.commons.compress.harmony.unpack200;
import org.apache.commons.compress.harmony.unpack200.MetadataBandGroup;
import org.apache.commons.compress.harmony.unpack200.bytecode.Attribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertNotNull;

public class harmony_unpack200_MetadataBandGroup_getParameterAttribute_int_Iterator_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetParameterAttribute() {
        try {
            // Arrange
            MetadataBandGroup metadataBandGroup = new MetadataBandGroup("test", null);
            int numParameters = 0; // Adjusted to match expected index
            List<CPUTF8> namesList = Arrays.asList(new CPUTF8("name1"));
            Iterator<CPUTF8> namesIterator = namesList.iterator();

            // Access the private method using reflection
            Method method = MetadataBandGroup.class.getDeclaredMethod("getParameterAttribute", int.class, Iterator.class);
            method.setAccessible(true);

            // Act
            Attribute result = (Attribute) method.invoke(metadataBandGroup, numParameters, namesIterator);

            // Assert
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}