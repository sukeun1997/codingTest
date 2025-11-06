package programmers.level2

/**
 * 프로그래머스
 * 의상
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */
class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        if (clothes.isEmpty()) {
            return 0
        }

        val clothesMap = mutableMapOf<String, Int>()
        for (clothe in clothes) {
            val type = clothe[1]
            clothesMap[type] = clothesMap.getOrDefault(type, 1) + 1
        }

        val answer = clothesMap.values.reduce { a, b -> a * b }

        return answer - 1
    }
}
