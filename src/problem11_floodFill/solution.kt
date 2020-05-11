package problem11_floodFill

import java.util.Queue
import java.util.LinkedList


class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val visited = mutableSetOf<Pair<Int, Int>>()
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val startColor = image[sr][sc]

        queue.add(Pair(sr, sc))
        while (!queue.isEmpty()) {
            val newPoint = queue.remove()
            visited.add(newPoint)
            image[newPoint.first][newPoint.second] = newColor

            for (point in getNeighbours(newPoint)) {
                if (visited.contains(point)) continue
                if (!isPointValid(point, image)) continue
                if (image[point.first][point.second] != startColor) continue
                queue.add(point)
            }
        }

        return image
    }

    private fun getNeighbours(point: Pair<Int, Int>) = listOf(
        Pair(point.first - 1, point.second),
        Pair(point.first + 1, point.second),
        Pair(point.first, point.second + 1),
        Pair(point.first, point.second - 1)
    )

    private fun isPointValid(point: Pair<Int, Int>, image: Array<IntArray>): Boolean =
        point.first >= 0 && point.first < image.size && point.second >= 0 && point.second < image[0].size
}


fun main() {
    val inputData: Array<IntArray> = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 1, 0),
        intArrayOf(1, 0, 1)
    )

    val filledImage = Solution().floodFill(inputData, 1, 1, 2)
    for (row in filledImage) {
        for (point in row)
            print("$point ")
        println()
    }
}
