package segmenttrees;

import java.util.function.BiFunction;
import java.util.function.Function;

//Driver class to check the minimum length of a string in given range
public class TestSegmentTreeOnString {
    SegmentTree<Integer,String> minLengthTree;
    public static void main(String[] args) {
        TestSegmentTreeOnString test = new TestSegmentTreeOnString();
        String[] input = Utility.getStringArray();
        BiFunction<Integer,Integer,Integer> operator = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return Math.min(integer,integer2);
            }
        };
        test.minLengthTree = new SegmentTree<>(new Integer[4*input.length],operator);
        test.minLengthTree.build(input, 1, 0, input.length - 1, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        });
        int[][] queries = Utility.get2DIntArray();
        for (int[] query : queries){
            System.out.println(test.minLengthTree.query(1,0,input.length-1,query[0]-1,query[1]-1));
        }
    }
}
