import java.util.ArrayList;
import java.util.List;

public class Node {

    private char self;
    private boolean visited;
    private List<Node> neighbours;

    public Node(char self) {
        this.self = self;
        this.neighbours = new ArrayList<>();
    }

    @Override
    public String toString() {
        return this.self + "";
    }

    public void addNeighbour(Node node){
        this.neighbours.add(node);
    }


    public char getSelf() {
        return self;
    }

    public void setSelf(char self) {
        this.self = self;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Node> neighbours) {
        this.neighbours = neighbours;
    }
}
