package graph.solver;

import core.AbstractGraphSearch;
import core.Node;
import core.Problem;

import java.util.Collection;
import java.util.Stack;

public class DepthFirstGraphSearch extends AbstractGraphSearch {

    public Collection<Node> initFrontier() {
        return new Stack<Node>();
    }

    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {

        return ((Stack<Node>) frontier).pop();
    }
}
