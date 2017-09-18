package seu;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import seu.view.MainView;
import seu.view.MySplashScreenView;

@SpringBootApplication
public class Main extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) {
        launchApp(Main.class, MainView.class, new MySplashScreenView(), args);
    }
}
