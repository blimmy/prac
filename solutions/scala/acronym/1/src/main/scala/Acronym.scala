object Acronym {
  def abbreviate(phrase: String): String = {
    
    val cleaned = phrase.replaceAll("-", " ")
   
    val lettersOnly = cleaned.replaceAll("[^A-Za-z ]", "")
    
    val acronym = lettersOnly
    // use the space to split 
    /** \s is space , \s+ one or more space , \\s+ escape */
      .split("\\s+")
    
      .filter(_.nonEmpty)
    
      .map(_.charAt(0).toUpper)

    // combine every letter in one string 
      .mkString
    acronym
  }
}
