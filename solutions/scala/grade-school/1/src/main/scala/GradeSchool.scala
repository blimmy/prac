import scala.collection.mutable

class School {
  
  type DB = Map[Int, Seq[String]]

  private val roster = mutable.Map[Int, Seq[String]]() 

  def add(name: String, g: Int): School = {

  // roster.getOrElse(g,Seq()) = check if theres g ?
  // no g -> build new list 
    roster.update(g, roster.getOrElse(g, Seq()) :+ name)

  // ans
    this
  }
  
  def db: DB = roster.toMap

  def grade(g: Int): Seq[String] =
    roster.getOrElse(g, Seq.empty)

  def sorted: DB =
    roster.toSeq

  // sort num Seq((1, ...), (2, ...))
      .sortBy(_._1)

  // sort the name (grade, names.sorted)
      .map { case (grade, names) => grade -> names.sorted }
      .toMap
}

