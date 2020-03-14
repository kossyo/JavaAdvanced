package Exercises;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _12_The_Matrix {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int[] dimensions = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        char[][] matrix = new char[dimensions[0]][dimensions[1]];

        fillMatrix(matrix);

        char replaceChar = reader.readLine().charAt(0);
        int[] target = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        Deque<Node> stack = new ArrayDeque<>();
        traverse(matrix, target, replaceChar);
    }

    private static void traverse(char[][] matrix, int[] target, char replaceChar){

        char originalChar = matrix[target[0]][target[1]];

        Node startNode = new Node(target[0], target[1]);
        Node upperNode = null;
        Node rightNode = null;
        Node lowerNode = null;
        Node leftNode = null;
        try {
            if (matrix[target[0] - 1][target[1]] == originalChar) {
                upperNode = new Node(target[0] - 1, target[1]);
            }
        }catch (IndexOutOfBoundsException ignored){}
        try{
            if (matrix[target[0]][target[1] + 1] == originalChar) {
                rightNode = new Node(target[0], target[1] + 1);
            }
        }catch (IndexOutOfBoundsException ignored){}
        try{
            if (matrix[target[0] + 1][target[1]] == originalChar) {
                lowerNode = new Node(target[0] + 1, target[1]);
            }
        }catch (IndexOutOfBoundsException ignored){}
        try{
            if (matrix[target[0]][target[1] - 1] == originalChar) {
                leftNode = new Node(target[0], target[1] - 1);
            }
        }catch (IndexOutOfBoundsException ignored){}

        if (upperNode != null){
            startNode.nodes.push(upperNode);
        }
        if (rightNode != null){
            startNode.nodes.push(rightNode);
        }
        if (lowerNode != null){
            startNode.nodes.push(lowerNode);
        }
        if (leftNode != null){
            startNode.nodes.push(leftNode);
        }

        while (!startNode.nodes.isEmpty()){

            //Node currentNode = new Node()
        }






    }


    private static void fillMatrix(char[][] matrix) throws IOException {
        for (int i = 0; i < matrix.length; i++) {

            matrix[i] = reader.readLine().replaceAll(" ", "").toCharArray();
        }
    }



















//int copyOfTargetRow = 0;
//        int copyOfTargetCol = 0;
//
//        //upper
//        try{
//            if(matrix[target[0]-1][target[1]] == originalChar){
//
//                copyOfTargetRow = target[0]-1;
//                int[] targetCopy = {copyOfTargetRow, target[1]};
//
//                traverse(matrix, targetCopy, replaceChar);
//            }else{System.out.println(target[0] + "" + target[1]);}
//        }catch(IndexOutOfBoundsException e){}
//
//        //right
//        try{
//            if(matrix[target[0]][target[1] + 1] == originalChar){
//
//                copyOfTargetCol = target[1] + 1;
//                int[] targetCopy = {target[0], copyOfTargetCol};
//                traverse(matrix, targetCopy, replaceChar);
//            }else{System.out.println(target[0] + "" + target[1]);}
//        }catch(IndexOutOfBoundsException e){}
//
//
//        //lower
//        try{
//            if(matrix[target[0]+1][target[1]] == originalChar){
//
//                copyOfTargetRow = target[0]+1;
//                int[] targetCopy = {copyOfTargetRow, target[1]};
//
//                traverse(matrix, targetCopy, replaceChar);
//            }else{System.out.println(target[0] + "" + target[1]);}
//        }catch(IndexOutOfBoundsException e){}
//
//        //left
//        try{
//            if(matrix[target[0]][target[1] - 1] == originalChar){
//
//                copyOfTargetCol = target[1] - 1;
//                int[] targetCopy = {target[0], copyOfTargetCol};
//                traverse(matrix, targetCopy, replaceChar);
//            }else{System.out.println(target[0] + "" + target[1]);}
//        }catch(IndexOutOfBoundsException e){}



//    private static void addStartingNodes(char[][] matrix, int[] startingPoint, List<Integer[]> allNodesOfStartingPoint) {
//        //add top node
//        try {
//            if (matrix[startingPoint[0] - 1][startingPoint[1]] == matrix[startingPoint[0]][startingPoint[1]]) {
//
//                Integer[] node = {startingPoint[0] - 1, startingPoint[1], 0};
//                allNodesOfStartingPoint.add(node);
//            }
//        }catch (IndexOutOfBoundsException ioobe){}
//
//        //add right node
//        try{
//            if (matrix[startingPoint[0]][startingPoint[1]+1] == matrix[startingPoint[0]][startingPoint[1]]){
//                Integer[] node = {startingPoint[0], startingPoint[1]+1, 0};
//                allNodesOfStartingPoint.add(node);
//            }
//        }catch (IndexOutOfBoundsException ioobe){}
//
//        //add bottom node
//        try{
//            if (matrix[startingPoint[0] + 1][startingPoint[1]] == matrix[startingPoint[0]][startingPoint[1]]){
//                Integer[] node = {startingPoint[0] + 1, startingPoint[1], 0};
//                allNodesOfStartingPoint.add(node);
//            }
//        }catch (IndexOutOfBoundsException ioobe){}
//
//        //add left node
//        try{
//            if (matrix[startingPoint[0]][startingPoint[1] - 1] == matrix[startingPoint[0]][startingPoint[1]]){
//                Integer[] node = {startingPoint[0], startingPoint[1] - 1, 0};
//                allNodesOfStartingPoint.add(node);
//            }
//        }catch (IndexOutOfBoundsException ioobe){}
//    }
}
