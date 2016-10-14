//  Michael Manzanares
//  masc0363

package data_structures;
import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class LinearList<E> implements LinearListADT<E> {

    Node<E> header, trailer;
    int currentSize;
    long modificationCounter;
    
    public LinearList() {
        header = trailer = null;
        currentSize = 0;
        modificationCounter = 0;
       }
    public class Node<E> {
        Node<E> previous;
        E data;
        Node<E> next;
        
        public Node(E data) {
            this.data = data;
            previous = next = null;
           }
       }
    //  Adds a new element to the front of the list.
    public boolean addFirst(E data) {
        Node<E> newNode = new Node(data);
        if(isEmpty()) header = trailer = newNode;           
        else {
            newNode.next = header;
            header.previous = newNode;
            header = newNode;
           }
        currentSize++;
        modificationCounter++;
        return true;
       }
    //  Adds a new element to the end of the list.
    public boolean addLast(E data) {
        Node<E> newNode = new Node(data);
        if(isEmpty()) header = trailer = newNode;
        else {
            newNode.previous = trailer;
            trailer.next = newNode;
            trailer = newNode;
           }
        currentSize++;
        modificationCounter++;
        return true;
       }
    //  Removes and returns  the fist element of the list.
    public E removeFirst() {
        if(isEmpty()) return null;
        E temp = header.data;
        header = header.next;
        //  If you just removed the last node.
        if(header == null) trailer = null;
        
        currentSize--;
        modificationCounter++;
        return temp;
       }
    //  Removes and return the last element of the list.
    public E removeLast() {
        if(isEmpty()) return null;
        E temp = trailer.data;
        trailer = trailer.previous;
        //  If you just removed the last node.
        if(header == null) trailer = null;
        else{
            trailer.next = null;
            currentSize--;
            modificationCounter++;
           }
        return temp;
       }
    //  Removes a specific object.
    public E remove(E data) {
        Node<E> current = header, previous = null;
        while(current != null && ((Comparable<E>)data).compareTo(current.data) != 0) {
            previous = current;
            current = current.next;
           }
        if(current==null) return null;
        if(current==header) removeFirst(); 
        if(current==trailer) removeLast();
        else {
            previous.next = current.next;
            currentSize--;
            modificationCounter++;
           }    
        return trailer.data;
       }
    //  Returns the first element in the list, null if the list is empty.
    //  The list is not modified.
    public E peekFirst() {
        if(isEmpty()) return null;
        return header.data;
       }
    //  Returns the last element in the list, null if the list is empty.
    //  The list is not modified.
    public E peekLast() {
        if(isEmpty()) return null;
        return trailer.data;
       }

    public boolean contains(E data) {
        Node<E> temp = header;
        while(!isEmpty()) {
            if(temp.data != null && ((Comparable<E>) data).compareTo(temp.data) == 0) 
                return true;
            else {
                temp = temp.next;
               }
           }
        return false;
       }
    //  Returns the element matching obj if it is in the list, null otherwise.
    //  In the case of duplicates, this method returns the element closest to front.
    //  The list is not modified.
    public E find(E data) {
        if(contains(data)) 
            return data;
        return null;
       }
    //  The list is returned to an empty state.
    public void clear() {
        header = trailer = null;
        currentSize = 0;
        modificationCounter++;
       }
    //  Returns true if the list is empty, flase otherwise.
    public boolean isEmpty() {
        if(currentSize == 0) 
            return true;
        else    return false;
       }
    //  Linked list never becomes full
    public boolean isFull() {
        return false;
       }
    //  Returns the number of elements in the list
    public int size() {
        return currentSize;
       }

    public Iterator<E> iterator() {
        return new ListIteratorHelper();
       }
    
    class ListIteratorHelper implements Iterator<E> {
        Node<E> iterPtr;
        long modCounter;
        
        public ListIteratorHelper() {
            iterPtr = header;
            modCounter = modificationCounter;
           }
        public boolean hasNext() {
            if(modCounter != modificationCounter)
              throw new ConcurrentModificationException();
            return iterPtr != null;
           }
        public E next() {
            if(!hasNext())
                throw new NoSuchElementException();
            E temp = iterPtr.data;
            iterPtr = iterPtr.next;
            return temp;       
           }
        public void remove() {
            throw new UnsupportedOperationException();
           }
       }
   }