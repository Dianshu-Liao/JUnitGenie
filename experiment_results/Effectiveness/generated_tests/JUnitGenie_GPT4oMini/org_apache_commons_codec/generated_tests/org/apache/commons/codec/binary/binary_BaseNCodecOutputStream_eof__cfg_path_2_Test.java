package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.BaseNCodec;
import org.apache.commons.codec.binary.BaseNCodecOutputStream;
import org.junit.Test;
import java.io.OutputStream;
import static org.mockito.Mockito.*;

public class binary_BaseNCodecOutputStream_eof__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEofWhenDoEncodeIsTrue() {
        // Arrange
        BaseNCodec mockBaseNCodec = mock(BaseNCodec.class);
        OutputStream mockOutputStream = mock(OutputStream.class);
        BaseNCodecOutputStream baseNCodecOutputStream = new BaseNCodecOutputStream(mockOutputStream, mockBaseNCodec, true);
        
        // Act
        try {
            baseNCodecOutputStream.eof();
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        verify(mockBaseNCodec).encode(new byte[]{0}, 0, -1, null);
    }

    @Test(timeout = 4000)
    public void testEofWhenDoEncodeIsFalse() {
        // Arrange
        BaseNCodec mockBaseNCodec = mock(BaseNCodec.class);
        OutputStream mockOutputStream = mock(OutputStream.class);
        BaseNCodecOutputStream baseNCodecOutputStream = new BaseNCodecOutputStream(mockOutputStream, mockBaseNCodec, false);
        
        // Act
        try {
            baseNCodecOutputStream.eof();
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        verify(mockBaseNCodec).decode(new byte[]{0}, 0, -1, null);
    }

}