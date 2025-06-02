package org.apache.commons.compress.harmony.unpack200;
import org.apache.commons.compress.harmony.unpack200.SegmentHeader;
import org.apache.commons.compress.harmony.unpack200.Segment;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class harmony_unpack200_SegmentHeader_setArchiveMinorVersion_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSetArchiveMinorVersion_ValidVersion() {
        try {
            SegmentHeader segmentHeader = new SegmentHeader(new Segment());
            Method method = SegmentHeader.class.getDeclaredMethod("setArchiveMinorVersion", int.class);
            method.setAccessible(true);
            method.invoke(segmentHeader, 7);
            
            // Accessing the private field archiveMinor using reflection
            java.lang.reflect.Field field = SegmentHeader.class.getDeclaredField("archiveMinor");
            field.setAccessible(true);
            int archiveMinor = (int) field.get(segmentHeader);
            assertEquals(7, archiveMinor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
