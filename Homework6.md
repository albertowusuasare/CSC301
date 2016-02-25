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

#### 4.14
-------

We can imagine our k sorted lists as buckets with the elements in it sorted such that the smallest element is on the top level in the bucket. We shall utilise the a min-heap data structure in sorting all the n elements spread into the k buckets. Recall that  that for a min-heap of 'e' entries, the order for the extraction(find and remove) of the minimum element is O(log e). Recall also the insertion of an item into the heap is of the order O(log e).

Our algorithm then is as follows:

1. Insert the top level of the buckets into the heap. Thus insert all the smallest elements of our buckets into the heap. The order of this operation is O(k log k) since there are k buckets and for each bucket the insertion costs logarithmic time.
2. At each index in our final array (the array we will put our final sorted elements in), we extract the minimum from the heap and then insert the min heap element into that index in the final array. 
3. We then go back to the bucket from which the element we inserted into our final array was from ( we need to encapsulate the bucket location together with the value at  in a structure to put in the heap). We insert the next smallest element of that bucket to the heap. 
4. We repeat 2 and 3 until we have filled the entire n elements of our final array. Note that because we go through the n elements and perform heap insert operations at each index. We have a contributing cost of O(n log k).


Overall our cost is of the form  O(k log k) + O(n log k). = O (n log k) since n >= k

#### 4.18
-------

```java
  public static String [] partitionColors (String [] arr){
        final String WHITE = "w";
        final String RED = "r";
        final String BLUE = "b";
        int redWhite = 0;
        int whiteBlue = arr.length-1;
        int arrLength = arr.length;
        for (int i = 0; i < arrLength; i++ ){
            String examinedValue = arr[i];
            if( redWhite < whiteBlue) {
                if (examinedValue.equals(RED)) {
                    swap(arr, i, redWhite);
                    redWhite++;
                    i--;
                }

                if (examinedValue.equals(BLUE)) {
                    swap(arr, i, whiteBlue);
                    whiteBlue--;
                    i--;
                }
            }
        }
        return arr;
    }

    private static <T> void swap(T [] arr, int i, int j){
        T val = arr[i];
        arr[i] = arr[j];
        arr[j] = val;
    }
```
#### 4.21
-------

During merging the algorithm should settle key equality by checking to see which key occured first in the original array. In order to know which key occured first, we can have a wrap around object that will encapsulate both a key and the index in the original array that the key is. This will take up more space but we dont lose in time complexity.
