/*
 *    Using the hash table data structure, now I'm adding the use of an algorithm to linked everything together, ie Linked list.
 */

import java.util.Scanner;

/* Node for singly linked list */
class LinkedListNode
{
    LinkedListNode nextNode;
    int dataWithinNode;

    /* Constructor */
    public LinkedListNode(int x)
    {
        dataWithinNode = x;
        nextNode = null;
    }
}

/* this is the class that will store majority of the functionality of the hash table */
class HashTableWithLinkedList
{
    private LinkedListNode[] table;
    private int size ;

    /* the Constructor for the hash table with linked list */
    public HashTableWithLinkedList(int sizeOfTable)
    {
        table = new LinkedListNode[ nextPrime(sizeOfTable) ];
        size = 0;
    }
    /* check to see if the table is empty */
    public boolean isEmpty()
    {
        return size == 0;
    }
    /* Help clear the table */
    public void makeEmpty()
    {
        int lengthOfTable = table.length;
        table = new LinkedListNode[lengthOfTable];
        size = 0;
    }
    /* find the size of table */
    public int getSize()
    {
        return size;
    }
    /* add element to the table */
    public void insert(int valueToBeAdded)
    {
        size++;
        int positionOfValueToBeInserted = myhash(valueToBeAdded);
        LinkedListNode newNodeToBeInserted = new LinkedListNode(valueToBeAdded);
        if (table[positionOfValueToBeInserted] == null)
            table[positionOfValueToBeInserted] = newNodeToBeInserted;
        else
        {
            newNodeToBeInserted.nextNode = table[positionOfValueToBeInserted];
            table[positionOfValueToBeInserted] = newNodeToBeInserted;
        }
    }
    /* remove an element from the hash table */
    public void remove(int valueToBeAdded)
    {
        int positionOfValueToBeInserted = myhash(valueToBeAdded);
        LinkedListNode start = table[positionOfValueToBeInserted];
        LinkedListNode end = start;
        if (start.dataWithinNode == valueToBeAdded)
        {
            size--;
            table[positionOfValueToBeInserted] = start.nextNode;
            return;
        }
        while (end.nextNode != null && end.nextNode.dataWithinNode != valueToBeAdded)
            end = end.nextNode;
        if (end.nextNode == null)
        {
            System.out.println("\nThe number you enter does not exist within this hash table\n");
            return;
        }
        size--;
        if (end.nextNode.nextNode == null)
        {
            end.nextNode = null;
            return;
        }
        end.nextNode = end.nextNode.nextNode;
        table[positionOfValueToBeInserted] = start;
    }
    /* myhash function is define below */
    private int myhash(Integer x )
    {
        int hashVal = x.hashCode( );
        hashVal %= table.length;
        if (hashVal < 0)
            hashVal += table.length;
        return hashVal;
    }
    /* generate the next prime number within the hash table */
    private static int nextPrime( int n )
    {
        if (n % 2 == 0)
            n++;
        for ( ; !isPrime( n ); n += 2);

        return n;
    }
    /* check to see if the number that was enter is prime */
    private static boolean isPrime( int n )
    {
        if (n == 2 || n == 3)
            return true;
        if (n == 1 || n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }
    /** Print out the hash table and what it contain **/
    public void printHashTable ()
    {
        System.out.println();
        for (int i = 0; i < table.length; i++)
        {
            System.out.print ("Bucket " + i + ":  ");
            LinkedListNode start = table[i];
            while(start != null)
            {
                System.out.print(start.dataWithinNode +" ");
                start = start.nextNode;
            }
            System.out.println();
        }
    }
}

/* The main function */
public class HashTableLinkedList
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hash Table Test\n\n");
        System.out.println("Enter size of the hash table");
        /* Make object of hash table */
        HashTableWithLinkedList hashTableLinkedList = new HashTableWithLinkedList(scan.nextInt() );

        char ch;

        do
        {
            System.out.println("\nHash Table Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. remove");
            System.out.println("3. clear");
            System.out.println("4. size");
            System.out.println("5. check empty \n");

	    System.out.println("Please enter a number from 1 to 5");
            int choice = scan.nextInt();
            switch (choice)
            {
		    case 1 :
      System.out.println("Enter integer to be inserted");
                hashTableLinkedList.insert( scan.nextInt() );
                break;
		case 2 :
    System.out.println("Enter integer to be deleted");
                hashTableLinkedList.remove( scan.nextInt() );
                break;
            case 3 :
                hashTableLinkedList.makeEmpty();
                System.out.println("Hash Table is not clear\n");
                break;
            case 4 :
                System.out.println("Size of the hash table= "+ hashTableLinkedList.getSize() );
                break;
            case 5 :
                System.out.println("Empty status = "+ hashTableLinkedList.isEmpty() );
                break;
            default :
                System.out.println("You didn't choose from 1 to 4, please pick again  \n ");
                break;
            }
            /* Display hash table */
            hashTableLinkedList.printHashTable();

            System.out.println("\nDo you want continue with this hash table, enter either 'y' for yes or 'n' for no \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }
}
