//Author: Mara Johnson
//Date: Submitted 1/14
//Quiz users about 10 different countries and allow them to review information about these countries in the form of a game

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main 
{

  // array of 10 Country objects
  private Country[] countryArray = new Country[10];  
  // index of current shown country
  private int index = 0;
  private int questionNumber;

  // GUI elements
  private JFrame jFrame = new JFrame("Countries");
  private ImageIcon img;
  private JLabel imageLabel;
  private JLabel outputLabel;
  private JTextField input;
  public static void main(String[] args) {
    // Create the GUI
    Main gui = new Main();
    gui.loadCountries();
    gui.showCountry();
  }

  /* loadCountries() reads in the data from the countries-data.csv file and fills in the countryArray with data. You need to add the loop that reads in the country data into the array. */
  public void loadCountries() 
  {
    // Open the data file - do not change
    File file = new File("/workspaces/Countries/workspace/countries-data.csv");
    Scanner scan = null;
    try {
      scan = new Scanner(file);
    } catch(FileNotFoundException e) { 
        System.out.println("File not found");     
    }
    
    // Write a for loop that goes through the countryArray.
    // for(int i ....) {
    // Do the following inside the loop
    for(int i = 0; i < countryArray.length; i++){
      String input = scan.nextLine();
      String[] data = input.split(",");
      System.out.println("Read in " + data[2]);
      Country info = new Country(data[0], data[1], data[2], data[3]);
      countryArray[i] = info;
      System.out.println(countryArray[i].toString());
      
    }
      // inside the loop, create a new Country using your constructor with 4 arguments and pass in data[0], data[1], data[2], data[3] as arguments.
     // inside the loop, set countryArray[i] to the created Country object
     
    
  }

  /* showCountry() will show the image associated with the current country. It should get the country at index from the countryArray. It should use its get method to get its image file name and use the code below to put the image in the GUI.
  */
  public void showCountry() {
    // Get the country at index from countryArray
    Country c = countryArray[index];
    
    // Use its get method to get the its image file name and save it into imagefile variable below instead of worldmap.jpg.
    String imagefile = "worldmap.jpg";
    // Use the following code to create an new Image Icon and put it into the GUI
    imagefile = c.getImagefile();
    img = new ImageIcon("/workspaces/Countries/workspace/" + imagefile);
    imageLabel.setIcon(img);
  }
  
  /* nextButton should increment index. If the index is greater than 9, reset it back to 0. Clear the outputLabel to empty string using setText, and call showCountry();*/
  public void nextButtonClick()
  {
    //increments the index, and resets it to 0 if it is greater than 9
    index++;
    if(index > 9){
      index = 0;
    }
  //clears the output label and input
    outputLabel.setText("");
    input.setText("");
    //calls showCountry()
    showCountry();
  }
  
  /* reviewButton should get the country at index from the countryArray, call its toString() method and save the result, print it out with System.out.println and as an argument to outputLabel.setText( text to print out ); */
  public void reviewButtonClick()
  {
    String review = countryArray[index].toString(); 
    System.out.println(review);
    outputLabel.setText(review);
    input.setText("");
  }

  /* quizButton gets the country at index from countryArray and prints out 1 of 3 randomly selected questions about the country: 
      "What country is this?", "What is this country's capital", or "What language is primarily spoken in this country?"
  */
  public void quizButtonClick()
  {
   //makes sure the input is blank
   input.setText("");
   //chooses a random number 0-2(inclusive), which will correspond to the question being asked
   questionNumber = (int)(Math.random() * 3);
   // Sets the output label to question based on the number randomly selected
    if (questionNumber == 0){
      outputLabel.setText("What country is this?");

    } 
    if (questionNumber == 1){
      outputLabel.setText("What is this country's capital?");
    }
     if (questionNumber == 2){
      outputLabel.setText("What language is primarily spoken in this country?");
     }
    
  

  }

  //This button compares the user's input to the answer of the question and prints out whether it is correct or incorrect
  public void submitButtonClick(){
  // Gets the user's input from the text box
  String guess = input.getText();
  //compares the user's input to the correct answer of the question that was randomly chosen
  //if the user's input matches the answer, prints out "That is correct!"
  //if the user's inpur does not match the answer, prints out "That is incorrect :( Try again or review"
  //The answer is case sensitive, the first letter must be capitalized
  if (questionNumber == 0){
    if(guess.equals(countryArray[index].getName())){
      outputLabel.setText("That is correct!");
    } else{
      outputLabel.setText("That is incorrect :( Try again or review!");
    }
  }
  if (questionNumber == 1){
    if(guess.equals(countryArray[index].getCapital())){
      outputLabel.setText("That is correct!");
    } else{
      outputLabel.setText("That is incorrect :( Try again or review!");
    }
  }
  if (questionNumber == 2){
    if(guess.equals(countryArray[index].getLanguage())){
      outputLabel.setText("That is correct!");
    } else{
      outputLabel.setText("That is incorrect :( Try again or review!");
    }
  }

 
  }




  /* Do NOT change anything below here */
  /* The Main() constructor is finished and will construct the GUI */
public Main() {
    jFrame.setLayout(new FlowLayout());
    jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // buttons at the top
        JButton reviewButton = new JButton("Review");
        JButton quizButton = new JButton("Quiz");
        JButton newButton = new JButton("Next");
        JButton submitButton = new JButton("Submit");
        jFrame.add(reviewButton);
        jFrame.add(quizButton);
        jFrame.add(newButton);
        
        // create a new image icon
        img = new ImageIcon("worldmap.jpg");
        // create a label to display image
        imageLabel = new JLabel(img);
        // and one for output
        outputLabel = new JLabel();
        jFrame.add(imageLabel);
        jFrame.add(outputLabel);
        input = new JTextField(20);
        jFrame.add(input);
        //button at the bottom 
        jFrame.add(submitButton);




        jFrame.setVisible(true);
        // add event listener for button click
        reviewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      reviewButtonClick();
    }
        });
    quizButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      quizButtonClick();
    }
    });
   
   newButton.addActionListener(new ActionListener()  {
    public void actionPerformed(ActionEvent e) 
    {
      nextButtonClick();
    }
   });
   submitButton.addActionListener(new ActionListener()  {
    public void actionPerformed(ActionEvent e) 
    {
      submitButtonClick();
    }
   });
}
  

}
