package p1;

import java.util.Scanner;

public class P1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        MyDDLLwithHandT list1 = new MyDDLLwithHandT(19, 61);
        MyDDLLwithHandT list2 = new MyDDLLwithHandT(19, 61);
        MyDDLLwithHandT list3;
        MyDDLLwithHandT list4 = new MyDDLLwithHandT(19, 61);
        generate(list1, 10, 20, 60);
        System.out.println("--------------- List 1 -----------------");
        list1.print();
        generate(list2, 15, 20, 60);
        System.out.println("--------------- List 2 -----------------");
        list2.print();
        list3 = list1.merge(list2);
        System.out.println("--------------- List 3 -----------------");
        list3.print();
        insertNonCom(list1, list2, list4);
        System.out.println("--------------- List 4 -----------------");
        list4.print();

        System.out.println("------------ list1 evenAvg -------------");
        System.out.println(evenAvg(list1));

    }

    public static void generate(MyDDLLwithHandT list, int v, int min, int max) {
        int element;
        for (int i = 0; i < v;) {
            element = min + (int) (Math.random() * (max - min + 1));
            if (list.search(element) == null) {
                list.insert(element);
                i++;
            }
        }
    }

    public static double evenAvg(MyDDLLwithHandT list) {
        double sum = 0;
        // int count=0;
        for (Dnode ptr = list.getHead().getNext(); ptr != list.getTail(); ptr = ptr.getNext()) {
            if (ptr.getInfo() % 2 == 0) {
                sum += ptr.getInfo();
                //count++;
            }
        }
        if (list.countDivByV(2) != 0) {
            return sum / list.countDivByV(2); 
            // return sum/count;
        } else {
            return 0;
        }
    }

    public static void insertNonCom(MyDDLLwithHandT L1, MyDDLLwithHandT L2, MyDDLLwithHandT L3) {
        for (Dnode p1 = L1.getHead().getNext(); p1 != L1.getTail(); p1 = p1.getNext()) {
            if (L2.search(p1.getInfo()) == null) {
                L3.insert(p1.getInfo());
            }
        }
        for (Dnode p1 = L2.getHead().getNext(); p1 != L2.getTail(); p1 = p1.getNext()) {
            if (L1.search(p1.getInfo()) == null) {
                L3.insert(p1.getInfo());
            }
        }
    }

}
