import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    static Stream<Object[]> arrayStream(){
        return Stream.of(
                new Object[]{ new Integer[][] {{9, 4, 5, 3}, {3, 4, 5, 9}} },
                new Object[]{ new Integer[][] {{6, 8, 9, 2}, {2, 6, 8, 9}} },
                new Object[]{ new Integer[][] {{0, 8, 1, 5}, {0, 1, 5, 8}} },
                new Object[]{ new Integer[][] {{6, 7, 5, 7}, {5, 6, 7, 7}} },
                new Object[]{ new Integer[][] {{8, 9, 6, 4}, {4, 6, 8, 9}} }
        );
    }

    @ParameterizedTest
    @MethodSource("arrayStream")
    void PQIntegerTest(Integer[][] testCase){
        PriorityQueue<Integer> pq = new PriorityQueue();
        List<Integer> listInput = Arrays.asList(testCase[0]);
        pq.addAll(listInput);
        List<Integer> listEx = Arrays.asList(testCase[1]);
        List<Integer> listOutput = new ArrayList<>();
        Integer item;
        while( (item = pq.poll()) != null ){
            listOutput.add(item);
        }
        System.out.println(listInput);
        System.out.println(listEx);
        System.out.println(listOutput);
        assertEquals(listOutput, listEx);
    }

    @Test
    public void whenExceptionThrown_thenAssSucceeds(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            PriorityQueue<Integer> pq = new PriorityQueue(-1);
        });
        Exception exception2 = assertThrows(NullPointerException.class, ()->{
            PriorityQueue<Integer> pq = new PriorityQueue();
            pq.offer(null);
        });
        Exception exception3 = assertThrows(ClassCastException.class, ()->{
            PriorityQueue pq = new PriorityQueue();
            pq.offer(92);
            pq.offer("consensus");
        });
    }
}