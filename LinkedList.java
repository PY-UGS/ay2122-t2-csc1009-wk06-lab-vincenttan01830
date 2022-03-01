package com.company;
import java.util.Random;

class LinkedList {
    Node head; // head of list

    //Question 2: Swapping values of two indexes
    public void swapNodes(int indOne, int indTwo)
    {
        // Do nothing if input both indexes
        if (indOne == indTwo)
            return;

        Node prevX = null, currX = head;
        for(int i=0; i<indOne; i++){
            if(currX != null){
                prevX = currX;
                currX = currX.next;
            }
            else{
                return;
            }
        }

        Node prevY = null, currY = head;
        for(int i=0; i<indTwo; i++){
            if(currY != null){
                prevY = currY;
                currY = currY.next;
            }
            else{
                return;
            }
        }

        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;

        // If x is not head of linked list
        if (prevX != null)
            prevX.next = currY;
        else // make y the new head
            head = currY;

        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            head = currX;

        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    // Function to add Node at beginning of list.
    public void push(int new_data)
    {
        // 1. alloc the Node and put the data
        Node new_Node = new Node(new_data);

        // 2. Make next of new Node as head
        new_Node.next = head;

        // 3. Move the head to point to new Node
        head = new_Node;
    }

    // This function prints contents of linked
    // list starting from the given Node
    public void printList()
    {
        Node tNode = head;
        while (tNode != null) {
            System.out.print(tNode.data + " ");
            tNode = tNode.next;
        }
        System.out.println();
    }

    //Question 1: Adding a value into the list and sort it
    public void addAndSort(int value){
        push(value);
        Node prevX = null, newX = head, currX = newX.next;
        if (currX != null && value >= currX.data){
            head = currX;
            while(currX != null && value >= currX.data){
                prevX = currX;
                currX = currX.next;
            }
        }
        if(prevX != null){
            prevX.next = newX;
            newX.next = currX;
        }
    }

    //Question 3: Finding the existence of a value in the list
    public int numExist(int value){
        Node prev = null, curr = head;
        while (curr != null && curr.data != value) {
            prev = curr;
            curr = curr.next;
        }

        if(curr != null){
            return curr.data;
        }
        else{
            return -1;
        }
    }

    // Driver program to test above function
    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();
        llist.push(9);
        llist.push(7);
        llist.push(5);
        llist.push(3);
        llist.push(1);

        System.out.println("Linked List Before Insertion :-");
        llist.printList();

        llist.addAndSort(0);

        System.out.println("Linked List After Insertion :-");
        llist.printList();

        System.out.println("Linked List Before Swapping :-");
        llist.printList();

        llist.swapNodes(1, 4);

        System.out.println("Linked List After Swapping :-");
        llist.printList();

        LinkedList randomllist = new LinkedList();
        int min = 1000;
        int max = 9999;

        for(int i = 0; i <= 500; i++){
            int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            randomllist.addAndSort(random_int);
        }

        //Question 3: Finding the existence of a value in the list
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        int found = randomllist.numExist(random_int);
        System.out.println("New random number is " + random_int);
        if(found != -1){
            System.out.println("Number is found in index: " + found);
        }
        else{
            System.out.println("Number not found in the list");
        }
    }
}
