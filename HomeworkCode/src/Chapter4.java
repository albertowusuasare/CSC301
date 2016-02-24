import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


    static class Pair<K,V>{
        K key;
        V value;

        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public String toString(){
            return "{ " + key.toString() + "," + value.toString() + "}";
        }
    }

    public static void main (String [] args){
        //Test partitionSequence
        int [] sequence = {2,4,6,8};
        List<Pair> pairs = partitionSequence(sequence);
        System.out.println(pairs);
    }
}
