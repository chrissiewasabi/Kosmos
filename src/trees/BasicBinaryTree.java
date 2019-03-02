package trees;

public class BasicBinaryTree<X extends Comparable<X>> {

    private Node root;
    private int size;

    public BasicBinaryTree() {
        this.root=null;
    }

    public int size(){
        return size;
    }
    public void add(X item){
        Node node=new Node(item);
        if(root==null){
            this.root=node;
            System.out.println("Setting Root: "+ node.getItem());
            this.size++;
        }
        else{
            insert(this.root,node);
        }

    }

    private void insert(Node parent,Node child){
        if(child.getItem().compareTo(parent.getItem())<0){
            if(parent.getLeft()==null){
                parent.setLeft(child);
                child.setParent(parent);
                this.size++;
            }
            else{
                insert(parent.getLeft(),child);
            }
        }
    }
    public boolean contains(X item){
        Node currentNode=getNode(item);
        if(currentNode==null){
            return  false;
        }
        else{
           return true;
        }

    }
    private Node getNode(X item){
        Node currenNode=this.root;
        while(currenNode!=null){
            int val=item.compareTo(currenNode.getItem());

            if(val==0){
                return currenNode;
            }
            else if(val <0){
                currenNode=currenNode.getLeft();
            }
            else{
                currenNode=currenNode.getRight();
            }
        }
        return null;
    }


    public boolean delete(X item){
        //find node and unlink it
        boolean deleted=false;
        if(this.root==null){
            return false;
        }
        Node currentNode=getNode(item);
        if(currentNode!=null){
            //no children on node
            if(currentNode.getLeft()==null && currentNode.getRight()==null){
                unlink(currentNode,null);
                deleted=true;
            }
            //only has a right child
            else if(currentNode.getLeft()==null && currentNode.getRight()!=null){
                unlink(currentNode,currentNode.getRight());
                deleted=true;
                //only has a left child
            } else if (currentNode.getLeft()!=null&& currentNode.getRight()==null) {
                unlink(currentNode,currentNode.getLeft());
                deleted=true;
            }
            //node has both children
            else{
                Node child=currentNode.getLeft();
                while(child.getRight()!=null && child.getLeft()!=null){
                    child=child.getRight();
                }
                child.getParent().setRight(null);
                child.setLeft(currentNode.getLeft());
                child.setRight(currentNode.getRight());

                unlink(currentNode,child);
                deleted=true;
            }
        }
        return deleted;
    }
    private void unlink(Node currentNode,Node newNode){
        if(currentNode==this.root){
            newNode.setLeft(currentNode.getLeft());
            newNode.setRight(currentNode.getRight());
            this.root=newNode;
        }else if(currentNode.getParent().getRight()==currentNode){
            currentNode.getParent().setRight(newNode);
        }
        else{
            currentNode.getParent().setLeft(newNode);
        }
    }
    private class Node{
        private Node left;
        private  Node right;
        private  Node parent;
        private X item;

        public Node(X item) {
            this.item = item;
            this.left=null;
            this.right=null;
            this.parent=null;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public X getItem() {
            return item;
        }

        public void setItem(X item) {
            this.item = item;
        }
    }
}
