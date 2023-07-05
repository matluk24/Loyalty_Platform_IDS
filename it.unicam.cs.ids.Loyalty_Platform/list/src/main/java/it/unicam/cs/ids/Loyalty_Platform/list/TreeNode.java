package it.unicam.cs.ids.Loyalty_Platform.list;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class TreeNode {
    char operator;
    double operand;
    TreeNode left;
    TreeNode right;
    String filePath="/utilities/file/tools.txt";

    // Constructor for operator nodes
    public TreeNode(char operator, TreeNode left, TreeNode right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    // Constructor for operand nodes
    public TreeNode(double operand) {
        this.operand = operand;
        this.left = null;
        this.right = null;
    }
    public double calculate() {
        if (operator != 0) {
            // If the node is an operator, recursively calculate the left and right subtrees
            double leftResult = left.calculate();
            double rightResult = right.calculate();

            // Perform the corresponding mathematical operation based on the operator
            switch (operator) {
                case '+':
                    return leftResult + rightResult;
                case '-':
                    return leftResult - rightResult;
                case '*':
                    return leftResult * rightResult;
                case '/':
                    return leftResult / rightResult;
                // Add more cases for other operators if needed
            }
        }
        // If the node is an operand, return its value
        return operand;
    }
 // Save the formula to a file
    public void saveFormulaToFile(TreeNode root, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            saveNodeToFile(root, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 // Recursively save the formula nodes to the file
    private void saveNodeToFile(TreeNode node, BufferedWriter writer) throws IOException {
        if (node.operator != 0) {
            writer.write(node.operator);
            writer.newLine();
            saveNodeToFile(node.left, writer);
            saveNodeToFile(node.right, writer);
        } else {
            writer.write(String.valueOf(node.operand));
            writer.newLine();
        }
    }
    // Read the formula from a file
    public TreeNode readFormulaFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return readNodeFromFile(reader);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    private TreeNode readNodeFromFile(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        if (line != null) {
            if (line.length() == 1 && isOperator(line.charAt(0))) {
                char operator = line.charAt(0);
                TreeNode left = readNodeFromFile(reader);
                TreeNode right = readNodeFromFile(reader);
                return new TreeNode(operator, left, right);
            } else {
                double operand = Double.parseDouble(line);
                return new TreeNode(operand);
            }
        }
        return null;
    }
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}

