import java.util.*;

public class FrequencySort {

    /*
    Given an array of integers, sort the array according to frequency of elements and print elements
    in increasing frequency.

    For example, if the input array is {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12},
    then modify the array to {4, 5, 12, 12, 2, 2, 2, 3, 3, 3, 3}

    If 2 numbers have same frequency then order them in increasing order
    */


    public static void main(String[] args) {
        int[] arr1 = { 5, 3, 1, 2, 2, 2, 2, 2, 2, 2, 6, 6, 6, 6, 6, 5, 4 };
        arr1 = frequencySort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12};
        arr2 = frequencySort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {1, 3, 7, 4, 5, 2, 8, 11, -99, 10000};
        arr3 = frequencySort(arr3);
        System.out.println(Arrays.toString(arr3));
    }

    public static int[] frequencySort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Arr must not be null");
        }

        if (arr.length == 0 || arr.length == 1) {
            return arr;
        }

        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> uniqueNums = new ArrayList<>();

        int highestFreq = 1;

        // Create mapping between numbers in array and their frequencies
        for (int num : arr) {
            if (map.containsKey(num)) {
                int freq = map.get(num) + 1;
                map.put(num, freq);
                if (highestFreq < freq) {
                    highestFreq = freq;
                }
            } else {
                map.put(num, 1);
                uniqueNums.add(num);
            }
        }

        // Sort unique nums so we sort numbers with same frequencies in increasing order
        Collections.sort(uniqueNums);

        int freqCount = 1;
        int index = 0;

        // Sort the array in order of frequencies
        while (highestFreq >= freqCount) {
            for (int num : uniqueNums) {
                if (map.get(num) == freqCount) {
                    for (int i = index; i < index + freqCount; i++) {
                        arr[i] = num;
                    }
                    index += freqCount;
                }
            }
            freqCount++;
        }
        return arr;
    }
}
