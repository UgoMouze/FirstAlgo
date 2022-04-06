package unoriented_loop;

import solver.BreadthFirstTreeSearch;

public class SimpleBreadth {

    public static void main(String[] args) {
        SimpleUnorientedGraphProblem p1 = new SimpleUnorientedGraphProblem();
        System.out.println("Solution to problem using depth first : ");
        System.out.println(new BreadthFirstTreeSearch().solve(p1).pathToString());
    }
}
