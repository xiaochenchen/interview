package interview.xcc.square;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: lightsaber
 * Date: 3/26/14
 * Time: 6:36 PM
 */
public class ConwayGameOfLife
{
    public static void main(String[] args) {
        ConwayGameOfLife s = new ConwayGameOfLife();
        s.init();
        s.printCurrentGeneration();
        s.nextGeneration();
        s.printCurrentGeneration();
        s.nextGeneration();
        s.printCurrentGeneration();
    }

    final int GSIZE = 5;

    int[][] currentGrid = new int[GSIZE][GSIZE];
    int[][] nextGrid = new int[GSIZE][GSIZE];

    public void init()
    {
        currentGrid[1][2] = 1;
        currentGrid[2][2] = 1;
        currentGrid[3][2] = 1;
    }

    public void printCurrentGeneration()
    {
        System.out.println(Arrays.deepToString(currentGrid));
    }

    public void nextGeneration()
    {
        for(int i = 0; i < GSIZE; ++i)
        {
            for(int j = 0; j < GSIZE; ++j)
            {
                int liveCount = 0;

                // (i-1, j-1), (i-1, j), (i-1, j+1)
                // (i, j-1), (i+1, j+1)
                // (i+1, j-1), (i+1, j), (i+1, j+1)

                // check the row above the current row
                if(i > 0)
                {
                    if(j > 0)
                    {
                        if(currentGrid[i-1][j-1] == 1) liveCount++;
                    }
                    if(currentGrid[i-1][j] == 1) liveCount++;
                    if(j < GSIZE - 1)
                    {
                        if(currentGrid[i-1][j+1] == 1) liveCount++;
                    }
                }

                // check current row
                if(j > 0)
                {
                    if(currentGrid[i][j-1] == 1) liveCount++;
                }

                if(j < GSIZE - 1)
                {
                    if(currentGrid[i][j+1] == 1) liveCount++;
                }

                // check the row below current row
                if(i < GSIZE - 1)
                {
                    if(j > 0)
                    {
                        if(currentGrid[i+1][j-1] == 1) liveCount++;
                    }
                    if(currentGrid[i+1][j] == 1) liveCount++;
                    if(j < GSIZE - 1)
                    {
                        if(currentGrid[i+1][j+1] == 1) liveCount++;
                    }
                }

                if(liveCount < 2)
                {
                    nextGrid[i][j] = 0;
                }
                else if(liveCount == 2 && currentGrid[i][j] == 1)
                {
                    nextGrid[i][j] = 1;
                }
                else if(liveCount == 3)
                {
                    nextGrid[i][j] = 1;
                }
                else
                {
                    nextGrid[i][j] = 0;
                }
            }
        }

        // swap current and next grid
        int[][] temp = currentGrid;
        currentGrid = nextGrid;
        nextGrid = temp;
    }
}
