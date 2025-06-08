package com.leetcode;

public class Leetcode1349 {
    public int maxStudents(char[][] seats) {


        int count =0;

        for(int i=0;i<seats.length;i++)
        {
           for( int j=0;j<seats[0].length;j++)
            {
                if(seats[i][j]=='.'){
                    if(isLeftGood(seats, i, j) && isRightGood(seats, i, j) && isUpperLeftGood(seats, i, j) && isUpperRightGood(seats, i, j)) count++;
                }
            }
        }

        return count;
    }

    private boolean isLeftGood(char[][] seats, int i, int j) {
        if(j==0 || (j>0 && seats[i][j-1]=='#')) return true;//wall
        else return false;
    }
    private boolean isRightGood(char[][] seats, int i, int j) {
        if(j==seats.length-1 || (j<seats.length && seats[i][j+1]=='#')) return true;//wall
        else return false;
    }
    private boolean isUpperLeftGood(char[][] seats, int i, int j)
    {
        if((j==0) || ((i-1)>=0 && (j-1)>=0 && seats[i-1][j-1]=='#')) return true;
        else return false;
    }
    private boolean isUpperRightGood(char[][] seats, int i, int j)
    {
        if((j==seats.length-1) || ((i-1)>=0 && (j+1)<seats.length && seats[i-1][j+1]=='#') ) return true;
        else return false;
    }
}
