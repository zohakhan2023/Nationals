import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UserInterface extends JFrame {

    private JTextField actionField;
    private JTextField preconditionsField;
    private JTextField effectsField;
    private JTextField initialStateField;
    private JTextField goalStateField;
    private JTextArea planArea;

    private List<Action> actions;
    private List<String> initialState;
    private List<String> goalState;

    public UserInterface() {
        actions = new ArrayList<>();
        initialState = new ArrayList<>();
        goalState = new ArrayList<>();

        setTitle("Planner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(6, 2));

        inputPanel.add(new JLabel("Action:"));
        actionField = new JTextField();
        inputPanel.add(actionField);

        inputPanel.add(new JLabel("Preconditions:"));
        preconditionsField = new JTextField();
        inputPanel.add(preconditionsField);

        inputPanel.add(new JLabel("Effects:"));
        effectsField = new JTextField();
        inputPanel.add(effectsField);

        inputPanel.add(new JLabel("Initial State:"));
        initialStateField = new JTextField();
        inputPanel.add(initialStateField);

        inputPanel.add(new JLabel("Goal State:"));
        goalStateField = new JTextField();
        inputPanel.add(goalStateField);

        JButton addActionBtn = new JButton("Add Action");
        addActionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAction();
            }
        });
        inputPanel.add(addActionBtn);

        add(inputPanel, BorderLayout.NORTH);

        JPanel planPanel = new JPanel(new BorderLayout());

        JButton planBtn = new JButton("Plan");
        planBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatePlan();
            }
        });
        planPanel.add(planBtn, BorderLayout.NORTH);

        planArea = new JTextArea();
        planArea.setEditable(false);
        planPanel.add(new JScrollPane(planArea), BorderLayout.CENTER);

        add(planPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    private void addAction() {
        String actionName = actionField.getText();
        String preconditions = preconditionsField.getText();
        String effects = effectsField.getText();

        Action action = new Action(actionName, preconditions, effects);
        actions.add(action);

        actionField.setText("");
        preconditionsField.setText("");
        effectsField.setText("");
    }

    private void generatePlan() {
        String[] initialStateInputs = initialStateField.getText().split(",");
        for (String input : initialStateInputs) {
            initialState.add(input.trim());
        }

        String[] goalStateInputs = goalStateField.getText().split(",");
        for (String input : goalStateInputs) {
            goalState.add(input.trim());
        }

        Planner planner = new Planner(actions, initialState, goalState);
        List<Action> plan = planner.plan();

        if (plan != null) {
            StringBuilder planText = new StringBuilder();
            for (Action action : plan) {
                planText.append(action.getActionName()).append("\n");
            }
            planArea.setText(planText.toString());
        } else {
            planArea.setText("No plan found!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserInterface();
            }
        });
    }
}
