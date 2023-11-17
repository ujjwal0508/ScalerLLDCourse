package CaseStudies.TicTacToe.Models;

import CaseStudies.TicTacToe.Strategies.BotPlayingStrategies.BotPlayingStrategy;
import CaseStudies.TicTacToe.Strategies.BotPlayingStrategies.BotPlayingStrategyFactory;

public class Bot extends Player{

    private BotDifficultyLevel botDifficultyLevel;

    private BotPlayingStrategy botPlayingStrategy;

    public Bot(Symbol symbol, String name, Long id, BotDifficultyLevel botDifficultyLevel) {
        super(symbol, name, id, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyFactory(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        Move move = botPlayingStrategy.makerMove(board);
        move.setPlayer(this);
        return move;
    }
}
