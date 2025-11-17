package MVC.Favorites;

import ObserverPattern.Admin;
import ObserverPattern.Subject;
import ObserverPattern.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FavoriteView extends JFrame{
    String[] favorites = {"Summer","Relax","Energizing"};
    JComboBox favoriteList = new JComboBox(favorites);
    JButton confirmButton = new JButton("Confirm");
    public FavoriteView(){
        super("Favorites");
    }
    public void showCocktailData(String cocktailName){
        JPanel panel = new JPanel(new FlowLayout());
        JLabel title = new JLabel("Select what type of favorite for Cocktail: "+cocktailName,JLabel.CENTER);
        favoriteList.setSelectedIndex(0);
        confirmButton.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String favName = (String)favoriteList.getSelectedItem();
                FavoriteController.setCocktailFavorite(cocktailName,favName);
            }
        });
        this.setSize(300,300);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        panel.add(favoriteList,BorderLayout.CENTER);
        this.add(title,BorderLayout.NORTH);
        this.add(panel,BorderLayout.CENTER);
        panel.add(confirmButton,BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public void showAllFavorites(List<String> favoriteList) {
        Subject ssubject = new Subject();
        new User(ssubject);
        new User(ssubject);
        new Admin(ssubject);

        JPanel panel = new JPanel(new FlowLayout());
        JLabel title = new JLabel("Your favorite cocktails are: ",JLabel.CENTER);
        List<JLabel> allFavorites = new ArrayList<>();
        for(int i=0;i<favoriteList.size(); i+=2){
            allFavorites.add(new JLabel("Cocktail: "+ favoriteList.get(i) + " is "+ favoriteList.get(i+1)));
        }
        for (JLabel allFavorite : allFavorites) panel.add(allFavorite);
        JButton back = new JButton("Back");
        back.addActionListener(e -> {this.dispose();});
        this.setSize(500,500);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.add(title,BorderLayout.NORTH);
        this.add(panel,BorderLayout.CENTER);
        panel.add(back,BorderLayout.SOUTH);
        this.setVisible(true);
        ssubject.setState("Anoi3e to favorite list tou xrhsth");
    }
}
