package unoriented_loop;

import solver.DepthFirstTreeSearch;

public class SimpleDepth {

    public static void main(String[] args) {
        SimpleUnorientedGraphProblem p1 = new SimpleUnorientedGraphProblem();
        System.out.println("Solution to problem using depth first : ");
        System.out.println(new DepthFirstTreeSearch().solve(p1).pathToString());
    }
}
