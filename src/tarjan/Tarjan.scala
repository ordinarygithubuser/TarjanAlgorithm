package tarjan

import scala.collection.mutable.Stack
import scala.collection.mutable.ListBuffer

class Tarjan[T] (graph: Graph[T]) {

  private val components = ListBuffer[ListBuffer[Node[T]]]()
  private val stack = Stack[Node[T]]()
  private var pointer = 0
  
  def findComponents (): ListBuffer[ListBuffer[Node[T]]] = {
    graph.nodes.map { node => 
      if (!node.visited) tarjan(node)
    }
    components
  }
  
  private def tarjan (node: Node[T]) {
    node.init(pointer)
    stack.push(node)
    pointer += 1
    
    getNeighbours(node, graph.edges).map { neighbor =>  
      if (graph.nodes.contains(neighbor) && !neighbor.visited) {
        tarjan(neighbor)
        node.adjustLink(neighbor.link)
      } else if (stack.contains(neighbor)) {
        node.adjustLink(neighbor.index)
      }
    }
    if (node.linkIsIndex) {
      components.+=(createComponent(node))
    }
  }
  
  private def createComponent (node: Node[T]): ListBuffer[Node[T]] = {
    val component = ListBuffer[Node[T]]()
    while (true) {
      val current = stack.pop
      component.+=(current)
      if (current.eq(node)) return component
    }
    component
  }
  
  private def getNeighbours (node: Node[T], edges: ListBuffer[Edge[T]]): ListBuffer[Node[T]] = {
      edges
        .filter { edge => edge.source.eq(node) || edge.target.eq(node) }
        .map { edge => if (edge.source.eq(node)) edge.target else edge.source }
  }
  
}