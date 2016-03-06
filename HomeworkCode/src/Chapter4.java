import java.util.*;

/**
 * Created by albertowusu-asare on 2/24/16.
 */
public class Chapter4 {
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

    static class Pair<K,V>{
        K key;
        V value;

        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public int hashCode(){
            return value.hashCode();
        }
        public String toString(){
            return "{ " + key.toString() + "," + value.toString() + "}";
        }
    }

    private static int generateRandomNumber(int low, int high){
        Random r = new Random();
        int result = r.nextInt(high-low) + low;
        return result;
    }
    public static void main (String [] args){
        //Test partitionSequence
        int [] sequence = {2,4,6,8};
        List<Pair> pairs = partitionSequence(sequence);
        System.out.println(pairs);

        System.out.println("4.5 ----------------------------------------------------");
        //Test findMode;
        //int [] modeArr = {4,6,2,4,3,1};
        int [] modeArr = {1,1,1,1,6};
        int mode = findMode(modeArr);
        System.out.println("Mode is :" + mode);

        System.out.println("4.16 ----------------------------------------------------");
        //Test partitionColors
        String [] colors = {"r","w","b"};
        String [] randomColors = new String [10];
        for(int i = 0; i < 10 ; i++){
            String randomColor = colors[generateRandomNumber(0, 3)];
            randomColors[i] = randomColor;
        }
        System.out.println(Arrays.deepToString(randomColors));
        partitionColors(randomColors);
        System.out.println(Arrays.deepToString(randomColors));


    }
}
