package org.apache.commons.collections4.sequence;

import org.apache.commons.collections4.sequence.SequencesComparator;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.Equator;
import org.apache.commons.collections4.functors.DefaultEquator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class SequencesComparator_buildSnake_1_2_Test {

    private SequencesComparator<String> sequencesComparator;

    private List<String> sequence1;

    private List<String> sequence2;

    private Equator<String> equator;

    @BeforeEach
    void setUp() {
        sequence1 = new ArrayList<>();
        sequence2 = new ArrayList<>();
        equator = mock(Equator.class);
        sequencesComparator = new SequencesComparator<>(sequence1, sequence2, equator);
    }

    @Test
    void testBuildSnake() throws Exception {
        // Setup for the test
        sequence1.add("A");
        sequence1.add("B");
        sequence1.add("C");
        sequence2.add("X");
        sequence2.add("B");
        sequence2.add("Y");
        when(equator.equate("B", "B")).thenReturn(true);
        when(equator.equate("C", "Y")).thenReturn(false);
        // Fixed Buggy Line
        java.lang.reflect.Method method = SequencesComparator.class.getDeclaredMethod("buildSnake", int.class, int.class, int.class, int.class);
        method.setAccessible(true);
        // Create an inner class to represent Snake
        class Snake {

            private final int start;

            private final int end;

            private final int diag;

            Snake(int start, int end, int diag) {
                this.start = start;
                this.end = end;
                this.diag = diag;
            }

            public int getStart() {
                return start;
            }

            public int getEnd() {
                return end;
            }

            public int getDiag() {
                return diag;
            }
        }
        Snake snake = (Snake) method.invoke(sequencesComparator, 1, 1, 3, 3);
        assertEquals(1, snake.getStart());
        assertEquals(2, snake.getEnd());
        assertEquals(1, snake.getDiag());
        Snake snake2 = (Snake) method.invoke(sequencesComparator, 2, 1, 3, 3);
        assertEquals(2, snake2.getStart());
        assertEquals(2, snake2.getEnd());
        assertEquals(1, snake2.getDiag());
        // Test case for empty sequences
        sequence1.clear();
        sequence2.clear();
        Snake snake3 = (Snake) method.invoke(sequencesComparator, 0, 0, 0, 0);
        assertEquals(0, snake3.getStart());
        assertEquals(0, snake3.getEnd());
        assertEquals(0, snake3.getDiag());
    }
}
