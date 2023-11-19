package ch.mse.app.path

sealed trait DocumentAttribute
object Title extends DocumentAttribute
object Author extends DocumentAttribute

class Document { 
  var title: String = ""
  var author: String = ""
  private var useNextArgAs: DocumentAttribute = null
  def set(obj: DocumentAttribute) = { useNextArgAs = obj; this }
  def to(arg: String) = useNextArgAs match {
    case Title => title = arg; this
    case Author => author = arg; this
  }
  override def toString() = s"Book(Title=$title, Author=$author)"
  //…
}

object DocumentTest {
  def main(args: Array[String]): Unit = {
    val book = new Document
    book.set(Title).to("Scala")

    book set Title to "Scala" set Author to "Cay Horstmann"
    println(book)
  }
}


