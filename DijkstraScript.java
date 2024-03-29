/* Please feel free to change and edit as needed! I will submit a tape recording today or tomorrow. Thanks! */

/* Hello, and welcome to the walkthrough of the Dijkstra java code. 
The Dijkstra algorithm is a searching algorithm that finds the shortest distance 
in a graph from an initial root node to other neighbor nodes in the graph.
It is commonly used in applications such as Digital mapping (Google Maps),
 Network Systems, and Flight Coordination Platforms.
Let's get started! */

import java.util.*; /* We will have to import the java.util.* package, as we will implement the 
Map, HashMap, and PriorityQueue objects and their contents, for use in this code. */

public class Dijkstra {  /* Here, we start by declaring a public class named, "Dijkstra", 
and defining a public static method, "dijkstra", with input parameter types 
Map<String, Map<String, Integer>> graph, and String, "start". Note that the name of 
the public static Map object, "dijkstra", is differentiated with a lowercase "d" 
from the public class, "Dijkstra." */
    public static Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> graph, String start) {/* 
        Also note that we use input parameters of type Map<String, Map<String, Integer>> 
        (a HashMap), and String start, to define the structure of the nodes we will include 
        in this Map object, "graph", and to define a String for where the code will begin its 
        traversal. The Map object, "graph", allows nodes (Map objects) of type 
        <String, Integer>, to be added to it as points, while the String, "start", defines 
        a String type input for a String type representation of the initial point of 
        traversal (the root node). From this initial point, the shortest distances 
        to all the neighboring nodes will be printed out as a type String output, 
        after traversal by the Dijkstra function, which we will see later on in the code. */
        Map<String, Integer> distances = new HashMap<String, Integer>(); /* We define a new HashMap 
        object as a Map object named, "distances", of key-value pair type <String, Integer>,
        with no specific parameters. */
        for (String node : graph.keySet()) { /* Here, we implement a for-loop with the condition 
            to set the nodes added to the Map object, "graph", an integer value with an upper limit
            Integer.MAX_VALUE. This defines a distance for each value with an upper limit 
            Integer.MAX_VALUE for two node points using the .put() function of the 
            java.util.Map package. */
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0); /* Here, we define the very first node at the value String "start", 
        as having a distance value of 0. */

        PriorityQueue<Node> queue = new PriorityQueue<>(); /* Here, we create a new PriorityQueue 
        object of type <Node> named, "queue", using the new PriorityQueue<>(); constructor.
        We use this PriorityQueue to order the traversal order of the node points, which are
        input later. Note, that there are no specified input parameters using this constuctor.*/
        queue.add(new Node(0, start)); /* Here, we queue the initial 
        Node using new Node(distance: 0, start)using the .add() function of 
        the java.util.PriorityQueue package to the PriorityQueue, "queue".
        Again, also note here the initial new node created has a
        distance of 0 and utilizes the String "start", which has a value of 0, as initialized
        by the .put() function above in line (**). */

        while (!queue.isEmpty()) { /* Here, we implement a while-loop that keeps running while 
            the condition, queue.isEmpty(), is false. In other words, the while loop
            keeps running while there is a node waiting in the queue,
            and only stops when the queue is empty. */
            Node current = queue.poll(); /* Here, we define a Node
            named, "current", and set it to the head of the queue,
            using the .poll() function of the java.util.PriorityQueue package. */
            int currentDistance = current.distance; /* Here, we define an
            integer named, "currentDistance", as the integer value, "distance",
            (defined later), of the "current" Node defined in the last line. */
            String currentNode = current.node; /* Here, we define a String, "currentNode",
            as the String defined in the for loop of the current node, "current".*/

            System.out.println("Current Node being visited: " + currentNode); /* Here, we use a
            System.out.println() statement to print the "Current Node being visited: ", 
            plus, the String type output, "currentNode". */
            if (currentDistance > distances.get(currentNode)) { /* Here, we implement an 
                if statement with a condition that while the integer value of "currentDistance" 
                is greater than the distance of currentNode mapped to the Map object, "distances", 
                the print statement continues printing out the "Current Node being visited: ". */
                continue;
            }

            System.out.print("\n\nNeighbours checked: "); /* Here, we use a System.out.print
            statement() statement to print "Neighbours checked: " to precede the
            results from the proceeding for-loop implementation below. */

            for (Map.Entry<String, Integer> neighbor : graph.get(currentNode).entrySet()) { 
                /* Here, we implement a for-loop with the condition that each new neighbor node
                is introduced as a Map<String, Integer> object named, "neighbor", into the queue,
                with an available Set of mapping entries included in the Map object, "graph", 
                as defined earlier. This is explained better in detail in the next few lines of 
                code (lines ** - **). */
                String nextNode = neighbor.getKey(); /* Here, a String named, "nextNode", is defined 
                as the key value of the Map<String, Integer> object, "neighbor" (defined above),
                with the .getKey() function available in the java.util.Map.Entry package.
                As defined above, the return value is always type String, which corresponds to
                the name of the "neighbor" node. */
                int weight = neighbor.getValue(); /* Here, an integer named, "weight", is defined
                as the value of the Map<String, Integer> object, "neighbor" (defined above),
                with the .getValue() function available in the java.util.Map.Entry package.
                As defined above, the return value is always type Integer, which corresponds to
                the numerical distance, or as aptly defined in the name, the "weight", of the node. */
                int distance = currentDistance + weight; /* Here, an integer named, "distance", is 
                defined as the sum of the integers, "currentDistance", and "weight". This integer 
                is defined here instead of earlier in the code because we want to see the name 
                and value of the currentNode being pritned first, before the neighbor name 
                and values are printed. Here, we see that the value of distance is 
                a sum of the integers currentDistance and weight. This is because Dijkstra's 
                Algorithm only runs with nodes that have non-negative weights. */

                /* If you remember the previous slides in the presentation (slide x), 
                Components are Nodes, Edges, and Weights; Nodes are The points of intersection 
                within a network; Edges are The relationships between the nodes within a network; 
                Weights are The "cost" associated with the edge. 
                
                The limitations of Djikstra’s algorithm are that the graph 
                should be weighted and the weights should be non-negative. 

                This explains the value of the integer, "distance", which can be explained to be the 
                sum of the integers "currentDistance" and "weight". Dijkstra's 
                Algorithm runs only for weighted graphs, and weights of non-negative value.
                Hence, every Map<String, Integer> object, "neighbor",
                has a variable int "weight" that must be factored in, as weights are also non-negative by
                design. "The shortest path tree identified using Dijkstra's technique will attempt to avoid edges with bigger
                weights because they indicate that the edge has a large weight/cost". 
                Djikstra's Algorithm has dis-advantages of being time-consuming: it
                takes time to conduct a blind search, unable to handle negative weights,
                and doesn't work well on nonuniformed graphs. */

                System.out.print(nextNode + "\t"); /* Here, we use a System.out.print() statement
                to print the node, "nextNode", with a tab, preceding the for-loop implementation above. */

                if (distance < distances.get(nextNode)) { /* Here, we implement an if statement 
                    with the condition that while the value of the integer named, "distance", is less than
                    that of the value of the String, "nextNode", mapped to the Map object, "distances", 
                    the distance of the String, "nextNode", is mapped to the Map object, "distances",
                    and "distance" and "nextNode" are added as a new Node as its input parameters,
                    to the PriorityQueue, "queue". In other words, this is the part of the dijkstra function
                    that finds the shortest distance between two nodes. */
                    distances.put(nextNode, distance);
                    queue.add(new Node(distance, nextNode));
                }
            }

            System.out.println("\n---------------------------------------"); /* Here, we use a System.out.println() statement
            to print out a line. */
        }

        return distances; /* Here, we have the return state of the function of the public static 
        Map<String, Integer> object "dijkstra", which returns the Map<String, Integer> object, "distances".
        Note the code of the "dijkstra" function. Inputting parameters this way provides better ease than,
        perhaps, making a void function. */
    }

    public static void main(String[] args) { // Here, we begin our main argument, and the implementation of the algorithm, dijkstra.
        Map<String, Map<String, Integer>> graph = new HashMap<>(); // First, we create and define a new HashMap object, as a Map object, "graph", with input parameters <String, Map<String, Integer>>.
        graph.put("A", new HashMap<String, Integer>()); // Here, we create and insert four new node points, with the names "A", "B", "C", and "D", into the Map object, "graph". 
        // Each node point contains a key-value pair of type String, and a new value of type HashMap<String, Integer>() (new HashMap<String, Integer>());).
        // The graph contains all the node points which will be traversed by the Dijkstra algorithm. 
        // Note that the construction and input parameters of the node points are identical for each new node.
        graph.put("B", new HashMap<String, Integer>()); // In this line, a new node point named "B", is created and inserted into the Map object, "graph".
        graph.put("C", new HashMap<String, Integer>()); // In this line, a new node point named "C", is created and inserted into the Map object, "graph".
        graph.put("D", new HashMap<String, Integer>()); // In this line, a new node point named "D", is created and inserted into the Map object, "graph".

        /* So now, we have a total of four node points, "A", "B", "C", and "D", which are queued for traversal in the Dijkstra algorithm. */

        graph.get("A").put("B", 3); // Here, we insert the distances between the nodes "A", "B", "C", and "D", by inserting a key-value pair of type <String, Integer> to correspond to the neighboring nodes and their distances from one another. 
        // We do this by utilizing the .put() function of the java.util.Map library, to insert a "key-key-value" pair as a corresponding value to one of the already existing points.
        // In this line, the node point, "B", is given an integer value "distance" of 3, from node point "A", which was defined in line 55 above.
        // Note that this is, in other words, a one directional traversal path in the algorithm from node point "A" to node point "B". 

        /* Because these are created as HashMap objects, we are able to queue the list with code that already refers to a created node in lines 55 to 59 above.
         * This is possible because HashMaps have a structure that allows the insertion of key-value pairs as a value into key-value pairs.
         * This makes traversal easier, as we do not have to create new points for each traversal we wish to map out, with new lines of code. */

        graph.get("A").put("C", 1); // In this line, the node point, "C", is given an integer value "distance" of 1, from node point "A" (line 56).
        graph.get("B").put("C", 7); // In this line, the node point, "C", is given an integer value "distance" of 7, from node point "B" (line 56).
        graph.get("C").put("B", 2); // In this line, the node point, "B", is given an integer value "distance" of 2, from node point "C" (line 57).
        graph.get("C").put("D", 6); // In this line, the node point, "D", is given an integer value "distance" of 6, from node point "C" (line 57).
        graph.get("D").put("B", 2); // In this line, the node point, "B", is given an integer value "distance" of 2, from node point "D" (line 58).

        /* Here is a graphical representation of the Map, "graph", with nodes "A", "B", "C", and "D", and their respective distances from one another (code_graph.jpg).
         * We can see that the distances between each node reflect what was entered in lines 60 to 65 of the code, representing the respective distances between each node.
         * Although it is entirely possible to create more than four nodes, for simplicity's sake, we will just stick to four nodes in this demonstration. */

        System.out.println("\n---------------------------------------"); // This line is present to space out the printed results.

        Map<String, Integer> distances = dijkstra(graph, "A"); //  Here, we call the dijkstra method to the Map, "distances", and set the input parameters as "graph", and start, at node point "A".
        System.out.println("\nShortest distances from A:\n" + distances); // Here, we print out the results, with the shortest distances from node point "A".
    }

    static class Node implements Comparable<Node> { // Here, we have a static class Node that implements the Comparable interface.
        int distance; // Here, we have a local integer, "distance".
        String node; // Here, we have a local String, "node".

        public Node(int distance, String node) { // Here, we define a public Node with variables, "distance", and "node".
            this.distance = distance; // Here, we return the integer, "distance", using this.
            this.node = node; // Here, we return the String, "node", using this.
        }

        @Override
        public int compareTo(Node other) { // Here, we have an @Override compareTo function, which compares the distance between the current node and the other node being compared to.
            return Integer.compare(this.distance, other.distance); // The compareTo function returns the result of the comparison between the currently defined Node and the other Node.
        }
    }
}



/* Note that all distances include the node's own weights.

> cd "d:\Pace University\CS 608 - Algorithms & Computing Theory\" ; if ($?) { javac Dijkstra.java } ; if ($?) { java Dijkstra }

---------------------------------------
Current Node being visited: A           // The Current Node being visited is node "A". No neighbors have been checked yet.


Neighbours checked: B   C               // The neighbors to node "A" are nodes "B" and "C". 
                                        // Node "A" is not checked itself as it is the root node.
                                        // The distance from node "A" to node "B" is checked.
                                        // The distance from node "A" to node "C" is checked.
---------------------------------------
Current Node being visited: C           // The distance from node "A" and node "B" is 3. 
                                        // The distance from node "A" and node "C" is 1. 
                                        // The algorithm traverses to node "C". 
                                        // Node "A" is checked out of the queue.
                                        // The Current Node being visited is now node "C".


Neighbours checked: B   D               // The neighbors to node "C" are nodes "B" and "D". 
                                        // Node "A" is not checked as it has already been traversed, as the root node.
                                        // The distance from node "C" to node "B" is checked. 
                                        // The distance from node "C" to node "D" is checked.
---------------------------------------
Current Node being visited: B           // The distance from node "C" to node "B" is 2, 
                                        // The distance from node "C" to node "D" is 6.
                                        // The algorithm traverses to node "B". 
                                        // Node "C" is checked out of the queue.
                                        // The Current Node being visited is now node "B".


Neighbours checked: C                   // The neighbors to node "B" are nodes "C" and "D".
                                        // The distance from node "B" to node "C" is checked. 
                                        // Node "A" is not checked as it has already been traversed, as the root node.
---------------------------------------
Current Node being visited: D           // The distance from node "B" to node "C" is 7.

                                        It is important to note that the distance from a node "X" to a node "Y" is 
                                        not the same as the distance from a node "Y" to a node "X".
                                        This is because in the traversal path, the weights of the nodes must be 
                                        accounted for when calculating the distance, as shown in the code in line (**).
                                        Therefore, it cannot be assumed that the shortest path from the root node to 
                                        the destination node, is the same as the distance calculated traversing via iteration.

                                        // The algorithm traverses to node "D".
                                        // Node "B" is checked out of the queue.
                                        // The Current Node being visited is now node "D".


Neighbours checked: B                   // The neighbor to node "D" is node "B".
                                        // The distance from node "D" to node "B" is checked.
                                        // The distance from node "D" to node "B" is 3.
                                        // Node "D" is checked out of the queue.
                                        // At this point, the algorithm has visited all the nodes.
                                        // Because the algorithm does not revisit any nodes, no other distances are calculated along a path to a neighbor node.
                                        // All distances from the root node along the traversal path to the neighbor nodes have been calculated.
---------------------------------------

Shortest distances from A:              // The algorithm prints a summary of the calculated shortest distances from the root node "A".
{A=0, B=3, C=1, D=7}                    // The distance to node "A" = 0, as the distance to itself cannot be any value other than 0 as the root node.
                                        // The distance to node "B" = 3, as the distance from node "A" to node "B" was calculated from node "A".
                                        // The distance to node "C" = 1, as the distance from node "A" to node "C" was calculated from node "A".
                                        /* The distance to node "D" = 7, as the distance from node "A" to node "C" was calculated from node "A" as 1, and
                                        the distance from node "C" to node "D" was calculated as 6 from node "C".
                                        
                                        // As stated above, the shortest distance from node "A" to node "D" is not calculated as:
                                        //  The distance from node "A" to node "B" to node "D", because there was no traversal from node "B" to node "D", 
                                        and the resulting traversal from node "A" to node "B" to node "C" to node "D" would be 3 + 7 + 6 = 16, which is twice greater than 7
                                        //  The distance from node "A" to node "B" to node "D", because there were no traversal paths from node "A" to node "B", nor from node "B" to node "D". 


Given all of its considerations, there are best and worst case uses for Dijkstra's Algorithm.
It has a run-time complexity of O(m log n) when implemented with a binary heap (source: https://www.cs.cmu.edu/~anupamg/advalgos15/lectures/lecture04.pdf)
which can be improved to a run-time complexity of O(m + n log n) time with a Fibonacci heap. 
It is better than another Single Source Shortest Path Algorithm, the Bellman-Ford algorithm, 
which has run-time complexity of O(m*n). 
However, in comparison against All Pairs Shortest Paths (APSP) algorithms such as Johnson's Algorithm, which has
a run-time complexity of O(mn + n2 log log n), which is achieved running Dijkstra's Algorithm n times,
and Floyd-Marshall's Algorithm which has a run-time complexity of O(n3), it is much better.

                                        */
