package CaseStudies.TicTacToe.Strategies.WinningStrategies;

import CaseStudies.TicTacToe.Models.Board;
import CaseStudies.TicTacToe.Models.Move;
import CaseStudies.TicTacToe.Models.Symbol;

import java.util.HashMap;

public interface WinningStrategy {

    boolean checkWinner(Board board, Move move);

    void handleUndo(Board board, Move move);
}
