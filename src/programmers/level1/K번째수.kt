package programmers.level1

/**
 * 프로그래머스
 * K 번째 수
 */
fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
    val answer = mutableListOf<Int>()

    for (command in commands) {
        answer.add(array.copyOfRange(command[0] - 1, command[1]).sorted()[command[2] - 1])
    }

    return answer.toIntArray()
}
