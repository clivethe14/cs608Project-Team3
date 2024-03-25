import java.util.*;

public class Dijkstra {
    public static Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> graph, String start) {
        Map<String, Integer> distances = new HashMap<String, Integer>();
        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, start));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentDistance = current.distance;
            String currentNode = current.node;

            System.out.println("Current Node being visited: " + currentNode);

            if (currentDistance > distances.get(currentNode)) {
                continue;
            }

            System.out.print("\n\nNeighbours checked: ");

            for (Map.Entry<String, Integer> neighbor : graph.get(currentNode).entrySet()) {
                String nextNode = neighbor.getKey();
                int weight = neighbor.getValue();
                int distance = currentDistance + weight;

                System.out.print(nextNode + "\t");

                if (distance < distances.get(nextNode)) {
                    distances.put(nextNode, distance);
                    queue.add(new Node(distance, nextNode));
                }
            }

            System.out.println("\n---------------------------------------");
        }

        return distances;
    }

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("A", new HashMap<String, Integer>());
        graph.put("B", new HashMap<String, Integer>());
        graph.put("C", new HashMap<String, Integer>());
        graph.put("D", new HashMap<String, Integer>());

        graph.get("A").put("B", 3);
        graph.get("A").put("C", 1);
        graph.get("B").put("C", 7);
        graph.get("C").put("B", 2);
        graph.get("C").put("D", 6);
        graph.get("D").put("B", 2);

        System.out.println("\n---------------------------------------");

        Map<String, Integer> distances = dijkstra(graph, "A");
        System.out.println("\nShortest distances from A:\n" + distances);
    }

    static class Node implements Comparable<Node> {
        int distance;
        String node;

        public Node(int distance, String node) {
            this.distance = distance;
            this.node = node;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
}