package seu.view;

import de.felixroske.jfxsupport.SplashScreen;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class MySplashScreenView extends SplashScreen {
    private static String DEFAULT_IMAGE = "splash.jpg";

    public MySplashScreenView() {}

    @Override
    public Parent getParent() {
        Image image = new Image(getImagePath());
        ImageView imageView = new ImageView(image);
        ProgressBar splashProgressBar = new ProgressBar();
        splashProgressBar.setPrefWidth(imageView.getImage().getWidth());
        VBox vbox = new VBox();
        vbox.getChildren().addAll(new Node[]{imageView, splashProgressBar});
        return vbox;
    }

    @Override
    public boolean visible() {
        return super.visible();
    }

    @Override
    public String getImagePath() {
        return DEFAULT_IMAGE;
    }
}
