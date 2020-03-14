package Exercises;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Node {

    int x;
    int y;
    Deque<Node> nodes;

    public Node(int x, int y ){
        this.x = x;
        this.y = y;
        this.nodes = new ArrayDeque<>();
    }
}
