package day5

import java.util.Stack

/*
 * Complete the 'isBalanced' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

fun isBalanced(s: String): String {
    // Write your code here
    val stack = Stack<Char>()
    s.forEach {
        if (it == '{' || it == '(' || it == '[') {
            stack.push(it)
        } else if ((it == '}' && stack.peek() != '{') ||
            (it == ']' && stack.peek() != '[') ||
            (it == ')' && stack.peek() != '(')
        ) {
            return "NO"
        } else {
            stack.pop()
        }
    }

    return if (stack.isNotEmpty()) "NO" else "YES"
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val s = readLine()!!

        val result = isBalanced(s)

        println(result)
    }
}
