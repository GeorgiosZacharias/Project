package OS;
import MVC.Cocktail.Cocktail;
import MVC.Cocktail.CocktailController;
import MVC.Cocktail.CocktailView;
import ObserverPattern.*;
import Singleton.Singleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LaunchPage  implements ActionListener {
    JFrame frame=new JFrame("Operation System Selector");
    JLabel label =new JLabel("Select Operating System");
    JButton WindowsButton = new JButton("Windows");
    JButton LinuxButton= new JButton("Linux");
    JButton macOSButton= new JButton("macOS");



    public LaunchPage(){
        label.setBounds(100,0,300,50);
        label.setFont(new Font(null, Font.PLAIN,25));
        WindowsButton.setBounds(150,60,200,40);
        WindowsButton.setFocusable(false);
        WindowsButton.addActionListener(this);
        LinuxButton.setBounds(150,160,200,40);
        LinuxButton.setFocusable(false);
        LinuxButton.addActionListener(this);
        macOSButton.setBounds(150,260,200,40);
        macOSButton.setFocusable(false);
        macOSButton.addActionListener(this);
        frame.add(label);
        frame.add(WindowsButton);
        frame.add(LinuxButton);
        frame.add(macOSButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,400);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== WindowsButton){
            frame.dispose();
            Subject ssubject = new Subject();
            new User(ssubject);
            new User(ssubject);
            new Admin(ssubject);
            ssubject.setState("Anoi3e window");
            OperatingSystem OS1 = OSFactory.getOS("Windows");
            OS1.OperationSystem();
            Singleton singleton = Singleton.getInstance();
            CocktailView cocktailView = new CocktailView();
            CocktailController cocktailController;
            List<Cocktail> cocktailList = singleton.cocktailRepository.getAllCocktails();
            for (Cocktail cocktail : cocktailList) {
                cocktailController = new CocktailController(cocktail, cocktailView);
                cocktailController.updateView();
            }
        }
        if(e.getSource()== LinuxButton){
            frame.dispose();
            Subject ssubject = new Subject();
            new User(ssubject);
            new User(ssubject);
            new Admin(ssubject);
            ssubject.setState("Anoi3e linux");

            OperatingSystem OS1 = OSFactory.getOS("Linux");
            OS1.OperationSystem();
            Singleton singleton = Singleton.getInstance();
            CocktailView cocktailView = new CocktailView();
            CocktailController cocktailController;
            List<Cocktail> cocktailList = singleton.cocktailRepository.getAllCocktails();
            for (Cocktail cocktail : cocktailList) {
                cocktailController = new CocktailController(cocktail, cocktailView);
                cocktailController.updateView();
            }
        }
        if(e.getSource()== macOSButton){
            frame.dispose();
            Subject ssubject = new Subject();
            new User(ssubject);
            new User(ssubject);
            new Admin(ssubject);
            ssubject.setState("Anoi3e macOS");
            OperatingSystem OS1 = OSFactory.getOS("MacOs");
            OS1.OperationSystem();
            Singleton singleton = Singleton.getInstance();
            CocktailView cocktailView = new CocktailView();
            CocktailController cocktailController;
            List<Cocktail> cocktailList = singleton.cocktailRepository.getAllCocktails();
            for (Cocktail cocktail : cocktailList) {
                cocktailController = new CocktailController(cocktail, cocktailView);
                cocktailController.updateView();
            }
        }
    }
}

