package programmers.level0

fun solution(array: IntArray): Int {

    if (array.size == 1) return array[0]

    var answer = 0
    val map = HashMap<Int, Int>()
    var maxCount = 0
    for (i in array.indices) {
        val count = map.getOrDefault(array[i], 0) + 1
        if (count > maxCount) {
            maxCount = count
            answer = array[i]
        } else if (count == maxCount) {
            answer = -1
        }
        map[array[i]] = count
    }

    return answer
}

fun main() {
}

