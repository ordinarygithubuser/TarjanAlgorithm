package tarjan

class Node[T] (obj: T) {
  
  var index: Int = -1
  var link: Int = -2
  var visited = false
  
  def init (pointer: Int) {
    index = pointer
    link = pointer
    visited = true
  }
  
  def adjustLink (value: Int) {
    if (value < link) link = value
  }
  
  def linkIsIndex (): Boolean = {
    link == index
  }
  
  override def toString (): String = {
    "N[" + obj.toString + "]"
  }
  
}