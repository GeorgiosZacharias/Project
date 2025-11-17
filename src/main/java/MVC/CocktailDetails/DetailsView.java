package MVC.CocktailDetails;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DetailsView extends JFrame{

    private final JPanel mainPanel;
    private final JPanel imagePanel;
    private final JButton backButton;
    private final List<JLabel> labels = new ArrayList<>();

    public DetailsView(){
        super("Cocktail Details");
        this.mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        this.imagePanel = new JPanel(new GridLayout(1,2));
        this.backButton = new JButton("Back");

    }
    public void showCocktailDetails(List<String> details, Image urlImage) {
        for(int i=0;i<details.size();i++){
            if(i==0) {
                this.labels.add(new JLabel(details.get(i)));
                imagePanel.add(this.labels.get(i));
            }
            else if(i==1){
                this.labels.add(new JLabel(new ImageIcon(urlImage)));
                imagePanel.add(this.labels.get(i));
                this.add(imagePanel, BorderLayout.NORTH);
            }
            else {
                this.labels.add(new JLabel(details.get(i)));
                this.mainPanel.add(this.labels.get(i));
            }
        }
        JScrollPane scroll = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.getVerticalScrollBar().setUnitIncrement(20);

        this.add(scroll,BorderLayout.CENTER);
        this.setSize(800,600);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.add(backButton,BorderLayout.SOUTH);
        this.setVisible(true);
        backButton.addActionListener(e -> {
            System.out.println("backed");this.dispose();});
    }
}
