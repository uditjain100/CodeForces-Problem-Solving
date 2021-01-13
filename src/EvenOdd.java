import java.util.*;

public class EvenOdd {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scn.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++)
                arr[j] = scn.nextInt();
            fun(arr);
        }
    }

    public static void fun(int[] arr) {

        long as = 0;
        long bs = 0;

        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        for (int ele : arr)
            if (ele % 2 == 0)
                even.add(ele);
            else
                odd.add(ele);

        Collections.sort(even, Collections.reverseOrder());
        Collections.sort(odd, Collections.reverseOrder());

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < even.size() && j < odd.size()) {
            if (k % 2 == 0L) {
                if (odd.get(j) > even.get(i))
                    j++;
                else
                    as += even.get(i++);
            } else {
                if (odd.get(j) < even.get(i))
                    i++;
                else
                    bs += odd.get(j++);
            }
            k++;
            k %= 2;
        }

        while (i < even.size()) {
            if (k % 2 == 0)
                as += even.get(i);
            k++;
            k %= 2;
            i++;
        }
        while (j < odd.size()) {
            if (k % 2 != 0)
                bs += odd.get(j);
            k++;
            k %= 2;
            j++;
        }
        if (as > bs)
            System.out.println("Alice");
        else if (bs > as)
            System.out.println("Bob");
        else
            System.out.println("Tie");
    }

}
