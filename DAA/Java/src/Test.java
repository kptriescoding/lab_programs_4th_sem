import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<10;i++)
            arr.add(i);
        ArrayList<Integer> arr2=arr;
        arr2.set(1,100);
        for(int i=0;i<10;i++)
            System.out.print(arr2.get(i)+" ");
        System.out.println();
        for (int i=0;i<10;i++)
            System.out.print(arr.get(i)+" ");
        System.out.println();

    }
}
