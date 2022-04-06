package modelingproblem;

import core.Problem;

import java.util.ArrayList;
import java.util.Collection;

public class ModeledProblem implements Problem {

    ModeledState initialState = new ModeledState(ModeledState.M3C3_M0C0);
    ModeledState finalState = new ModeledState(ModeledState.M0C0_M3C3);

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
        String s = ((ModeledState) state).value;
        /**
         * We don't take into account states that count more cannibals than missionaries
         *
         * We suppose that the boat
         */
        if (s.equals(ModeledState.M3C3_M0C0)) {
            actions.add("M3C1_M0C2");
            actions.add("M2C2_M1C1");
        } else if (s.equals(ModeledState.M3C1_M0C2)) {
            actions.add("M3C3_M0C0");
            actions.add("M3C2_M0C1");
        } else if (s.equals(ModeledState.M3C2_M0C1)) {
            actions.add("M3C1_M0C2");
            actions.add("M2C2_M1C1");
        }
        else if (s.equals(ModeledState.M2C2_M1C1)) {
            actions.add("M3C2_M0C1");
            actions.add("M3C3_M0C0");
            actions.add("M1C1_M2C2");
        }
        else if (s.equals(ModeledState.M1C1_M2C2)) {
            actions.add("M2C2_M1C1");
            actions.add("M0C1_M3C2");
            actions.add("M0C0_M3C3");
        }
        else if (s.equals(ModeledState.M0C1_M3C2)) {
            actions.add("M1C1_M2C2");
            actions.add("M0C3_M3C0");
            actions.add("M0C2_M3C1");
        }
        else if (s.equals(ModeledState.M0C3_M3C0)) {
            actions.add("M0C1_M3C2");
            actions.add("M0C2_M3C1");
        }
        else if (s.equals(ModeledState.M0C2_M3C1)) {
            actions.add("M0C3_M3C0");
            actions.add("M0C1_M3C2");
            actions.add("M0C0_M3C3");
        }

        return actions;
    }

    @Override
    public Object getNextState(Object state, Object action) {
        if (action.equals("M3C1_M0C2")) return new ModeledState(ModeledState.M3C1_M0C2);
        if (action.equals("M2C2_M1C1")) return new ModeledState(ModeledState.M2C2_M1C1);
        if (action.equals("M1C1_M2C2")) return new ModeledState(ModeledState.M1C1_M2C2);
        if (action.equals("M0C0_M3C3")) return new ModeledState(ModeledState.M0C0_M3C3);
        if (action.equals("M3C3_M0C0")) return new ModeledState(ModeledState.M3C3_M0C0);
        if (action.equals("M3C2_M0C1")) return new ModeledState(ModeledState.M3C2_M0C1);
        if (action.equals("M0C1_M3C2")) return new ModeledState(ModeledState.M0C1_M3C2);
        if (action.equals("M0C3_M3C0")) return new ModeledState(ModeledState.M0C3_M3C0);
        if (action.equals("M0C2_M3C1")) return new ModeledState(ModeledState.M0C2_M3C1);
        return null;
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return Character.getNumericValue((action.toString().charAt(1)))+Character.getNumericValue(action.toString().charAt(3));
    }
}
