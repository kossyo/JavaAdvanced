import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class DFS {


    private Deque<Node> stack;

    public DFS() {
        this.stack = new ArrayDeque<>();
    }

    public void dfs(List<Node> nodes){

        for (Node node : nodes) {

            if (!node.isVisited()){
                node.setVisited(true);
                dfsWithStack(node);
            }
            
        }
    }

    private void dfsWithStack(Node rootNode) {

        this.stack.add(rootNode);
        rootNode.setVisited(true);

        while (!stack.isEmpty()){
            Node theNode = this.stack.pop();
            System.out.println(theNode + " ");

            for (Node neighbour : theNode.getNeighbours()) {
                if (!neighbour.isVisited()){
                    neighbour.setVisited(true);
                    this.stack.push(neighbour);
                }
            }
        }
    }
}
