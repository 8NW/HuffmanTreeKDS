/**
 * Name: 8N
 * Lab Name: Node
 * Lab purpose: The goal of Node is to create a program that
 * Date: 11/7/17
 * Collaborators: None
 */

public class Node<Key extends Comparable<Key>, Value> implements Comparable{

    private Key key;
    private Value value;
    private Node<Key, Value> left;
    private Node<Key, Value> right;

    public Node(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }


    public int compareTo(Object compareNode) {
        int returnInt = 0;
        Comparable comparableKey = ((Node)compareNode).getKey();

        returnInt = ((Comparable)key).compareTo(comparableKey);


        return returnInt;
    }

    public boolean isLeaf(){
        boolean returnBoolean = true;

        if (left != null || right != null){
            returnBoolean = false;
        }

        return returnBoolean;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Node<Key, Value> getLeft() {
        return left;
    }

    public void setLeft(Node<Key, Value> left) {
        this.left = left;
    }

    public Node<Key, Value> getRight() {
        return right;
    }

    public void setRight(Node<Key, Value> right) {
        this.right = right;
    }


}