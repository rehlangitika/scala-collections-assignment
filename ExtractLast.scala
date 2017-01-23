
object ExtractLast extends App {
def recList(srcList:List[Int]):Int={
  srcList match{
    case Nil=>throw new Exception("Empty list")
    case x::Nil=> x
    case x::xs=>recList(xs)
  }
}
  val l = List(1,2,3,4,5)
  println(recList(l))
}
