import scala.collection.mutable.ListBuffer
object StackAndQueue extends App{
  val stackList=ListBuffer[Int]()
  val queueList=ListBuffer[Int]()
  def push(l:ListBuffer[Int],el:Int):ListBuffer[Int]= {l.prepend(el)
    l}
  def pop(l:ListBuffer[Int]):ListBuffer[Int]=l.tail
  def enqueue(l:ListBuffer[Int],el:Int):ListBuffer[Int]=l+=el
  def dequeue(l:ListBuffer[Int]):ListBuffer[Int]=l.tail
  println("STACK : ")
  println(push(stackList,20))
  println(push(stackList,21))
  println(push(stackList,22))
  println(pop(stackList))
  println("QUEUE : ")
  println(enqueue(queueList,20))
  println(enqueue(queueList,21))
  println(enqueue(queueList,22))
  println(dequeue(queueList))
}
