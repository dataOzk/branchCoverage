import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class TestCompute {

    // Compute.java ilk if statementı, quenun boş olduğu durumu test ediyor.  
    @Test
    public void testCountNumberOfOccurrences_EmptyQueue() {
        MessageQueue mq = mock(MessageQueue.class);
        when(mq.size()).thenReturn(0);

        Compute c = new Compute(mq);
        int occurrences = c.countNumberOfOccurrences("test");

        assertEquals(-1, occurrences);
    }

    // Compute.java ikinci if statementı, eleman quenun içinde olmadığı durum.
    @Test
    public void testCountNumberOfOccurrences_ElementNotInQueue() {
        MessageQueue mq = mock(MessageQueue.class);
        when(mq.size()).thenReturn(3);
        when(mq.contains("test")).thenReturn(false);
        when(mq.getAt(0)).thenReturn("element1");
        when(mq.getAt(1)).thenReturn("element2");
        when(mq.getAt(2)).thenReturn("element3");

        Compute c = new Compute(mq);
        int occurrences = c.countNumberOfOccurrences("test");

        assertEquals(0, occurrences);
    }

    // Son if statementı, normal çalışıyor mu görmek için.
    @Test
    public void testCountNumberOfOccurrences_ElementInQueue() {
        MessageQueue mq = mock(MessageQueue.class);
        when(mq.size()).thenReturn(3);
        when(mq.contains("test")).thenReturn(true);
        when(mq.getAt(0)).thenReturn("test");
        when(mq.getAt(1)).thenReturn("test");
        when(mq.getAt(2)).thenReturn("test");

        Compute c = new Compute(mq);
        int occurrences = c.countNumberOfOccurrences("test");

        assertEquals(3, occurrences);
    }



    @Test
    public void testCountNumberOfOccurrences_ElementInQueueButNotFound() {
        // Create a mock MessageQueue
        MessageQueue mq = mock(MessageQueue.class);
        // Set up the mock behavior
        when(mq.size()).thenReturn(3);
        when(mq.contains("test")).thenReturn(true);
        // Return different values for the elements in the queue to ensure none of them match "test"
        when(mq.getAt(0)).thenReturn("element1");
        when(mq.getAt(1)).thenReturn("element2");
        when(mq.getAt(2)).thenReturn("element3");

        // Create an instance of Compute with the mock MessageQueue
        Compute c = new Compute(mq);
        // Call the method being tested
        int occurrences = c.countNumberOfOccurrences("test");

        // Assert that the result is as expected (0 occurrences)
        assertEquals(0, occurrences);
    }



}
