package graph;

import core.Problem;

import java.util.ArrayList;
import java.util.Collection;

public class GraphProblem implements Problem {

    GraphState initialState = new GraphState(GraphState.A);
    GraphState finalState = new GraphState(GraphState.H);

    @Override
    public Object getInitialState() {
        return initialState;
    }

    @Override
    public boolean isGoal(Object state) {
        return state.equals(finalState);
    }

    @Override
    public Collection<Object> getActions(Object state) {
        ArrayList<Object> actions = new ArrayList<Object>();
        String s = ((GraphState) state).value;
        if (s.equals(GraphState.A)) {
            actions.add("go to B");
            actions.add("go to C");
        } else if (s.equals(GraphState.B)) {
            actions.add("go to D");
            actions.add("go to A");
            actions.add("go to E");
        } else if (s.equals(GraphState.C)) {
            actions.add("go to D");
            actions.add("go to A");
        } else if (s.equals(GraphState.D)) {
            actions.add("go to G");
            actions.add("go to B");
            actions.add("go to C");
        } else if (s.equals(GraphState.E)) {
            actions.add("go to F");
            actions.add("go to B");
        } else if (s.equals(GraphState.F)) {
            actions.add("go to H");
            actions.add("go to E");
        } else if (s.equals(GraphState.G)) {
            actions.add("go to H");
            actions.add("go to D");
        } else if (s.equals(GraphState.H)) {
            actions.add("go to F");
            actions.add("go to G");

        }
        return actions;
    }

    @Override
    public Object getNextState(Object state, Object action) {
        if (action.equals("go to A")) return new GraphState(GraphState.A);
        if (action.equals("go to B")) return new GraphState(GraphState.B);
        if (action.equals("go to C")) return new GraphState(GraphState.C);
        if (action.equals("go to D")) return new GraphState(GraphState.D);
        if (action.equals("go to E")) return new GraphState(GraphState.E);
        if (action.equals("go to F")) return new GraphState(GraphState.F);
        if (action.equals("go to G")) return new GraphState(GraphState.G);
        if (action.equals("go to H")) return new GraphState(GraphState.H);
        return null;
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }
}
