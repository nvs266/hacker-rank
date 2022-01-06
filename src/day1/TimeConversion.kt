package day1

/*
 * Complete the 'timeConversion' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

fun timeConversion(s: String): String {
    // Write your code here
    return s.let { input ->
        val hour = input.take(2).toInt()
        val isAM = input.takeLast(2) == "AM"
        val minuteAndSecond = s.drop(2).take(6)
        return@let if (isAM && hour == 12) "00$minuteAndSecond"
        else if (isAM || (!isAM && hour == 12)) s.take(8)
        else (hour + 12).toString() + s.drop(2).take(6)
    }
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val result = timeConversion(s)

    println(result)
}
