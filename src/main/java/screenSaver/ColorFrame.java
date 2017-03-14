package screenSaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Evegeny on 14/03/2017.
 */
public abstract class ColorFrame extends JFrame {
    @Autowired
    private Color color;


    private Random random = new Random();

    @PostConstruct
    public void init() {

        setSize(150, 150);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void fly() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        color = getColorBean();
        setLocation(random.nextInt(screenSize.width), random.nextInt(screenSize.height));
        getContentPane().setBackground(color);
        repaint();
    }

    protected abstract Color getColorBean();
}
















