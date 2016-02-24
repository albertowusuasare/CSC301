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
