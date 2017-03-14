package screenSaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Evegeny on 14/03/2017.
 */
@Component
public class ColorFrame extends JFrame {
    @Autowired
    private Color color;

    private Random random = new Random();

    @PostConstruct
    public void init() {
        System.out.println(color);
        System.out.println(color);
        System.out.println(color);
        System.out.println(color);
        System.out.println(color);
        System.out.println(color.getClass());
        setSize(150, 150);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void fly() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(random.nextInt(screenSize.width), random.nextInt(screenSize.height));
        getContentPane().setBackground(color);
        repaint();
    }
}
















