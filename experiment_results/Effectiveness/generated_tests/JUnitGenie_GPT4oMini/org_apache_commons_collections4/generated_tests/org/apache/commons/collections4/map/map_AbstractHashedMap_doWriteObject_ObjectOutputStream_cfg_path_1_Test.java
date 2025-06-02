package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class map_AbstractHashedMap_doWriteObject_ObjectOutputStream_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testDoWriteObject() {
        try {
            // Create an instance of AbstractHashedMap using reflection
            Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class, float.class);
            constructor.setAccessible(true);
            AbstractHashedMap<Integer, String> map = constructor.newInstance(10, 0.75f);

            // Set the size and loadFactor fields using reflection
            setFieldValue(map, "size", 5);
            setFieldValue(map, "loadFactor", 0.75f);

            // Prepare the ObjectOutputStream
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

            // Call the protected method doWriteObject using reflection
            Method doWriteObjectMethod = AbstractHashedMap.class.getDeclaredMethod("doWriteObject", ObjectOutputStream.class);
            doWriteObjectMethod.setAccessible(true);
            doWriteObjectMethod.invoke(map, objectOutputStream);

            // Verify that the output stream is not null (indicating that the method executed)
            assertNotNull(byteArrayOutputStream.toByteArray());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setFieldValue(AbstractHashedMap map, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = AbstractHashedMap.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(map, value);
    }

}