/**
* Souncloud Rapper Manager
* @author Matt Lee
* @version 1.0
*/

import java.util.Scanner;

public class SoundcloudRapperManager{

    // Declare Class Variables to represent rapper's attributes.     
    private static String name;
    private static int currentAge;
    private static int currentEdge, currentRelevance, currentMusicQuality;
    private static int edgeRate, relevanceRate, musicQualityRate;
    private static final int LOW_STAT_THRESHOLD = 5;
    private static final int MED_STAT_THRESHOLD = 10;
    private static final int HIGH_STAT_THRESHOLD = 15;
    private static final int END_THRESHOLD = 0;

    // main method - contains game loop
    public static void main(String[] args){

        createRapper();
        while(checkIfEnd() == false){
            feedback();
            playerDecision();
            updateAge();
        }
        endOfGame();
    }

    //creates a rapper by initializing it's attributes 
    public static void createRapper(){
        currentAge = 13; 							// Rapper starts at 13 years old
        System.out.println("Enter the name of your Soundcloud rapper.\n");      // Ask for a name
        Scanner input = new Scanner(System.in);					// new scanner
        name = input.nextLine(); 						// take name input
	//Set current stats to 15
        currentEdge = 15;							
        currentRelevance = 15;
        currentMusicQuality = 15;
        checkForLil();  							// Check if name starts with 'Lil
	//Set beginning rates of change 
        edgeRate = 2;
        relevanceRate = 1;
        musicQualityRate = 2;
        
    }

    // Method to increase the age by one year every iteration of the game loop
    public static void updateAge(){
        System.out.println("\n* * * * * Birthday Update * * * *");   		
        currentAge++;								// increment currentAge
        System.out.printf("%s's age is now %d\n",name,currentAge);		// print current age
	// The following methods increment rates of change of certain attributes at certain years depending on
	// which numbers the current age is evenly divisible by
        if(currentAge % 4 == 0){
            musicQualityRate++;
            System.out.printf("Your music's quality is now decreasing by %d units per year\n",musicQualityRate);
        }
        if(currentAge % 3 == 0){
            edgeRate++;
            System.out.printf("Your edge is now decreasing by %d units per year\n",edgeRate);
        }
        if(currentAge % 5 == 0){
            relevanceRate++;
            System.out.printf("Your relevance is now decreasing by %d units per year\n",relevanceRate);
        }
        if(currentAge % 6 == 0){
            relevanceRate++;
            System.out.printf("Your relevance is now decreasing by %d units per year\n",relevanceRate);
        }
        if(currentAge % 7 == 0){
            edgeRate++;
            System.out.printf("Your edge is now decreasing by %d units per year\n",edgeRate);
        }


    }
    
    // Method to provide player with their choices and implement their decision
    public static void playerDecision(){
        // Display choices
        System.out.println("What do you want to do? Enter your choice as an integer.\n"+
        "1.) Get a face tattoo\n"+
        "2.) Insult a celebrity for clout\n"+
        "3.) Make iconic jams\n");
        // Input choice
        Scanner input = new Scanner(System.in);
        int playerChoice = input.nextInt();
	// Implement the appopriate method for each choice and redisplay the choices if input is invalid 
        switch(playerChoice){
            case 1: faceTat();
                    break;
            case 2: insultCelebrity();
                    break;
            case 3: makeMusic();
                    break;
            default: playerDecision();
        }

    }

    // Method to provide a status update for all current attribute levels
    public static void feedback(){
        System.out.println("\n* * * * Status Update * * * * *");
        String edgeDescription = "Edge level: ";
        System.out.println(edgeDescription+statusDescription(currentEdge));
        String relevanceDescription = "Relevance level: ";
        System.out.println(relevanceDescription+statusDescription(currentRelevance));
        String musicQualityDescription = "Music Quality Level: ";
        System.out.println(musicQualityDescription+statusDescription(currentMusicQuality));
        
    }

    // Method to check if the game is over by determining if any of the attributes have reached 0
    public static boolean checkIfEnd(){
        if(currentEdge<=0){
            System.out.println(name+" is not edgy enough. Their music career is over.");
            return true;
        }
        else if(currentRelevance<=0){
            System.out.println(name+" is irrelevant. Their music career is over.");
            return true;
        }
        else if(currentMusicQuality<=0){
            System.out.println(name+"'s jams do not slap. Their music career is over.");
            return true;
        }
        return false;

    }
    // Method to determine how well the player did based on how long their career lasted
    public static void endOfGame(){
        if(currentAge<18){
            System.out.println(name+" got out early, congrats");
        }
        else if(currentAge<20){
            System.out.println("That was a pretty long Soundcloud rap career. Hopefully "+name+" is ok");
        }
        else if(currentAge<22){
            System.out.println("Consider providing "+name+" with a college fund. There's still time");
        }
        else if(currentAge>21){
            System.out.println(name+" had an amazing career. It's time to take on Hollywood.");
        }
        else{
            System.out.println("You were playing the game, and now you are not.");
        }

    }

    // sub-methods
    // Method to check if the name of rapper starts with "'Lil", which provides a relevance bonus    
    public static void checkForLil(){
        if(name.length()>=4){
            String firstFourChars = name.substring(0,4);
            if(firstFourChars.equals("Lil'")||firstFourChars.equals("lil'")){
                currentRelevance += 4;
                System.out.println("Lil\' Bonus: +6 relevance points");
            }
        }
    }
 
    // Method for getting a face tattoo
    public static void faceTat(){
        currentEdge = currentEdge + edgeRate;				// edge increases by edge rate
        currentMusicQuality -= 2+musicQualityRate;			// music quality decreases by 2 + musicQualitiyRate
        System.out.printf("Your edginess has increased to %d\n"+
        "Your music quality has decreased to %d\n",currentEdge,currentMusicQuality);

    }

    // Method for publicly insulting a clebrity
    public static void insultCelebrity(){
        currentRelevance += relevanceRate;				// relevance increases by relevance rate
        currentMusicQuality -= 2+musicQualityRate;			// musicQuality decreases by 2 + musicQualityRate
        System.out.printf("Your relevance has increased to %d\n"+
        "Your music quality has decreased to %d\n",currentRelevance,currentMusicQuality);

    }

    // Method for making music
    public static void makeMusic(){
        currentMusicQuality += musicQualityRate;			// increases music quality by musicQualityRate
        currentEdge -= 1+edgeRate;					// decreases edge by 1 + edgeRate
        currentRelevance -= 1+relevanceRate;				// decreases relevance by 1 + relevanceRate
        System.out.printf("Your music quality has increased to %d\n"+
        "Your edginess has decreased to %d\n"+
        "Your relevance has decreased to %d\n",currentMusicQuality,currentEdge,currentRelevance);

    }

    // Method for determing the  state of each attribute
    public static String statusDescription(int i){
        String message;
        if(i<LOW_STAT_THRESHOLD){
            message = "Almost career-endingly low";                     // stat extremely low message
        }
        else if(i<MED_STAT_THRESHOLD){
            message = "A bit low";					// stat a little low message
        }
        else if(i<=HIGH_STAT_THRESHOLD){
            message = "very good";					// Stat is pretty good message
        }
        else if(i>HIGH_STAT_THRESHOLD){
            message = "Lil' Pump is proud of you";                      // Stat is high message
        }
        else{
            message = "There is a serious problem";                     // Error message (Stat out of Range)
        }

        return message;

    }


}	 
