public class insertRemoveSearch {

  public void insert(int item, int index){
    /**
     * Implement the insert function, which inserts the given item at the given position.
     * If the underlying array is full, it shall resize the array appropriately, by doubling its capacity.
     */

    // TODO: Implement

    throw new RuntimeException("Not implemented yet");
  }


  public void remove(int index){
    /**
     * Implement the remove function, which delete the item stored at the given index.
     * If the underlying array gets empty, it shall resize the array appropriately.
     * It should halve the capacity as soon as the load is less or equal than 25 %.
     */
    // TODO: Implement
    throw new RuntimeException("Not implemented yet");
  }

  /**
   *Implement the search function, which returns an index where the given item can be found,
   * or 0 if the sequence does not include that item.
   */
  public int search(int item){
    int indexcounter = 0;
    for(int i = 0; i < items.length; i++){
      if(items[i] == item){
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
    int i = 2;
    int minimum = items[1];
    int maximum = items [1];
    while (i <= this.length) {
      if (items[i] > maximum) {
        maximum = items [i];
      }
      if (items[i] < minimum){
        minimum = items[i];
      }
      i++;
    }
    return new int[] {minimum, maximum};
  }


  /**
   * Finding duplicates
   */

  public boolean hasDuplicate() {
    int i = 1;
    int countCounter = 0;
    while (countCounter < 2 && i <= this.length) {
      countCounter = 0;
      for (int j = 1; j <= this.length && countCounter < 2; j++) {
        if (items[j] == items[i]){
          countCounter = countCounter +1;
        }
      }
      i = i +1;
    }
    if (countCounter > 1) {
      return true;
    }
    else {
      return false;
    }
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