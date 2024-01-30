/*
    Name: Chen Wang
    PID:  A17090044
 */

import java.util.NoSuchElementException;

/**
 *CharQueue Implementation
 *
 * @author Chen Wang
 * @since 1/30/2023
 */

public class CharQueue {
    /* instance variables, feel free to add more if you need */
    private char[] circularArray;
    private int size;
    private int front;
    private int rear;
    private static final int FIVE = 5;

    /**
     * empty constructor of CharQueue
     * */
    public CharQueue() {
        circularArray = new char[FIVE];
    }

    /**
     * constructor of CharQueue
     *
     * @param capacity capacity of CharQueue
     * @throws IllegalArgumentException if capacity is out of valid range
     * */
    public CharQueue(int capacity) throws IllegalArgumentException {
        if(capacity<1){
            throw new IllegalArgumentException();
        }
        circularArray = new char[capacity];
    }

    /**
     * check if CharQueue is empty
     *
     * @return if CharQueue is empty
     * */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements currently stored in the queue.
     *
     * @return the number of elements currently stored in the queue
     * */
    public int size() {
        return size;
    }

    /**
     * Clears all elements in the queue.
     */
    public void clear() {
        circularArray = new char[circularArray.length];
        size = 0;
        front = rear;
    }

    /**
     * Adds a new elem to the back of the queue.
     *
     * @param elem element to be added
     */
    public void enqueue(char elem) {
        if(size == circularArray.length){
            char[] ori = circularArray;
            circularArray = new char[circularArray.length*2];
            for(int i = front; i<ori.length; i++){
                circularArray[i] = ori[i];
            }
            if(rear<=front){
                for(int i = 0; i<rear; i++){
                    circularArray[ori.length+i] = ori[i];
                }
            }
            rear = front + size;
        }
        if(rear == circularArray.length-1){
            circularArray[rear] = elem;
            rear = 0;
            size++;
        }
        else{
            circularArray[rear] = elem;
            rear++;
            size++;
        }
    }

    /**
     * Returns the element at the front of the queue.
     *
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public char peek() throws NoSuchElementException{
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        return circularArray[front];
    }

    /**
     * Returns and removes the element at the front of the queue.
     *
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public char dequeue() throws NoSuchElementException{
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        char res = circularArray[front];
        circularArray[front] = '\0';
        front++;
        if(front == circularArray.length){
            front = 0;
        }
        size--;
        return res;
    }
}
