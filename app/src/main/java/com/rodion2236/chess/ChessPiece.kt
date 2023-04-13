package com.rodion2236.chess

data class ChessPiece(
    val col: Int,
    val row: Int,
    val player: ChessPlayer,
    val rank: ChessRank
    ) {
}