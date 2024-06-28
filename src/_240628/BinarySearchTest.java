package _240628;

import java.util.Arrays;

public class BinarySearchTest {
    public static void main(String[] args) throws Exception {
        // 인덱스 0, 1, 2, 3, 4
        // {   -1 -2 -3
        int[] arr = {1, 3, 5, 7, 9};
        System.out.println(Arrays.binarySearch(arr, 1)); // 인덱스 출력됨
        System.out.println(Arrays.binarySearch(arr, 2)); // -2가 됨 없는데 어디에 있어야 할지 위치를 나타냄
        System.out.println(Arrays.binarySearch(arr, 0)); // -1이 됨

    }
}
