/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FxForm;

import java.awt.Dimension;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JComponent;
import netscape.javascript.JSObject;

/**
 *
 * @author Admin
 */
public class FxWebview {

    private WebEngine webEngine;
    private JFXPanel JFxPanel;
    private String initHTML;
    private WebView browser;
    private double width;
    private double height;

    public FxWebview(JComponent parent, String initHTML, double w, double h) {
        JFxPanel = new JFXPanel();
        this.initHTML = initHTML;
        Platform.setImplicitExit(false);
        width = w;
        height = h;
        parent.add(JFxPanel);
        System.out.println("add ok");
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(JFxPanel);
                System.out.println("init fw ok");
            }
        });
    }
    public void setzoom(double zoom) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                browser.setZoom(zoom);
            }
        });
    }

    public WebEngine getWebEngine() {
        return webEngine;
    }

    public void setWebEngine(WebEngine webEngine) {
        this.webEngine = webEngine;
    }

    public JFXPanel getJFxPanel() {
        return JFxPanel;
    }

    private void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    private Scene createScene() {
        Group root = new Group();
        Scene scene = new Scene(root, javafx.scene.paint.Color.ALICEBLUE);
        // Tạo một đối tượng WebView
        browser = new WebView();
        browser.setPrefHeight(height);
        browser.setPrefWidth(width);
        browser.setZoom(1.25);
// Lấy ra đối tượng WebEngine từ WebView
        webEngine = browser.getEngine();
        webEngine.loadContent(initHTML);
        System.out.println("pass load init");
        root.getChildren()
                .add(browser);
        return (scene);
    }

    public void createObject(String objectName, Object object) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                webEngine.getLoadWorker().stateProperty().addListener(
                        new ChangeListener<Worker.State>() {
                    @Override
                    public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {

                        if (newState == Worker.State.SUCCEEDED) {

                            JSObject win = (JSObject) webEngine.executeScript("window");
                            if (win.getMember(objectName) != null) {
                                win.setMember(objectName, object);
                                System.out.println("ok");
                            }

                        }

                    }
                });
            }
        });
    }

    public void loadConent(String html) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                webEngine.loadContent(html);
            }
        });
    }
}
