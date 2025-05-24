fun main() {
    // If-else statement
    val age = 18
    
    if (age >= 18) {
        println("You can vote!")
    } else {
        println("You cannot vote yet.")
    }
    
    // If-else if-else
    val score = 85
    
    if (score >= 90) {
        println("Grade: A")
    } else if (score >= 80) {
        println("Grade: B")
    } else if (score >= 70) {
        println("Grade: C")
    } else if (score >= 60) {
        println("Grade: D")
    } else {
        println("Grade: F")
    }
    
    // When expression
    val day = 3
    
    val dayName = when (day) {
        1 -> "Monday"
        2 -> "Tuesday"
        3 -> "Wednesday"
        4 -> "Thursday"
        5 -> "Friday"
        6 -> "Saturday"
        7 -> "Sunday"
        else -> "Invalid day"
    }
    println("Day $day is $dayName")
    
    // When with range
    val temperature = 28
    
    when (temperature) {
        in Int.MIN_VALUE..0 -> println("Freezing")
        in 1..10 -> println("Very cold")
        in 11..20 -> println("Cold")
        in 21..30 -> println("Warm")
        else -> println("Hot")
    }
    
    // When without argument
    when {
        age < 13 -> println("Child")
        age < 18 -> println("Teenager")
        age < 65 -> println("Adult")
        else -> println("Senior")
    }
    
    // Using if as an expression
    val message = if (age >= 18) "Adult" else "Minor"
    println("Status: $message")
    
    // Using when as an expression
    val season = 3
    val seasonName = when (season) {
        1 -> "Spring"
        2 -> "Summer"
        3 -> "Fall"
        4 -> "Winter"
        else -> "Invalid season"
    }
    println("Season: $seasonName")
}