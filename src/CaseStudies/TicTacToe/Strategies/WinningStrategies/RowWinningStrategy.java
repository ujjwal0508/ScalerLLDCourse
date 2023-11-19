package CaseStudies.TicTacToe.Strategies.WinningStrategies;

import CaseStudies.TicTacToe.Models.Board;
import CaseStudies.TicTacToe.Models.Move;
import CaseStudies.TicTacToe.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{

    HashMap<Integer, HashMap<Symbol, Integer>> counts = new HashMap<>();
    // |0 | -> x -> 0,  O -> 0
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!counts.containsKey(row)){
            counts.put(row, new HashMap<>());
        }

        Map<Symbol, Integer> rowMap = counts.get(row);

        if(!rowMap.containsKey(symbol)){
            rowMap.put(symbol, 0);
        }

        rowMap.put(symbol, rowMap.get(symbol) + 1);

        if(rowMap.get(symbol) == board.getSize())
            return true;

        return false;
    }

    @Override
    public void handleUndo(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();
        Map<Symbol, Integer> rowMap = counts.get(row);
        rowMap.put(symbol, rowMap.get(symbol) - 1);
    }


}
