package com.example.assignment1app.ui

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment1app.R

class MainActivity : AppCompatActivity() {

    private var currentPlayer = "X"
    private val board = Array(3) { arrayOfNulls<String>(3) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttons = arrayOf(
            arrayOf(findViewById<Button>(R.id.button00), findViewById(R.id.button01), findViewById(R.id.button02)),
            arrayOf(findViewById(R.id.button10), findViewById(R.id.button11), findViewById(R.id.button12)),
            arrayOf(findViewById(R.id.button20), findViewById(R.id.button21), findViewById(R.id.button22))
        )

        for (i in 0..2) {
            for (j in 0..2) {
                buttons[i][j].setOnClickListener {
                    if (board[i][j] == null) {
                        board[i][j] = currentPlayer
                        buttons[i][j].text = currentPlayer
                        if (checkWinner()) {
                            showWinnerDialog(currentPlayer, buttons)
                        } else if (isBoardFull(buttons)) {
                            showDrawDialog(buttons)
                        } else {
                            currentPlayer = if (currentPlayer == "X") "O" else "X"
                        }
                    }
                }
            }
        }
    }

    private fun checkWinner(): Boolean {
        for (i in 0..2) {
            if (board[i][0] != null && board[i][0] == board[i][1] && board[i][1] == board[i][2]) return true
            if (board[0][i] != null && board[0][i] == board[1][i] && board[1][i] == board[2][i]) return true
        }

        if (board[0][0] != null && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true
        if (board[0][2] != null && board[0][2] == board[1][1] && board[1][1] == board[2][0]) return true

        return false    }

    private fun isBoardFull(buttons: Array<Array<Button>>): Boolean {
        return true
    }

    private fun showWinnerDialog(winner: String, buttons: Array<Array<Button>>) {

    }

    private fun showDrawDialog(buttons: Array<Array<Button>>) {

    }


    private fun resetBoard(buttons: Array<Array<Button>>) {

    }
}