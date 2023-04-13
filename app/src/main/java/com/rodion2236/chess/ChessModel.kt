package com.rodion2236.chess

class ChessModel {

    var piecesBox = mutableSetOf<ChessPiece>()

    init {
        reset()
    }

    private fun reset() {
        piecesBox.removeAll(piecesBox)
        for (i in 0..1) {
            piecesBox.add(ChessPiece(0 + i * 7, 0, ChessPlayer.white, ChessRank.rook))
            piecesBox.add(ChessPiece(0 + i * 7, 7, ChessPlayer.black, ChessRank.rook))

            piecesBox.add(ChessPiece(1 + i * 5, 0, ChessPlayer.white, ChessRank.knight))
            piecesBox.add(ChessPiece(1 + i * 5, 7, ChessPlayer.black, ChessRank.knight))

            piecesBox.add(ChessPiece(2 + i * 3, 0, ChessPlayer.white, ChessRank.bishop))
            piecesBox.add(ChessPiece(2 + i * 3, 7, ChessPlayer.black, ChessRank.bishop))
        }

        for (i in 0..7) {
            piecesBox.add(ChessPiece(i, 1, ChessPlayer.white, ChessRank.pawn))
            piecesBox.add(ChessPiece(i, 6, ChessPlayer.black, ChessRank.pawn))
        }

        piecesBox.add(ChessPiece(3, 0, ChessPlayer.white, ChessRank.queen))
        piecesBox.add(ChessPiece(3, 7, ChessPlayer.black, ChessRank.queen))

        piecesBox.add(ChessPiece(4, 0, ChessPlayer.white, ChessRank.king))
        piecesBox.add(ChessPiece(4, 7, ChessPlayer.black, ChessRank.king))
    }

    private fun pieceAt(col: Int, row: Int) : ChessPiece? {
        for (piece in piecesBox) {
            if (col == piece.col && row == piece.row) {
                return  piece
            }
        }
        return null
    }

    override fun toString(): String {
        var desc = " \n"
        for (row in 7 downTo 0) {
            desc += "$row"
            for (col in 0..7) {
                val piece = pieceAt(col, row)
                if (piece == null) {
                    desc += " ."
                } else {
                    val white = piece.player == ChessPlayer.white
                    desc += " "
                    desc += when (piece.rank) {
                        ChessRank.king -> {
                            if (white) "k" else "K"
                        }
                        ChessRank.queen -> {
                            if (white) "q" else "Q"
                        }
                        ChessRank.bishop -> {
                            if (white) "b" else "B"
                        }
                        ChessRank.rook -> {
                            if (white) "r" else "R"
                        }
                        ChessRank.knight -> {
                            if (white) "n" else "N"
                        }
                        ChessRank.pawn -> {
                            if (white) "p" else "P"
                        }
                    }
                }
            }
            desc += "\n"
        }
        desc += "  0 1 2 3 4 5 6 7"
        return desc
    }
}