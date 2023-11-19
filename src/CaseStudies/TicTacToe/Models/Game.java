package CaseStudies.TicTacToe.Models;

import CaseStudies.TicTacToe.Exceptions.MoreThanOneBotException;
import CaseStudies.TicTacToe.Exceptions.PlayerCountDimensionMismatchException;
import CaseStudies.TicTacToe.Exceptions.PlayerSymbolNotUniqueException;
import CaseStudies.TicTacToe.Strategies.WinningStrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextMovePlayerIdx;
    private List<WinningStrategy> winningStrategies;

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.gameState = GameState.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.nextMovePlayerIdx = 0;
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.board = new Board(dimension);
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public void printBoard() {
        this.board.print();
    }

    private boolean checkWinner(Move move) {
        for (WinningStrategy winningStrategy : winningStrategies) {
            if (winningStrategy.checkWinner(board, move)) {
                return true;
            }
        }
        return false;
    }

    public void makeMove() {
        Player currentMovePlayer = this.players.get(nextMovePlayerIdx);

        System.out.println("This is " + currentMovePlayer.getName() + "'s turn");
        Move move = currentMovePlayer.makeMove(board);
        if (!validateMove(move)) {
            System.out.println("You have made an invalid move");
            return;
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell boardCell = this.board.getBoard().get(row).get(col);
        boardCell.setCellState(CellState.FILLED);
        boardCell.setPlayer(currentMovePlayer);
        Move finalMoveObj = new Move(boardCell, currentMovePlayer);
        this.moves.add(finalMoveObj);

        nextMovePlayerIdx++;
        nextMovePlayerIdx %= players.size();

        //check winner pending
        if (checkWinner(finalMoveObj)) {
            gameState = GameState.WIN;
            winner = currentMovePlayer;
        } else if (moves.size() == this.board.getSize() * this.board.getSize()) {
            gameState = GameState.DRAW;
        }
    }

    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if (row >= board.getSize() || col >= board.getSize())
            return false;

        if (board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)) {
            return true;
        }

        return false;
    }

    public void undo() {

        if (moves.size() == 0)
            return;

        Move lastMove = moves.get(moves.size() - 1);

        moves.remove(lastMove);

        Cell cell = lastMove.getCell();
        cell.setPlayer(null);
        cell.setCellState(CellState.EMPTY);

        //update winnning strategies
        for (WinningStrategy winningStrategy : this.winningStrategies) {
            winningStrategy.handleUndo(board, lastMove);
        }

        nextMovePlayerIdx--;
        nextMovePlayerIdx = (nextMovePlayerIdx + players.size()) % players.size();
    }

    public static class Builder {
        // put only those attr whose value you need from user
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int boardDimension;

        private Builder() {
            this.winningStrategies = new ArrayList<>();
            this.players = new ArrayList<>();
            this.boardDimension = 0;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Builder setBoardDimension(int boardDimension) {
            this.boardDimension = boardDimension;
            return this;
        }

        public Builder addPlayer(Player player) {
            this.players.add(player);
            return this;
        }

        public Builder addWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategies.add(winningStrategy);
            return this;
        }

        private void validateBotCount() throws Exception {
            int botCount = 0;
            for (Player player : players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    botCount++;
                }
            }

            if (botCount > 1) {
                throw new MoreThanOneBotException();
            }
        }

        private void validatePlayerCount() throws Exception {
            if (players.size() != boardDimension - 1) {
                throw new PlayerCountDimensionMismatchException();
            }
        }

        private void validateUniquePlayerCharacters() throws Exception {
            HashSet<Character> symbols = new HashSet<>();
            for (Player player : players) {
                if (symbols.contains(player.getSymbol().getAchar())) {
                    throw new PlayerSymbolNotUniqueException();
                }
                symbols.add(player.getSymbol().getAchar());
            }
        }

        private void validate() throws Exception {
            validateBotCount();
            validatePlayerCount();
            validateUniquePlayerCharacters();

        }

        public Game build() throws Exception {
            try {
                validate();
            } catch (Exception ex) {
                System.out.println("LOG LINE - There was an exception creating the game");
                throw ex;
            }
            return new Game(boardDimension, players, winningStrategies);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextMovePlayerIdx() {
        return nextMovePlayerIdx;
    }

    public void setNextMovePlayerIdx(int nextMovePlayerIdx) {
        this.nextMovePlayerIdx = nextMovePlayerIdx;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }
}
