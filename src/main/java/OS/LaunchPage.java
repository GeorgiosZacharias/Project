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

    private void showLoadingDialog(String osName) {
        JDialog loadingDialog = new JDialog(frame, "Loading", true);
        loadingDialog.setLayout(new BorderLayout());
        loadingDialog.setSize(300, 150);
        loadingDialog.setLocationRelativeTo(frame);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel loadingLabel = new JLabel("Loading Cocktails...");
        loadingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        loadingLabel.setFont(new Font(null, Font.BOLD, 16));
        
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressBar.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel.add(Box.createVerticalGlue());
        panel.add(loadingLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(progressBar);
        panel.add(Box.createVerticalGlue());
        
        loadingDialog.add(panel, BorderLayout.CENTER);
        
        // Load everything in background thread
        SwingWorker<CocktailView, Void> worker = new SwingWorker<CocktailView, Void>() {
            @Override
            protected CocktailView doInBackground() throws Exception {
                Subject ssubject = new Subject();
                new User(ssubject);
                new User(ssubject);
                new Admin(ssubject);
                ssubject.setState("Anoi3e " + osName);
                OperatingSystem OS1 = OSFactory.getOS(osName);
                OS1.OperationSystem();
                Singleton singleton = Singleton.getInstance();
                List<Cocktail> cocktailList = singleton.cocktailRepository.getAllCocktails();
                
                // Create view and load everything in background
                CocktailView cocktailView = new CocktailView();
                CocktailController cocktailController;
                for (Cocktail cocktail : cocktailList) {
                    cocktailController = new CocktailController(cocktail, cocktailView);
                    cocktailController.updateView();
                }
                
                return cocktailView;
            }
            
            @Override
            protected void done() {
                try {
                    CocktailView cocktailView = get();
                    loadingDialog.dispose();
                    cocktailView.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    loadingDialog.dispose();
                }
            }
        };
        
        worker.execute();
        loadingDialog.setVisible(true);
    }



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
            showLoadingDialog("Windows");
        }
        if(e.getSource()== LinuxButton){
            frame.dispose();
            showLoadingDialog("Linux");
        }
        if(e.getSource()== macOSButton){
            frame.dispose();
            showLoadingDialog("MacOs");
        }
    }
}

