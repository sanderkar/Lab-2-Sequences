/*
 * This file is part of NTNU's IDATA2302 Lab02.
 *
 * Copyright (C) NTNU 2022
 * All rights reserved.
 *
 */
package no.ntnu.idata2302.lab02;

/**
 * Implement the Sequence ADT from Lecture 2.2
 *
 * The items in the sequence are indexed from 1 (as opposed to Java arrays that
 * are indexed from 0)
 */
public class Sequence {

  private static final int INITIAL_CAPACITY = 100;

  private int capacity;
  private int length;
  private int[] items;

  public Sequence() {
    this(INITIAL_CAPACITY, new int[]{});
  }

  public Sequence(int capacity, int[] items) {
    if (capacity < items.length) {
      throw new IllegalArgumentException("Capacity must be greater than item count");
    }
    this.capacity = capacity;
    this.length = items.length;
    this.items = new int[capacity];
    for (int i=0 ; i<items.length ; i++) {
      this.items[i] = items[i];
    }
  }

  /**
   * @return The number of items in the sequence
   */
  public int getLength() {
    return this.length;
  }

  /**
   * @return the number of "buckets" currently allocated
   */
  int getCapacity() {
    return this.capacity;
  }

  /**
   * Return the item stored at the given index
   *
   * @param index the index of the desired item, starting at 1
   * @return the item at the given index.
   */
  public int get(int index) {
    if (index < 1 || index > length) {
      throw new IllegalArgumentException("Invalid index!");
    }
    return this.items[index - 1];
  }

  /**
   * Append the given item at the end of the sequence
   *
   * @param item the item that must be inserted
   */
  public void insert(int item, int index) {
    int[] tempItems;
    int internalIndex = index - 1;
    if (this.capacity <= this.length) {
      this.capacity = capacity * 2;
    }
    tempItems = new int[capacity];
    int i = 0;
    while (i < internalIndex) {
      tempItems[i] = items[i];
      i++;
    }
    tempItems[i] = item;
    i++;
    this.length++;
    while (i < this.length) {
      tempItems[i] = items[i-1];
      i++;
    }
    this.items = tempItems;
  }

  /**
   * Remove the index at the given index
   *
   * @param index the index that must be removed.
   */
  public void remove(int index) {
    // TODO: Implement
    throw new RuntimeException("Not yet implemented.");
  }

  /**
   * Find a index where the given item can be found. Returns 0 if that item cannot
   * be found.
   *
   * @param item the item whose index must be found
   * @return an
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

  /**
   * Find both the smallest and the largest items in the sequence.
   *
   * @return an array of length two where the first entry is the minimum and the
   *         second the maximum
   */
  public int[] extrema() {
    if (this.length == 0) {
      throw new IllegalStateException("asd");
    }
    int i = 1;
    int minimum = items[0];
    int maximum = items [0];
    while (i < this.length) {
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
   * Check whether the given sequence contains any duplicate item
   *
   * @return true if the sequence has the the same items at multiple indices
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


  /**
   * Convert the sequence into an Java array
   */
  public int[] toArray() {
    return items;
  }

}
