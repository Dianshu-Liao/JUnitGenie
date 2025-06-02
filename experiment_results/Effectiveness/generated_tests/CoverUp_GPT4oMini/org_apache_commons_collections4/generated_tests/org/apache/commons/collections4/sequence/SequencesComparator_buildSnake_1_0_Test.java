package org.apache.commons.collections4.sequence;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.collections4.Equator;
import org.apache.commons.collections4.functors.DefaultEquator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class SequencesComparator_buildSnake_1_0_Test {

    private SequencesComparator<String> sequencesComparator;

    private List<String> sequence1;

    private List<String> sequence2;

    private Equator<String> equator;

    @BeforeEach
    void setUp() {
        sequence1 = Arrays.asList("A", "B", "C", "D", "E");
        sequence2 = Arrays.asList("A", "X", "C", "Y", "E");
        equator = DefaultEquator.defaultEquator();
        sequencesComparator = new SequencesComparator<>(sequence1, sequence2, equator);
    }

    @Test
    void testBuildSnakeWithMatchingElements() throws Exception {
        Method buildSnakeMethod = SequencesComparator.class.getDeclaredMethod("buildSnake", int.class, int.class, int.class, int.class);
        buildSnakeMethod.setAccessible(true);
        Snake snake = (Snake) buildSnakeMethod.invoke(sequencesComparator, 0, 0, 5, 5);
        assertNotNull(snake);
        assertEquals(0, snake.getStart());
        assertEquals(1, snake.getEnd());
        assertEquals(0, snake.getDiag());
    }

    @Test
    void testBuildSnakeWithPartialMatch() throws Exception {
        Method buildSnakeMethod = SequencesComparator.class.getDeclaredMethod("buildSnake", int.class, int.class, int.class, int.class);
        buildSnakeMethod.setAccessible(true);
        Snake snake = (Snake) buildSnakeMethod.invoke(sequencesComparator, 0, 1, 5, 5);
        assertNotNull(snake);
        assertEquals(0, snake.getStart());
        assertEquals(1, snake.getEnd());
        assertEquals(1, snake.getDiag());
    }

    @Test
    void testBuildSnakeWithNoMatch() throws Exception {
        Method buildSnakeMethod = SequencesComparator.class.getDeclaredMethod("buildSnake", int.class, int.class, int.class, int.class);
        buildSnakeMethod.setAccessible(true);
        Snake snake = (Snake) buildSnakeMethod.invoke(sequencesComparator, 1, 1, 5, 5);
        assertNotNull(snake);
        assertEquals(1, snake.getStart());
        assertEquals(1, snake.getEnd());
        assertEquals(1, snake.getDiag());
    }

    // Define the Snake class here for the tests to compile
    private static class Snake {

        private final int start;

        private final int end;

        private final int diag;

        public Snake(int start, int end, int diag) {
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
}
