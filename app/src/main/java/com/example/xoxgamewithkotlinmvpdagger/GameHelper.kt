package com.example.xoxgamewithkotlinmvpdagger

/**
 * Created by ismailgungor on 12.01.2018.
 */
class GameHelper {

    private var player1: ArrayList<Int>
    private var player2: ArrayList<Int>
    private var remainCell: ArrayList<Int>

    init {
        this.player1 = ArrayList<Int>()
        this.player2 = ArrayList<Int>()
        this.remainCell = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    }

    fun getCellId(buttonId: Int): Int {

        var cellId = 0

        when (buttonId) {

            R.id.btn1 -> cellId = 1

            R.id.btn2 -> cellId = 2

            R.id.btn3 -> cellId = 3

            R.id.btn4 -> cellId = 4

            R.id.btn5 -> cellId = 5

            R.id.btn6 -> cellId = 6

            R.id.btn7 -> cellId = 7

            R.id.btn8 -> cellId = 8

            R.id.btn9 -> cellId = 9

        }

        return cellId
    }

    fun isPlayer2IncludeCellId(cellId: Int): Boolean {
        return this.player2.contains(cellId)
    }

    fun isPlayer1IncludeCellId(cellId: Int): Boolean {
        return this.player1.contains(cellId)
    }


    fun addPlayer1CellId(cellId: Int) {
        this.player1.add(cellId)
        this.remainCell.remove(cellId)
    }

    fun addPlayer2CellId(cellId: Int) {
        this.player2.add(cellId)
        this.remainCell.remove(cellId)

    }

    fun checkWinner(player: Int, cellId: Int): Boolean {

        if (player == 1) {
            return checkArrayList(cellId, player1)
        } else {
            return checkArrayList(cellId, player2)
        }

    }

    private fun checkArrayList(cellId: Int, arrayList: ArrayList<Int>): Boolean {

        when (cellId) {

            1 -> return (arrayList.contains(2) && arrayList.contains(3)) || (arrayList.contains(4) && arrayList.contains(7)) || (arrayList.contains(5) && arrayList.contains(9))
            2 -> return (arrayList.contains(1) && arrayList.contains(3)) || (arrayList.contains(5) && arrayList.contains(8))
            3 -> return (arrayList.contains(1) && arrayList.contains(2)) || (arrayList.contains(6) && arrayList.contains(9)) || (arrayList.contains(5) && arrayList.contains(7))
            4 -> return (arrayList.contains(5) && arrayList.contains(6)) || (arrayList.contains(1) && arrayList.contains(7))
            5 -> return (arrayList.contains(4) && arrayList.contains(6)) || (arrayList.contains(2) && arrayList.contains(8)) || (arrayList.contains(1) && arrayList.contains(9)) || (arrayList.contains(3) && arrayList.contains(7))
            6 -> return (arrayList.contains(4) && arrayList.contains(5)) || (arrayList.contains(3) && arrayList.contains(9))
            7 -> return (arrayList.contains(8) && arrayList.contains(9)) || (arrayList.contains(1) && arrayList.contains(3)) || (arrayList.contains(5) && arrayList.contains(3))
            8 -> return (arrayList.contains(7) && arrayList.contains(9)) || (arrayList.contains(2) && arrayList.contains(5))
            9 -> return (arrayList.contains(7) && arrayList.contains(8)) || (arrayList.contains(3) && arrayList.contains(6)) || (arrayList.contains(1) && arrayList.contains(5))
            else -> return false
        }

    }

    fun initializeArrays() {
        this.player1 = ArrayList<Int>()
        this.player2 = ArrayList<Int>()
        this.remainCell = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    }

    fun isRemainCell(): Boolean {
        return remainCell.size > 0
    }

}