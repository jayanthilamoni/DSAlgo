package segmenttrees;

import java.util.Scanner;

public class Utility {
    static Scanner sc = new Scanner(System.in);
    public static int getAInteger(){
        return sc.nextInt();
    }
    public static String[] getStringArray(){
        int size = getAInteger();
        String[] in = new String[size];
        for (int i=0;i<size;i++){
            in[i] = sc.next();
        }
        return in;
    }
    public static int[][] get2DIntArray(){
        int x = getAInteger();
        int y = getAInteger();
        int[][] val = new int[x][y];
        for (int i=0;i<x;i++){
            for (int j=0;j<y;j++){
                val[i][j] = getAInteger();
            }
        }
        return val;
    }
    public static Integer[] getIntegerArray(){
        int size = sc.nextInt();
        Integer[] input = new Integer[size];
        for(int i=0;i<size;i++){
            input[i] = sc.nextInt();
        }
        return input;
    }
}
