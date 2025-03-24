package programmers.level0

import java.net.IDN

/**
 * 프로그래머스
 * 코드 처리하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181932
 */

fun solution(code: String): String {
    val answer = StringBuilder()

    var mode = 0
    for (idx in code.indices) {
        if (code[idx] == '1') {
            mode = 1 - mode
            continue
        }

        if (mode == 0 && idx % 2 == 0) {
            answer.append(code[idx])
        } else if (mode == 1 && idx % 2 == 1) {
            answer.append(code[idx])
        }
    }

    return if (answer.isEmpty()) "EMPTY" else answer.toString()
}

fun main() {
    println(solution("abc1abc1abc1"))
    println(solution("abcdef"))
    println(solution("abc1def"))
    println(solution("1"))
    println(solution("a1b1c1d"))
}
