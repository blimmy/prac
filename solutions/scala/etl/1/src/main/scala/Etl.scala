object Etl {
  
  def transform(scoreMap: Map[Int, Seq[String]]): Map[String, Int] = {

    // 3 -> F Y T
    // 3 -> F , 3 -> Y
    scoreMap.flatMap {
      case ( score , letters ) => letters.map(letter => letter.toLowerCase -> score )
    }
    }
}
