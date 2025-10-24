object Bob {
  def response(statement: String): String = statement.trim match {
    
    case s if s.isEmpty =>
      "Fine. Be that way!"
    case s if s.exists(_.isLetter) &s.forall(c => !c.isLetter || c.isUpper) && s.endsWith("?") =>
      "Calm down, I know what I'm doing!"
    case s if s.exists(_.isLetter) && s.forall(c => !c.isLetter || c.isUpper) =>
      "Whoa, chill out!"
    case s if s.endsWith("?") =>
      "Sure."
    case _ =>
      "Whatever."
  }
}
