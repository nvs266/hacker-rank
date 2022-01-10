package day3

/*
 * Complete the 'palindromeIndex' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts STRING s as parameter.
 */

fun palindromeIndex(s: String): Int {
    // Write your code here
    if (s == s.reversed()) return -1

    var result = -1
    for (i in 0 until s.length / 2) {
        val isDiffer = s[i] != s[s.length - 1 - i]

        if (s[i] != s[s.length - 1 - i] && s.removeRange(i, i + 1) == s.removeRange(i, i + 1).reversed()) {
            return i
        } else if (isDiffer &&
            s.removeRange(s.length - 1 - i, s.length - i) == s.removeRange(s.length - 1 - i, s.length - i).reversed()
        ) {
            result = s.length - 1 - i
        }
    }

    return result
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val s = readLine()!!

        val result = palindromeIndex(s)

        println(result)
    }
}
