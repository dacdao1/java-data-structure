/*
 *  Using the linkedlist informationWithinSingleNode structure and algorithm. This help indentify a node and then connectToNextNode that node to another node, creating a chain of nodes that can be transverse up and down that chain to find the right node. Each node can be deleted by not letting that node connect to anything.
 */

import java.util.Scanner;

/*  Class Node  */
class Node
{
    protected int informationWithinSingleNode;
    protected Node connectToNextNode;

    /*  Constructor  */
    public Node()
    {
        connectToNextNode = null;
        informationWithinSingleNode = 0;
    }
    /*  Constructor  */
    public Node(int d,Node n)
    {
        informationWithinSingleNode = d;
        connectToNextNode = n;
    }
    /* set end of node to next Node  */
    public void setLink(Node n)
    {
        connectToNextNode = n;
    }
    /*  set the current data to current Node  */
    public void setData(int d)
    {
        informationWithinSingleNode = d;
    }
    /*  get current to next node  */
    public Node getLink()
    {
        return connectToNextNode;
    }
    /*  get information from current node */
    public int getData()
    {
        return informationWithinSingleNode;
    }
}

/* Class linkedList */
class linkedList
{
    protected Node start;
    protected Node end ;
    public int size ;

    /*  Constructor  */
    public linkedList()
    {
        start = null;
        end = null;
        size = 0;
    }
    /*  check if list is empty  */
    public boolean isEmpty()
    {
        return start == null;
    }
    /*  get size of list  */
    public int getSize()
    {
        return size;
    }
    /*  insert an element at begining  */
    public void insertAtStart(int val)
    {
        Node nodePointerToNextNode = new Node(val, null);
        size++ ;
        if(start == null)
        {
            start = nodePointerToNextNode;
            end = start;
        }
        else
        {
            nodePointerToNextNode.setLink(start);
            start = nodePointerToNextNode;
        }
    }
    /*  insert an element at end  */
    public void insertAtEnd(int val)
    {
        Node nodePointerToNextNode = new Node(val,null);
        size++ ;
        if(start == null)
        {
            start = nodePointerToNextNode;
            end = start;
        }
        else
        {
            end.setLink(nodePointerToNextNode);
            end = nodePointerToNextNode;
        }
    }
    /*   insert an element at position  */
    public void insertNodeAtCertainPoint(int val , int position)
    {
        Node nodePointerToNextNode = new Node(val, null);
        Node pointer = start;
        position = position - 1 ;
        for (int i = 1; i < size; i++)
        {
            if (i == position)
            {
                Node tmp = pointer.getLink() ;
                pointer.setLink(nodePointerToNextNode);
                nodePointerToNextNode.setLink(tmp);
                break;
            }
            pointer = pointer.getLink();
        }
        size++ ;
    }
    /*  delete an element at position  */
    public void deleteNodeAtPosition(int position)
    {
        if (position == 1)
        {
            start = start.getLink();
            size--;
            return ;
        }
        if (position == size)
        {
            Node s = start;
            Node t = start;
            while (s != end)
            {
                t = s;
                s = s.getLink();
            }
            end = t;
            end.setLink(null);
            size --;
            return;
        }
        Node pointer = start;
        position = position - 1 ;
        for (int i = 1; i < size - 1; i++)
        {
            if (i == position)
            {
                Node tmp = pointer.getLink();
                tmp = tmp.getLink();
                pointer.setLink(tmp);
                break;
            }
            pointer = pointer.getLink();
        }
        size-- ;
    }
    /*  Function to display elements  */
    public void display()
    {
        System.out.print("\nSingly Linked List = ");
        if (size == 0)
        {
            System.out.print("empty\n");
            return;
        }
        if (start.getLink() == null)
        {
            System.out.println(start.getData() );
            return;
        }
        Node pointer = start;
        System.out.print(start.getData()+ "->");
        pointer = start.getLink();
        while (pointer.getLink() != null)
        {
            System.out.print(pointer.getData()+ "->");
            pointer = pointer.getLink();
        }
        System.out.print(pointer.getData()+ "\n");
    }
}

/*  main function class to run the linkedlist data structure above  */
public class LinkedListDataStructure
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        linkedList list = new linkedList();
        System.out.println("Singly Linked List Test\n");
        char ch;
        /*  Perform list operations  */
        do
        {
            System.out.println("\nSingly Linked List Operations\n");
            System.out.println("1. insert at begining");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. check empty");
            System.out.println("6. get size");
            System.out.println("Please enter a number from 1 to 6");
            int choice = scan.nextInt();
            switch (choice)
            {
            case 1 :
                System.out.println("Enter number to be insert");
                list.insertAtStart( scan.nextInt() );
                break;
            case 2 :
                System.out.println("Enter integer element to insert");
                list.insertAtEnd( scan.nextInt() );
                break;
            case 3 :
                System.out.println("Enter integer element to insert");
                int num = scan.nextInt() ;
                System.out.println("Enter position");
                int position = scan.nextInt() ;
                if (position <= 1 || position > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.insertNodeAtCertainPoint(num, position);
                break;
            case 4 :
                System.out.println("Enter position");
                int p = scan.nextInt() ;
                if (p < 1 || p > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.deleteNodeAtPosition(p);
                break;
            case 5 :
                System.out.println("Linked List Empty= "+ list.isEmpty());
                break;
            case 6 :
                System.out.println("Size = "+ list.getSize() +" \n");
                break;
             default :
                System.out.println("You didn't choose from 1 to 6, please pick again  \n ");
                break;
            }
            /*  Display List  */
            list.display();
              System.out.println("\nDo you want continue with this hash table, enter either 'y' for yes or 'n' for no \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }
}
