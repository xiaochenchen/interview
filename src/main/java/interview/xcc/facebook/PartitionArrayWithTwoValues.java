package interview.xcc.facebook;

import java.util.Arrays;

/**
 * Given an integer array a[], and one left partition value lv, one right partition value rv
 * so that after partition, all elements smaller than lv will be left to elements between lv and rv
 * and all elements greater than rv will be to the right most of the array
 *
 * for example
 *
 * int a[] = {2,9,6,1,5,8}; int lv = 4; int rv = 7
 * after partition, a will be
 * a[] = {2,1,6,5,9,8}
 *
 * Created by Maximus on 3/20/14.
 */
public class PartitionArrayWithTwoValues
{
    public void partition(int[] a, int lv, int rv)
    {
        int lb = 0;
        int rb = a.length;

        int cur = 0;

        while(cur <= rb)
        {
            if(a[cur] > rb)
            {
                swap(a, cur, rb--);
            }
            else if(a[cur] < lb)
            {
                swap(a, cur++, lb++);
            }
            else
            {
                cur++;
            }
        }
    }

    private void swap(int a[], int x, int y)
    {
        if(x < 0 || y < 0 || x >= a.length || y >= a.length || x == y)
        {
            return;
        }

        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void main(String[] args)
    {
        // test
        int[] a = {2,9,4,28,6,11,15,1};
        int lb = 5, rb = 10;
        PartitionArrayWithTwoValues p = new PartitionArrayWithTwoValues();
        System.out.println(Arrays.toString(a));
        p.partition(a, lb, rb);
        System.out.println(Arrays.toString(a));
    }
}
