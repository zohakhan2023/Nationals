import java.util.ArrayList;
import java.util.List;

class Action {
    private String actionName;
    private List<String> preconditions;
    private List<String> effects;

    public Action(String actionName, String preconditions, String effects) {
        this.actionName = actionName;
        this.preconditions = new ArrayList<>();
        this.effects = new ArrayList<>();

        String[] preconditionsArray = preconditions.split(",");
        for (String condition : preconditionsArray) {
            this.preconditions.add(condition.trim());
        }

        String[] effectsArray = effects.split(",");
        for (String effect : effectsArray) {
            this.effects.add(effect.trim());
        }
    }

    public Action(String actionName2, List<String> of, List<String> of2) {
        // TODO Auto-generated constructor stub
    }

    public String getActionName() {
        return actionName;
    }

    public List<String> getPreconditions() {
        return preconditions;
    }

    public List<String> getEffects() {
        return effects;
    }

    public boolean isApplicable(List<String> state) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isApplicable'");
    }

    public List<String> apply(List<String> state) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'apply'");
    }

    public char[] getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }
}
