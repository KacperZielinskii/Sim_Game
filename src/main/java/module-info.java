module com.example.pio_sim_game {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pio_sim_game to javafx.fxml;
    opens com.example.pio_sim_game.controllers to javafx.fxml;
    opens com.example.pio_sim_game.models to javafx.fxml;
    exports com.example.pio_sim_game;
}