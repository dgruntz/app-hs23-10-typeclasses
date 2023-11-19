package ch.mse.app.path

object Fluent2 {
  class Document {
    def setTitle(title: String): this.type = { /* do something; */ this }
    def setAuthor(author: String): this.type = { /* do something; */ this }
  }

  class Book extends Document {
    def addChapter(chapter: String): this.type = { /* do something; */ this }
  }

  def main(args: Array[String]): Unit =  {
    val book = new Book()
    book.setTitle("Scala")
    book.setTitle("Scala").addChapter("chapter1")
  }
}
