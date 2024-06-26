package _240621;

import java.lang.reflect.Array;
import java.util.*;

public class ArraySortTest {

    public static void main(String[] args) {
        List<Item> list = new ArrayList<>();
        list.add(new Item(3, "666"));
        list.add(new Item(2, "777"));
        list.add(new Item(5, "444"));
        list.add(new Item(3, "111"));

        System.out.println(list);
        Collections.sort(list, (el1, el2) -> el1.itemId - el2.itemId);
        Collections.sort(list, (el1, el2) -> el1.itemNm.compareTo(el2.itemNm));


//        int[] intArray = { 3, 5, 2, 7, 9, 4};
//        Arrays.sort(intArray);
//        System.out.println(Arrays.toString(intArray));

        String[] strArray={"Hello", "ABC", "WORLD", "UPLUS"};
        Arrays.sort(strArray, Collections.reverseOrder());
        System.out.println(Arrays.toString(strArray));

        Item[] itemArray = {
                new Item(3, "666"), new Item(2, "777"), new Item(5,"444"), new Item(3, "111")
        };


        // implements Comparable
        // 정렬 방법 1
        // Arrays.sort(itemArray);

        // Comparator interface 객체 전달
        // 정렬하기 위한 방법2: Comparator 객체 전달(익명) // 대상 객체에 Comparable 구현 없어도 된다.
        Arrays.sort(itemArray, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                //return o1.itemId - o2.itemId;
                return o1.itemNm.compareTo(o2.itemNm); // 문자니까 compareTo
            }
        });

        // 정렬하기 위한 방법3: Comparator 객체 전달(Lamda) // 대상 객체에 Comparable 구현 없어도 된다.
        // 람다식: 매개변수 -> 리턴값
        // 오름차순 o1 o2 -> o1 - o2 / 내림차순 o1 o2 -> o2 - o1
        Arrays.sort(itemArray, (o1, o2) -> o1.itemId - o2.itemId);

        System.out.println(Arrays.toString(itemArray));
    }

    // 정렬이 되기 위한 방법 1: Comparable interface 구현
    static class Item implements Comparable<Item> {
        int itemId;
        String itemNm;

        Item(int itemId, String itemNm){
            this.itemId=itemId;
            this.itemNm = itemNm;
        }

        @Override
        public String toString(){
            return "Item [itemId=" + itemId + ", itemNm=" +itemNm+"]";
        }

        @Override
        public int compareTo(Item o) {
            // this 객체하고 아이템 o 기준으로 어떻게 정렬?

            //return this.itemId - o.itemId; // itemId asc : 앞에꺼에서 뒤에꺼 빼기
            // desc은 반대로 부호 붙이면 됨

            //return this.itemNm.compareTo(o.itemNm); //itemNm 기준

            //itemId 우선 비교, 같으면 itemNm 비교
            return this.itemId == o.itemId ? this.itemNm.compareTo(o.itemNm) : this.itemId - o.itemId;

        }
    }
}
