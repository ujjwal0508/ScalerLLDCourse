import CaseStudies.TicTacToe.Controller.GameController;
import CaseStudies.TicTacToe.Models.*;
import CaseStudies.TicTacToe.Strategies.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

//        GameController gameController = new GameController();
//
//        Game game = gameController.startGame();
//
//        gameController.startGame(game);
//        while(gameController.getGameStatus(game).equals(IN_PROGRESS)){
//            gameController.printBoard(game);
//            gameController.makeNextMove(game);
//
//            if(gameController.getGameStatus(game).equals(DRAW)){
//                System.out.println("game is drawn");
//                break;
//            }
//
//            if(gameController.getGameStatus(game).equals(SUCCESS)){
//                System.out.println("game is drawn");
//                break;
//            }
//        }

        GameController gameController = new GameController();
        try {
            int dimensionOfGame = 3;
            List<Player> playerList = new ArrayList<>();
            playerList.add(new Player(new Symbol('X'), "Ujjwal",1L , PlayerType.HUMAN));
            playerList.add(new Bot(new Symbol('O'),"GPT", 2L, BotDifficultyLevel.EASY));

            List<WinningStrategy> winningStrategyList = new ArrayList<>();
            Game game = gameController.startGame(dimensionOfGame, playerList, winningStrategyList);

            while(gameController.checkState(game).equals(GameState.IN_PROGRESS)){
                // print board
                // x's turn
                // ask to make move
                gameController.printBoard(game);
                gameController.makeMove(game);
            }
        } catch (Exception ex) {
            System.out.println("Game did not work");
        }

//        System.out.println("GAME CREATED");


    }
}