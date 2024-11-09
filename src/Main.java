import BasicSortsAndShuffle.InsertionSort;
import PriorityQueueAndHeapSort.Heapsort;
import QuicksortAndMergesort.Mergesort;
import QuicksortAndMergesort.Quicksort;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Selection;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //In in = new In("algs4-testcase\\sortTestcase\\sort1_oneHundredThousand"); // tạo luồng đọc từ file
        //In in = new In("algs4-testcase\\sortTestcase\\sort2_random"); // tạo luồng đọc từ file
        //In in = new In("algs4-testcase\\sortTestcase\\sort3_ascending"); // tạo luồng đọc từ file
        //In in = new In("algs4-testcase\\sortTestcase\\sort4_descending"); // tạo luồng đọc từ file
        In in = new In("algs4-testcase\\sortTestcase\\sort5_equals"); // tạo luồng đọc từ file

        String[] file = in.readAllStrings();
        String[] a = new String[file.length];  // đọc toàn bộ file vào mảng a
        for (int i = 0; i < file.length; i++) {
            a[i] = file[i];  // chuyển đổi `double` thành `Double`
        }
        long start = System.currentTimeMillis();
        //InsertionSort.sort(a);
        //Selection.sort(a);
        //Mergesort.sort(a);
        //Quicksort.sortByHoare(a);
        //Quicksort.sortbyLomuto(a);
        //Heapsort.sortBySink(a);
        long end = System.currentTimeMillis();  // thời gian chạy bằng end - start
        //StdArrayIO.print(a); // in mảng ra màn hình
        //System.out.println(end - start);
        String s = "This is a test. This test is only a test.";
        Solution.solve(s);
        sc.close();
    }
}
