# CS 2720 - Data Structures

This repository contains all of the data structures and algorithm that I learned while in college. We mostly cover Stack, Linked List, and Queue but my Advance Algorithm class covers Heap, Binary Heap, and Hash Table. So I included what I learned from those two classes within this repository. I added within each folder the way to run each Java program and what it looks like at the end.

To run each program, first you have to have JDK install within your local machine. Once JDK is install, please click onto one of the folder, then download that file. Then use the command line terminal to move into the folder that contain the file. Then use the command below to run the program.

```java
javac dataStructureName.java
java dataStructureName
```
Take out the dataStructureName declarative and put in the file name that you downloaded.

** Please choose a folder to go into and looks at the README to have a better understand of how each data structure and algorithm works **

## Binary Heap

A Binary Heap is a Binary Tree with following properties.
1) It’s a complete tree (All levels are completely filled except possibly the last level and the last level has all keys as left as possible). This property of Binary Heap makes them suitable to be stored in an array.

2) A Binary Heap is either Min Heap or Max Heap. In a Min Binary Heap, the key at root must be minimum among all keys present in Binary Heap. The same property must be recursively true for all nodes in Binary Tree. Max Binary Heap is similar to MinHeap.

![Binary Heap](https://www.geeksforgeeks.org/wp-content/uploads/binaryheap.png)

## Hash Table

In computing, a hash table (hash map) is a data structure that implements an associative array abstract data type, a structure that can map keys to values. A hash table uses a hash function to compute an index into an array of buckets or slots, from which the desired value can be found.

![Hash Table](https://he-s3.s3.amazonaws.com/media/uploads/0e2c706.png)

## Hash Table with Linked List

Using the Linked List algorithm to connect each of the Hash Table bucket together.

## Heap

A Heap is a special Tree-based data structure in which the tree is a complete binary tree. Generally, Heaps can be of two types:

Max-Heap: In a Max-Heap the key present at the root node must be greatest among the keys present at all of it’s children. The same property must be recursively true for all sub-trees in that Binary Tree.
Min-Heap: In a Min-Heap the key present at the root node must be minimum among the keys present at all of it’s children. The same property must be recursively true for all sub-trees in that Binary Tree.

![Heap](https://www.cdn.geeksforgeeks.org/wp-content/uploads/MinHeapAndMaxHeap.png)

## Linked List

A linked list is a linear data structure, in which the elements are not stored at contiguous memory locations. The algorithm I provided is a single linked list and not a circular or double linked list.

![Linked List](https://media.geeksforgeeks.org/wp-content/cdn-uploads/gq/2013/03/Linkedlist.png)

## Queue

A Queue is a linear structure which follows a particular order in which the operations are performed. The order is First In First Out (FIFO). A good example of a queue is any queue of consumers for a resource where the consumer that came first is served first.

![Queue](https://www.studytonight.com/data-structures/images/introduction-to-queue.png)

## Stack

Stack is a linear data structure which follows a particular order in which the operations are performed. The order may be LIFO(Last In First Out) or FILO(First In Last Out).

![Stack](https://www.studytonight.com/data-structures/images/stack-data-structure.png)

## Tower of Hanoi Problems


The Tower Of Hanoi problems can be find [here](https://en.wikipedia.org/wiki/Tower_of_Hanoi). The main point of the problem is to move a set of disks that increase it size within a stack. Move those disks from point A to point C. There are rules to move the stack, obviously, and the Java program should solve that problems for you. I used the stack data structures to takes in the amount of disks the users specify and then recursive through the tasks and move all of the disks from stack A to stack C with stack B in the middle that would help all of the disks move back and forth.

![Tower Of Hanoi](https://media.geeksforgeeks.org/wp-content/uploads/tower-of-hanoi.png)
