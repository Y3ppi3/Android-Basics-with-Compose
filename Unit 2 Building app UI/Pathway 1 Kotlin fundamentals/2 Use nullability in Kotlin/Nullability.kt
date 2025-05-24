fun main() {
    // Non-nullable variable
    var nonNullableString: String = "Hello"
    // nonNullableString = null // This would cause a compilation error
    
    // Nullable variable
    var nullableString: String? = "Hello"
    nullableString = null // This is allowed
    println("Nullable string: $nullableString")
    
    // Safe call operator (?.)
    val length = nullableString?.length
    println("Length of nullable string: $length")
    
    // Elvis operator (?:)
    val nonNullLength = nullableString?.length ?: 0
    println("Non-null length: $nonNullLength")
    
    // Not-null assertion operator (!!)
    var notNullString: String? = "Not null"
    val definiteLength = notNullString!!.length
    println("Definite length: $definiteLength")
    
    // notNullString = null
    // val willThrow = notNullString!!.length // This would throw NullPointerException
    
    // Smart cast
    var smartCastExample: String? = "Smart cast example"
    if (smartCastExample != null) {
        // Compiler knows smartCastExample is not null here
        println("Length: ${smartCastExample.length}")
    }
    
    // Safe cast (as?)
    val anyValue: Any = "This is a string"
    val stringValue: String? = anyValue as? String
    println("String value: $stringValue")
    
    val intValue: Int? = anyValue as? Int
    println("Int value: $intValue") // Will be null
    
    // Extension functions with nullability
    println("Is nullableString empty? ${nullableString.isNullOrEmpty()}")
    
    // Function parameter nullability
    printLength(nonNullableString)
    printLength(nullableString) // Works fine because the function handles null
}

fun printLength(text: String?) {
    if (text != null) {
        println("Text length: ${text.length}")
    } else {
        println("Text is null")
    }
}