package day3

/*
 * Complete the 'caesarCipher' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts following parameters:
 *  1. STRING s
 *  2. INTEGER k
 */

fun caesarCipher(s: String, k: Int): String {
    // Write your code here
    var result = ""
    val optimizedK = k.rem('z' - 'a' + 1)
    for (i in s.indices) {
        val c: Char = when {
            s[i].toLowerCase() < 'a' || s[i].toLowerCase() > 'z' -> s[i]
            else -> {
                when {
                    s[i].isLowerCase() && (s[i] + optimizedK) > 'z' -> 'a' + (s[i] + optimizedK - 'z' - 1)
                    !s[i].isLowerCase() && s[i] + optimizedK > 'Z' -> 'A' + (s[i] + optimizedK - 'Z' - 1)
                    else -> s[i] + optimizedK
                }
            }
        }

        result += c
    }
    return result
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val s = readLine()!!

    val k = readLine()!!.trim().toInt()

    val result = caesarCipher(s, k)

    println(result)
}
