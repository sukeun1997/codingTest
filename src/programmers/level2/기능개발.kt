package programmers.level2

/**
 * 프로그래머스
 * 기능개발
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */
fun solution(progresses: IntArray, speeds: IntArray): IntArray {

    val daysNeeded = progresses.mapIndexed { index, progress ->
        val remainingWork = 100 - progress
        val speed = speeds[index]
        val days = if (remainingWork % speed == 0) {
            remainingWork / speed
        } else {
            (remainingWork / speed) + 1
        }
        days
    }

    val queue = ArrayDeque(daysNeeded)
    val answer = mutableListOf<Int>()
    while (queue.isNotEmpty()) {
        var count = 0
        val progress = queue.first()

        while (queue.isNotEmpty() && queue.first() <= progress) {
            queue.removeFirst()
            count++
        }

        answer.add(count)
    }



    return answer.toIntArray()
}
