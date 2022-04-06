package core;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractGraphSearch implements Search {

    Collection<Node> frontier;
    Collection<Node> explored;

    public Node solve(Problem problem) {
        // initialize fringe
        System.out.println("Solving...");
        frontier = initFrontier();
        explored = frontier;
        frontier.addAll(expand(new Node(problem.getInitialState()), problem));
        System.out.println("Starting frontier is " + frontier);
        boolean done = false;
        Node solution = null;
        while (!done) {
            if (frontier.isEmpty()) {
                System.out.println("No more nodes in frontier => FAILURE");
                done = true;
            } else {
                Node node = chooseLeafNode(frontier, problem);
                System.out.println("Inspecting node " + node);
                if (problem.isGoal(node.getState())) {
                    System.out.println("Goal node reached => SUCCESS");
                    solution = node;
                    done = true;
                } else {
                    frontier.addAll(expand(node, problem));
                    System.out.println("Expanding node, frontier is " + frontier);
                }
            }
        }
        return solution;

    }

    public Collection<Node> expand(Node node, Problem problem) {
        Collection<Node> nodes = new ArrayList<Node>();
        Collection<Object> actions = problem.getActions(node.getState());
        Boolean skipped = false;
        for (Object action : actions) {
            Object next = problem.getNextState(node.getState(), action);
            Node nextNode = new Node(next, node, action, problem.getStepCost(node.getState(), action, next));

            for( Node test : explored ){
                if (nextNode.getState().equals(test.getState())){
                    skipped = true;
                }
            }
            if (! skipped){
                explored.add(nextNode);
                nodes.add(nextNode);
            }
            else{
                System.out.println("Skipped node " + node);
            }
        }
        return nodes;
    }

    public abstract Collection<Node> initFrontier();

    public abstract Node chooseLeafNode(Collection<Node> frontier, Problem problem);
}
