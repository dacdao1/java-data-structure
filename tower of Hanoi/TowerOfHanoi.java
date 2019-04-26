/*
 * Solving the tower of Hanoi problem with using the stack data structure
 */

 import java.util.*;


 public class TowerOfHanoi
 {
     public static int numberOfNode;
     /* creating a stack to add values*/
     public static Stack<Integer>[] tower = new Stack[4];

     public static void main(String[] args)
     {
         Scanner scan = new Scanner(System.in);
         tower[1] = new Stack<Integer>();
         tower[2] = new Stack<Integer>();
         tower[3] = new Stack<Integer>();
         /* total number of disks */
         System.out.println("Enter the number of disks to be move");
         int userNumberInput = scan.nextInt();
         numberOfNode = userNumberInput;
         towerOfHanoiUses(userNumberInput);
     }
     /* push disks into stack */
     public static void towerOfHanoiUses(int n)
     {
         for (int d = n; d > 0; d--)
             tower[1].push(d);
         display();
         move(n, 1, 2, 3);
     }
     /* Recursive Function to move disks */
     public static void move(int n, int a, int b, int c)
     {
         if (n > 0)
         {
             move(n-1, a, c, b);
             int d = tower[a].pop();
             tower[c].push(d);
             display();
             move(n-1, b, a, c);
         }
     }
     /*  ]display the towers*/
     public static void display()
     {
         System.out.println("  A  |  B  |  C");
         System.out.println("---------------");
         for(int i = numberOfNode - 1; i >= 0; i--)
         {
             String d1 = " ", d2 = " ", d3 = " ";
             try
             {
                 d1 = String.valueOf(tower[1].get(i));
             }
             catch (Exception e){
             }
             try
             {
                 d2 = String.valueOf(tower[2].get(i));
             }
             catch(Exception e){
             }
             try
             {
                 d3 = String.valueOf(tower[3].get(i));
             }
             catch (Exception e){
             }
             System.out.println("  "+d1+"  |  "+d2+"  |  "+d3);
         }
         System.out.println("\n");
     }
 }
