package ch.mse.app.typeclass

object Logging {
  type Printer = String => Unit

  def blue: Printer = s => println(Console.BLUE + s)
  def red: Printer = s => println(Console.RED + s.toUpperCase())

  given out: Printer = blue

  given datePrefix: String = s"${java.time.LocalDate.now}>>"
  // given String = s"${java.time.LocalDate.now}>>"
  // given timePrefix: String = s"${java.time.LocalTime.now}>>"

  def log(msg: String)(using out: Printer): Unit = out(msg)
  def logTimed(msg: String)(using out: Printer): Unit = log("[" + new java.util.Date + "] " + msg)
  def logPrefixed(msg: String)(using out: Printer, prefix: String): Unit = log("[" + prefix + "] " + msg)
  def logPrefixed2(msg: String)(using out: Printer)(using prefix: String): Unit = logPrefixed(msg)


  def main(args: Array[String]): Unit = {
    log("Normal message")
    log("Error message")(using red)
    logTimed("Hello")
    logTimed("Hello")(using red)
    logPrefixed("Hello")
    Thread.sleep(1000)
    logPrefixed("Hello")
    logPrefixed("Hello")(using summon[Printer], ">>")
    logPrefixed("Hello")(using summon, summon)

    // logPrefixed2("Hello2")
    // //logPrefixed2("Hello")(using ">>") // this does not compile
    // logPrefixed2("Hello")(using summon)(using ">>")
    // logPrefixed2("Hello")(using red)
    // logPrefixed2("Hello")(using red)(using ">>")
  }
}
