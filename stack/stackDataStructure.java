/*
 * The data structure and algorithm of stack is created and define below. Mostly popular with the use of pop and push.
 */

import java.util.*;

class TheStackArray
{
    protected int arr[];
    protected int top, size, len;

    public TheStackArray(int n)
    {
        size = n;
        len = 0;
        arr = new int[size];
        top = -1;
    }
    /*  check if stack is empty */
    public boolean isEmpty()
    {
        return top == -1;
    }
    /* check if stack is full */
    public boolean isFull()
    {
        return top == size -1 ;
    }
    /* get the size of the stack */
    public int getSize()
    {
        return len ;
    }
    /* check the top element of the stack */
    public int peek()
    {
        if( isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        return arr[top];
    }
    /*  add an element to the stack */
    public void push(int i)
    {
        if(top + 1 >= size)
            throw new IndexOutOfBoundsException("Overflow Exception");
        if(top + 1 < size )
            arr[++top] = i;
        len++ ;
    }
    /* delete an element from the stack */
    public int pop()
    {
        if( isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        len-- ;
        return arr[top--];
    }
    /*  display the status of the stack */
    public void display()
    {
        System.out.print("\nStack = ");
        if (len == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        for (int i = top; i >= 0; i--)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}

/*  main class use to implement the stack data structure and algorithm  */
public class stackDataStructure
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Stack Test\n");
        System.out.println("Enter Size of Integer Stack ");
        int n = scan.nextInt();
        /* Creating object of class TheStackArray */
        TheStackArray stk = new TheStackArray(n);
        /* Perform Stack Operations */
        char ch;
        do{
            System.out.println("\nStack Operations");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. peek");
            System.out.println("4. check empty");
            System.out.println("5. check full");
            System.out.println("6. size \n");
            System.out.println("Please enter a number from 1 to 6");
            int choice = scan.nextInt();
            switch (choice)
            {
            case 1 :
                System.out.println("Enter number to be push");
                try
                {
                    stk.push( scan.nextInt() );
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }
                break;
            case 2 :
                try
                {
                    System.out.println("Popped Element = " + stk.pop());
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }
                break;
            case 3 :
                try
                {
                    System.out.println("Peek Element = " + stk.peek());
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }
                break;
            case 4 :
                System.out.println("Stack Empty= " + stk.isEmpty());
                break;
            case 5 :
                System.out.println("Stack Full = " + stk.isFull());
                break;
            case 6 :
                System.out.println("Size = " + stk.getSize());
                break;
            default :
                System.out.println("You didn't choose from 1 to 6, please pick again  \n ");
                break;
            }
            /* display stack */
            stk.display();
            System.out.println("\nDo you want continue with this hash table, enter either 'y' for yes or 'n' for no \n");
            ch = scan.next().charAt(0);

        } while (ch == 'Y'|| ch == 'y');
    }
}
