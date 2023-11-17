package CaseStudies.TicTacToe.Strategies.BotPlayingStrategies;

import CaseStudies.TicTacToe.Models.Board;
import CaseStudies.TicTacToe.Models.Cell;
import CaseStudies.TicTacToe.Models.CellState;
import CaseStudies.TicTacToe.Models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makerMove(Board board) {
        for(List<Cell> row: board.getBoard()){
            for(Cell cell: row){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    return new Move(cell, null);
                }
            }
        }
        return null;
    }
}
