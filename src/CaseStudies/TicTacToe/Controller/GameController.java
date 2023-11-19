package CaseStudies.TicTacToe.Controller;

import CaseStudies.TicTacToe.Models.Game;
import CaseStudies.TicTacToe.Models.GameState;
import CaseStudies.TicTacToe.Models.Player;
import CaseStudies.TicTacToe.Strategies.WinningStrategies.WinningStrategy;

import java.util.List;

public class GameController {

//    Game game;

    // in a real world scenario we would want to catch this exception and throw a more generic thing that telling the actual working of our system
    public Game startGame(int dimensionBoard, List<Player> players, List<WinningStrategy> winningStrategies) throws Exception {
        return Game.getBuilder().setBoardDimension(dimensionBoard)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public void undo(Game game){
        game.undo();
    }

    public GameState checkState(Game game){
        return game.getGameState();
    }

    public void getWinner(Game game){

    }

    public void printBoard(Game game){
        // where will this business logic go
        game.printBoard();
    }
}
