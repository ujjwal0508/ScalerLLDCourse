package CaseStudies.TicTacToe.Strategies.BotPlayingStrategies;

import CaseStudies.TicTacToe.Models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyFactory(BotDifficultyLevel botDifficultyLevel){
        return new EasyBotPlayingStrategy();
    }
}
