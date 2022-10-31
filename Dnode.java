
package p1;

public class Dnode {
    private int info;
    private Dnode next;
    private Dnode back;
    
    public Dnode(int info){
        this.info = info;
        next=null;
        back=null;
    }
    public int getInfo() {
        return info;
    }

    public void setInfo(int Info) {
        this.info = Info;
    }

    public Dnode getNext() {
        return next;
    }

    public void setNext(Dnode next) {
        this.next = next;
    }

    public Dnode getBack() {
        return back;
    }

    public void setBack(Dnode back) {
        this.back = back;
    }
    
    
}
