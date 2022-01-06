package day1

import java.math.BigDecimal

/*
 * Complete the 'miniMaxSum' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun miniMaxSum(arr: Array<Int>): Unit {
    // Write your code here
    var min: BigDecimal = BigDecimal(arr[0])
    var max: BigDecimal = BigDecimal(arr[0])
    var total: BigDecimal = BigDecimal(0)

    arr.forEach { item ->
        BigDecimal(item)
            .let {
                total += it
                if (it > max) {
                    max = it
                }
                if (it < min) {
                    min = it
                }
            }

    }

    print("${total - max} ${total - min}")
}

fun main(args: Array<String>) {

    val arr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    miniMaxSum(arr)
}
