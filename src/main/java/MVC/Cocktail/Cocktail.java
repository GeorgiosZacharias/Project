package MVC.Cocktail;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.List;

public class Cocktail{
    private String name;
    private String image;
    private int id;
    public Cocktail(String name, String image, int id)
    {
        this.name = name;
        this.image = image;
        this.id = id;
    }
    public String getName() { return this.name; }
    public void setName(String name){this.name = name;}
    public String getImage() { return this.image; }
    public void setImage(String image){this.image =image;}
    public int getId() { return this.id;}
    public void setId(int id){this.id =id;}

}