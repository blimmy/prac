object ReverseString {

  def reverse(str: String): String = {
    if (str.isEmpty) ""
    else {
      def Trev(s: String, acc: String): String = s match {
        case "" => acc
        case _  => Trev(s.tail, s.head + acc)
      }

      Trev(str, "")
    }
  }

}
