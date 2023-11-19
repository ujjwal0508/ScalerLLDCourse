package CaseStudies.TicTacToe.Strategies.WinningStrategies;

import CaseStudies.TicTacToe.Models.Board;
import CaseStudies.TicTacToe.Models.Move;
import CaseStudies.TicTacToe.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy{

    private Map<Symbol, Integer> leftDiagCount = new HashMap<>();
    private Map<Symbol, Integer> rightDiagCount = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {

        //check for left diagonal
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(row == col){
            if(!leftDiagCount.containsKey(symbol)){
                leftDiagCount.put(symbol, 0);
            }

            leftDiagCount.put(symbol, leftDiagCount.get(symbol) + 1);

            if(leftDiagCount.get(symbol) == board.getSize()){
                return true;
            }
        }

        //check for right diagonal

        if(row + col == board.getSize() - 1){
            if(!rightDiagCount.containsKey(symbol)){
                rightDiagCount.put(symbol, 0);
            }

            rightDiagCount.put(symbol, rightDiagCount.get(symbol) + 1);

            if(rightDiagCount.get(symbol) == board.getSize()) return true;
        }

        return false;
    }

    @Override
    public void handleUndo(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(row == col){
            leftDiagCount.put(symbol, leftDiagCount.get(symbol) - 1);
        }

        if(row + col == board.getSize() - 1){
            rightDiagCount.put(symbol, rightDiagCount.get(symbol) - 1);
        }
    }
}
