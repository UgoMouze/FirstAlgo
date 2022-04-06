package solver;

import core.AbstractTreeSearch;
import core.Node;
import core.Problem;

import java.util.Collection;
import java.util.LinkedList;

public class BreadthFirstTreeSearch extends AbstractTreeSearch{


    public Collection<Node> initFrontier() {
        return new LinkedList<>();
    }

    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {
        return ((LinkedList<Node>) frontier).remove();
    }
}
