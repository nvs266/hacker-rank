package day4

import java.math.BigInteger

/*
 * Complete the 'superDigit' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. STRING n
 *  2. INTEGER k
 */

fun superDigit(n: String, k: Int): Int {
    // Write your code here
    if (n.length == 1 && k == 1) return n.toInt()

    var sum = BigInteger.ZERO

    n.forEach { sum += it.toString().toBigInteger() }

    return superDigit((sum * k.toBigInteger()).toString(), 1)
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0]

    val k = first_multiple_input[1].toIntOrNull() ?: 1

    val result = superDigit(n, k)

    println(result)
}
