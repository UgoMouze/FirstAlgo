package graph;

import graph.solver.BreadthFirstGraphSearch;

public class GraphBreadth {

    public static void main(String[] args) {
        GraphProblem p1 = new GraphProblem();
        System.out.println("Solution to problem using breadth first : ");
        System.out.println(new BreadthFirstGraphSearch().solve(p1).pathToString());
    }
}
