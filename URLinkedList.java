import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class URLinkedList<E> implements URList<E> {
    
    private URNode<E> first; 
    private URNode<E> last;
    private int n;

	public URLinkedList() {
		first = null;
		last = null;
		n = 0;
	}

	public URLinkedList(Collection<? extends E> c) {
		for (E it : c) add(it);
	}

    // Appends the specified element to the end of this list 
	public boolean add(E e) {
        URNode<E> newNode = new URNode<E>(e, last, null);
        
		if (first == null) {
            first = newNode;
			last = newNode;
        } 

		else {
            last.setNext(newNode);
			last = newNode;
        }
        n++;
        return true;

    }

	// Inserts the specified element at the specified position in this list 
	public void add(int index, E element) {
		if (index > n || index < 0) throw new IndexOutOfBoundsException(index);

		URNode<E> newNode = new URNode<E>(element, null, null);
		if (n == 0) {
			first = newNode;
			last = newNode;
		}
		else {
			if (index == 0) {
				newNode.setNext(first);
				first.setPrev(newNode);
				first = newNode;
			}
			else if	(index == n) {
				newNode.setPrev(last);
				last.setNext(newNode);
				last = newNode;
			}	
			else {
				URNode<E> temp = first;
				for (int i = 0; i < index; i++) temp = temp.next();

				newNode.setNext(temp);
				newNode.setPrev(temp);
				temp.prev().setNext(newNode);
				temp.setPrev(newNode);
			}
		}
		n++;
	}

	// Appends all of the elements in the specified collection to the end of this list,
	// in the order that they are returned by the specified collection's iterator 
	public boolean addAll(Collection<? extends E> c) {		
		for (E it : c) {
       		add(it);
		}
		return true;
    }

	// Inserts all of the elements in the specified collection into this list 
	// at the specified position
	public boolean addAll(int index, Collection<? extends E> c) {
		for (E it : c) {
			add(index, it);
			index++;
		}
		return true;
    }

	// Removes all of the elements from this list 
	public void clear() {
		first = null;
		last = null;
		n = 0;
    }

	// Returns true if this list contains the specified element.
	public boolean contains(Object o) {
		URNode<E> temp = first;
		while (temp != null) {
			if (temp.element().equals(o)) return true;
			temp = temp.next();
		} 
		return false;
    }

	// Returns true if this list contains all of the elements of the specified collection
	public boolean containsAll(Collection<?> c) {
		for (Object e : c)
        	if (!contains(e))
            return false;
    	return true;
    }

	// Compares the specified object with this list for equality. 
	// Returns true if both contain the same elements. Ignore capacity
	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o instanceof URLinkedList) { 
			URLinkedList<E> other = (URLinkedList<E>)o;
			URNode<E> temp = first;
			URNode<E> temp2 = other.first;

			while (temp != null) {
				if (temp.element() != temp2.element()) {
					return false;
				}
				temp = temp.next();
				temp2 = temp2.next();
			}
			return true;
		}
		return false;
    }

	// Returns the element at the specified position in this list.
	public E get(int index) {
		if (index >= n || index < 0) throw new IndexOutOfBoundsException(index);

		URNode<E> temp = first;
		
		for (int i = 0; i < index; i++) temp = temp.next();

		return temp.element();
    }

	// Returns the index of the first occurrence of the specified element in this list, 
	// or -1 if this list does not contain the element.
	public int indexOf(Object o) {
		URNode<E> temp = first; 
		int current = 0; 
		
		while (temp != null) {
			if (temp.element().equals(o)) return current;
			temp = temp.next();
			current++;
		}

		return -1;
    }

	// Returns true if this list contains no elements.
	public boolean isEmpty() {
		return (first == null && last == null && n == 0);
    }

	// Returns an iterator over the elements in this list in proper sequence.
	public Iterator<E> iterator(){
		return new Iterator<E>() {
		
			URNode<E> temp = first;

			@Override
			public boolean hasNext() {
				return (temp.next() != null);
			}

			@Override
			public E next() {
				if (hasNext()) {
					E element = temp.element();
                	temp = temp.next();
                	return element;
				}
				return null;
			}

			public void remove() {
				if (hasNext()) temp.next().setPrev(temp.prev());
				else {
					last = temp.prev();
					temp.prev().setNext(null);
				}
				if (temp.prev() != null) temp.prev().setNext(temp.next());
				else {
					first = temp.next();
					temp.next().setPrev(null);
				}
				n--;
			}
		};
	}

	// Removes the element at the specified position in this list 
	public E remove(int index) {
		if (index >= n || index < 0) throw new IndexOutOfBoundsException(index);

		URNode<E> temp = first;
		
		for (int i = 0; i < index; i++) temp = temp.next();

		if (temp != last) temp.next().setPrev(temp.prev());
		else {
			last = temp.prev();
			temp.prev().setNext(null);
		}
		if (temp != first) temp.prev().setNext(temp.next());
		else {
			first = temp.next();
			temp.next().setPrev(null);
		};

		n--;

		return temp.element();
    }

	// Removes the first occurrence of the specified element from this list,
	// if it is present 
	public boolean remove(Object o) {
		URNode<E> temp = first;
		while (temp != null) {
			if (temp.element().equals(o)) {
				if (temp != last) temp.next().setPrev(temp.prev());
				else {
					last = temp.prev();
					temp.prev().setNext(null);
				}
				if (temp != first) temp.prev().setNext(temp.next());
				else {
					first = temp.next();
					temp.next().setPrev(null);
				}
				n--;
				return true;
			}
			temp = temp.next();
		} 
		
		return false;
    }

	// Removes from this list all of its elements that are contained
	//  in the specified collection
	public boolean removeAll(Collection<?> c) {
		for (Object e : c)
        	if (contains(e))
			remove(e);
    	return true;
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
	public URList<E> subList(int fromIndex, int toIndex){
		if(fromIndex < 0 || fromIndex > this.size()-1 || toIndex < 0 || toIndex > this.size()-1){
			throw new IndexOutOfBoundsException("Index out of bounds on call to subList with fromIndex of" + fromIndex + " and toIndex of" + toIndex);
		}

		URLinkedList<E> subList = new URLinkedList<E>();

		int subListN = toIndex - fromIndex;

		URNode<E> temp = first;
		for (int i = 0; i < fromIndex; i++) temp = temp.next();

		while (subList.n < subListN) {
			if (subList.first == null) {
           		subList.first = temp;
				subList.last = temp;
        	}	 
			else {
            	subList.last.setNext(temp);
				subList.last = temp;
        	}
        	subList.n++;
			temp = temp.next();
		}

		return subList;
    }

	// Returns an array containing all of the elements in this list
	//  in proper sequence (from first to the last element).
	public Object[] toArray() {
        // Object[] array = new Object[n];
        ArrayList<Object> arr = new ArrayList<>();
        URNode<E> temp = first;
        
        while (temp != null) {
            arr.add(temp.element());
            if (temp == last) break;
            temp = temp.next();
        }

        int i = 0;
        Object[] array = new Object[arr.size()];
        for (Object obj : arr) {
            array[i] = arr.get(i);
            i++;
        }
        return array;
    }

}