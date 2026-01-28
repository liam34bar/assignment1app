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
        return true
    }

    private fun isBoardFull(buttons: Array<Array<Button>>): Boolean {
        return true
    }

    private fun showWinnerDialog(winner: String, buttons: Array<Array<Button>>) {
        AlertDialog.Builder(this)
            .setTitle("🎉 ניצחון!")
            .setMessage("השחקן $winner ניצח!\nרוצה לשחק שוב?")
            .setCancelable(false)
            .setPositiveButton("שחק שוב") { _, _ ->
                resetBoard(buttons)
            }
            .setNegativeButton("יציאה") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun showDrawDialog(buttons: Array<Array<Button>>) {
        AlertDialog.Builder(this)
            .setTitle("🤝 תיקו")
            .setMessage("אין מנצח.\nעוד סיבוב?")
            .setCancelable(false)
            .setPositiveButton("שחק שוב") { _, _ ->
                resetBoard(buttons)
            }
            .show()
    }

    private fun resetBoard(buttons: Array<Array<Button>>) {

    }
}