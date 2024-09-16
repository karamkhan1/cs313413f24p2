package cs271.lab.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerformance {

  private static final int[] SIZES = {10, 100, 1000, 10000};  
  private static final int REPS = 1000000;  

  private List<Integer> arrayList;
  private List<Integer> linkedList;
  private int currentSize; 

  @Before
  public void setUp() throws Exception {
    // Initialize lists for a default size
    currentSize = SIZES[0];
    arrayList = new ArrayList<>(currentSize);
    linkedList = new LinkedList<>();
    for (int i = 0; i < currentSize; i++) {
      arrayList.add(i);
      linkedList.add(i);
    }
  }

  @After
  public void tearDown() throws Exception {
    arrayList = null;
    linkedList = null;
  }

  private void initializeLists(int size) {
    currentSize = size;
    arrayList = new ArrayList<>(currentSize);
    linkedList = new LinkedList<>();
    for (int i = 0; i < currentSize; i++) {
      arrayList.add(i);
      linkedList.add(i);
    }
  }

  private void measurePerformance() {
    for (int size : SIZES) {
      System.out.println("Testing with SIZE = " + size);

      initializeLists(size);

      long startTime = System.nanoTime();
      testLinkedListAddRemove();
      long endTime = System.nanoTime();
      System.out.println("LinkedList Add/Remove: " + (endTime - startTime) / 1e6 + " ms");

      startTime = System.nanoTime();
      testArrayListAddRemove();
      endTime = System.nanoTime();
      System.out.println("ArrayList Add/Remove: " + (endTime - startTime) / 1e6 + " ms");

      startTime = System.nanoTime();
      testLinkedListAccess();
      endTime = System.nanoTime();
      System.out.println("LinkedList Access: " + (endTime - startTime) / 1e6 + " ms");

      startTime = System.nanoTime();
      testArrayListAccess();
      endTime = System.nanoTime();
      System.out.println("ArrayList Access: " + (endTime - startTime) / 1e6 + " ms");
    }
  }

  @Test
  public void testPerformance() {
    measurePerformance();
  }

  @Test
  public void testLinkedListAddRemove() {
    for (int r = 0; r < REPS; r++) {
      linkedList.add(0, 77);
      linkedList.remove(0);
    }
  }

  @Test
  public void testArrayListAddRemove() {
    for (int r = 0; r < REPS; r++) {
      arrayList.add(0, 77);
      arrayList.remove(0);
    }
  }

  @Test
  public void testLinkedListAccess() {
    long sum = 0L;
    for (int r = 0; r < REPS; r++) {
      sum += linkedList.get(r % currentSize);
    }
  }

  @Test
  public void testArrayListAccess() {
    long sum = 0L;
    for (int r = 0; r < REPS; r++) {
      sum += arrayList.get(r % currentSize);
    }
  }
}
