package com.solvd.hardwarestore.custom_linkedlist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLinkedList<T> {
    private static final Logger LOGGER= LogManager.getLogger(CustomLinkedList.class);
    //The first Node element in the linked list
    private Node<T> head;
    //The final Node element in the linked list
    private Node<T> tail;
    public class Node<T>{
        //The data that the node has inside
        T data;
        //the nextNode pointer
        Node<T> nextNode =null;
        //constructor of the node
        public Node(T data){
            this.data=data;
        }
    }

    //Now the methods that interact with the nodes
    //print every element in the list
    public void printAllData(){
        //I create a new node and i assing the first element
        Node<T> actualNode=head;
        //I create a while that when a the actual node is not null it print the data of the node
        while (actualNode!=null){
            LOGGER.info(actualNode.data);
            actualNode=actualNode.nextNode;
        }
        System.out.println();
    }

    //Method to add an element to the linked list

    public void addEndNode(T data){
        //Create a new Node element with the new data
        Node<T> newNode=new Node<T>(data);
        //Check if the first node is null or not
        if (head==null){
            head=newNode;
            return;
        }
        //Turn the actual node in the first Node
        Node<T> actualNode=head;
        /*While the actual node is not null check if the next node is null
        if it is null we now that the actual node is the last node and we save it
        in the tail Node.
        Then we pass to the next element entering into the actualNode.next and make that node
        the actual node
         */
        while (actualNode!=null){
            if (actualNode.nextNode==null){
                tail=actualNode;
            }
            actualNode=actualNode.nextNode;
        }
        //Once we find that the actual node is null we add to the next element
        //of the tail the newNode with the new data
        tail.nextNode=newNode;
    }
    //Add an element in the first node
    public void addFirstNode(T data){
        //Create a new Node element with the new data
        Node<T> newNode=new Node<T>(data);
        //Check if the first node is null or not if it is we add it in the fist data
        if (head==null){
            head=newNode;
            return;
        }
        //Turn the actual node in the first Node
        Node<T> previousFistNode=head;
        //Now i made the new node the first node
        head=newNode;
        //Add the previous firstNode to the pointer of the newNode
        head.nextNode=previousFistNode;
    }

    //method to delete the first node
    public void deleteFirstNode(){
        Node <T> newFirstNode=new Node<>(null);
        try {
            newFirstNode=head.nextNode;
            head=newFirstNode;
        }catch (NullPointerException e){
            LOGGER.error("You cant do that"+e);
        }

    }
    //With this method you delete a desired Middle Node
    public void deleteMiddleNode(T data){
        //The previous node, it saves the information of the previous node
        Node<T> previousNode=new Node<>(null);
        //The node that we have to delete
        Node<T> deletNode=new Node<>(data);
        //The next node that its going to replace the actualnode.next
        Node<T> nextNode=new Node<>(null);
        //If the data is the same we delete the whole arrayList for that reason, we cannot delete it
        if (head==null){
            LOGGER.info("The list is already empty");
            return;
        }
        if (head.data==deletNode.data){
            LOGGER.info("You cant delete the first node");
            return;
        }
        //Here we start to iterate through the array
        Node<T> actualNode=head;
        try {
            //While the information in the data Node is different to the one thath we want to delete
            //we save the information of the actual node in the previous node and advance to the
            //next node using the actual node
            while (actualNode.data!=deletNode.data){
                previousNode=actualNode;
                actualNode=actualNode.nextNode;
            }
            //Once we find the element we save the information of the next element
            // of thath node in the nextNode
            nextNode=actualNode.nextNode;
            //finally we delete the desired element (actual node) assing the following node to the
            //previousNode.nextNode
            previousNode.nextNode=nextNode;
            return;
            //If the element is not in the array an error is going to appear
        }catch (NullPointerException e){
           LOGGER.error("The element was not in the array "+e);
        }catch (Exception f){
            LOGGER.error("Another error happened"+f);
        }

    }

    public void deleteLastNode(){
        Node<T> previousLastNode=new Node<>(null);
        Node<T>actualNode=new Node<>(null);
        actualNode=head;
        if (actualNode==tail.nextNode){
            LOGGER.info("you cant delete the array with this method use the deletCustomLinkedList() method");
            return;
        }
        while (actualNode.nextNode!=null){
            if (actualNode.nextNode.nextNode==null){
                previousLastNode=actualNode;
            }
            actualNode=actualNode.nextNode;
        }
        tail.nextNode=previousLastNode;
        previousLastNode.nextNode=null;
    }
    //Delete the whole customlinkedlist
    public void deleteCustomLinkedList(){
        head=null;
    }






}

