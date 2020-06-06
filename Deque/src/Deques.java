public class Deques{
    private int dequeSize;
    private String[] dequeArray;
    private int top;
    private int bot;

    public Deques(int n){
        this.dequeSize = n;
        this.dequeArray = new String[dequeSize];
        this.top = -1;
        this.bot = 0;
    }

    public void addFirst(String element){
        dequeArray[++top] = element;
    }

    public void addLast(String element){
        for (int i = top+1; i > 0; i--) {
            dequeArray[i] = dequeArray[i - 1];
        }
        dequeArray[bot] = element;
        top++;
    }

    public String deleteFirst(){
        return dequeArray[top--];
    }

    public String deleteLast(){
        String temp = dequeArray[0];
        for (int i = 0; i < top; i++) {
            dequeArray[i] = dequeArray[i + 1];
        }
        top--;
        return temp;
    }

    public String getFirst(){
        return dequeArray[top];
    }

    public String getLast(){
        return dequeArray[bot];
    }

    public boolean isEmpty(){
        return (top + 1 == bot);
    }

    public boolean isFull(){
        return (top == dequeSize - 1);
    }
    public String pollFirst(){
        String elem=this.getFirst();
        deleteFirst();
        return elem;
    }
    public String pollLast(){
        String elem=this.getLast();
        deleteLast();
        return elem;
    }
}
