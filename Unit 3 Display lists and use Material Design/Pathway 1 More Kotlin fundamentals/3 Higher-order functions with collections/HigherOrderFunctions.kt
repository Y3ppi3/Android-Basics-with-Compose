fun main() {
    // Sample data
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val fruits = listOf("apple", "banana", "cherry", "date", "elderberry", "fig", "grape")
    val people = listOf(
        Person("Alice", 28),
        Person("Bob", 35),
        Person("Charlie", 22),
        Person("Diana", 41),
        Person("Eve", 30)
    )
    
    println("=== FILTER ===")
    // Basic filter
    val evenNumbers = numbers.filter { it % 2 == 0 }
    println("Even numbers: $evenNumbers")
    
    // Filter with complex condition
    val shortFruits = fruits.filter { it.length <= 5 }
    println("Fruits with 5 or fewer characters: $shortFruits")
    
    // Filter on class properties
    val youngPeople = people.filter { it.age < 30 }
    println("People younger than 30: ${youngPeople.map { it.name }}")
    
    // filterNot
    val oddNumbers = numbers.filterNot { it % 2 == 0 }
    println("Odd numbers: $oddNumbers")
    
    println("\n=== MAP ===")
    // Basic map
    val squaredNumbers = numbers.map { it * it }
    println("Squared numbers: $squaredNumbers")
    
    // Map with transformation
    val fruitLengths = fruits.map { "${it.capitalize()} has ${it.length} letters" }
    println("Fruit lengths:")
    fruitLengths.forEach { println(it) }
    
    // Map to a different type
    val peopleAges = people.map { it.age }
    println("Ages of all people: $peopleAges")
    
    println("\n=== COMBINATION OF OPERATIONS ===")
    // Chaining operations
    val sumOfSquaredEvenNumbers = numbers
        .filter { it % 2 == 0 }
        .map { it * it }
        .sum()
    println("Sum of squared even numbers: $sumOfSquaredEvenNumbers")
    
    // Names of people older than 30, uppercase
    val olderPeopleNames = people
        .filter { it.age > 30 }
        .map { it.name.uppercase() }
    println("Uppercase names of people older than 30: $olderPeopleNames")
    
    println("\n=== FIND / FIRST / LAST ===")
    // find (returns first matching element or null)
    val firstEven = numbers.find { it % 2 == 0 }
    println("First even number: $firstEven")
    
    // first (throws exception if no element matches)
    try {
        val firstLongFruit = fruits.first { it.length > 10 }
        println("First fruit with more than 10 characters: $firstLongFruit")
    } catch (e: NoSuchElementException) {
        println("No fruit has more than 10 characters")
    }
    
    // firstOrNull (returns null if no element matches)
    val firstShortFruit = fruits.firstOrNull { it.length < 4 }
    println("First fruit with fewer than 4 characters: $firstShortFruit")
    
    // last and lastOrNull
    val lastEven = numbers.last { it % 2 == 0 }
    println("Last even number: $lastEven")
    
    println("\n=== ANY / ALL / NONE ===")
    // any (returns true if at least one element matches)
    val hasEven = numbers.any { it % 2 == 0 }
    println("Does the collection have any even numbers? $hasEven")
    
    // all (returns true if all elements match)
    val allPositive = numbers.all { it > 0 }
    println("Are all numbers positive? $allPositive")
    
    // none (returns true if no elements match)
    val hasNoNegatives = numbers.none { it < 0 }
    println("Are there no negative numbers? $hasNoNegatives")
    
    println("\n=== COUNT / SUM / AVERAGE ===")
    // count
    val evenCount = numbers.count { it % 2 == 0 }
    println("Count of even numbers: $evenCount")
    
    // sum (only available on numeric collections)
    val totalSum = numbers.sum()
    println("Sum of all numbers: $totalSum")
    
    // average (only available on numeric collections)
    val average = numbers.average()
    println("Average of all numbers: $average")
    
    println("\n=== MIN / MAX ===")
    // minOrNull and maxOrNull
    val minNumber = numbers.minOrNull()
    val maxNumber = numbers.maxOrNull()
    println("Min: $minNumber, Max: $maxNumber")
    
    // minBy and maxBy
    val shortestFruit = fruits.minByOrNull { it.length }
    val longestFruit = fruits.maxByOrNull { it.length }
    println("Shortest fruit: $shortestFruit, Longest fruit: $longestFruit")
    
    // Youngest and oldest person
    val youngest = people.minByOrNull { it.age }
    val oldest = people.maxByOrNull { it.age }
    println("Youngest person: ${youngest?.name} (${youngest?.age})")
    println("Oldest person: ${oldest?.name} (${oldest?.age})")
    
    println("\n=== GROUPING ===")
    // groupBy
    val fruitsByLength = fruits.groupBy { it.length }
    println("Fruits grouped by length:")
    fruitsByLength.forEach { (length, fruitList) ->
        println("$length characters: $fruitList")
    }
    
    // Grouping by age category
    val peopleByAgeGroup = people.groupBy { 
        when {
            it.age < 30 -> "Young"
            it.age < 40 -> "Middle-aged"
            else -> "Senior"
        }
    }
    println("People grouped by age category:")
    peopleByAgeGroup.forEach { (category, personList) ->
        println("$category: ${personList.map { it.name }}")
    }
    
    println("\n=== PARTITION ===")
    // partition (splits collection into two lists)
    val (evenList, oddList) = numbers.partition { it % 2 == 0 }
    println("Even list: $evenList")
    println("Odd list: $oddList")
    
    // Partitioning people by age
    val (young, old) = people.partition { it.age < 30 }
    println("Young people: ${young.map { it.name }}")
    println("Older people: ${old.map { it.name }}")
    
    println("\n=== FLATTEN / FLATMAP ===")
    // flatten
    val nestedLists = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6),
        listOf(7, 8, 9)
    )
    val flattened = nestedLists.flatten()
    println("Flattened list: $flattened")
    
    // flatMap
    val sentences = listOf(
        "The quick brown fox",
        "jumps over",
        "the lazy dog"
    )
    val words = sentences.flatMap { it.split(" ") }
    println("All words: $words")
    
    println("\n=== FOLD / REDUCE ===")
    // reduce
    val sum = numbers.reduce { acc, number -> acc + number }
    println("Sum using reduce: $sum")
    
    // fold (with initial value)
    val sumPlus100 = numbers.fold(100) { acc, number -> acc + number }
    println("Sum plus 100 using fold: $sumPlus100")
    
    // Custom accumulation
    val namesConcatenated = people.fold("People: ") { acc, person ->
        "$acc ${person.name},"
    }.dropLast(1) // Remove the trailing comma
    println(namesConcatenated)
}

data class Person(val name: String, val age: Int)

// Extension to capitalize a string
fun String.capitalize(): String {
    return if (this.isEmpty()) this
    else this.substring(0, 1).uppercase() + this.substring(1)
}