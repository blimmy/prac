import java.time.LocalDate

object LensPerson {
  case class Person(_name: Name, _born: Born, _address: Address)

  case class Name(_foreNames: String /*Space separated*/ , _surName: String)

  

  // Value of java.time.LocalDate.toEpochDay
  type EpochDay = Long

  case class Born(_bornAt: Address, _bornOn: EpochDay)

  case class Address(_street: String, _houseNumber: Int,
    _place: String /*Village / city*/ , _country: String)

  // Valid values of Gregorian are those for which 'java.time.LocalDate.of'
  // returns a valid LocalDate.
  case class Gregorian(_year: Int, _month: Int, _dayOfMonth: Int)

  // Implement these.


  
  val bornStreet: Born => String = b => b._bornAt._street

  val setCurrentStreet: String => Person => Person =
  newStreet => p => p.copy(
    _address = p._address.copy(_street = newStreet)
  )

  val setBirthMonth: Int => Person => Person =
  month => p => {
    val current = LocalDate.ofEpochDay(p._born._bornOn)
    val updated = current.withMonth(month)
    p.copy(_born = p._born.copy(_bornOn = updated.toEpochDay))
  }


  // Transform both birth and current street names.
  val renameStreets: (String => String) => Person => Person =
  f => p => {
    val newCurrentAddr = p._address.copy(_street = f(p._address._street))
    val newBirthAddr   = p._born._bornAt.copy(_street = f(p._born._bornAt._street))
    p.copy(
      _address = newCurrentAddr,
      _born = p._born.copy(_bornAt = newBirthAddr)
    )
  }

}
