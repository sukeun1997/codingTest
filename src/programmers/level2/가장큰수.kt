package programmers.level2

/**
 * 프로그래머스
 * 가장 큰 수
 */
fun solution(numbers: IntArray): String {

    return numbers.sortedWith(
        comparator = { o1, o2 ->
            (o2.toString() + o1.toString()).compareTo((o1.toString() + o2.toString()))
        }
    ).joinToString("")
}

fun main() {
    // 6 10 2
    val numbers5 = intArrayOf(6, 10, 2)
    println(solution(numbers5))

    val numbers = intArrayOf(3, 30, 34, 5, 9)
    println(solution(numbers)) // "9534330"

    val numbers2 = intArrayOf(0, 0, 0, 0)
    println(solution(numbers2)) // "0"

    val numbers3 = intArrayOf(1, 10, 100, 1000)
    println(solution(numbers3)) // "1101001000"

    val numbers4 = intArrayOf(0, 1, 2, 3, 4, 5)
    println(solution(numbers4)) // "543210"

    val numbers6 = intArrayOf(0, 0, 0, 1)
    println(solution(numbers6)) // "1000"

    val numbers7 = intArrayOf(0, 0, 0, 0, 1)
    println(solution(numbers7)) // "10000"

    val numbers8 = intArrayOf(10, 100)
    println(solution(numbers8))

    // 테스트 케이스 1: 일의 자리가 같고 백의 자리 이상이 다른 경우
    val fail1 = intArrayOf(110, 10)
    println("fail1: ${solution(fail1)} (기대값: 11010)")

    // 테스트 케이스 2: 일의 자리가 같고 자릿수가 매우 다른 경우
    val fail2 = intArrayOf(1000, 10)
    println("fail2: ${solution(fail2)} (기대값: 101000)")

    // 테스트 케이스 3: 일의 자리는 다르지만 이어붙였을 때 결과가 달라지는 경우
    val fail3 = intArrayOf(121, 12)
    println("fail3: ${solution(fail3)} (기대값: 12121)")

    // 테스트 케이스 4: 일의 자리가 같고 십의 자리도 같지만 백의 자리가 다른 경우
    val fail4 = intArrayOf(212, 21)
    println("fail4: ${solution(fail4)} (기대값: 21221)")

    // 테스트 케이스 5: 큰 숫자들의 비교
    val fail5 = intArrayOf(978, 97)
    println("fail5: ${solution(fail5)} (기대값: 97978)")

    // 테스트 케이스 6: 세 자리 수와 두 자리 수 비교
    val fail6 = intArrayOf(128, 12)
    println("fail6: ${solution(fail6)} (기대값: 12812)")
}
