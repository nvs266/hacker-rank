package day6

/*
 * Complete the 'bfs' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER m
 *  3. 2D_INTEGER_ARRAY edges
 *  4. INTEGER s
 */

fun bfs(n: Int, m: Int, edges: Array<Array<Int>>, s: Int): Array<Int> {
    // Write your code here
    return emptyArray()
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val n = first_multiple_input[0].toInt()

        val m = first_multiple_input[1].toInt()

        val edges = Array<Array<Int>>(m, { Array<Int>(2, { 0 }) })

        for (i in 0 until m) {
            edges[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
        }

        val s = readLine()!!.trim().toInt()

        val result = bfs(n, m, edges, s)

        println(result.joinToString(" "))
    }
}