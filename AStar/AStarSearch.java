package AStar;

import core.AbstractAStarSearch;
import core.Node;
import core.Problem;

import java.util.ArrayList;

public class AStarSearch extends AbstractAStarSearch {


    public ArrayList<Node> initFrontier() {
        return new ArrayList<>();
    }

    public Node chooseLeafNode(ArrayList<Node> frontier, Problem problem) {
        Node choosen;
        double min;
        choosen = frontier.get(0);
        min = choosen.getPathCost();
        for(int i=1; i<frontier.size(); i++){
            if(frontier.get(i).getPathCost()<min){
                choosen = frontier.get(i);
                min = choosen.getPathCost();
            }
        }
        frontier.remove(choosen);
        return choosen;
    }
}
