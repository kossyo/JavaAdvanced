package Exercises;

public class Node2 {

    Node2 prev;
    char self;
    Node2 next;

    public Node2(Node2 prev, char self, Node2 next){
        this.self = self;
        this.prev = prev;
        this.next = next;
    }
}
