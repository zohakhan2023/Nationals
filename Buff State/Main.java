import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Action> actions = new ArrayList<>();

        while (true) {
            System.out.println("Enter details for Your Task:");
            System.out.print("Name: ");
            String actionName = scanner.nextLine();
            if (actionName.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Preconditions: ");
            String preconditions = scanner.nextLine();
            System.out.print("Effects: ");
            String effects = scanner.nextLine();

            Action action = new Action(actionName, List.of(preconditions.split(",")), List.of(effects.split(",")));
            actions.add(action);
        }

        System.out.println("\nEnter initial state:");
        String initialStateInput = scanner.nextLine();
        List<String> initialState = List.of(initialStateInput.split(","));

        System.out.println("\nEnter goal state:");
        String goalStateInput = scanner.nextLine();
        List<String> goalState = List.of(goalStateInput.split(","));

        Planner planner = new Planner(actions, initialState, goalState);
        List<Action> plan = planner.plan();

        if (plan != null) {
            System.out.println("Plan:");
            for (Action action : plan) {
                System.out.println(action.getName());
            }
        } else {
            System.out.println("No plan found!");
        }

        scanner.close();
    }
}
