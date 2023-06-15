module com.example.a1suneha {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.a1suneha to javafx.fxml;
    exports com.example.a1suneha;
}