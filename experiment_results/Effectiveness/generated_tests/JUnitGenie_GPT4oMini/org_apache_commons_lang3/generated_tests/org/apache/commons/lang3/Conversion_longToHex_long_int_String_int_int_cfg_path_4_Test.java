package org.apache.commons.lang3;
import org.apache.commons.lang3.Conversion;
import org.junit.Test;
import static org.junit.Assert.*;

public class Conversion_longToHex_long_int_String_int_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testLongToHex_ThrowsIllegalArgumentException_WhenConditionIsMet() {
        long src = 0L;
        int srcPos = 60; // This will cause (nHexs-1)*4 + srcPos to be >= 64
        String dstInit = "";
        int dstPos = 0;
        int nHexs = 2; // nHexs = 2, so (2-1)*4 + 60 = 64, which triggers the exception

        try {
            Conversion.longToHex(src, srcPos, dstInit, dstPos, nHexs);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("(nHexs-1)*4+srcPos is greater or equal to than 64", e.getMessage());
        }
    }

}