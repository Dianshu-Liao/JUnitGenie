package org.apache.commons.compress.archivers.zip;
import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Date;
import static org.junit.Assert.assertNull;

public class archivers_zip_X000A_NTFS_dateToZip_Date_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testDateToZipWithNullDate() {
        try {
            Method method = X000A_NTFS.class.getDeclaredMethod("dateToZip", Date.class);
            method.setAccessible(true);
            ZipEightByteInteger result = (ZipEightByteInteger) method.invoke(null, (Date) null);
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}