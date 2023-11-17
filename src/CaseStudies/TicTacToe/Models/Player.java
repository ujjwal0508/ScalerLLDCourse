package CaseStudies.TicTacToe.Models;

import java.util.Scanner;

public class Player {
    private Symbol symbol;
    private String name;
    private long id;

    private PlayerType playerType;

    private Scanner scanner;

    public Player(Symbol symbol, String name, Long id, PlayerType playerType) {
        this.symbol = symbol;
        this.name = name;
        this.id = id;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in);
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board) {
        System.out.println("Please tell row count where you want to make the move");
        int row = scanner.nextInt();

        System.out.println("Please tell column count where you want to make the move");
        int col = scanner.nextInt();

        // player can move anywhere so he should not be allowed to make the actual move, he only tells the move
        return new Move(new Cell(row, col), this);
    }
}
