package MVC.Cocktail;

import MVC.Favorites.FavoriteView;
import Singleton.Singleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CocktailView extends JFrame {
    private final JPanel panel;
    private final ArrayList<JButton> cocktailNames = new ArrayList<>();
    private final ArrayList<JLabel> cocktailImages = new ArrayList<>();
    private JPanel layout;
    private int i=0;
    public CocktailView(){
        super("Cocktail");
        this.panel = new JPanel(new GridLayout(100,3));
        JScrollPane scroll = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.getVerticalScrollBar().setUnitIncrement(20);
        
        // Create favorites button at the top
        JButton viewFavoritesButton = new JButton("View My Favorites");
        viewFavoritesButton.setFont(new Font(null, Font.BOLD, 14));
        viewFavoritesButton.setBackground(new Color(100, 200, 100));
        viewFavoritesButton.setFocusable(false);
        viewFavoritesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Singleton singleton = Singleton.getInstance();
                FavoriteView favoriteView = new FavoriteView();
                favoriteView.showAllFavorites(singleton.favoriteDao.getAllFavorites());
            }
        });
        
        this.setSize(600,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        add(viewFavoritesButton, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }
    public void showCocktailData(int id,String cocktailName,Image cocktailImage){
        //Έχω μια λίστα απο κουμπιά cocktailNames για κάθε cocktail
        this.cocktailNames.add(new JButton(cocktailName));
        this.cocktailNames.get(i).setBackground(Color.WHITE);
        //Για κάθε κουμπί φτιάχνω ένα actionListener όπου παίρνει το id του cocktail και κάνει ένα νέο παράθυρο για τα details του cocktail
        this.cocktailNames.get(i).addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                CocktailController.callDetailsController(id);
            }
        });
        //Έχω μια λίστα από Icons για κάθε cocktail
        this.cocktailImages.add(new JLabel(new ImageIcon(cocktailImage)));
        JButton btn = new JButton("Add To Favorites");
        btn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        CocktailController.callFavoriteController(cocktailName);
                    }
                });
        btn.setFocusable(false);
        btn.setBackground(Color.WHITE);
        this.layout = new JPanel(new BorderLayout());
        this.layout.add(cocktailImages.get(i),BorderLayout.WEST);
        this.layout.add(cocktailNames.get(i),BorderLayout.CENTER);
        this.layout.add(btn,BorderLayout.EAST);
        this.panel.add(this.layout,BorderLayout.WEST);
        i++;
    }
}