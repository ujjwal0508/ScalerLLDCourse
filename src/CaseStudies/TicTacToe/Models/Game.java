package CaseStudies.TicTacToe.Models;

import CaseStudies.TicTacToe.Strategies.WinningStrategies.WinningStrategy;

import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextMovePlayerIdx;
    private List<WinningStrategy> winningStrategies;
}
