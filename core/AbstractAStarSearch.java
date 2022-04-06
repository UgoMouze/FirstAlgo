package core;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractAStarSearch implements Search {

    ArrayList<Node> frontier;
    ArrayList<Node> explored = new ArrayList<>();

    public Node solve(Problem problem) {
        // initialize fringe
        System.out.println("Solving...");
        frontier = initFrontier();
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
        explored.add(node);
        Boolean addNode;
        int indice;
        Boolean inFrontier;
        Collection<Object> actions = problem.getActions(node.getState());
        for (Object action : actions) {
            inFrontier=false;
            addNode = true;
            indice=-1;
            Object next = problem.getNextState(node.getState(), action);
            Node nextNode = new Node(next, node, action, problem.getStepCost(node.getState(), action, next));

            for (int i=0; i<frontier.size(); i++){
                Node fNode = frontier.get(i);
                if (nextNode.getState().equals(fNode.getState())){
                    addNode = false;
                    if (fNode.getPathCost() > nextNode.getPathCost()){
                        indice = i;
                    }
                }
            }
            if (indice>-1){
                frontier.remove(indice);
                frontier.add(nextNode);
                inFrontier=true;
            }
            indice = -1;
            for (int i=0; i<explored.size(); i++){
                Node eNode = explored.get(i);
                if (nextNode.getState().equals(eNode.getState())){
                    addNode = false;
                    if (eNode.getPathCost() > nextNode.getPathCost()){
                        indice=i;
                    }
                }
            }
            if (indice>-1){
                explored.remove(indice);
                if(!inFrontier) frontier.add(nextNode);
            }
            if (addNode) nodes.add(nextNode);
        }
        return nodes;
    }

    public abstract ArrayList<Node> initFrontier();

    public abstract Node chooseLeafNode(ArrayList<Node> frontier, Problem problem);
}
