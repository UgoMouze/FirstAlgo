package graph.solver;

import core.AbstractGraphSearch;
import core.Node;
import core.Problem;

import java.util.Collection;
import java.util.LinkedList;

public class BreadthFirstGraphSearch extends AbstractGraphSearch{


    public Collection<Node> initFrontier() {
        return new LinkedList<>();
    }

    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {
        return ((LinkedList<Node>) frontier).remove();
    }
}
