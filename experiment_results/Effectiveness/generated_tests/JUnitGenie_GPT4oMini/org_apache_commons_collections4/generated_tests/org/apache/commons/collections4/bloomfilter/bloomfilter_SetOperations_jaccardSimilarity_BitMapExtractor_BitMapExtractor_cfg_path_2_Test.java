package org.apache.commons.collections4.bloomfilter;
import org.apache.commons.collections4.bloomfilter.SetOperations;
import org.apache.commons.collections4.bloomfilter.BitMapExtractor;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class bloomfilter_SetOperations_jaccardSimilarity_BitMapExtractor_BitMapExtractor_cfg_path_2_Test {

    private static class TestBitMapExtractor implements BitMapExtractor {
        private final long[] bitMap;

        public TestBitMapExtractor(long[] bitMap) {
            this.bitMap = bitMap;
        }

        @Override
        public boolean processBitMaps(java.util.function.LongPredicate predicate) {
            for (long value : bitMap) {
                if (!predicate.test(value)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public long[] asBitMapArray() {
            return bitMap;
        }

        @Override
        public boolean processBitMapPairs(BitMapExtractor second, org.apache.commons.collections4.bloomfilter.LongBiPredicate predicate) {
            long[] secondBitMap = second.asBitMapArray();
            for (int i = 0; i < Math.min(bitMap.length, secondBitMap.length); i++) {
                if (!predicate.test(bitMap[i], secondBitMap[i])) {
                    return false;
                }
            }
            return true;
        }
    }

    @Test(timeout = 4000)
    public void testJaccardSimilarity() {
        long[] firstBitMap = {1L, 2L, 3L};
        long[] secondBitMap = {2L, 3L, 4L};

        BitMapExtractor first = new TestBitMapExtractor(firstBitMap);
        BitMapExtractor second = new TestBitMapExtractor(secondBitMap);

        try {
            double result = SetOperations.jaccardSimilarity(first, second);
            assertEquals(0.5, result, 0.01);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}