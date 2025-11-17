package MVC.CocktailDetails;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.lang.reflect.Field;


public class DetailsController {
    private DetailsView detailsView;
    private CocktailDetails model;
    public DetailsController(CocktailDetails model, DetailsView detailsView){
        this.model = model;
        this.detailsView = detailsView;
    }

    //region Getters/Setters
    public void setModelId(int index){this.model.setId(index);}
    public void setModelName(String name){this.model.setName(name);}
    public void setModelNameAlt(String nameAlt){this.model.setNameAlt(nameAlt);}
    public void setModelTags(String tags){this.model.setTags(tags);}
    public void setModelVideo(String video){this.model.setVideo(video);}
    public void setModelCategory(String category){this.model.setCategory(category);}
    public void setModelIBA(String iba){this.model.setIBA(iba);}
    public void setModelAlcoholic(String alcoholic){this.model.setAlcoholic(alcoholic);}
    public void setModelGlass(String glass){this.model.setGlass(glass);}
    public void setModelInstructions(String instructions){this.model.setInstructions(instructions);}
    public void setModelInstructionsEs(String instructionsEs){this.model.setInstructionsEs(instructionsEs);}
    public void setModelInstructionsDe(String instructionsDe){this.model.setInstructionsDe(instructionsDe);}
    public void setModelInstructionsFr(String instructionsFr){this.model.setInstructionsFr(instructionsFr);}
    public void setModelInstructionsIt(String instructionsIt){this.model.setInstructionsIt(instructionsIt);}
    public void setModelInstructionsZhHANS(String instructionsZhHANS){this.model.setInstructionsZhHANS(instructionsZhHANS);}
    public void setModelInstructionsZhHANT(String instructionsZhHANT){this.model.setInstructionsZhHANT(instructionsZhHANT);}
    public void setModelImage(String image){this.model.setImage(image);}
    public void setModelIngredient1(String ingredient1){this.model.setIngredient1(ingredient1);}
    public void setModelIngredient2(String ingredient2){this.model.setIngredient2(ingredient2);}
    public void setModelIngredient3(String ingredient3){this.model.setIngredient3(ingredient3);}
    public void setModelIngredient4(String ingredient4){this.model.setIngredient4(ingredient4);}
    public void setModelIngredient5(String ingredient5){this.model.setIngredient5(ingredient5);}
    public void setModelIngredient6(String ingredient6){this.model.setIngredient6(ingredient6);}
    public void setModelIngredient7(String ingredient7){this.model.setIngredient7(ingredient7);}
    public void setModelIngredient8(String ingredient8){this.model.setIngredient8(ingredient8);}
    public void setModelIngredient9(String ingredient9){this.model.setIngredient9(ingredient9);}
    public void setModelIngredient10(String ingredient10){this.model.setIngredient10(ingredient10);}
    public void setModelIngredient11(String ingredient11){this.model.setIngredient11(ingredient11);}
    public void setModelIngredient12(String ingredient12){this.model.setIngredient12(ingredient12);}
    public void setModelIngredient13(String ingredient13){this.model.setIngredient13(ingredient13);}
    public void setModelIngredient14(String ingredient14){this.model.setIngredient14(ingredient14);}
    public void setModelIngredient15(String ingredient15){this.model.setIngredient15(ingredient15);}
    public void setModelMeasure1(String measure1){this.model.setMeasure1(measure1);}
    public void setModelMeasure2(String measure2){this.model.setMeasure2(measure2);}
    public void setModelMeasure3(String measure3){this.model.setMeasure3(measure3);}
    public void setModelMeasure4(String measure4){this.model.setMeasure4(measure4);}
    public void setModelMeasure5(String measure5){this.model.setMeasure5(measure5);}
    public void setModelMeasure6(String measure6){this.model.setMeasure6(measure6);}
    public void setModelMeasure7(String measure7){this.model.setMeasure7(measure7);}
    public void setModelMeasure8(String measure8){this.model.setMeasure8(measure8);}
    public void setModelMeasure9(String measure9){this.model.setMeasure9(measure9);}
    public void setModelMeasure10(String measure10){this.model.setMeasure10(measure10);}
    public void setModelMeasure11(String measure11){this.model.setMeasure11(measure11);}
    public void setModelMeasure12(String measure12){this.model.setMeasure12(measure12);}
    public void setModelMeasure13(String measure13){this.model.setMeasure13(measure13);}
    public void setModelMeasure14(String measure14){this.model.setMeasure14(measure14);}
    public void setModelMeasure15(String measure15){this.model.setMeasure15(measure15);}
    public void setModelImageSource(String imageSource){this.model.setImageSource(imageSource);}
    public void setModelImageAttributions(String imageAttributions){this.model.setImageAttribution(imageAttributions);}
    public void setModelCreativeCommonsConfirmed(String creative){this.model.setCreativeCommonsConfirmed(creative);}
    public void setModelDate(String date){this.model.setDate(date);}
    public int getModelId(){return this.model.getId();}
    public String getModelName(){return this.model.getName();}
    public String getModelNameAlt(){return this.model.getNameAlt();}
    public String getModelTags(){return this.model.getTags();}
    public String getModelVideo(){return this.model.getVideo();}
    public String getModelCategory(){return this.model.getCategory();}
    public String getModelIBA(){return this.model.getIBA();}
    public String getModelAlcoholic(){return this.model.getAlcoholic();}
    public String getModelGlass(){return this.model.getGlass();}
    public String getModelInstructions(){return this.model.getInstructions();}
    public String getModelInstructionsEs(){return this.model.getInstructionsEs();}
    public String getModelInstructionsDe(){return this.model.getInstructionsDe();}
    public String getModelInstructionsFr(){return this.model.getInstructionsFr();}
    public String getModelInstructionsIt(){return this.model.getInstructionsIt();}
    public String getModelInstructionsZhHANS(){return this.model.getInstructionsZhHANS();}
    public String getModelInstructionsZhHANT(){return this.model.getInstructionsZhHANT();}
    public String getModelImage(){return this.model.getImage();}
    public String getModelIngredient1(){return this.model.getIngredient1();}
    public String getModelIngredient2(){return this.model.getIngredient2();}
    public String getModelIngredient3(){return this.model.getIngredient3();}
    public String getModelIngredient4(){return this.model.getIngredient4();}
    public String getModelIngredient5(){return this.model.getIngredient5();}
    public String getModelIngredient6(){return this.model.getIngredient6();}
    public String getModelIngredient7(){return this.model.getIngredient7();}
    public String getModelIngredient8(){return this.model.getIngredient8();}
    public String getModelIngredient9(){return this.model.getIngredient9();}
    public String getModelIngredient10(){return this.model.getIngredient10();}
    public String getModelIngredient11(){return this.model.getIngredient11();}
    public String getModelIngredient12(){return this.model.getIngredient12();}
    public String getModelIngredient13(){return this.model.getIngredient13();}
    public String getModelIngredient14(){return this.model.getIngredient14();}
    public String getModelIngredient15(){return this.model.getIngredient15();}
    public String getModelMeasure1(){return this.model.getMeasure1();}
    public String getModelMeasure2(){return this.model.getMeasure2();}
    public String getModelMeasure3(){return this.model.getMeasure3();}
    public String getModelMeasure4(){return this.model.getMeasure4();}
    public String getModelMeasure5(){return this.model.getMeasure5();}
    public String getModelMeasure6(){return this.model.getMeasure6();}
    public String getModelMeasure7(){return this.model.getMeasure7();}
    public String getModelMeasure8(){return this.model.getMeasure8();}
    public String getModelMeasure9(){return this.model.getMeasure9();}
    public String getModelMeasure10(){return this.model.getMeasure10();}
    public String getModelMeasure11(){return this.model.getMeasure11();}
    public String getModelMeasure12(){return this.model.getMeasure12();}
    public String getModelMeasure13(){return this.model.getMeasure13();}
    public String getModelMeasure14(){return this.model.getMeasure14();}
    public String getModelMeasure15(){return this.model.getMeasure15();}
    public String getModelImageSource(){return this.model.getImageSource();}
    public String getModelImageAttributions(){return this.model.getImageAttribution();}
    public String getModelCreativeCommonsConfirmed(){return this.model.getCreativeCommonsConfirmed();}
    public String getModelDate(){return this.model.getDate();}
    //endregion

    public Image UrlImage(String imageString){
        try {
            System.out.println("Get Image from " + imageString);
            URL url = new URL(imageString);
            BufferedImage image = ImageIO.read(url);
            Image newImage = image.getScaledInstance(125,125,Image.SCALE_DEFAULT);
            System.out.println("Load image into frame... \n");
            return newImage;
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return null;
    }
    public List<String> createStringList() throws IllegalAccessException {
        List<String> temp = new ArrayList<>();
        Field[] fields = model.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            String t = field.get(model).toString();
            temp.add(t);
        }
        return temp;
    }
    public List<String> getDetails() throws IllegalAccessException {
        List<String> details = new ArrayList<>();
        for(int i=0;i<createStringList().size();i++) {
            if (!(Objects.equals(createStringList().get(i), "null")) && !(Objects.equals(createStringList().get(i), ""))) {
                switch (i) {
                    case 1 -> details.add("Cocktail name: " + createStringList().get(i));
                    case 2 -> details.add("Cocktail alternative name: " + createStringList().get(i));
                    case 3 -> details.add("Cocktail tags: " + createStringList().get(i));
                    case 4 -> details.add("Cocktail video url: " + createStringList().get(i));
                    case 5 -> details.add("Cocktail category: " + createStringList().get(i));
                    case 6 -> details.add("Cocktail iba: " + createStringList().get(i));
                    case 7 -> details.add("Cocktail is: " + createStringList().get(i));
                    case 8 -> details.add("For this Cocktail you need a: " + createStringList().get(i));
                    case 9 -> details.add("<html> English Instructions: " + createStringList().get(i).replace("\r","<br>") + "<br></html>");
                    case 10 -> details.add("<html> Spanish Instructions: " + createStringList().get(i).replace("\r","<br>") + "<br></html>");
                    case 11 -> details.add("<html>German Instructions: " + createStringList().get(i).replace("\r","<br>") + "<br></html>");
                    case 12 -> details.add("<html>French Instructions: " + createStringList().get(i).replace("\r","<br>") + "<br></html>");
                    case 13 -> details.add("<html>Italian Instructions: " + createStringList().get(i).replace("\r","<br>") + "<br></html>");
                    case 14 -> details.add("<html>Zh-Hans Instructions: " + createStringList().get(i).replace("\r","<br>") + "<br></html>");
                    case 15 -> details.add("<html>Zh-Hant Instructions: " + createStringList().get(i).replace("\r","<br>") + "<br></html>");
                    case 47 -> details.add("Cocktail's image source: " + createStringList().get(i));
                    case 48 -> details.add("Cocktail's image attribution: " + createStringList().get(i));
                    case 49 -> details.add("Is the cocktail creative? " + createStringList().get(i));
                    case 50 -> details.add("Date modified: " + createStringList().get(i));
                }
                if(i>=31 && i<46)
                details.add("You need " + createStringList().get(i) + " of " + createStringList().get(i - 15));
            }
        }
        return details;
}
    public void updateView() throws IllegalAccessException {
        List<String> details = getDetails();
        this.detailsView.showCocktailDetails(details,UrlImage(getModelImage()));
    }

}
