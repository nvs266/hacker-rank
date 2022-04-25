package day6

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

/**
 * Description
 * Implement a simple text editor.
 * The editor initially contains an empty string S.
 * Perform Q operations of the following 4 types:
 * 1. append(W) - Append string W to the end of S.
 * 2. delete(k) - Delete the last k characters of S.
 * 3. print(k) - Print the k(th) character of S.
 * 4. undo() - Undo the last (not previously undone) operation of type 1 or 2,
 * reverting S to the state it was in prior to that operation.
 *
 * @sample
 * @input
 * 8
 * 1 abc
 * 3 3
 * 2 3
 * 1 xy
 * 3 2
 * 4
 * 4
 * 3 1
 *
 * @sample output
 * f
 * g
 * d
 */

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val q = reader.readLine().trim().toInt()

    val history = Stack<String>()
    for (i in 0 until q) {
        val operation = reader.readLine().trim()
        when (operation[0] - '0') {
            1 -> {
                val W = operation.substringAfter(" ")
                history.push("${history.lastOrNull() ?: ""}$W")
            }

            2 -> {
                val k = operation.substringAfter(" ").toInt()
                history.push(history.lastOrNull()?.dropLast(k) ?: "")
            }

            3 -> {
                val k = operation.substringAfter(" ").toInt()
                println(history.lastOrNull()?.getOrNull(k - 1))
            }

            4 -> {
                history.pop()
            }
        }
    }
}