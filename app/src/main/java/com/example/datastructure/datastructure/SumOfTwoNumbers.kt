package com.example.datastructure.datastructure

/*
Given a array of int try to find two values inside array whos addition matches with given numner

 */

 fun main() {

     val matchingPair = findTwoSums(arrayOf(2,4,5,6,7), 11)
     print("${matchingPair.first} ${matchingPair.second}")

 }


fun findTwoSums(arrayOfInt: Array<Int>, target : Int) : Pair<Int, Int> {
    val mapOfValues = HashMap<Int, Int>()

    arrayOfInt.forEachIndexed { index, i ->
        if(mapOfValues.containsKey(target - i)) {
            return Pair(mapOfValues.get(target - i)!!, index)
        }
        mapOfValues[i] = index
    }
    return Pair(-1, -1)
}