/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlist;

/**
 *
 * @author ruba
 */
public class linkedList {
    protected Node start;
    protected Node end ;
    public int size;
 
    public linkedList(){}
 
    /* Function to get size of list */
    public int getSize(){
        return size;
    }
    
    
    /* insert element at begining */
    public void insert(int value){
        Node newNode = new Node(value, null, null);        
        if(start == null)
        {
            start = newNode;
            end = start;
        }
        else
        {
            start.setLinkPrev(newNode);
            newNode.setLinkNext(start);
            start = newNode;
        }
        size++;
    }

    /* delete node at position */
    public void deleteAtPos(int pos){        
        if (pos == 1) 
        {
            // only one node lfet
            if (size == 1)
            {
                start = null;
                end = null;
                size = 0;
                return; 
            }
            start = start.getLinkNext();
            start.setLinkPrev(null);
            size--; 
            return ;
        }
        if (pos == size)
        {
            end = end.getLinkPrev();
            end.setLinkNext(null);
            size-- ;
        }
        Node ptr = start.getLinkNext();
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                Node p = ptr.getLinkPrev();
                Node n = ptr.getLinkNext();
 
                p.setLinkNext(n);
                n.setLinkPrev(p);
                size-- ;
                return;
            }
            ptr = ptr.getLinkNext();
        }        
    }    
    /* display status of list */
    public void show(){
        System.out.print("\nDoubly Linked List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }
        //only one node
        if (start.getLinkNext() == null) 
        {
            System.out.println(start.getData() );
            return;
        }
        Node ptr = start;
        System.out.print(start.getData()+ "  ");
        ptr = start.getLinkNext();
        while (ptr.getLinkNext() != null)
        {
            System.out.print(ptr.getData()+ "  ");
            ptr = ptr.getLinkNext();
        }
        System.out.println(ptr.getData()+ "  ");
    }
}
