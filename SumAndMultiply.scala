object SumAndMultiply extends App{
val l =List[Int](1,2,3,4,5)
def sumOfList(srcList:List[Int],counter:Int,result:Int):Unit={
  counter match {
    case counter if counter<0=>println(result)
    case x => {
      val element = srcList(x)
      sumOfList(srcList,counter-1,result+element)
    }
  }
}

  def multiplyOfList(srcList:List[Int],counter:Int,result:Int):Unit={
    counter match {
      case counter if counter<0=>println(result)
      case x => {
        val element = srcList(x)
        multiplyOfList(srcList,counter-1,result*element)
      }
    }
  }
  val list1 = List(1,2,3,4)
  sumOfList(list1, list1.length-1, 0)
  multiplyOfList(list1,list1.length-1,1)

}
