/**
  * Created by knodus on 23/1/17.
  */

case class Student(id:Long,name:String)
case class Marks(subjectId:Int,studentId:Long,marksObtained:Float){
  def isPass(percentage:Int):Boolean={
    if(marksObtained>=percentage) true else false
  }

}


object ResultCounter1 extends App {


  val marksList = List(Marks(1, 1, 95), Marks(1, 2, 67), Marks(1, 3, 89), Marks(1, 4, 78), Marks(1, 5, 90), Marks(1, 6, 54), Marks(1, 7, 40), Marks(1, 8, 70), Marks(1, 9, 35), Marks(1, 10, 60), Marks(5, 1, 95), Marks(5, 2, 67), Marks(5, 3, 89), Marks(5, 4, 78), Marks(5, 5, 90), Marks(5, 6, 54), Marks(5, 7, 40), Marks(5, 8, 70), Marks(5, 9, 35), Marks(5, 10, 60), Marks(2, 1, 95), Marks(2, 2, 67), Marks(2, 3, 89), Marks(2, 4, 78), Marks(2, 5, 90), Marks(2, 6, 54), Marks(2, 7, 40), Marks(2, 8, 70), Marks(2, 9, 35), Marks(2, 10, 60), Marks(3, 1, 95), Marks(3, 2, 67), Marks(3, 3, 89), Marks(3, 4, 78), Marks(3, 5, 90), Marks(3, 6, 54), Marks(3, 7, 40), Marks(3, 8, 70), Marks(3, 9, 35), Marks(3, 10, 60), Marks(4, 1, 95), Marks(4, 2, 67), Marks(4, 3, 89), Marks(4, 4, 78), Marks(4, 5, 90), Marks(4, 6, 54), Marks(4, 7, 40), Marks(4, 8, 70), Marks(4, 9, 35), Marks(4, 10, 60))

  val studentList = List(Student(1, "Kunal"), Student(2, "Himanshu"), Student(3, "Anmol"), Student(4, "Geetika"), Student(5, "Mahesh"), Student(6, "Simarpreet"), Student(7, "Ramandeep"), Student(8, "Anuj"), Student(9, "Jatin"), Student(10, "Pankhuri"))

  def checkPassCount(subjectId: Int, percentage: Int, result: String): String = {

    result.toLowerCase match {
      case "pass" =>
        s"Pass count: ${marksList.flatMap(x => if (x.subjectId == subjectId && x.isPass(percentage)) Some(x) else None).length.toString}"
      case "fail" =>
        s"Fail count: ${marksList.flatMap(x => if (x.subjectId == subjectId && !x.isPass(percentage)) Some(x) else None).length.toString}"
      case _ => "Heyy"
    }

  }

  /*
  * Function to show student details having particular percentage
  * */
  def showStudentDetails(subjectId : Int, count : Int, extreme : String) = {

    // val marksSelected = for(marks <- marksList.filter(_.subjectId == subjectId).sortBy(_.marksObtained))yield marks
    val marksSelected = sort(subjectId, marksList )
    val resultList = extractSome(count, marksSelected)
    s"$resultList"
     val student =  for(marks<-resultList) yield {
         for(student<-studentList if(marks.studentId == student.id)) yield {
           (student.name +" "+ marks.marksObtained)
         }
       }
    s"$student"
  }

  /* Sort list according to marks obtained in particular subject
  * */
  private def sort(subjectId : Int, marksList : List[Marks]) : List[Marks]= {
    val sortedList = for(marks <- marksList.filter(_.subjectId == subjectId).sortBy(_.marksObtained))yield marks
    sortedList
  }
  /*
  * extract count no of list elements
  * */
  private def extractSome(count : Int, list : List[Marks])={
    //val newList1 = List[Int]()
    val newList2 = for(i<- 0 to count-1)yield list(i)
    newList2
  }
/*
  private def sortOnAggregate(marksList : List[Marks],studentList:List[Student]) : List[Marks]= {
    val sortedList = for(student<-studentList) yield {
      for(marks <- marksList.filter(_.studentId==student.id).sum(_.marksObtained).sortBy(_.marksObtained))yield marks
    sortedList
    }
  }
*/


  println("Pass/Fail Count is: " + checkPassCount(1, 50, "pass"))
  println("Pass/Fail Count is: " + checkPassCount(1, 95, "fail"))
  println("Student details: "+ showStudentDetails(1,5,"top"))
  //println(  sumOfList(marksList,marksList.length,0))
}

