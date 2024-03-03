package task5package;


public class LLNode<T> {
    protected T info; // information stored in list
    protected LLNode<T> link; // reference to a node

    public LLNode(T info) {
        this.info = info;
        link = null;
    }
   public void setInfo(T info) {
        this.info = info;
   }
   public T getInfo() {
        return info;
   }

   public void setLink(LLNode<T> link) {
        this.link = link;
   }
   public LLNode<T> getLink() {
        return link;
   }


}
