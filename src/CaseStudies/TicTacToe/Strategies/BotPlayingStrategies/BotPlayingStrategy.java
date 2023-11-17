package CaseStudies.TicTacToe.Strategies.BotPlayingStrategies;

import CaseStudies.TicTacToe.Models.Board;
import CaseStudies.TicTacToe.Models.Move;

public interface BotPlayingStrategy {
    Move makerMove(Board board);
}
