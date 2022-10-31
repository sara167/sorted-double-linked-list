package p1;

public class MyDDLLwithHandT {

    private Dnode head = null;
    private Dnode tail = null;

    public Dnode getHead() {
        return head;
    }

    public Dnode getTail() {
        return tail;
    }

    public MyDDLLwithHandT(int x, int y) {
        head = new Dnode(x);
        tail = new Dnode(y);
        head.setNext(tail);
        tail.setBack(head);
    }
//1

    public void insert(int v) {
        Dnode n = new Dnode(v);
        Dnode ptr;
        for (ptr = head.getNext(); ptr.getInfo() < v && ptr != tail; ptr = ptr.getNext());
        ptr.getBack().setNext(n);
        n.setBack(ptr.getBack());
        n.setNext(ptr);
        ptr.setBack(n);
    }

//2
    public Dnode search(int v) {
        for (Dnode ptr = head.getNext(); ptr != tail; ptr = ptr.getNext()) {
            if (v == ptr.getInfo()) {
                return ptr;
            } else if (ptr.getInfo() > v) {
                return null;
            }
        }
        return null;
    }

    //3
    public void delete(int v) {
        Dnode p = search(v);
        if (p != null) {
            p.getBack().setNext(p.getNext());
            p.getNext().setBack(p.getBack());
        } else {
            System.out.println(v + " is not in the list");
        }
    }

    //4
    public void print() {
        for (Dnode ptr = head.getNext(); ptr != tail; ptr = ptr.getNext()) {
            System.out.print(ptr.getInfo() + "  ");
        }
        System.out.println("");
    }

    //5
    public MyDDLLwithHandT merge(MyDDLLwithHandT L2) {
        MyDDLLwithHandT L3 = new MyDDLLwithHandT(19, 61);
        Dnode p1 = head.getNext();
        Dnode p2 = L2.head.getNext();
        while (p1 != tail && p2 != L2.tail) {
            if (p1.getInfo() < p2.getInfo()) {
                if (L3.search(p1.getInfo()) == null) {
                    L3.insert(p1.getInfo());
                }
                p1 = p1.getNext();
            } else {
                if (L3.search(p2.getInfo()) == null) {
                    L3.insert(p2.getInfo());
                }
                p2 = p2.getNext();
            }
        }

        while (p1 != tail) {
            if (L3.search(p1.getInfo()) == null) {
                L3.insert(p1.getInfo());
            }
            p1 = p1.getNext();
        }
        while (p2 != L2.tail) {
            if (L3.search(p2.getInfo()) == null) {
                L3.insert(p2.getInfo());
            }
            p2 = p2.getNext();

        }

        return L3;

    }
    
    // another way , becuase insert method will always put the nodes in a sorted way
    
    public MyDDLLwithHandT merge2(MyDDLLwithHandT L2){
        MyDDLLwithHandT L3 = new MyDDLLwithHandT(19,61);
        for (Dnode ptr = head.getNext(); ptr!=tail ; ptr=ptr.getNext() ){
            if (L3.search(ptr.getInfo())==null)
                L3.insert(ptr.getInfo());
        }
        for (Dnode ptr = L2.head.getNext(); ptr!=L2.tail ; ptr=ptr.getNext() )
            if (L3.search(ptr.getInfo())==null)
            L3.insert(ptr.getInfo());
        return L3;
    }

    public int countDivByV(int v) {
        int count = 0;
        for (Dnode ptr = head.getNext(); ptr != tail; ptr = ptr.getNext()) {
            if (ptr.getInfo() % v == 0) {
                count++;
            }
        }
        return count;
    }
}
