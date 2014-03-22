package interview.xcc.square;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * Square round 1 phone interview question
 *
 * Given
 *
 *  File1 -> File2, File3 (meaning File1 depend on File2 and File 3)
 *  File2 -> File3
 *  File3 -> File1
 *
 * How do you find out if there is a circular dependency
 *
 * In this case, there is a circular dependency: File1 -> File2 -> File3 -> File1
 *
 * To simplify it is a problem to find if there is a circle inside a graph:
 *  Solution I provided during the interview:
 *  Start from each node, DFS each of it's neighbors, used a set to keep track of visited nodes
 *  if visiting a node that's been visited before, we have a circle, otherwise, there is no circle
 *
 * The interviewer and I discussed an improvement to keep track of temporary result to improve efficiency
 *  for example, if File1->File2->File3->File4 is visited and proved no circle
 *  that means next time when we get to any of these File, we can safely determine there are no circle
 *
 * Created with IntelliJ IDEA.
 * User: Xiaochen Chen
 * Date: 3/21/14
 * Time: 8:05 PM
 */
public class FindCircularDependency {

    class File
    {
        List<File> neighbors;

        public List<File> getNeighbors()
        {
            return neighbors;
        }
    }

    public boolean findCircularDependency(Set<File> inputFiles)
    {
        Set<File> visitedFiles = new HashSet<File>();

        for(File f : inputFiles)
        {
            visitedFiles.add(f);
            if(findCircle(f, visitedFiles))
            {
                return true;
            }
        }

        return false;
    }

    // key recursive function to determin if there is circle in the
    public boolean findCircle(File f, Set<File> visitedFiles)
    {
        // terminating condition
        if(f.getNeighbors() == null || f.getNeighbors().isEmpty())
        {
            return false;
        }

        for(File neighbor : f.getNeighbors())
        {
            if(visitedFiles.contains(neighbor))
            {
                // visited this neighbor before, found circle!
                return true;
            }

            // add this neighbor to the usedFiles set
            visitedFiles.add(neighbor);
            // if going through the neighbors of this neighbor results in a circle, return true
            if(findCircle(neighbor, visitedFiles)) return true;

            // remove this neighbor, continue with next neighbor
            visitedFiles.remove(neighbor);
        }

        // if every neighbor does not result in a circle, return false
        return false;
    }

}
