package graph;

import graph.solver.DepthFirstGraphSearch;

public class GraphDepth {

    public static void main(String[] args) {
        GraphProblem p1 = new GraphProblem();
        System.out.println("Solution to problem using depth first : ");
        System.out.println(new DepthFirstGraphSearch().solve(p1).pathToString());
    }
}
