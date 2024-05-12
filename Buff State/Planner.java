import java.util.ArrayList;
import java.util.List;

class Planner {
    private List<Action> actions;
    private List<String> initialState;
    private List<String> goalState;

    public Planner(List<Action> actions, List<String> initialState, List<String> goalState) {
        this.actions = actions;
        this.initialState = initialState;
        this.goalState = goalState;
    }

    public List<Action> plan() {
        List<Action> plan = new ArrayList<>();
        List<String> state = new ArrayList<>(initialState);

        while (!state.containsAll(goalState)) {
            boolean actionFound = false;

            for (Action action : actions) {
                if (action.isApplicable(state)) {
                    plan.add(action);
                    state = action.apply(state);
                    actionFound = true;
                    break;
                }
            }

            if (!actionFound) {
                // No applicable action found, plan failed
                return null;
            }
        }

        return plan;
    }
}