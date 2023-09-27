import java.util.Collection;
import java.util.Iterator;

public class URLinkedList<E> extends URNode<E> implements URList<E>{
    
    private URNode<E> first; 
    private URNode<E> last;
    private int n;

    // Appends the specified element to the end of this list 
	public boolean add(E e) {
        URNode<E> newNode = new URNode<E>(e, last, null);
        last = newNode;
		if (first == null) {
            first = newNode;
        } else {
            URNode<E> temp = first;
            while (temp.next()!= null) {
                temp = temp.next();
            }
            temp.setNext(newNode);
        }
        n++;
        return true;

    }

	// Inserts the specified element at the specified position in this list 
	public void add(int index, E element) {
		URNode<E> newNode = new URNode<E>(element, null, null);
        if (index == 0) {
            newNode.setNext(first);
            first = newNode;
        } else {
            URNode<E> temp = first;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next();
            }
            newNode.setNext(temp.next());
            temp.setNext(newNode);
        }
        n++;
    }

	// Appends all of the elements in the specified collection to the end of this list,
	// in the order that they are returned by the specified collection's iterator 
	public boolean addAll(Collection<? extends E> c) {		
		URNode<E> newNode = new URNode(null, null, null);
		for (E it : c) {
       		add(it);
		}
    }


	// Inserts all of the elements in the specified collection into this list 
	// at the specified position
	public boolean addAll(int index, Collection<? extends E> c) {
		
    }

	// Removes all of the elements from this list 
	public void clear() {
		first = null;
    }

	// Returns true if this list contains the specified element.
	public boolean contains(Object o) {
		URNode<E> temp = first;
		while (temp.next() != null) {
			if (temp.element().equals(o)) return true;
			temp = temp.next();
		} 
		return false;
    }

	// Returns true if this list contains all of the elements of the specified collection
	public boolean containsAll(Collection<?> c) {
	
    }

	// Compares the specified object with this list for equality. 
	// Returns true if both contain the same elements. Ignore capacity
	public boolean equals(Object o) {

    }

	// Returns the element at the specified position in this list.
	public E get(int index) {
		if (index >= n || index < 0) throw new IndexOutOfBoundsException(index);

		URNode<E> temp = first;
		int current = 0; 
		
		while (current != index) {
			temp = temp.next();
			current++;
		}

		return temp.element();
    }

	// Returns the index of the first occurrence of the specified element in this list, 
	// or -1 if this list does not contain the element.
	public int indexOf(Object o) {
		URNode<E> temp = first; 
		int current = 0; 
		
		while (temp.next() != null) {
			if (temp.element().equals(o)) return current;
			temp = temp.next();
			current++;
		}

		return -1;
    }

	// Returns true if this list contains no elements.
	public boolean isEmpty() {
		if (first == null) return true;
		return false;
    }

	// Returns an iterator over the elements in this list in proper sequence.
	public Iterator<E> iterator() {

    }

	// Removes the element at the specified position in this list 
	public E remove(int index) {
		if (index >= n || index < 0) throw new IndexOutOfBoundsException(index);

		URNode<E> temp = first;
		int current = 0; 
		
		while (current != index) {
			temp = temp.next();
			current++;
		}

		temp.prev().setNext(temp.next());
		return temp.element();
    }

	// Removes the first occurrence of the specified element from this list,
	// if it is present 
	public boolean remove(Object o) {
		URNode<E> temp = first;
		while (temp.next() != null) {
			if (temp.element().equals(o)) {
				temp.prev().setNext(temp.next());
				return true;
			}
			temp = temp.next();
		} 
		return false;
    }

	// Removes from this list all of its elements that are contained
	//  in the specified collection
	public boolean removeAll(Collection<?> c) {

    }

	// Replaces the element at the specified position in this list
	// with the specified element 
	public E set(int index, E element) {
		if (index >= n || index < 0) throw new IndexOutOfBoundsException(index);

		URNode<E> temp = first;
		int current = 0; 
		
		while (current != index) {
			temp = temp.next();
			current++;
		}

		temp.setElement(element);
		return temp.element();
    }

	// Returns the number of elements in this list.
	public int size() {
		return n;
    }

	// Returns a view of the portion of this list 
	// between the specified fromIndex, inclusive, and toIndex, exclusive.
	public URList<E> subList(int fromIndex, int toIndex) {

    }


	// Returns an array containing all of the elements in this list
	//  in proper sequence (from first to the last element).
	public Object[] toArray() {
		Object[] array = new Object[n];
		URNode<E> temp = first;
		
		int i = 0;
		while (temp.next() != null) {
			array[i] = temp.element();
			temp = temp.next();
		}
		return array;
    }

}