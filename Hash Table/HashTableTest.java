
import java.util.Scanner;

/**
 * This program goal is to implement the data structure of a Hash table and to create the uses for a hash table.
 **/

import java.util.Scanner;

class HashTable
{
    int[] arrayForNumbers;
    int amountOfNumbersAvailable;

    /** The constructor to add numbers into the hash table, with respect to the amount of numbers that is available to the array. **/
    public HashTable(int amountOfNumbersAvailable)
    {
        this.amountOfNumbersAvailable = nextPrime(amountOfNumbersAvailable);
        arrayForNumbers = new int[this.amountOfNumbersAvailable];
    }

    /** this function will help insert the elementAddedIntoHashTablemenent or number into the hash table **/
    public void insert(int elementAddedIntoHashTable)
    {
        arrayForNumbers[elementAddedIntoHashTable % amountOfNumbersAvailable] = elementAddedIntoHashTable;
    }

    /** This function goal is to clear the values within the hash table **/
    public void clear()
    {
        arrayForNumbers = new int[amountOfNumbersAvailable];
    }

    /** this function should show the users what is in the hash table **/
    public boolean contains(int elementAddedIntoHashTable)
    {
        return arrayForNumbers[elementAddedIntoHashTable % amountOfNumbersAvailable] == elementAddedIntoHashTable;
    }

    /** This function should delete the element that is added into the hash table **/
    public void delete(int elementAddedIntoHashTable)
    {
        if (arrayForNumbers[elementAddedIntoHashTable % amountOfNumbersAvailable] == elementAddedIntoHashTable)
            arrayForNumbers[elementAddedIntoHashTable % amountOfNumbersAvailable] = 0;
        else
            System.out.println("\nError : The element you enter is not found\n");
    }

    /** this function will find the next prime number within the set of array. **/
    private static int nextPrime( int n )
    {
        if (n % 2 == 0)
            n++;
        for (; !isPrime(n); n += 2);

        return n;
    }

    /** This function should check if the given number is prime or not **/
    private static boolean isPrime(int n)
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

    /** This should print out the hash table **/
    public void printTable()
    {
        System.out.print("\nHash Table = ");
        for (int i = 0; i < amountOfNumbersAvailable; i++)
            System.out.print(arrayForNumbers[i] +" ");
        System.out.println();
    }
}

/** This is the main hash table function, which would test out the inputs of the hash table. **/
public class HashTableTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hash Table Test\n\n");
        System.out.println("Enter size of the hash table");

        HashTable ht = new HashTable(scan.nextInt() );

        char ch;
        /**  below will print out the hash table functionality to the users and wait for their respond.  **/
        do
        {
            System.out.println("\nPlease choose a hash table operations below by entering a number between 1 to 4\n");
            System.out.println("1. insert ");
            System.out.println("2. remove");
            System.out.println("3. contains");
            System.out.println("4. clear \n");
             System.out.println("Please enter a number from 1 to 4")
            int choice = scan.nextInt();
            /** Switch statement to understand the users input and see what they wanted to do with the hash table.**/
            switch (choice)
            {
            case 1 :
                System.out.println("Enter integer to be inserted");
                ht.insert( scan.nextInt() );
                break;
            case 2 :
                System.out.println("Enter integer to be deleted");
                ht.delete( scan.nextInt() );
                break;
            case 3 :
                System.out.println("Enter integer to see if it in the hash table");
                System.out.println("Located in : "+ ht.contains(scan.nextInt() ));
                break;
            case 4 :
                ht.clear();
                System.out.println("Clear out hash table\n");
                break;
            default :
                System.out.println("You didn't choose from 1 to 4, please pick again \n ");
                break;
            }
            /** This function below will display the hash table**/
            ht.printTable();

            System.out.println("\nDo you want continue with this hash table, enter either 'y' for yes or 'n' for no \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }
}
