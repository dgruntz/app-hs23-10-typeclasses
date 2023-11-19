package ch.mse.app.path

object Fluent1 {
  class Document {
    def setTitle(title: String) = { /* do something; */ this }
    def setAuthor(author: String) = { /* do something; */ this }
  }

  class Book extends Document {
    def addChapter(chapter: String) = { /* do something; */ this }
  }

  def main(args: Array[String]): Unit =  {
    val book = new Book()
    book.setTitle("Scala")
    // book.setTitle("Scala").addChapter("chapter1")
    //    Error: value addChapter is not a member of Document
  }
}
