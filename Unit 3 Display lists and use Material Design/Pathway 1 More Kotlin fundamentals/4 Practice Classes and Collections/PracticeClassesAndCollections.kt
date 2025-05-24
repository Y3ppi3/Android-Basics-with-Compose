// Task 1: Create a Book class with properties for title, author, year, and genre
class Book(
    val title: String,
    val author: String,
    val year: Int,
    val genre: String
) {
    override fun toString(): String {
        return "$title by $author ($year) - $genre"
    }
}

// Task 2: Create a Library class that manages a collection of books
class Library {
    private val books = mutableListOf<Book>()
    
    // Add a book to the library
    fun addBook(book: Book) {
        books.add(book)
    }
    
    // Add multiple books to the library
    fun addBooks(booksList: List<Book>) {
        books.addAll(booksList)
    }
    
    // Get all books
    fun getAllBooks(): List<Book> {
        return books.toList() // Return a copy of the list
    }
    
    // Find books by author
    fun findBooksByAuthor(author: String): List<Book> {
        return books.filter { it.author.equals(author, ignoreCase = true) }
    }
    
    // Find books by genre
    fun findBooksByGenre(genre: String): List<Book> {
        return books.filter { it.genre.equals(genre, ignoreCase = true) }
    }
    
    // Find books published after a certain year
    fun findBooksPublishedAfter(year: Int): List<Book> {
        return books.filter { it.year > year }
    }
    
    // Find the oldest book
    fun findOldestBook(): Book? {
        return books.minByOrNull { it.year }
    }
    
    // Count books by genre
    fun countBooksByGenre(): Map<String, Int> {
        return books.groupingBy { it.genre }.eachCount()
    }
    
    // Get the average publication year
    fun getAveragePublicationYear(): Double {
        if (books.isEmpty()) return 0.0
        return books.map { it.year }.average()
    }
    
    // Check if a specific book exists in the library
    fun containsBook(title: String): Boolean {
        return books.any { it.title.equals(title, ignoreCase = true) }
    }
    
    // Remove a book by title
    fun removeBook(title: String): Boolean {
        val bookToRemove = books.find { it.title.equals(title, ignoreCase = true) }
        return books.remove(bookToRemove)
    }
    
    // Get book titles sorted alphabetically
    fun getBookTitlesSorted(): List<String> {
        return books.map { it.title }.sorted()
    }
    
    // Get the most recent book
    fun getMostRecentBook(): Book? {
        return books.maxByOrNull { it.year }
    }
    
    // Get authors and their book counts
    fun getAuthorsAndBookCounts(): Map<String, Int> {
        return books.groupingBy { it.author }.eachCount()
    }
}

fun main() {
    // Create a library
    val library = Library()
    
    // Add some books
    library.addBooks(listOf(
        Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "Novel"),
        Book("To Kill a Mockingbird", "Harper Lee", 1960, "Novel"),
        Book("1984", "George Orwell", 1949, "Dystopian"),
        Book("Animal Farm", "George Orwell", 1945, "Dystopian"),
        Book("The Hobbit", "J.R.R. Tolkien", 1937, "Fantasy"),
        Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, "Fantasy"),
        Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997, "Fantasy"),
        Book("Brave New World", "Aldous Huxley", 1932, "Dystopian"),
        Book("Pride and Prejudice", "Jane Austen", 1813, "Romance"),
        Book("The Catcher in the Rye", "J.D. Salinger", 1951, "Novel")
    ))
    
    // Display all books
    println("=== All Books ===")
    library.getAllBooks().forEach { println(it) }
    
    // Display books by George Orwell
    println("\n=== Books by George Orwell ===")
    library.findBooksByAuthor("George Orwell").forEach { println(it) }
    
    // Display fantasy books
    println("\n=== Fantasy Books ===")
    library.findBooksByGenre("Fantasy").forEach { println(it) }
    
    // Display books published after 1950
    println("\n=== Books Published After 1950 ===")
    library.findBooksPublishedAfter(1950).forEach { println(it) }
    
    // Display the oldest book
    println("\n=== Oldest Book ===")
    println(library.findOldestBook())
    
    // Display book counts by genre
    println("\n=== Book Counts by Genre ===")
    library.countBooksByGenre().forEach { (genre, count) ->
        println("$genre: $count")
    }
    
    // Display average publication year
    println("\n=== Average Publication Year ===")
    println(library.getAveragePublicationYear())
    
    // Check if a specific book exists
    val bookTitle = "1984"
    println("\n=== Book Check ===")
    if (library.containsBook(bookTitle)) {
        println("The library contains '$bookTitle'")
    } else {
        println("The library does not contain '$bookTitle'")
    }
    
    // Display book titles sorted alphabetically
    println("\n=== Book Titles (Sorted) ===")
    library.getBookTitlesSorted().forEach { println(it) }
    
    // Display the most recent book
    println("\n=== Most Recent Book ===")
    println(library.getMostRecentBook())
    
    // Display authors and their book counts
    println("\n=== Authors and Book Counts ===")
    library.getAuthorsAndBookCounts().forEach { (author, count) ->
        println("$author: $count book(s)")
    }
    
    // Remove a book
    val bookToRemove = "Animal Farm"
    println("\n=== Removing Book ===")
    if (library.removeBook(bookToRemove)) {
        println("'$bookToRemove' has been removed from the library")
    } else {
        println("'$bookToRemove' was not found in the library")
    }
    
    // Display all books after removal
    println("\n=== Updated Book List ===")
    library.getAllBooks().forEach { println(it) }
}