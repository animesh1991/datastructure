package com.example.datastructure.datastructure

fun main() {
    print(addTwoNumbers(getNodeOne(), getNodeTwo()))
}

fun addTwoNumbers(
    listNodeOne: Node,
    listNodeTwo: Node
): Node {

    var carry = 0
    var addedNode = Node(-1)

    var tempNodeOne = listNodeOne
    var tempNodeTwo = listNodeTwo

    while (tempNodeOne != null || tempNodeTwo != null) {
        val tempOne = tempNodeOne.key
        val tempTwo = tempNodeTwo.key
        val sum = tempOne + tempTwo + carry
        carry = sum / 10
        addedNode.next = Node(sum % 10)
        if(tempNodeOne.next != null) tempNodeOne = tempNodeOne.next!!
        if(tempNodeTwo.next != null) tempNodeTwo = tempNodeTwo.next!!
        addedNode = addedNode.next!!
    }
    if(carry > 0) addedNode.next = Node(carry)
    return addedNode
}

fun getNodeOne(): Node {
    val node1 = Node(key = 2)
    val node2 = Node(key = 4)
    val node3 = Node(key = 3)

    node1.next = node2
    node2.next = node3
    return node1
}

fun getNodeTwo(): Node {
    val node1 = Node(key = 5)
    val node2 = Node(key = 6)
    val node3 = Node(key = 4)

    node1.next = node2
    node2.next = node3
    return node1
}

data class Node(var key: Int, var next: Node? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$key -> ${next.toString()}"
        } else {
            "$key"
        }
    }
}