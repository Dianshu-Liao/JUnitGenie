package org.apache.commons.compress.harmony.pack200;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;

class IntList_growForInsert_7_1_Test {

    private IntList intList;

    @BeforeEach
    void setUp() {
        intList = new IntList();
    }

    @Test
    void testGrowForInsertWithSmallRequired() throws Exception {
        invokeGrowForInsert(0, 5);
        assertNotNull(getPrivateField("array"));
        assertEquals(12, ((int[]) getPrivateField("array")).length);
    }

    @Test
    void testGrowForInsertWithLargeRequired() throws Exception {
        invokeGrowForInsert(0, 20);
        assertNotNull(getPrivateField("array"));
        assertEquals(20, ((int[]) getPrivateField("array")).length);
    }

    @Test
    void testGrowForInsertAtMiddle() throws Exception {
        invokeGrowForInsert(1, 15);
        assertNotNull(getPrivateField("array"));
        assertEquals(15, ((int[]) getPrivateField("array")).length);
    }

    @Test
    void testGrowForInsertWithZeroRequired() throws Exception {
        invokeGrowForInsert(0, 0);
        assertNotNull(getPrivateField("array"));
        assertEquals(12, ((int[]) getPrivateField("array")).length);
    }

    private void invokeGrowForInsert(int location, int required) throws Exception {
        Method method = IntList.class.getDeclaredMethod("growForInsert", int.class, int.class);
        method.setAccessible(true);
        method.invoke(intList, location, required);
    }

    private Object getPrivateField(String fieldName) throws Exception {
        return IntList.class.getDeclaredField(fieldName).get(intList);
    }
}
