package linkedLists;

import java.util.HashMap;

public class BasicLinkedList<X> {
    private Node first;
    private Node last;
    private int nodeCount;
    public BasicLinkedList() {
        first=null;
        last=null;
        nodeCount=0;

    }
    public int size(){
        return nodeCount;
    }
    public void add(X item){
        //if it's the first time
        if(first==null){
            first=new Node(item);
            last=first;
        }
        else{
            Node newLastNode=new Node(item);
            last.setNextNode(newLastNode);
            last=newLastNode;
        }
        nodeCount++;
    }
    public X remove(){
        if(first==null){
          //nothing in list
            throw new IllegalStateException("List is empty");

        }
        else{
            X nodeItem=first.getNodeItem();
            first=first.getNextNode();
            nodeCount--;
            return nodeItem;

        }

    }
    public void insert(X item,int position){
        if(size()<position){
            throw new IllegalStateException("The postion does not exists");
        }
      Node currentNode=first;
        for (int i = 1; i < position && currentNode!=null; i++) {
            System.out.println("pos:"+i);
            currentNode=currentNode.nextNode;
        }
        Node newNode=new Node(item);
        Node nextNode=currentNode.getNextNode();
        currentNode.setNextNode(nextNode);
        newNode.setNextNode(nextNode);
        nodeCount++;
    }
    public X removeAt(int position){
        if(first==null){
            throw new IllegalStateException("Empty");
        }
        Node currentNode=first;
        Node prevNode=first;
        for (int i = 1; i <position &&currentNode!=null ; i++) {
            prevNode=currentNode;
            currentNode=currentNode.getNextNode();
        }
        X nodeItem=currentNode.getNodeItem();
        prevNode.setNextNode(currentNode.getNextNode());
        nodeCount--;
        return nodeItem;

    }
    public X get(int position){
        if(first==null){
            throw new IllegalStateException("Empty");
        }
        Node currentnode=first;
        for (int i = 1; i < size() ; i++) {
            if(i==position){
                return currentnode.getNodeItem();

            }
        }
        return null;

    }
    public int find(X item){
        if(first==null){
            throw new IllegalStateException("Empty");
        }
        Node currentNode=first;
        for (int i = 0; i < size() && currentNode!=null ;i++) {
            if(currentNode.getNodeItem().equals(item)){
                return i;
            }
        }
        return  -1;
    }

    private class Node {
        private Node nextNode;
        private X nodeItem;

        public Node(X item) {
            this.nextNode = null;
            this.nodeItem = item;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public X getNodeItem() {
            return nodeItem;
        }
    }
}
