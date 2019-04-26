/**
 *  This program implement the use of heap data structure.
 */

import java.util.Scanner;

/** the class for heap and the implementation of the heap data structure */
class Heap
{

    private int[] theHeapArray;
    private int maximumSizeOfArray;
    private int sizeOfTheHeap;

    /** Constructor **/
    public Heap(int maximumValue)
    {
        maximumSizeOfArray = maximumValue;
        sizeOfTheHeap = 0;
        theHeapArray = new int[maximumSizeOfArray];
    }
    /** Check if heap is empty **/
    public boolean isEmpty()
    {
        return sizeOfTheHeap == 0;
    }
    /** Function to insert element **/
    public boolean insert(int elementToBeAdded)
    {
        if (sizeOfTheHeap + 1 == maximumSizeOfArray)
            return false;
        theHeapArray[++sizeOfTheHeap] = elementToBeAdded;
        int theCurrentPositionOfArray = sizeOfTheHeap;
        while (theCurrentPositionOfArray != 1 && elementToBeAdded > theHeapArray[theCurrentPositionOfArray/2])
        {
            theHeapArray[theCurrentPositionOfArray] = theHeapArray[theCurrentPositionOfArray/2];
            theCurrentPositionOfArray /=2;
        }
        theHeapArray[theCurrentPositionOfArray] = elementToBeAdded;
        return true;
    }

    /** function to remove element **/
    public int remove()
    {
        int parentElement, childElement;
        int item, temp;
        if (isEmpty() )
            throw new RuntimeException("Error : The current heap is empty");

        item = theHeapArray[1];
        temp = theHeapArray[sizeOfTheHeap--];

        parentElement = 1;
        childElement = 2;
        while (childElement <= sizeOfTheHeap)
        {
            if (childElement < sizeOfTheHeap && theHeapArray[childElement] < theHeapArray[childElement + 1])
                childElement++;
            if (temp >= theHeapArray[childElement])
                break;

            theHeapArray[parentElement] = theHeapArray[childElement];
            parentElement = childElement;
            childElement *= 2;
        }
        theHeapArray[parentElement] = temp;

        return item;
    }

    /** Function to print values **/
    public void displayHeap()
    {
        /* Array format */
        System.out.print("\nThe Heap array is: ");
        for(int i = 1; i <= sizeOfTheHeap; i++)
            System.out.print(theHeapArray[i] +" ");
        System.out.println("\n");
    }
}

/** Class HeapTest **/
public class HeapDataStructure
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Heap Test\n\n");
        System.out.println("Please enter the size of heap");
        Heap heap = new Heap(scan.nextInt() );

        char ch;
        /**  Perform Heap operations  **/
        do
        {
            System.out.println("\nHeap Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. delete item with max key ");
            System.out.println("3. check empty");

            System.out.println("Please enter a number from 1 to 3");
            boolean checkChoices;
            int choice = scan.nextInt();
            switch (choice)
            {
                case 1 :
      System.out.println("Enter integer to be inserted");
                checkChoices = heap.insert( scan.nextInt() );
                if (checkChoices)
                    System.out.println("Insertion  was successful\n");
                else
                    System.out.println("Insertion has failed\n");
                break;
                case 2 :
            System.out.println("Enter integer to be deleted");
                if (!heap.isEmpty())
                    heap.remove();
                else
                    System.out.println("The current heap is empty\n");
                break;
            case 3 :
                System.out.println("Empty status = "+ heap.isEmpty());
                break;
            default :
                System.out.println("You didn't choose from 1 to 3, please pick again  \n ");
                break;
            }

            /** Display heap **/
            heap.displayHeap();

            System.out.println("\nDo you want continue with this hash table, enter either 'y' for yes or 'n' for no \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }
}
