###Homework 6
--------
####Questions 4.3, 4.5, 4.13,4.14,4.16,4.18,4.21

#### 4.3
-------
```java
public static List<Pair> partitionSequence(int [] sequence){
        Arrays.sort(sequence);
        int i = 0; int j = sequence.length -1;
        List<Pair> pairs = new ArrayList<>();
        while (i < j){
            Pair newPair = new Pair(sequence[i],sequence[j]);
            pairs.add(newPair);
            i++;
            j--;
        }
        return pairs;
    }
```

#### 4.5
-------
```java
    public static int findMode(int [] sequence){
        int mode;
        Map<Integer,Integer> frequencyMap= new HashMap<>();
        int sequenceLength = sequence.length;
        for(int i= 0; i < sequenceLength ; i++){
            int key = sequence[i];
            Integer frequency;
            if((frequency = frequencyMap.get(key)) == null){
                frequency = 1;
            }
            else {
                frequency = frequency +1;
            }
            frequencyMap.put(key,frequency);
        }
        System.out.println(frequencyMap);
        mode = getMode(frequencyMap);
        return mode;
    }


    private static <K,V> int getMode(Map<Integer, Integer> frequencyMap){
        int mode = Integer.MIN_VALUE;
        int value =0;
        Set<Map.Entry<Integer,Integer>> entrySet = frequencyMap.entrySet();
        for(Map.Entry<Integer,Integer> entry : entrySet){
            int mapValue;
            if ((mapValue =entry.getValue()) > mode){
                mode = mapValue;
                value = entry.getKey();
            }
        }
        return value;
    }
```
#### 4.13
-------
You wish to store a set of n numbers in either a max-heap or a sorted array.
For each application below, state which data structure is better, or if it does not
matter. Explain your answers.

+  Want to find the maximum element quickly.
max-heap: constant time to access maximum element
+ Want to be able to delete an element quickly.
sorted-array: Allows you to use binary search and find an item in O(log n) time
+ Want to be able to form the structure quickly.
sorted-array: With heaps you will have to make sure the heap property is always intact and that takes more operations averagely to do
+ Want to find the minimum element quickly.
sorted-array : We can use binary search on a sorted array in O(log n) time but with a max heap we have to search through all the elements
