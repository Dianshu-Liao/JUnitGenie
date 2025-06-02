package org.apache.commons.collections4.bloomfilter;
import org.apache.commons.collections4.bloomfilter.ArrayCountingBloomFilter;
import org.apache.commons.collections4.bloomfilter.Shape;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class bloomfilter_ArrayCountingBloomFilter_subtract_int_int_cfg_path_5_Test {


    private boolean invokeSubtract(ArrayCountingBloomFilter bloomFilter, int idx, int subtrahend) throws Exception {
        Method subtractMethod = ArrayCountingBloomFilter.class.getDeclaredMethod("subtract", int.class, int.class);
        subtractMethod.setAccessible(true);
        return (boolean) subtractMethod.invoke(bloomFilter, idx, subtrahend);
    }


}
