package org.apache.commons.compress.harmony.unpack200;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_unpack200_SegmentConstantPool_getValue_int_long_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetValue_NegativeIndexThrowsPack200Exception() {
        // Create a new Segment instance
        Segment segment = new Segment(); // Assuming Segment is the correct type
        CpBands cpBands = new CpBands(segment); // Pass the Segment instance to CpBands constructor
        SegmentConstantPool segmentConstantPool = new SegmentConstantPool(cpBands);
        long longIndex = -1L; // This will cause the index to be negative
        int cp = 0; // Any valid cp value

        try {
            segmentConstantPool.getValue(cp, longIndex);
            fail("Expected Pack200Exception to be thrown");
        } catch (Pack200Exception e) {
            assertEquals("Cannot have a negative range", e.getMessage());
        }
    }


}