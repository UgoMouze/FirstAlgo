package AStar;

import modelingproblem.ModeledProblem;

public class AStar {

    public static void main(String[] args) {
        ModeledProblem p1 = new ModeledProblem();
        System.out.println("Solution to problem using A* solver : ");
        System.out.println(new AStarSearch().solve(p1).pathToString());
    }
}
