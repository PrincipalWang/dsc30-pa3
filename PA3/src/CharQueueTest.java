import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CharQueueTest {
    @org.junit.jupiter.api.Test
    public void totalTest() {
        CharQueue test1 = new CharQueue(1);
        assertThrows(IllegalArgumentException.class, () -> {
            CharQueue test2 = new CharQueue(0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            CharQueue test3 = new CharQueue(-1);
        });
        CharQueue test4 = new CharQueue();
        CharQueue test5 = new CharQueue();
        CharQueue test6 = new CharQueue();
        assertTrue(test1.isEmpty());
        test1.enqueue('1');
        assertFalse(test1.isEmpty());
        assertEquals('1',test1.peek());
        assertEquals(1,test1.size());
        assertEquals('1',test1.dequeue());
        assertEquals(0,test1.size());
        assertTrue(test1.isEmpty());
        test1.clear();
        test1 = new CharQueue(1);
        test1.enqueue('1');
        assertEquals('1',test1.peek());
        test1.enqueue('2');
        assertEquals('1',test1.peek());
        assertEquals('1',test1.dequeue());
        assertEquals('2',test1.peek());
        test1.enqueue('1');
        assertEquals('2',test1.peek());
        test1.enqueue('3');
        assertEquals('2',test1.peek());
        assertEquals(3,test1.size());
        assertEquals('2',test1.dequeue());
        assertEquals('1',test1.peek());
        assertEquals('1',test1.dequeue());
        assertEquals('3',test1.peek());
        test1.clear();
        CharQueue finalTest = test1;
        assertThrows(NoSuchElementException.class, () -> {
            finalTest.peek();
        });
        assertThrows(NoSuchElementException.class, () -> {
            finalTest.dequeue();
        });
        test1.clear();
        assertTrue(test1.isEmpty());
    }
}