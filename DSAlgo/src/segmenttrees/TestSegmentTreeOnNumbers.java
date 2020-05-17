package segmenttrees;

import java.util.function.BiFunction;
import java.util.function.Function;

//Driver class to check number of odd numbers in a Range
public class TestSegmentTreeOnNumbers {
    SegmentTree<Integer,Integer> segmentTree;
    public static void main(String[] args) {
        TestSegmentTreeOnNumbers test = new TestSegmentTreeOnNumbers();
        Integer[] input = Utility.getIntegerArray();
        BiFunction<Integer,Integer,Integer> operator = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a+b;
            }
        };
        Function<Integer,Integer> leafOperator = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer a) {
                return a%2;
            }
        };
        test.segmentTree = new SegmentTree<>(new Integer[4*input.length],operator);
        test.segmentTree.build(input,1,0,input.length-1,leafOperator);
        int[][] queries = Utility.get2DIntArray();
        for (int[] query : queries){
            if(query[0]==1){
                test.segmentTree.update(1,0,input.length-1,query[1]-1,query[2],leafOperator);
            }else if(query[0]==2) {
                System.out.println(test.segmentTree.query(1,0,input.length-1,query[1]-1,query[2]-1));
            }
        }
    }
}
