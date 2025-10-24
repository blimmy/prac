object Hamming {

  
  def distance(dnaStrandOne: String, dnaStrandTwo: String): Option[Int] = {

    if ( dnaStrandOne.length != dnaStrandTwo.length ) None 
    else {
      
      val list1 = dnaStrandOne.toList
      val list2 = dnaStrandTwo.toList

      // tailrec
    
      def Tdistance(a: List[Char],b: List[Char], acc: Int): Int = (a,b) match {
        case ( Nil, Nil ) => acc
        case ( x :: xs , y :: ys ) =>
          if ( x != y ) Tdistance(xs,ys,acc+1) 
          else Tdistance(xs,ys,acc) 
      }

      Some(Tdistance(list1,list2,0))

    }
    }
    


  
}

