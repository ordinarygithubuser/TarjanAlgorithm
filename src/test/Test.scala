package test

import tarjan.Graph
import tarjan.Node
import tarjan.Tarjan

object Test {

  def main(args: Array[String]): Unit = {
    val tarjan = new Tarjan(buildExampleGraph)
    print(tarjan.findComponents())
  }
  
  def buildExampleGraph (): Graph[String] = {
    val graph = new Graph[String]()
    val n1 = new Node("n1")
    val n2 = new Node("n2")
    val n3 = new Node("n3")
    val n4 = new Node("n4")
    val n5 = new Node("n5")
    val n6 = new Node("n6")
    
    graph.addAll(n1, n2, n3, n4, n5, n6)
    graph.connect(n1, n2)
    graph.connect(n2, n3)
    graph.connect(n3, n1)
    graph.connect(n4, n5)
    graph.connect(n5, n6)
    graph
  }
  
}