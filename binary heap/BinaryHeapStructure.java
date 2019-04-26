/**
 *  Java Program to create a binary heap that would insert data into the data structure and the data structure would store the data in a tree like structure
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.NoSuchElementException;


class BinaryHeap
{
    /** A binary tree only have two children, so each node can only have the final value of 2 for children **/
    private static final int totalNumberOfChildNode = 2;
    private int heapSize;
    private int[] theHeapArray;

    /** Constructor **/
    public BinaryHeap(int scope)
    {
        heapSize = 0;
        theHeapArray = new int[scope + 1];
        Arrays.fill(theHeapArray, -1);
    }

    /** check to see if heap is empty **/
    public boolean isEmpty( )
    {
        return heapSize == 0;
    }

    /** Check to see if heap is full **/
    public boolean isFull( )
    {
        return heapSize == theHeapArray.length;
    }

    /** clear said heap */
    public void makeEmpty( )
    {
        heapSize = 0;
    }

    /** find the index of parent node **/
    private int parent(int i)
    {
        return (i - 1)/totalNumberOfChildNode;
    }

    /**find the child node **/
    private int kthChild(int i, int k)
    {
        return totalNumberOfChildNode * i + k;
    }

    /** insert element */
    public void insert(int x)
    {
        if (isFull( ) )
            throw new NoSuchElementException("Overflow, please dont add any more value");

        theHeapArray[heapSize++] = x;
        heapUp(heapSize - 1);
    }

    /**find least element **/
    public int findMin( )
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow");
        return theHeapArray[0];
    }

    /**delete min element **/
    public int deleteMin()
    {
        int itemToBeDeleted = theHeapArray[0];
        delete(0);
        return itemToBeDeleted;
    }

    /** delete element at an index **/
    public int delete(int certainNodeAtIndex)
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow");
        int itemToBeDeleted = theHeapArray[certainNodeAtIndex];
        theHeapArray[certainNodeAtIndex] = theHeapArray[heapSize - 1];
        heapSize--;
        heapDown(certainNodeAtIndex);
        return itemToBeDeleted;
    }

/** Below are ways to travel up and down the heap**/
    private void heapUp(int childInd)
    {
        int tmp = theHeapArray[childInd];
        while (childInd > 0 && tmp < theHeapArray[parent(childInd)])
        {
            theHeapArray[childInd] = theHeapArray[ parent(childInd) ];
            childInd = parent(childInd);
        }
        theHeapArray[childInd] = tmp;
    }


    private void heapDown(int certainNodeAtIndex)
    {
        int child;
        int tmp = theHeapArray[ certainNodeAtIndex ];
        while (kthChild(certainNodeAtIndex, 1) < heapSize)
        {
            child = minChild(certainNodeAtIndex);
            if (theHeapArray[child] < tmp)
                theHeapArray[certainNodeAtIndex] = theHeapArray[child];
            else
                break;
            certainNodeAtIndex = child;
        }
        theHeapArray[certainNodeAtIndex] = tmp;
    }

    /**get smallest child **/
    private int minChild(int certainNodeAtIndex)
    {
        int bestChild = kthChild(certainNodeAtIndex, 1);
        int k = 2;
        int pos = kthChild(certainNodeAtIndex, k);
        while ((k <= totalNumberOfChildNode) && (pos < heapSize))
        {
            if (theHeapArray[pos] < theHeapArray[bestChild])
                bestChild = pos;
            pos = kthChild(certainNodeAtIndex, k++);
        }
        return bestChild;
    }

    /** print the heap **/
    public void printHeap()
    {
        System.out.print("\nHeap = ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(theHeapArray[i] +" ");
        System.out.println();
    }
}

/** main class to use the heap functionality**/
public class BinaryHeapStructure
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Binary Heap Test\n\n");
        System.out.println("Enter size of Binary theHeapArray");
        /** Make object of BinaryHeap **/
        BinaryHeap bh = new BinaryHeap(scan.nextInt() );

        char ch;
        /**  Perform Binary Heap operations  **/
        do
        {
            System.out.println("\nBinary Heap Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. delete min");
            System.out.println("3. check full");
            System.out.println("4. check empty");
            System.out.println("5. clear");

System.out.println("Please enter a number from 1 to 5");
            int choice = scan.nextInt();
            switch (choice)
            {
            case 1 :
                try
                {
                    System.out.println("Enter integer to be inserted");
                    bh.insert( scan.nextInt() );
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage() );
                }
                break;
            case 2 :
                try
                {
                    System.out.println("Minimum Element : "+ bh.deleteMin());
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage() );
                }
                break;
            case 3 :
                System.out.println(" Heap Full = "+ bh.isFull());
                break;
            case 4 :
                System.out.println(" Heap Empty  = "+ bh.isEmpty());
                break;
            case 5 :
                bh.makeEmpty();
                System.out.println("Heap Cleared\n");
                break;
            default :
                System.out.println("You didn't choose from 1 to 5, please pick again  \n ");
                break;
            }
            /** Display theHeapArray **/
            bh.printHeap();

            System.out.println("\nDo you want continue with this hash table, enter either 'y' for yes or 'n' for no \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }
}
