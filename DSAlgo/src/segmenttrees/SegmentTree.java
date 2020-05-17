package segmenttrees;

import java.util.function.BiFunction;
import java.util.function.Function;

public class SegmentTree<T,E> {
    public T[] segmentTree;
    public BiFunction<T,T,T> operator;
    public SegmentTree(T[] segmentTree,BiFunction<T,T,T> operator){
        this.segmentTree = segmentTree;
        this.operator = operator;
    }

    //Method to build the Segment Tree
    //Data type of Segment Tree might be different from data type of Input, using leaf operator to retrieve desired values
    public void build(E[] input, int index, int start, int end, Function<E,T> leafOperator){
        if(start==end){
            segmentTree[index] = leafOperator.apply(input[start]);
            return;
        }
        int mid = start + (end - start)/2;
        build(input,2*index,start,mid,leafOperator);
        build(input,2*index+1,mid+1,end,leafOperator);
        segmentTree[index] = operator.apply(segmentTree[2*index],segmentTree[2*index+1]);
    }

    //Method to update Segment Tree
    public void update(int index,int start,int end,int updateIndex,E value,Function<E,T> leafOperator){
        if(start == end){
            if(start == updateIndex){
                segmentTree[index] = leafOperator.apply(value);
            }
            return;
        }
        int mid = start + (end-start)/2;
        if(updateIndex>mid){
            update(2*index+1,mid+1,end,updateIndex,value,leafOperator);
        }else{
            update(2*index,start,mid,updateIndex,value,leafOperator);
        }
        segmentTree[index] = operator.apply(segmentTree[2*index],segmentTree[2*index+1]);
    }

    //Method to query Segment Tree
    public T query(int index, int start, int end, int rangeStart, int rangeEnd){
        if(start==end){
            return segmentTree[index];
        }
        int mid = start + (end-start)/2;
        if(rangeStart<=start && rangeEnd>=end){
            return segmentTree[index];
        }else if(rangeStart<=mid && rangeEnd>mid){
            return operator.apply(query(2*index,start,mid,rangeStart,rangeEnd),
                    query(2*index+1,mid+1,end,rangeStart,rangeEnd));
        }else if(rangeStart>mid){
            return query(2*index+1,mid+1,end,rangeStart,rangeEnd);
        }else {
            return query(2*index,start,mid,rangeStart,rangeEnd);
        }
    }
}
