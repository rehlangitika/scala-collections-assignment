object TableTester extends App{
  def tableGenerator(l1:List[Int]):List[List[Int]]= {
    l1 map(x => List(x,x*2,x*3,x*4,x*5,x*6,x*7,x*8,x*9,x*10))
  }
  val l=List(1,2,3,4)
  val l2=tableGenerator(l)
  println (l2)
}
