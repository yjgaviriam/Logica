package logic;

/**
 * 
 * @author xJoni
 */
public class Node {
    
    private Node left;
    private Node right;
    private Node negation;
    private String value;
    
    public Node(String value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getNegation() {
        return negation;
    }

    public void setNegation(Node negation) {
        this.negation = negation;
    }
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
