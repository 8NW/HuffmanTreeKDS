/**
 * Name: 8N
 * Lab Name: HuffmanTree
 * Lab purpose: The goal of HuffmanTree is to create a program that
 * Date: 11/7/17
 * Collaborators: None
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

public class HuffmanTree {

    private PriorityQueue orderedQueue;

    private ArrayList charList;
    private ArrayList frequencyList;

    private String originalString;

    private Node root;

    public HuffmanTree(String input){

        root = null;
        originalString = input;

        orderedQueue = new PriorityQueue();
        charList = new ArrayList();
        frequencyList = new ArrayList();


        countFrequencies();
        toQueue();
        turnToTree();

    }

    private void countFrequencies(){

        for (int i = 0; i < originalString.length(); i++) {
            if (charList.contains(originalString.charAt(i))){
                frequencyList.set(charList.indexOf(originalString.charAt(i)), ((int)frequencyList.get(charList.indexOf(originalString.charAt(i))))+1);

            }
            else{
                charList.add(originalString.charAt(i));
                frequencyList.add(1);
            }

        }

    }

    private void toQueue(){
        while(charList.size() > 0){
            Node addingNode = new Node(((Comparable)(frequencyList.get(0))), ((Character)(charList.get(0))));
            orderedQueue.add(addingNode);

            frequencyList.remove(0);
            charList.remove(0);
        }

    }

    private void turnToTree(){
        if (!orderedQueue.isEmpty()){


            while(orderedQueue.size() > 1){
                Node rightNode = ((Node) orderedQueue.poll());
                Node leftNode = ((Node) orderedQueue.poll());

                Node tempRoot = new Node(((int)rightNode.getKey() + (int)leftNode.getKey()), "Branch or Root");

                tempRoot.setRight(rightNode);
                tempRoot.setLeft(leftNode);

                orderedQueue.add(tempRoot);


            }

            root = ((Node)orderedQueue.poll());

        }

    }

    public String toString(){
        String returnString = toString(root);

        return returnString;
    }

    private String toString(Node top){
        String returnString = "";

        if (top == null){
            returnString = "";
        }
        else if(top.isLeaf()){
            returnString += "1";

            int charNum = (int)(top.getValue().toString().charAt(0));

            returnString += Integer.toBinaryString(charNum);
        }
        else{
            returnString += "0";
            returnString += toString(top.getLeft());
            returnString += toString(top.getRight());
        }

        return returnString;
    }

//    public String createCompressed(){
//
//    }



    public static void main(String[] args) {

        String input = ";laksdjfa;lskdjfadjjsdjfjsdjsjjsdal;kfj;sdkhjnc";

        HuffmanTree test = new HuffmanTree(input);

        System.out.println("Tree Binary: " + test.toString());

        String actualBinary = "";

        for(int i = 0; i < input.length(); i++) {
           actualBinary += Integer.toBinaryString((int)(input.charAt(i))).toString();
        }

        System.out.println("Actual Binary: " + actualBinary);

        Double compressionRate = 1.0 * test.toString().length() / actualBinary.length();

        System.out.println(compressionRate + "% of the original size.");


    }


}

