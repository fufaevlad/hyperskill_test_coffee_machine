package hyperskill



const val espressoWater = 250
const val espressoMilk = 0
const val espressoCoffee = 16
const val espressoCost = 4

const val latteWater = 350
const val latteMilk = 75
const val latteCoffee = 20
const val latteCost = 7

const val capuccinoWater = 200
const val capuccinoMilk = 100
const val capuccinoCoffee = 12
const val capuccinoCost = 6

var waterInStock = 400
var milkInStock = 540
var coffeeInStock = 120
var cupsInStock = 9
var moneyInStock = 550

fun main() {
    actionChoise()
}

fun remaining(){
    println("The coffee machine has:")
    println("$waterInStock ml of water")
    println("$milkInStock ml of milk")
    println("$coffeeInStock g of coffee beans")
    println("$cupsInStock disposable cups")
    println("$$moneyInStock of money")
    actionChoise()
}

fun actionChoise(){
    println("Write action (buy, fill, take, remaining, exit):")
    var action = readln()
    if(action == "buy"){
        buy()
    } else if (action == "fill"){
        fill()
    } else if (action == "take"){
        take()
        remaining()
    } else if (action == "remaining") {
        remaining()
    } else if (action == "exit"){
        exit()
    }
}


fun buy(){
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
    val whatYouBuy = readln()
    when(whatYouBuy){
        "1"->{
            checkResources("Espresso")
            actionChoise()
        }
        "2"->{
            checkResources("Latte")
            actionChoise()
        }
        "3"->{
            checkResources("Cappucino")
            actionChoise()
        }
        "back"->{
            actionChoise()
        }

    }

}


fun fill(){
    println("Write how many ml of water you want to add:")
    waterInStock+=readln().toInt()
    println("Write how many ml of milk you want to add:")
    milkInStock+=readln().toInt()
    println("Write how many grams of coffee beans you want to add:")
    coffeeInStock+=readln().toInt()
    println("Write how many disposable cups you want to add:")
    cupsInStock+=readln().toInt()
    actionChoise()
}

fun take(){
    println("I gave you $$moneyInStock")
    moneyInStock = 0
    actionChoise()
}


fun checkResources(type:String){
    when(type){
        "Espresso" -> {
            if(waterInStock >= espressoWater && milkInStock >= espressoMilk
                && coffeeInStock >= espressoCoffee && cupsInStock > 0){
                println("I have enough resources, making you a coffee!")
                makeEspresso()
            } else {
                if (waterInStock < espressoWater) {
                    println("Sorry, not enough water!")
                } else if (milkInStock < espressoMilk){
                    println("Sorry, not enough milk!")
                } else if (coffeeInStock < espressoCoffee){
                    println("Sorry, not enough coffee!")
                } else if (cupsInStock < 1){
                    println("Sorry, not enough cups!")
                }
            }
        }
        "Latte" -> {
            if(waterInStock >= latteWater && milkInStock >= latteMilk
                && coffeeInStock >= latteCoffee && cupsInStock > 0){
                println("I have enough resources, making you a coffee!")
                makeLatte()
            } else {
                if (waterInStock < latteWater) {
                    println("Sorry, not enough water!")
                } else if (milkInStock < latteMilk){
                    println("Sorry, not enough milk")
                } else if (coffeeInStock < latteCoffee){
                    println("Sorry, not enough coffee")
                } else if (cupsInStock < 1){
                    println("Sorry, not enough cups")
                }
            }
        }
        "Cappucino" -> {
            if(waterInStock >= capuccinoWater && milkInStock >= capuccinoMilk
                && coffeeInStock >= capuccinoCoffee && cupsInStock > 0){
                println("I have enough resources, making you a coffee!")
                makeCappucino()
            } else {
                if (waterInStock < capuccinoWater) {
                    println("Sorry, not enough water!")
                } else if (milkInStock < capuccinoMilk){
                    println("Sorry, not enough milk")
                } else if (coffeeInStock < capuccinoCoffee){
                    println("Sorry, not enough coffee")
                } else if (cupsInStock < 1){
                    println("Sorry, not enough cups")
                }
            }

        }
    }
}

fun exit(){
    System.exit(0)
}


fun makeEspresso(){
    waterInStock -= espressoWater
    milkInStock -= espressoMilk
    coffeeInStock -= espressoCoffee
    moneyInStock += espressoCost
    cupsInStock--
}


fun makeLatte(){
    waterInStock -= latteWater
    milkInStock -= latteMilk
    coffeeInStock -= latteCoffee
    moneyInStock += latteCost
    cupsInStock--
}

fun makeCappucino(){
    waterInStock -= capuccinoWater
    milkInStock -= capuccinoMilk
    coffeeInStock -= capuccinoCoffee
    moneyInStock += capuccinoCost
    cupsInStock--
}



//const val oneCupWater_ml = 200
//const val oneCupMilk_ml = 50
//const val oneCupCoffee_g = 15

//    println("Starting to make a coffee\n" +
//            "Grinding coffee beans\n" +
//            "Boiling water\n" +
//            "Mixing boiled water with crushed coffee beans\n" +
//            "Pouring coffee into the cup\n" +
//            "Pouring some milk into the cup\n" +
//            "Coffee is ready!")


//    println("Write how many cups of coffee you will need:")
//    val cupsNum = readln().toInt()
//    println("For 125 cups of coffee you will need:")
//    println("${cupsNum * oneCupWater_ml} ml of water")
//    println("${cupsNum * oneCupMilk_ml} ml of milk")
//    println("${cupsNum * oneCupCoffee_g} g of coffee beans")


//    println("Write how many ml of water the coffee machine has:")
//    val water = readln().toInt()
//    val howMuchCups_water = water / oneCupWater_ml
//    println("Write how many ml of milk the coffee machine has:")
//    val milk = readln().toInt()
//    val howMuchCups_milk = milk /  oneCupMilk_ml
//    println("Write how many grams of coffee beans the coffee machine has:")
//    val coffee = readln().toInt()
//    val howMuchCups_coffee = coffee / oneCupCoffee_g
//
//    val maxNumOfCups = minOf(howMuchCups_milk,howMuchCups_water,howMuchCups_coffee)
//
//    println("Write how many cups of coffee you will need:")
//    val cupsNum = readln().toInt()
//
//    if(cupsNum*oneCupMilk_ml<water && cupsNum*oneCupMilk_ml<milk
//    && cupsNum*oneCupCoffee_g<coffee && cupsNum == maxNumOfCups){
//        println("Yes, I can make that amount of coffee")
//    } else if(cupsNum*oneCupMilk_ml<water && cupsNum*oneCupMilk_ml<milk
//        && cupsNum*oneCupCoffee_g<coffee && cupsNum < maxNumOfCups) {
//        println("Yes, I can make that amount of coffee (and even ${maxNumOfCups-cupsNum} more than that)")
//    } else if(cupsNum*oneCupMilk_ml>water || cupsNum*oneCupMilk_ml>milk
//        || cupsNum*oneCupCoffee_g<coffee){
//        println("No, I can make only ${maxNumOfCups} cups of coffee")
//    }

