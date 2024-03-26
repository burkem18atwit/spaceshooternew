module JFXHelper.JavaFXExampleNew {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens JFXHelper.JavaFXExampleNew to javafx.fxml;
    exports JFXHelper.JavaFXExampleNew;
}
