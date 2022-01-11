package day4

/*
 * Complete the 'truckTour' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
 */

fun truckTour(petrolpumps: Array<Array<Int>>): Int {
    // Write your code here
    var start = 0
    var petrolAmountFromStart = 0
    var distanceAmountFromStart = 0
    petrolpumps.forEachIndexed { index, ints ->
        val petrolAtCurrentPump = ints[0]
        val distanceToNextPump = ints[1]
        if (petrolAtCurrentPump < distanceToNextPump &&
            petrolAmountFromStart - distanceAmountFromStart < distanceToNextPump - petrolAtCurrentPump
        ) {
            start = index + 1
            petrolAmountFromStart = 0
            distanceAmountFromStart = 0
        } else {
            petrolAmountFromStart += petrolAtCurrentPump
            distanceAmountFromStart += distanceToNextPump
        }
    }

    return start
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val petrolpumps = Array<Array<Int>>(n, { Array<Int>(2, { 0 }) })

    for (i in 0 until n) {
        petrolpumps[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val result = truckTour(petrolpumps)

    println(result)
}
