package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.apache.commons.lang3.AppendableJoiner;
import org.junit.Test;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.Method;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class reflect_TypeUtils_parameterizedTypeToString_ParameterizedType_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testParameterizedTypeToString() {
        try {
            // Create a mock ParameterizedType
            ParameterizedType parameterizedType = new ParameterizedType() {
                @Override
                public Type[] getActualTypeArguments() {
                    return new Type[]{String.class};
                }

                @Override
                public Type getRawType() {
                    return List.class;
                }

                @Override
                public Type getOwnerType() {
                    return null; // No owner type
                }
            };

            // Access the private static method using reflection
            Method method = TypeUtils.class.getDeclaredMethod("parameterizedTypeToString", ParameterizedType.class);
            method.setAccessible(true);

            // Invoke the method
            String result = (String) method.invoke(null, parameterizedType);

            // Expected output
            String expected = "java.util.List<String>";
            assertEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}