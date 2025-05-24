fun main() {
    // Task 1: Mobile notification system
    val morningNotification = 51
    val eveningNotification = 135
    
    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
    
    // Task 2: Movie ticket price calculator
    val child = 5
    val adult = 28
    val senior = 87
    val isMonday = true
    
    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}")
    
    // Task 3: Temperature converter
    printFinalTemperature(27.0, "Celsius", "Fahrenheit") { 9.0 / 5.0 * it + 32.0 }
    printFinalTemperature(350.0, "Kelvin", "Celsius") { it - 273.15 }
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { 5.0 / 9.0 * (it - 32) + 273.15 }
    
    // Task 4: Song catalog
    val song = Song("Bohemian Rhapsody", "Queen", 1975, 1_000_000)
    song.printDescription()
    
    // Task 5: Internet profile
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)
    
    amanda.showProfile()
    atiqah.showProfile()
    
    // Task 6: Foldable phones
    val newFoldablePhone = FoldablePhone()
    
    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
    newFoldablePhone.unfold()
    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
    newFoldablePhone.fold()
    newFoldablePhone.checkPhoneScreenLight()
    
    // Task 7: Special auction
    val winningBid = Bid(5000, "Private Collector")
    
    println("Item A is sold at ${auctionPrice(winningBid, 2000)}")
    println("Item B is sold at ${auctionPrice(null, 3000)}")
}

// Task 1: Mobile notification system
fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages < 100) {
        println("You have $numberOfMessages notifications.")
    } else {
        println("Your phone is blowing up! You have 99+ notifications.")
    }
}

// Task 2: Movie ticket price calculator
fun ticketPrice(age: Int, isMonday: Boolean): Int {
    return when {
        age <= 12 -> 15  // Child discount
        age >= 13 && age <= 60 -> if (isMonday) 25 else 30  // Regular price with Monday discount
        age >= 61 -> 20  // Senior discount
        else -> 0
    }
}

// Task 3: Temperature converter
fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement))
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}

// Task 4: Song catalog
class Song(
    val title: String,
    val artist: String,
    val yearPublished: Int,
    val playCount: Int
) {
    val isPopular: Boolean
        get() = playCount >= 1000
    
    fun printDescription() {
        println("$title, performed by $artist, was released in $yearPublished.")
        if (isPopular) {
            println("This song is popular.")
        } else {
            println("This song is not very popular.")
        }
    }
}

// Task 5: Internet profile
class Person(val name: String, val age: Int, private val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")
        print("Likes to $hobby. ")
        
        if (referrer != null) {
            println("Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}.")
        } else {
            println("Doesn't have a referrer.")
        }
        println()
    }
}

// Task 6: Foldable phones
open class Phone(var isScreenLightOn: Boolean = false) {
    open fun switchOn() {
        isScreenLightOn = true
    }
    
    fun switchOff() {
        isScreenLightOn = false
    }
    
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isFolded: Boolean = true) : Phone() {
    override fun switchOn() {
        if (!isFolded) {
            isScreenLightOn = true
        }
    }
    
    fun fold() {
        isFolded = true
        switchOff()  // Turn off screen when folded
    }
    
    fun unfold() {
        isFolded = false
    }
}

// Task 7: Special auction
class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    // If there's no bid, return the minimum price
    return bid?.amount ?: minimumPrice
}