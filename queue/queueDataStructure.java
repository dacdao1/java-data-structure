/*
 * Creating and using the queue array. First in, first out method.
 */

import java.util.*;

/*  Class QueueArray  */
class QueueArray
{
    protected int Queue[] ;
    protected int front, rear, sizeOfArray, lengthOfArray;

    /* Constructor */
    public QueueArray(int userInput)
    {
        sizeOfArray = userInput;
        lengthOfArray = 0;
        Queue = new int[sizeOfArray];
        front = -1;
        rear = -1;
    }
    /*  check if queue is empty */
    public boolean isEmpty()
    {
        return front == -1;
    }
    /*  check if queue is full */
    public boolean isFull()
    {
        return front==0 && rear == sizeOfArray -1 ;
    }
    /*  find the size queue  */
    public int getSize()
    {
        return lengthOfArray ;
    }
    /*  check front elemenet of queue */
    public int peek()
    {
        if (isEmpty())
           throw new NoSuchElementException("Underflow Exception");
        return Queue[front];
    }
    /* insert an element to the queue */
    public void insert(int i)
    {
        if (rear == -1)
        {
            front = 0;
            rear = 0;
            Queue[rear] = i;
        }
        else if (rear + 1 >= sizeOfArray)
            throw new IndexOutOfBoundsException("Overflow Exception");
        else if ( rear + 1 < sizeOfArray)
            Queue[++rear] = i;
        lengthOfArray++ ;
    }
    /*  remove front element from the queue */
    public int remove()
    {
        if (isEmpty())
           throw new NoSuchElementException("Underflow Exception");
        else
        {
            lengthOfArray-- ;
            int ele = Queue[front];
            if ( front == rear)
            {
                front = -1;
                rear = -1;
            }
            else
                front++;
            return ele;
        }
    }
    /* display the status of the queue */
    public void display()
    {
        System.out.print("\nQueue = ");
        if (lengthOfArray == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        for (int i = front; i <= rear; i++)
            System.out.print(Queue[i]+" ");
        System.out.println();
    }
}

/* Class QueueImplement  */
public class queueDataStructure
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Array Queue Test\n");
        System.out.println("Enter Size of Integer Queue ");
        int userInput = scan.nextInt();
        /* creating object of class QueueArray */
        QueueArray newQueue = new QueueArray(userInput);
        /* Perform Queue Operations */
        char ch;
        do{
            System.out.println("\nQueue Operations");
            System.out.println("1. insert");
            System.out.println("2. remove");
            System.out.println("3. peek");
            System.out.println("4. check empty");
            System.out.println("5. check full");
            System.out.println("6. size of queue");
            System.out.println("Please enter a number from 1 to 6");
            int choice = scan.nextInt();
            switch (choice)
            {
            case 1 :
                System.out.println("Enter number to be push");
                try
                {
                    newQueue.insert( scan.nextInt() );
                }
                catch(Exception e)
                {
                    System.out.println("Error : " +e.getMessage());
                }
                break;
            case 2 :
                try
                {
                    System.out.println("Removed Element = "+newQueue.remove());
                }
                catch(Exception e)
                {
                    System.out.println("Error : " +e.getMessage());
                }
                break;
            case 3 :
                try
                {
                    System.out.println("Peek Element = "+newQueue.peek());
                }
                catch(Exception e)
                {
                    System.out.println("Error : "+e.getMessage());
                }
                break;
            case 4 :
                System.out.println(" Queue Empty = "+newQueue.isEmpty());
                break;
            case 5 :
                System.out.println(" Queue Full= "+newQueue.isFull());
                break;
            case 6 :
                System.out.println("Size of Array = "+ newQueue.getSize());
                break;
            default : System.out.println("You didn't choose from 1 to 6, please pick again  \n ");
                break;
            }
            /* display Queue */
            newQueue.display();
            System.out.println("\nDo you want continue with this hash table, enter either 'y' for yes or 'userInput' for no \n");
            ch = scan.next().charAt(0);

        } while (ch == 'Y'|| ch == 'y');
    }
}
