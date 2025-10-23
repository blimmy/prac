object Twofer {
  def twofer(name: String = ""): String = name match {
    case "" => "One for you, one for me."
    case n => s"One for $n, one for me."
  }
}

