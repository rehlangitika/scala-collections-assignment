
object AggregateTester extends App{
  def aggregateLists(srcList1:List[Int],srcList2:List[String],counter:Int,resultList:List[List[Any]]):Unit=
  {
    counter match {
      case counter if counter<0 => print(resultList)
      case _ => {
        val l1 = List(srcList1(counter),srcList2(counter))::resultList
        aggregateLists(srcList1,srcList2,counter-1,l1)
      }
    }
  }
  val s1 = List(1,2,3)
  val s2 = List("a","b","c")
  val s3 = List[List[Any]]()
  aggregateLists(s1,s2,s1.length-1,s3)
  //println(s3)
}
