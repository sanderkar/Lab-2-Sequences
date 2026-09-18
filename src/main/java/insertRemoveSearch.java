public class insertRemoveSearch {

  private int[] items;
  private int length;

  public insertRemoveSearch() {
    this.items = new int[4];
    this.length = 0;
  }

  private void resize(int newCapacity) {
    int[] resized = new int[newCapacity];
    for (int i = 0; i < length; i++) {
      resized[i] = items[i];
    }
    items = resized;
  }

  public void insert(int item, int index) {
    /**
     * Implement the insert function, which inserts the given item at the given position.
     * If the underlying array is full, it shall resize the array appropriately, by doubling its capacity.
     */
    if (index < 0 || index > length) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }

    if (length >= items.length) {
      int newCapacity = (items.length == 0) ? 1 : items.length * 2;
      resize(newCapacity);
    }

    for (int i = length; i > index; i--) {
      items[i] = items[i - 1];
    }
    items[index] = item;
    length++;
  }

  public void remove(int index) {
    /**
     * Implement the remove function, which delete the item stored at the given index.
     * If the underlying array gets empty, it shall resize the array appropriately.
     * It should halve the capacity as soon as the load is less or equal than 25 %.
     */
    if (index < 0 || index >= length) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }

    for (int i = index; i < length - 1; i++) {
      items[i] = items[i + 1];
    }
    items[length - 1] = 0;
    length--;

    if (length <= items.length * 0.25 && items.length > 1) {
      int newCapacity = Math.max(1, items.length / 2);
      resize(newCapacity);
    }
  }

  /**
   *Implement the search function, which returns an index where the given item can be found,
   * or 0 if the sequence does not include that item.
   */
  public int search(int item) {
    for (int i = 0; i < length; i++) {
      if (items[i] == item) {
        return i;
      }
    }
    return 0;
  }

  // Extrema

  /**
   * Propose an algorithm the finds both the minimum and the maximum of the sequence.
   */
  public int[] extrema() {
    if (length == 0) {
      throw new IllegalStateException("Sequence is empty");
    }

    int minimum = items[0];
    int maximum = items[0];
    for (int i = 1; i < length; i++) {
      if (items[i] > maximum) {
        maximum = items[i];
      }
      if (items[i] < minimum) {
        minimum = items[i];
      }
    }
    return new int[] {minimum, maximum};
  }

  /**
   * Finding duplicates
   */
  public boolean hasDuplicate() {
    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
        if (items[i] == items[j]) {
          return true;
        }
      }
    }
    return false;
  }
}

/**
 * What is the worst-case scenario for your algorithm?
 * Give an sample sequence that triggers that worst case.
 */

/**
 * Given a sequence of length
 * ℓ
 * , how many comparisons are needed in the worst case. Express it as a function of
 * ℓ
 * .
 */