package simple;

import solver.BreadthFirstTreeSearch;

public class SimpleBreadth {

    public static void main(String[] args) {
        SimpleOrientedGraphProblem p1 = new SimpleOrientedGraphProblem();
        System.out.println("Solution to problem using breadth first : ");
        System.out.println(new BreadthFirstTreeSearch().solve(p1).pathToString());
    }
}
