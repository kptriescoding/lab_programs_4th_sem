import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Program9 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayListOper oper = new ArrayListOper();
        System.out.println("Enter the num of colors");
        int n  = s.nextInt();
        s.nextLine();
        System.out.println("Enter colors one by one");
        for(int i = 0;i<n;i++) oper.add(s.nextLine());

        String[] arr = oper.toArray();
        System.out.println("To arrayed array is");
        for (String str : arr) System.out.print(str + " ");
        System.out.println();

        ArrayList<String> rev = oper.reverse();
        System.out.println("The reversed list is ");
        System.out.println(rev);

        ArrayList<String> sorted = oper.getSorted();
        System.out.println("The sorted list is ");
        System.out.println(sorted);

        int sI,eI;
        System.out.println("Enter start index and end index off sublist you want to get");
        sI = s.nextInt();
        eI = s.nextInt();
        List<String> sL = oper.subList(sI, eI);
        System.out.println("The subList of the given array from "+sI+" to "+eI+" index is");
        System.out.println(sL);

        ArrayList<String> cloned = oper.getClone();
        System.out.println("The cloned list is");
        System.out.println(cloned);
    }
}

class ArrayListOper {
    private ArrayList<String> colors;

    public ArrayListOper() {
        this.colors = new ArrayList<>();
    }

    public void add(String color) {
        colors.add(color);
    }

    public String[] toArray() {
        String[] arr = new String[colors.size()];
        colors.toArray(arr);
        return arr;
    }

    public ArrayList<String> reverse() {
        ArrayList<String> ret = new ArrayList<>(colors);
        Collections.reverse(ret);
        return ret;
    }

    public ArrayList<String> getSorted() {
        ArrayList<String> ret = new ArrayList<>(colors);
        Collections.sort(ret);
        return ret;
    }

    public List<String> subList(int sI, int eI) {
        return colors.subList(sI, eI);
    }

    public ArrayList<String> getClone() {
        return (ArrayList<String>) colors.clone();
    }

}
