package interview.xcc.linkedin;

import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 3/25/14
 * Time: 10:27 PM
 */
public class ShuffleArray
{
    public void shuffle(int[] arr)
    {
        Random rand = new Random();
        for(int i = 0; i < arr.length; ++i)
        {
            swap(arr, i, rand.nextInt(arr.length));
        }
    }

    // searched onlin after interview - Fisher-Yates Shuffle
    public void fyShuffle(int[] arr)
    {

    }

    public void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        ShuffleArray sa = new ShuffleArray();
        sa.shuffle(arr);

        System.out.println(Arrays.toString(arr));
    }
}
