package CaseStudies.TicTacToe.Strategies.WinningStrategies;

import CaseStudies.TicTacToe.Models.Board;
import CaseStudies.TicTacToe.Models.Move;
import CaseStudies.TicTacToe.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStrategy{

    // in each coln each symbol is present how many times
    HashMap<Integer, HashMap<Symbol, Integer>> counts = new HashMap<>();
    // |0 | -> x -> 0,  O -> 0
    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!counts.containsKey(col)){
            counts.put(col, new HashMap<>());
        }

        Map<Symbol, Integer> colMap = counts.get(col);

        if(!colMap.containsKey(symbol)){
            colMap.put(symbol, 0);
        }

        colMap.put(symbol, colMap.get(symbol) + 1);

        if(colMap.get(symbol) == board.getSize())
            return true;

        return false;
    }

    @Override
    public void handleUndo(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();
        Map<Symbol, Integer> colMap = counts.get(col);
        colMap.put(symbol, colMap.get(symbol) - 1);
    }
}
