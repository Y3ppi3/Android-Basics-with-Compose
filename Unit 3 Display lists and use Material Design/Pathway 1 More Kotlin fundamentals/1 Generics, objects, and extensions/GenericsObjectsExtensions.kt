// GENERICS

// Generic class
class Box<T>(var value: T) {
    fun getValue(): T {
        return value
    }
    
    fun setValue(newValue: T) {
        value = newValue
    }
}

// Generic function
fun <T> printArrayElements(array: Array<T>) {
    for (element in array) {
        println(element)
    }
}

// Generic with constraints
interface Comparable {
    fun compareTo(other: Any): Int
}

class NumberBox<T : Number>(val value: T) {
    fun displayValue() {
        println("Value: $value")
    }
}

// Generic with multiple constraints
interface Printable {
    fun print()
}

class PrintableBox<T> where T : Comparable, T : Printable {
    fun addItem(item: T) {
        item.print()
    }
}

// OBJECTS

// Object declaration (singleton)
object DatabaseConnection {
    private var dbName = "main_db"
    private var isConnected = false
    
    fun connect() {
        println("Connecting to database $dbName")
        isConnected = true
    }
    
    fun disconnect() {
        println("Disconnecting from database $dbName")
        isConnected = false
    }
    
    fun isConnected(): Boolean {
        return isConnected
    }
}

// Companion object
class Logger {
    fun log(message: String) {
        println("LOG: $message")
    }
    
    companion object {
        const val LOG_LEVEL = "INFO"
        
        fun create(): Logger {
            println("Creating new logger with level $LOG_LEVEL")
            return Logger()
        }
    }
}

// Object expression (anonymous object)
fun createRunnable(): Runnable {
    return object : Runnable {
        override fun run() {
            println("Running...")
        }
    }
}

// EXTENSIONS

// Extension function
fun String.addExclamation(): String {
    return this + "!"
}

// Extension function with parameters
fun String.repeatTimes(times: Int): String {
    return this.repeat(times)
}

// Extension property
val String.lastChar: Char
    get() = this[this.length - 1]

// Extension function for nullable type
fun String?.isNullOrBlank(): Boolean {
    return this == null || this.isBlank()
}

// Companion object extension
class DateUtil {
    companion object {}
}

fun DateUtil.Companion.currentDate(): String {
    return "2025-05-24"
}

// Main function to showcase all features
fun main() {
    println("=== GENERICS ===")
    // Using generic class
    val intBox = Box<Int>(42)
    println("Value in intBox: ${intBox.getValue()}")
    intBox.setValue(100)
    println("Updated value in intBox: ${intBox.getValue()}")
    
    val stringBox = Box<String>("Hello, Kotlin!")
    println("Value in stringBox: ${stringBox.getValue()}")
    
    // Using generic function
    val intArray = arrayOf(1, 2, 3, 4, 5)
    val stringArray = arrayOf("apple", "banana", "cherry")
    
    println("Integer array elements:")
    printArrayElements(intArray)
    
    println("String array elements:")
    printArrayElements(stringArray)
    
    // Using constrained generic
    val intNumberBox = NumberBox<Int>(10)
    intNumberBox.displayValue()
    
    val doubleNumberBox = NumberBox<Double>(10.5)
    doubleNumberBox.displayValue()
    
    println("\n=== OBJECTS ===")
    // Using singleton object
    DatabaseConnection.connect()
    println("Database connected: ${DatabaseConnection.isConnected()}")
    DatabaseConnection.disconnect()
    println("Database connected: ${DatabaseConnection.isConnected()}")
    
    // Using companion object
    println("Logger level: ${Logger.LOG_LEVEL}")
    val logger = Logger.create()
    logger.log("This is a log message")
    
    // Using anonymous object
    val runnable = createRunnable()
    runnable.run()
    
    println("\n=== EXTENSIONS ===")
    // Using extension functions
    val greeting = "Hello"
    println(greeting.addExclamation())
    println(greeting.repeatTimes(3))
    
    // Using extension property
    println("Last character of '$greeting' is '${greeting.lastChar}'")
    
    // Using nullable extension
    val nullString: String? = null
    println("Is null string blank? ${nullString.isNullOrBlank()}")
    
    // Using companion object extension
    println("Current date: ${DateUtil.currentDate()}")
}