package tarjan

import scala.collection.mutable.ListBuffer

class Graph[T] (
  val nodes: ListBuffer[Node[T]] = ListBuffer[Node[T]](),
  val edges: ListBuffer[Edge[T]] = ListBuffer[Edge[T]]()    
) {
  
  def addAll (ts: Node[T]*) {
    ts.map { t => nodes.+=(t) }
  }
  
  def connect (n1: Node[T], n2: Node[T]) {
    if (n1.eq(n2)) throw new Exception("Nodes must not equal (" + n1 + ", " + n2 + ")!")
    edges.+=(new Edge(n1, n2))
  }
  
}