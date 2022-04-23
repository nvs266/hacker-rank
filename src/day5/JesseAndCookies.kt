package day5

import java.util.PriorityQueue

/*
 * Complete the 'cookies' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER k
 *  2. INTEGER_ARRAY A
 */

fun cookies(k: Int, A: Array<Int>): Int {
    // Write your code here
    var count = 0
    val priorityQueue = PriorityQueue<Int>()
    A.forEach { priorityQueue.add(it) }
    while (priorityQueue.peek() < k && priorityQueue.size > 1) {
        val temp = priorityQueue.poll() + 2 * priorityQueue.poll()
        priorityQueue.add(temp)
        count++
    }

    return if (priorityQueue.peek() >= k) {
        count
    } else {
        -1
    }
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val k = first_multiple_input[1].toInt()

    val A = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = cookies(k, A)

    println(result)
}

