package queued;

public class BasicQueue<X> {
    private X[]data;
    private int front;
    private int end;
    public BasicQueue() {
        this(1000);

    }
    public BasicQueue(int size) {
        this.front=-1;
        this.end=-1;
        data=(X[])new Object[size];

    }
    public int size(){
        if(front==-1 && end ==-1){
            return 0;
        }
        else{
            System.out.println("front: "+front+" end: "+end);
            return end-front +1;
        }

    }
    public void enQueue(X item){
        if((end+1)%data.length==front){
            throw new IllegalStateException("Queue is full");
        }
        else if(size()==0){//if any other items have been added
            front++;
            end++;
            data[end]=item;
        }
        else {
            end++;
            data[end]=item;
        }

    }
    public X deQueue(){
        X item=null;
        //is queue empty
        if(size()==0){
            throw new IllegalStateException("Queue is Empty");

        }
        //if is last item
        else if(front==end){
            item=data[front];
            data[front]=null;
            front=-1;
            end=-1;
        }
        else{
            //return the first item : adjust front pointer
            item=data[front];
            data[front]=null;
            front++;
        }
        return item;

    }
    public boolean contains(X item){
        boolean found=false;
        //if empty
        if(size()==0){
            return found;

        }
        else{
            for (int i = front; i <end ; i++) {
                if(data[i].equals(item)){
                    found=true;
                    break;
                }

            }
        }
        return found;
    }

    public X access(int position){
        if(size()==0 ||position>size()) {
            throw new IllegalStateException("Queue is Empty or item not in Queue ");
        }
        int trueIndex=0;
        for (int i = front; i <end ; i++) {
            if(trueIndex==position){
                return data[i];
            }
            trueIndex++;
        }
        throw new IllegalStateException("Item not found in Queue ");

    }
}
