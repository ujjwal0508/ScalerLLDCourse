package DesignPattern.Singleton.EagerLoaded;

public class DatabaseConnection {

    private static DatabaseConnection instance = new DatabaseConnection();

    private DatabaseConnection() {

    }

    public DatabaseConnection getInstance(){
        return instance;
    }

}
