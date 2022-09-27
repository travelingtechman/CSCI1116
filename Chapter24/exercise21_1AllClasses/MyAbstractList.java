package exercise21_1AllClasses;
public abstract class MyAbstractList<E> implements MyList<E> {
	protected int size = 0; // The size of the last

	/** Create a default list */
	protected MyAbstractList() {
	}

	/** Create a list from an array of objects */
	protected MyAbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	@Override /** Add a new element at the end of this list */
	public void add(E e) {
		add(size, e);
	}

	@Override /** Return true if this list doesn't contain any elements */
	public boolean isEmpty() {
		return size == 0;
	}

	@Override /** Return the number of elements in this list */
	public int size() {
		return size;
	}

	@Override 
	public boolean remove(E e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		}
		else
			return false;
	}

	@Override 
	public boolean addAll(MyList<E> otherList) {
		boolean changed = false;
		for (int i = 0; i < otherList.size(); i++) {
			E e = otherList.get(i);
			if (!contains(e)){
				add(e);
				changed = true;
			}
		}
		return changed;
	}

	@Override
	public boolean removeAll(MyList<E> otherList) {
		boolean changed = false;
		for (int i = 0; i < otherList.size(); i++) {
			E e = otherList.get(i); 
			if (contains(e)) {
				remove(e);
				changed = true;
			}
		}
		return changed;
	}

	@Override
	public boolean retainAll(MyList<E> otherList) {
		boolean changed = false;
		for (int i = size - 1; i >= 0; i--) {
			E e = get(i);
			if (!otherList.contains(e)) {
				remove(i);
				changed = true;
			}
		}
		return changed;
	}
}