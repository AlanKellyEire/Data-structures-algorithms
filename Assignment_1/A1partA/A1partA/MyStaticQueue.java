

public class MyStaticQueue implements MyQueue {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------
    private int maxItems;
    private int[] items;
    private int numItems;

    private int getMaxItems() {
        return maxItems;
    }

    private void setMaxItems(int maxItems) {
        this.maxItems = maxItems;
    }

    public int getNumItems() {
        return numItems;
    }

    private void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    private void increNumItems() {
        this.numItems += 1;
    }

    private void decreNumItems() {
        this.numItems -= 1;
    }

    private int[] getItems() {
        return items;
    }

    private int getItemsElement(int i) {
        return items[i];
    }

    private void setItems(int[] items) {
        this.items = items;
    }

    //-------------------------------------------------------------------
    // Basic Operation --> Check if myQueue is empty: myCreateEmpty
    //-------------------------------------------------------------------
    public MyStaticQueue(int m){
        setMaxItems(m);
        setItems(new int[m]);
        setNumItems(0);
    }

    //-------------------------------------------------------------------
    // Basic Operation --> Check if MyQueue is empty: isEmpty
    //-------------------------------------------------------------------
    public boolean isEmpty(){
        if(getNumItems()!= 0){
            return false;
        }

        return true;
    }

    //-------------------------------------------------------------------
    // Basic Operation (Partial) --> Get first element from front of MyQueue: first
    //-------------------------------------------------------------------
    public int first(){
        if(isEmpty()) {
            p("error array is empty");
            return -1;
        }
        else {
            return getItemsElement(0);
        }
    }

    //-------------------------------------------------------------------
    // Basic Operation (Partial) --> Add element to back of MyQueue: add
    //-------------------------------------------------------------------
    public void add(int element){

        if(getNumItems() != getMaxItems()){
            for (int i = 0; i < getItems().length; i++) {
                if(getItems()[i] == 0){
                    getItems()[i] = element;
                    increNumItems();
                    break;
                }
            }
        }
        else{
            p("Error Queue Already Full");
        }
    }

    //-------------------------------------------------------------------
    // Basic Operation (Partial) --> Remove element from front of MyQueue: remove
    //-------------------------------------------------------------------
    public void remove(){
        if(getNumItems() <= 0) {
            p("Error Queue Already empty");
        }

        else {
            for (int i = 0; i < (getNumItems() - 1); i++) {
                getItems()[i] = getItems()[i + 1];
            }
            getItems()[getNumItems() - 1] = 0;
            decreNumItems();
        }

    }

    public void p(String s){
        System.out.println(s);
    }

    public void pError(String s){
        System.err.println(s);

    }

    public void printList(){
        p("\n\n");
        for(int i = 0; i < getNumItems(); i++){
            p("element "+ i +" in list item =" + getItems()[i]);
        }
    }

}
