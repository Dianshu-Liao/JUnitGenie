package com.fasterxml.jackson.core.sym;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class sym_ByteQuadsCanonicalizer__verifySharing__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testVerifySharing_ThrowsIllegalStateException_WhenCountIsZeroAndParentIsNull() {
        try {
            // Create an instance of ByteQuadsCanonicalizer using reflection
            Class<?> clazz = ByteQuadsCanonicalizer.class;
            Constructor<?> constructor = clazz.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true);
            ByteQuadsCanonicalizer instance = (ByteQuadsCanonicalizer) constructor.newInstance(0, 0);

            // Set the protected fields using reflection
            java.lang.reflect.Field hashSharedField = clazz.getDeclaredField("_hashShared");
            hashSharedField.setAccessible(true);
            hashSharedField.setBoolean(instance, true);

            java.lang.reflect.Field countField = clazz.getDeclaredField("_count");
            countField.setAccessible(true);
            countField.setInt(instance, 0);

            java.lang.reflect.Field parentField = clazz.getDeclaredField("_parent");
            parentField.setAccessible(true);
            parentField.set(instance, null);

            // Invoke the private method _verifySharing
            Method verifySharingMethod = clazz.getDeclaredMethod("_verifySharing");
            verifySharingMethod.setAccessible(true);
            verifySharingMethod.invoke(instance);

            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }


}