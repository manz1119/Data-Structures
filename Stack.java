//  Michael Manzanares
//  masc0363

package data_structures;
import java.util.Iterator;

public class Stack<E> implements Iterable {
    LinearListADT<E> StackList;
    
    public Stack() {
        StackList = new LinearList<E>();
       }
    //  Inserts the object into the stack.
    public void push(E obj) {
        StackList.addFirst(obj);
       }    
    //  Pops and returns the element on the top of the stack.
    public E pop() {
        return StackList.removeFirst();
       }
    //  Returns the number of elements currently in the stack.
    public int size() {
        return StackList.size();
       } 
    //  Return true if the stack is empty, otherwise false.
    public boolean isEmpty() {
        return StackList.isEmpty();
       }
    //  Returns but does not remove the element on the top of the stack.   
    public E peek() {
        return StackList.peekFirst();
       }
    //  Returns true if the object is in the stack, otherwise false.
    public boolean contains(E obj) {
        return StackList.contains(obj);
       }
    //  Returns the stack to an empty state.
    public void makeEmpty() {
        StackList.clear();
       }
    //  Removes obj and returns true, otherwise returns false.
    public E remove(E obj) {    //  Changed from boolean to E.
        return StackList.remove(obj);
       }
    //  Returns an iterator of the elements in the stack.  
    //  The elements are in the same sequence as pop() would return them.    
    public Iterator<E> iterator() {
        return StackList.iterator();
       }
   }