package day6;

import java.util.*;

class Vertex {
    // A Vertex in a graph.
    int label;

    public Vertex(int label) {
        // Create a vertex, with int label.
        this.label = label;
    }

    public int label() {
        // Return the label for the vertex.
        return this.label;
    }

    @Override
    public String toString() {
        return String.valueOf(this.label);
    }
}
class Pair<T> {
    private T objectOne; // The first object in the Pair
    private T objectTwo; // The second object in the Pair

    public Pair() {}

    public Pair(T objectOne, T objectTwo) {
        this.objectOne = objectOne;
        this.objectTwo = objectTwo;
    }

    public T one() {
        return objectOne;
    }

    public T two() {
        return objectTwo;
    }

    @Override
    public String toString() {
        return "(" + objectOne + ", " + objectTwo + ")";
    }
}

class Edge {
    /*An edge in a graph.
      Implemented with an order, so can be used for directed or undirected
      graphs. Methods are provided for both. It is the job of the Graph class
      to handle them as directed or undirected.*/
    Pair<Vertex> vertices;
    int weight;

    public Edge(Vertex v, Vertex w, int weight) {
    /*Create an edge between vertices v and w, with weight.
      element can be an arbitrarily complex structure.*/
        this.vertices = new Pair<>(v, w);
        this.weight = weight;
    }

    public Pair<Vertex> vertices() {
        // Return an ordered pair of the vertices of this edge.
        return this.vertices;
    }

    public Vertex start() {
        // Return the first vertex in the ordered pair.
        return this.vertices.one();
    }

    public Vertex end() {
        // Return the first vertex in the ordered pair.
        return this.vertices.two();
    }

    public Vertex opposite(Vertex v) {
        // Return the opposite vertex to v in this edge.
        if (this.vertices.one() == v) {
            return this.vertices.two();
        } else if (this.vertices.two() == v) {
            return this.vertices.one();
        } else {
            return null;
        }
    }

    public int weight() {
        // Return the data element for this edge.
        return this.weight;
    }

    @Override
    public String toString() {
        // Return a string representation of this edge.
        return "(" + this.vertices.one() + "--" + this.vertices.two() + " : " + this.weight + ")";
    }
}


public class Graph {

    /*Represent a simple graph.
    This version maintains only undirected graphs, and assumes no
    self loops.
    Adjacency map implementation - dictionary of dictionaries
     - the keys are the vertices
     - the values are the sets of edges for the corresponding vertex.
       Each edge set is also maintained as a dictionary,
       with the opposite vertex as the key and the edge object as the value.*/

    Map<Vertex, Map<Vertex, Edge>> structure;

    public Graph() {
        // Create an initial empty graph.
        this.structure = new HashMap<>();
    }

    @Override
    public String toString() {
        // Return a string representation of the graph.
        String hstr = "|V| = " + this.numVertices() + "; |E| = " + this.numEdges();
        StringBuilder vstr = new StringBuilder("\nVertices: ");
        for (Vertex v : this.structure.keySet()) {
            vstr.append(v).append("-");
        }
        List<Edge> edges = this.edges();
        StringBuilder estr = new StringBuilder("\nEdges: ");
        for (Edge e : edges) {
            estr.append(e).append(" ");
        }
        return hstr + vstr + estr;
    }

    // --------------------------------------------------
    // ADT methods to query the graph

    public int numVertices() {
        // Return the number of vertices in the graph.
        return this.structure.size();
    }

    public int numEdges() {
        // Return the number of edges in the graph.
        int num = 0;
        for (Vertex v : this.structure.keySet()) {
            num += this.structure.get(v).size();  // the dict of edges for v
        }
        return num / 2;  // divide by 2, since each edge appears in the
        // vertex list for both of its vertices
    }

    public List<Vertex> vertices() {
        // Return a list of all vertices in the graph.
        if (!this.structure.isEmpty()) {
            return new ArrayList<>(this.structure.keySet());
        } else {
            return null;
        }
    }

    public Vertex getVertexByLabel(int label) {
        // get the first vertex that matches element.
        for (Vertex v : this.structure.keySet()) {
            if (v.label() == label) {
                return v;
            }
        }
        return null;
    }

    public List<Edge> edges() {
        // Return a list of all edges in the graph.
        List<Edge> edgeList = new ArrayList<>();
        for (Vertex v : this.structure.keySet()) {
            for (Vertex w : this.structure.get(v).keySet()) {
                // to avoid duplicates, only return if v is the first vertex
                if (this.structure.get(v).get(w).start() == v) {
                    edgeList.add(this.structure.get(v).get(w));
                }
            }
        }
        return edgeList;
    }

    public List<Edge> getEdges(Vertex v) {
        // Return a list of all edges incident on v.
        if (this.structure.containsKey(v)) {
            List<Edge> edgeList = new ArrayList<>();
            for (Vertex w : this.structure.get(v).keySet()) {
                edgeList.add(this.structure.get(v).get(w));
            }
            return edgeList;
        }
        return null;
    }

    public Edge getEdge(Vertex v, Vertex w) {
        // Return the edge between v and w, or None.
        if (!this.structure.isEmpty() && this.structure.containsKey(v) && this.structure.get(v).containsKey(w)){
            return this.structure.get(v).get(w);
        }
        return null;
    }

    public int degree(Vertex v) {
        // Return the degree of vertex v.
        return this.structure.get(v).size();
    }

    // --------------------------------------------------
    // ADT methods to modify the graph

    public Vertex addVertex(int label) {
        /* Add a new vertex with data element.
            If there is already a vertex with the same data element,
            this will create another vertex instance.*/
        Vertex v = new Vertex(label);
        this.structure.put(v, new HashMap<>());
        return v;
    }

    public Vertex addVertexIfNew(int label) {
        /* Add and return a vertex with element, if not already in graph.
            Checks for equality between the elements. If there is special
            meaning to parts of the element (e.g. element is a tuple, with an
            'id' in cell 0), then this method may create multiple vertices with
            the same 'id' if any other parts of element are different.
            To ensure vertices are unique for individual parts of element,
            separate methods need to be written.*/
        for (Vertex v : this.structure.keySet()) {
            if (v.label() == label) {
                return v;
            }
        }
        return this.addVertex(label);
    }

    public Edge addEdge(Vertex v, Vertex w, Integer label) {
        /* Add and return an edge between two vertices v and w, with  element.
            If either v or w are not vertices in the graph, does not add, and
            returns None.
            If an edge already exists between v and w, this will
            replace the previous edge.*/
        if (!this.structure.containsKey(v) || !this.structure.containsKey(w)) {
            return null;
        }
        Edge e = new Edge(v, w, label);
        this.structure.get(v).put(w, e);
        this.structure.get(w).put(v, e);
        return e;
    }

    public void addEdgePairs(List<Pair<Vertex>> elist) {
        // add all vertex pairs in elist as edges with empty elements.
        for (Pair<Vertex> pair : elist){
            this.addEdge(pair.one(), pair.two(), null);
        }
    }
}