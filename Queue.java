//  Michael Manzanares
//  masc0363

package data_structures;
import java.util.Iterator;

public class Queue<E> implements Iterable {
    LinearListADT<E> QueueList;
    
    public Queue() {
        QueueList = new LinearList<E>();
       }
    //  Inserts obj into the queue.
    public void enqueue(E obj) {
        QueueList.addLast(obj);
       }
    //  Removes and returns the object at the front of the queue.
    public E dequeue() {
        return QueueList.removeFirst();
       }
    //  Returns the number of objects currently in the queue.    
    public int size() {
        return QueueList.size();
       }
    //  Returns true if the queue is empty, otherwise false.
    public boolean isEmpty() {
        return QueueList.isEmpty();
       }
    //  Returns but does not remove the object at the front of the queue.
    public E peek() {
        return QueueList.peekFirst();
       } 
    //  Returns true if the Object is in the queue.
    public boolean contains(E obj) {
        return QueueList.contains(obj);
       }
    //  Returns the queue to an empty state.
    public void makeEmpty() {
        QueueList.clear();
       }
    //  Removes the Object and returns true, otherwise, returns false.
    public E remove(E obj) {    //  Changed from boolean to E.
        return QueueList.remove(obj);
       }
    //  Returns an iterator of the elements in the queue.  
    //  The elements must be in the same sequence as dequeue would return them. 
    public Iterator<E> iterator() {
        return QueueList.iterator();
       }
   }