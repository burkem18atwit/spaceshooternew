module JFXHelper.JavaFXExampleNew {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;

    opens JFXHelper.JavaFXExampleNew to javafx.fxml;
    exports JFXHelper.JavaFXExampleNew;
}
