package programmers.level2

/**
 * 프로그래머스
 * H-index
 *
 * n 편중 h 번 이상 인용된 논문이 h 편이상이고 나머지 논문이 h 이하 인용이라면 h 최댓값 = H-index
 * n 1~1000
 * h 0~10000
 */
fun solution1(citations: IntArray): Int {
    val size = citations.size

    val sortedDescending = citations.sortedDescending()
    sortedDescending.forEachIndexed { index, i ->

        val now = (index + 1)
        if (i == now) {
            return i
        } else if (i < now) {
            return now - 1
        }
    }

    return size
}

fun main() {
    // 테스트 케이스 1
    val citations1 = intArrayOf(3, 0, 6, 1, 5)
    println("Test Case 1:")
    println("Input: ${citations1.joinToString()}")
    println("Expected Output: 3")
    println("Actual Output: ${solution1(citations1)}")
    println()

    // 테스트 케이스 2 - 모든 논문이 많이 인용된 경우
    val citations2 = intArrayOf(10, 8, 5, 4, 3)
    println("Test Case 2:")
    println("Input: ${citations2.joinToString()}")
    println("Expected Output: 4")
    println("Actual Output: ${solution1(citations2)}")
    println()

    // 테스트 케이스 3 - 인용이 거의 없는 경우
    val citations3 = intArrayOf(0, 1, 1)
    println("Test Case 3:")
    println("Input: ${citations3.joinToString()}")
    println("Expected Output: 1")
    println("Actual Output: ${solution1(citations3)}")
    println()

    // 테스트 케이스 4 - 논문이 1개인 경우
    val citations4 = intArrayOf(5)
    println("Test Case 4:")
    println("Input: ${citations4.joinToString()}")
    println("Expected Output: 1")
    println("Actual Output: ${solution1(citations4)}")
}
