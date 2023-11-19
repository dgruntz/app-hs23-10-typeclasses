package ch.mse.app.path

object Fluent3 {
  class Document[T] {
    this: T =>
    def setTitle(title: String): T = { /* do something; */ this }
    def setAuthor(author: String): T = { /* do something; */ this }
  }

  class Book extends Document[Book] {
    def addChapter(chapter: String): Document[Book] = { /* do something; */ this }
  }

  def main(args: Array[String]): Unit =  {
    val book = new Book()
    val x: Document[Book] = book.setTitle("Scala")
    book.setTitle("Scala").addChapter("chapter1")
  }
}
