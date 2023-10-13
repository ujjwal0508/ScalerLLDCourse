package DesignPattern.Singleton.SingleThreaded;

public class DatabaseConnection {

    private static DatabaseConnection instance = null;

    private DatabaseConnection() {

    }

    public DatabaseConnection getInstance(){
        if(instance == null)
            instance = new DatabaseConnection();

        return instance;
    }

}
