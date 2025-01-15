//Author: Mara Johnson
//Date: Submitted 1/14
//Creates a Country class to make Country objects

public class Country
{
  // add private instance variables for the name, capital, language, and image file.
  private String name = "";
  private String capital = "";
  private String language = "";
  private String image = "";

  // add constructors
  public Country(){
    name = "Pig";
    capital = "Pig City";
    language = "Pig Latin";
    image = "pig.jpg";
  }
  public Country(String nameInput, String capitalInput, String languageInput, String imageInput){
    name = nameInput;
    capital = capitalInput;
    language = languageInput;
    image = imageInput;
  }

  // Write accessor/get methods for each instance variable that returns it.
  public String getName(){
    return name;
  }

  public String getCapital(){
    return capital;
  }

  public String getLanguage(){
    return language;
  }

  public String getImagefile(){
    return image;
  }

  // Write a toString() method that returns a concatenated String of the instance variables "name", "capital", and "language" in the sentence  "..'s capital is .. and its primary language is ..."
 public String toString(){
  return name + "'s capital is " + capital + " and its primary language is " + language;
 } 


  
}