import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Frame extends JFrame {

    //creating global variables

    int whoStart = 0; // to decide who starts
    String temp;


    JLabel p1label1;
    JLabel p1label2;
    JLabel p1label3;
    JLabel p1label4;
    JLabel p1label5;

    JCheckBox p1box1;
    JCheckBox p1box2;
    JCheckBox p1box3;
    JCheckBox p1box4;
    JCheckBox p1box5;

    String p1cardname1;
    String p1cardname2;
    String p1cardname3;
    String p1cardname4;
    String p1cardname5;

    JLabel p1TotalPointLabel;
    int p1TotalPoint;

    //-------------------------------------------------


    JLabel p2label1;
    JLabel p2label2;
    JLabel p2label3;
    JLabel p2label4;
    JLabel p2label5;

    JCheckBox p2box1;
    JCheckBox p2box2;
    JCheckBox p2box3;
    JCheckBox p2box4;
    JCheckBox p2box5;

    String p2cardname1;
    String p2cardname2;
    String p2cardname3;
    String p2cardname4;
    String p2cardname5;

    JLabel p2TotalPointLabel;
    int p2TotalPoint;


    HashSet<String> AllOnDeskCards; // Contains all already selected cards.
    HashSet<Integer>playerdesk1= new HashSet<>(); // Contains player's cards values that he/she have
    HashSet<String>playerdesk1names= new HashSet<>(); // Contains player's cards names that he/she have
    HashSet<Integer>checkedvalue= new HashSet<>(); // This is for rule 4, determine straight of 5 cards or more


    //-------------------------------------------------

    String middlecard1name;
    String middlecard2name;
    String middlecard3name;

    JLabel middlecard1;
    JLabel middlecard2;
    JLabel middlecard3;

    JButton p1button;
    JButton p2button;
    JButton NextButton;

    HashMap<String, Integer> hasmap;


    //----------------------------------
    JLabel p1WinCounter;
    int p1WinNumber = 0;
    JLabel p2WinCounter;
    int p2WinNumber = 0;


    Frame() { //Defining variables in constructor
        super("Project3&4");
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);


        p1label1 = new JLabel();
        p1label2 = new JLabel();
        p1label3 = new JLabel();
        p1label4 = new JLabel();
        p1label5 = new JLabel();
        p1WinCounter = new JLabel("Player 1 Total Win: "+p1WinNumber);
        p1WinCounter.setFont(new Font("Arial",Font.BOLD,15));

        p1WinNumber = 0;


        p1label1.setBounds(50, 25, 100, 100);
        p1label2.setBounds(150, 25, 100, 100);
        p1label3.setBounds(250, 25, 100, 100);
        p1label4.setBounds(350, 25, 100, 100);
        p1label5.setBounds(450, 25, 100, 100);
        p1WinCounter.setBounds(650, 20, 150, 50);

        add(p1label1);
        add(p1label2);
        add(p1label3);
        add(p1label4);
        add(p1label5);
        add(p1WinCounter);

        p1box1 = new JCheckBox("", false);
        p1box2 = new JCheckBox("", false);
        p1box3 = new JCheckBox("", false);
        p1box4 = new JCheckBox("", false);
        p1box5 = new JCheckBox("", false);

        p1box1.setBounds(80, 130, 15, 20);
        p1box2.setBounds(180, 130, 15, 20);
        p1box3.setBounds(280, 130, 15, 20);
        p1box4.setBounds(380, 130, 15, 20);
        p1box5.setBounds(480, 130, 15, 20);

        p1box1.setBackground(Color.GRAY);
        p1box2.setBackground(Color.GRAY);
        p1box3.setBackground(Color.GRAY);
        p1box4.setBackground(Color.GRAY);
        p1box5.setBackground(Color.GRAY);

        add(p1box1);
        add(p1box2);
        add(p1box3);
        add(p1box4);
        add(p1box5);

        //------------------------------------------

        p2label1 = new JLabel();
        p2label2 = new JLabel();
        p2label3 = new JLabel();
        p2label4 = new JLabel();
        p2label5 = new JLabel();
        p2TotalPointLabel = new JLabel("Player 2 Total Score Is: "+p2WinNumber);
        p2TotalPointLabel.setFont(new Font("Arial",Font.BOLD,15));
        p2WinCounter = new JLabel("Player 2 Total Win: 0 ");
        p2WinCounter.setFont(new Font("Arial",Font.BOLD,15));


        p2label1.setBounds(50, 400, 100, 100);
        p2label2.setBounds(150, 400, 100, 100);
        p2label3.setBounds(250, 400, 100, 100);
        p2label4.setBounds(350, 400, 100, 100);
        p2label5.setBounds(450, 400, 100, 100);
        p2TotalPointLabel.setBounds(650, 410, 310, 50);
        p2WinCounter.setBounds(650, 390, 150, 50);

        p2WinNumber = 0;

        add(p2label1);
        add(p2label2);
        add(p2label3);
        add(p2label4);
        add(p2label5);
        add(p2TotalPointLabel);
        add(p2WinCounter);

        p2box1 = new JCheckBox("", false);
        p2box2 = new JCheckBox("", false);
        p2box3 = new JCheckBox("", false);
        p2box4 = new JCheckBox("", false);
        p2box5 = new JCheckBox("", false);

        p2box1.setBounds(80, 500, 15, 20);
        p2box2.setBounds(180, 500, 15, 20);
        p2box3.setBounds(280, 500, 15, 20);
        p2box4.setBounds(380, 500, 15, 20);
        p2box5.setBounds(480, 500, 15, 20);

        p2box1.setBackground(Color.GRAY);
        p2box2.setBackground(Color.GRAY);
        p2box3.setBackground(Color.GRAY);
        p2box4.setBackground(Color.GRAY);
        p2box5.setBackground(Color.GRAY);

        add(p2box1);
        add(p2box2);
        add(p2box3);
        add(p2box4);
        add(p2box5);

        //-----------------------------------

        middlecard1 = new JLabel(new ImageIcon(getClass().getResource("Cards/back.png")));
        middlecard2 = new JLabel(new ImageIcon(getClass().getResource("Cards/back.png")));
        middlecard3 = new JLabel(new ImageIcon(getClass().getResource("Cards/back.png")));

        middlecard1.setBounds(150, 200, 100, 100);
        middlecard2.setBounds(250, 200, 100, 100);
        middlecard3.setBounds(350, 200, 100, 100);

        add(middlecard1);
        add(middlecard2);
        add(middlecard3);


        ButtonHandler handler = new ButtonHandler();

        p1button = new JButton("Change");
        p1button.setBounds(650, 80, 100, 50);

        p2button = new JButton("Change");
        p2button.setBounds(650, 450, 100, 50);

        p1button.addActionListener(handler);
        p2button.addActionListener(handler);

        p1TotalPointLabel = new JLabel();
        p1TotalPointLabel.setFont(new Font("Arial",Font.BOLD,15));
        p1TotalPointLabel.setBounds(650, 40, 300, 50);

        add(p1button);
        add(p2button);
        add(p1TotalPointLabel);

        //----------------------------------

        NextButton = new JButton("Next Round");
        NextButton.setBounds(650, 265, 100, 50);
        NextButton.addActionListener(handler);

        add(NextButton);

        hasmap = new HashMap<>(); //Contains card names with their value.
        AllOnDeskCards = new HashSet<>(); // Contains already selected card names.

        indicateHashMap(); // to determine card values

        OpenCard(); // for start the game.

        setSize(1000, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    // Middle cards will close and Player 1 desk or player 2 desk will show according to who will start.
    public void OpenCard() {
        AllOnDeskCards.clear(); //Clears 'AllOnDeskCards' Hashset
        if (whoStart == 0) { // 0 = Player 1 and 1 = Player2

            //if player 1 start :

            p1DeskCreate(); // Player 1's cards will open on desk

            p2label1.setIcon(new ImageIcon(getClass().getResource("Cards/back.png")));
            p2label2.setIcon(new ImageIcon(getClass().getResource("Cards/back.png")));
            p2label3.setIcon(new ImageIcon(getClass().getResource("Cards/back.png")));
            p2label4.setIcon(new ImageIcon(getClass().getResource("Cards/back.png")));
            p2label5.setIcon(new ImageIcon(getClass().getResource("Cards/back.png")));

            middleCardClose(); // Middle of cards will close on desk

            p2TotalPointLabel.setText("Player 2 Total Score Is: ");


        } else {
            //if player 2 start :

            p2DeskCreate(); // Player 2's cards will open on desk

            p1label1.setIcon(new ImageIcon(getClass().getResource("Cards/back.png")));
            p1label2.setIcon(new ImageIcon(getClass().getResource("Cards/back.png")));
            p1label3.setIcon(new ImageIcon(getClass().getResource("Cards/back.png")));
            p1label4.setIcon(new ImageIcon(getClass().getResource("Cards/back.png")));
            p1label5.setIcon(new ImageIcon(getClass().getResource("Cards/back.png")));

            middleCardClose(); // Middle of cards will close on desk

            p1TotalPointLabel.setText("Player 1 Total Score Is: ");


        }

    }

    public class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) { //Adding functionality to buttons
            if (whoStart == 0) { // 0 = Player 1 and 1 = Player 2

                //if player 1 start :

                if (e.getSource() == p1button) {

                  p1DeskChange(); // Changes which cards selected by player 1.
                  p1button.setEnabled(false); // disable player1 change button
                  p2DeskCreate(); // Player 2's cards will open on desk

                }
                    if (e.getSource() == p2button) {

                        p2DeskChange(); // Changes which cards selected by player 2.
                        p2button.setEnabled(false); // disable player2 change button
                        middleCardCreate();// Middle of cards will open on desk

                        if(p1TotalPoint>p2TotalPoint){ // if player 1's point more than player 2 : player 1's total win increased by 1
                            p1WinNumber++;
                            p1WinCounter.setText("Player 1 Total Win: "+p1WinNumber);
                        }
                        else if (p2TotalPoint>p1TotalPoint){ // if player 2's point more than player 1 : player 2's total win increased by 1
                            p2WinNumber++;
                            p2WinCounter.setText("Player 2 Total Win: "+p2WinNumber);
                        }
                        if (p2WinNumber==3||p1WinNumber==3){ // if first who get 3 times win then the game will end
                            NextButton.setEnabled(false);
                        }
                    }
                }

            else{
                //if player 2 start :

                if (e.getSource() == p2button) {

                    p2DeskChange(); // Changes which cards selected by player 2.
                    p2button.setEnabled(false); // disable player2 change button
                    p1DeskCreate(); // Player 1's cards will open on desk
                }

                if(e.getSource()==p1button){

                    p1DeskChange(); // Changes which cards selected by player 1.
                    p1button.setEnabled(false); // disable player1 change button
                    middleCardCreate(); // Player 2's cards will open on desk

                    if(p1TotalPoint>p2TotalPoint){ // if player 1's point more than player 2 : player 1's total win increased by 1
                        p1WinNumber++;
                        p1WinCounter.setText("Player 1 Total Win: "+p1WinNumber);
                    }
                    else if (p2TotalPoint>p1TotalPoint){ // if player 2's point more than player 1 : player 2's total win increased by 1
                        p2WinNumber++;
                        p2WinCounter.setText("Player 2 Total Win: "+p2WinNumber);
                    }
                    if (p2WinNumber==3||p1WinNumber==3){ // if first who get 3 times win then the game will end
                        NextButton.setEnabled(false);
                    }

                }
            }

            if(e.getSource()==NextButton){
                if(whoStart==0){ // to determine who will start.First round player1, next round player2,next round player1....
                    whoStart++;
                }
                else{
                    whoStart--;
                }

                p1TotalPoint=0;
                p2TotalPoint=0;


                p1button.setEnabled(true);// Activate player1's change button
                p2button.setEnabled(true);// Activate player2's change button

                //Turn back to unselect all radio buttons
                p1box1.setSelected(false);
                p1box2.setSelected(false);
                p1box3.setSelected(false);
                p1box4.setSelected(false);
                p1box5.setSelected(false);

                p2box1.setSelected(false);
                p2box2.setSelected(false);
                p2box3.setSelected(false);
                p2box4.setSelected(false);
                p2box5.setSelected(false);

                OpenCard();// For start game

            }//End of nextbutton action adding

            }//End of acionPerfomed() function

    }//End of ButtonHandler inner class


    // For calculation player's point
    public int Calculation(int[]playerdesk,String[] names){
            int count = 0;
            int point = 0;

            Arrays.sort(names);

            playerdesk1.clear();//Clear hashset playerdesk1
            checkedvalue.clear();//clear hashset checkedvalue
            playerdesk1names.clear(); //clear hashset playerdesk1names

           for(int value:playerdesk){
               playerdesk1.add(value);// adding player's cards value to hashset for rule 4
           }

            int rule5 = CalculationRule5(playerdesk,names); //Checking rule 5 condition
            point+=rule5;


            if(playerdesk1.size()==5){// if player has Straight of 5 cards:

                Integer[] playerdesk2= playerdesk1.toArray(new Integer[playerdesk1.size()]);// converting hashset to an array.

                for(int i =0;i<5;i++){
                    for(int i2=i,i3=0;i2<5;i2++,i3++){ // checking for rule 4, straight of 5 cards or more.
                        if(playerdesk2[i]+i3==playerdesk2[i2]){
                            count++;

                        }
                    }
                    if(count==5&&i==0) { // if there is straight of 5 cards multiplies each card by 5 and adding to point.
                        for(int i3=i;i3<i+5;i3++){
                            point+=playerdesk2[i3]*5;
                            checkedvalue.add(playerdesk2[i3]);
                        }
                        count=0;
                    }
                }
                count=0;
            }
                    for (int i = 0; i < 4; i++) { // for rule 1&2&3

                        for (int i2=i;i2<5;i2++){  // check player's card values, if they same, increase count by 1.
                            if(playerdesk[i]==playerdesk[i2]){
                                count++;
                            }
                        }
                         if(count==4){ // if there is four of kind one of same card's values multiplied by 16 and add to point.
                            point+=playerdesk[i]*16;
                            checkedvalue.add(playerdesk[i]); // adds this cards value into 'checkedvalue' hashset.
                            i+=3;
                        }
                        else if(count==3){ // if there is three of kind one of same card's values multiplied by 9 and add to point.
                            point+=playerdesk[i]*9;
                            checkedvalue.add(playerdesk[i]);
                            i+=2;

                        }
                        else if(count==2){ // if there is two of kind one of same card's values multiplied by 4 and add to point.
                            point+=playerdesk[i]*4;
                            checkedvalue.add(playerdesk[i]);
                           i+=1;
                        }
                        count=0;
                    }

            for(int i =0 ;i<names.length;i++){ // if end of to the calculation, which cards not in any of rules, their default values adds on point.
                if(!(checkedvalue.contains(hasmap.get(names[i])))){
                    point+=hasmap.get(names[i]);
                }
            }

            return point;
        } // end of calculation


           //Checking for Rule 5
            public int CalculationRule5(int[] playerdesk,String[] names){
            int point=0;
            int counter=0;
            Arrays.sort(names);
            ArrayList<String> samesuit = new ArrayList<>();

                for(int i=0;i<playerdesk.length;i++){ //Checking same suits using their suit names
                    for(int i2=i;i2<playerdesk.length;i2++){
                        if(names[i].charAt(names[i].length()-5)==names[i2].charAt(names[i2].length()-5)){
                            samesuit.add(names[i2]);

                        }
                    }

                    if(samesuit.size()>=5){ // If there are 5 Cards or more with the same suit, each card's point multiplied by 6 and adds to point
                        for(int i3=0;i3<samesuit.size();i3++){
                            point+=hasmap.get(samesuit.get(i3))*6;
                            checkedvalue.add(hasmap.get(samesuit.get(i3)));
                        }
                        i+=samesuit.size();
                    }
                    samesuit.clear();
                }

            return point;
        } // end of CalculationRule5


          //Calculation points after all players cards open on the table
           public int LastCalculation(int[] playerdesk,String[] names){
            int count = 0;
            int point=0;

            //Clears hashsets
            Arrays.sort(names);
            playerdesk1.clear();
            checkedvalue.clear();
            playerdesk1names.clear();


            for(int value:playerdesk){
                playerdesk1.add(value); // adding player's cards value to hashset for rule 4
            }

            int rule5 = CalculationRule5(playerdesk,names); //Checking rule 5 condition
            point+=rule5;

            if(playerdesk1.size()>=5){ // if player has straight of 5 cards or more

                    Integer[] playerdesk2= playerdesk1.toArray(new Integer[playerdesk1.size()]); // converting hashset to an array.

                    for(int i =0;i<playerdesk2.length;i++){ // checking for rule 4, straight of 5 cards or more.
                        for(int i2=i,i3=0;i2<playerdesk2.length;i2++,i3++){
                            if(playerdesk2[i]+i3==playerdesk2[i2]){
                                count++;
                            }
                        }
                        if(count>=5) { // if there is straight of 5 cards or more multiplies each card by 5 and adding to point.
                            for(int i3=i;i3<i+count;i3++){
                                point+=playerdesk2[i3]*5;
                                checkedvalue.add(playerdesk2[i3]);

                            }
                            i+=count;
                            count=0;
                        }
                        count=0;
                    }

            }

            for (int i = 0; i < 7; i++) { // for rule 1&2&3

                for (int i2=i;i2<8;i2++){ // check player's card values, if they same, increase count by 1.
                    if(playerdesk[i]==playerdesk[i2]){
                        count++;

                    }
                }

                if(count==4){ // if there is four of kind one of same card's values multiplied by 16 and add to point.
                    point+=playerdesk[i]*12;
                    checkedvalue.add(playerdesk[i]);
                    i+=3;

                }

                if(count==3){ // if there is three of kind one of same card's values multiplied by 9 and add to point.
                    point+=playerdesk[i]*9;
                    checkedvalue.add(playerdesk[i]);
                   i+=2;
                    count=0;
                }

                if(count==2){ // if there is two of kind one of same card's values multiplied by 4 and add to point.
                    point+=playerdesk[i]*4;
                    checkedvalue.add(playerdesk[i]);

                   i+=1;
                }

                count=0;
            }

            for(int i =0 ;i< playerdesk.length;i++){ // if end of to the calculation, which cards not in any of rules, their default values adds on point.
                if(!(checkedvalue.contains(playerdesk[i]))){
                    point+=playerdesk[i];
                }
            }

            playerdesk1names.clear();
            return point;
        }// End of LastCalculation function


        public void p1DeskCreate(){

           // Chooses randomly player1'cards, each card will be different
            p1cardname1 = names[RandomIndex(names.length)];
            while(AllOnDeskCards.contains(p1cardname1)){ // find a card until not selected before
                p1cardname1 = names[RandomIndex(names.length)];
            }
            AllOnDeskCards.add(p1cardname1);

            p1cardname2 = names[RandomIndex(names.length)];
            while(AllOnDeskCards.contains(p1cardname2)){ // find a card until not selected before
                p1cardname2 = names[RandomIndex(names.length)];
            }
            AllOnDeskCards.add(p1cardname2);

            p1cardname3 = names[RandomIndex(names.length)];
            while(AllOnDeskCards.contains(p1cardname3)){ // find a card until not selected before
                p1cardname3 = names[RandomIndex(names.length)];
            }
            AllOnDeskCards.add(p1cardname3);

            p1cardname4 = names[RandomIndex(names.length)];
            while(AllOnDeskCards.contains(p1cardname4)){ // find a card until not selected before
                p1cardname4 = names[RandomIndex(names.length)];
            }
            AllOnDeskCards.add(p1cardname4);

            p1cardname5 = names[RandomIndex(names.length)];
            while(AllOnDeskCards.contains(p1cardname5)){ // find a card until not selected before
                p1cardname5 = names[RandomIndex(names.length)];
            }
            AllOnDeskCards.add(p1cardname5);

            //Declare an image for each card.
            p1label1.setIcon(new ImageIcon(getClass().getResource(p1cardname1)));
            p1label2.setIcon(new ImageIcon(getClass().getResource(p1cardname2)));
            p1label3.setIcon(new ImageIcon(getClass().getResource(p1cardname3)));
            p1label4.setIcon(new ImageIcon(getClass().getResource(p1cardname4)));
            p1label5.setIcon(new ImageIcon(getClass().getResource(p1cardname5)));

            //Create an array for player1's cards values
            int[] player1desk={hasmap.get(p1cardname1),hasmap.get(p1cardname2),hasmap.get(p1cardname3),hasmap.get(p1cardname4),
                    hasmap.get(p1cardname5)};
            //Create an array for player1's card names that he/she have
            String[] player1desknames={p1cardname1,p1cardname2,p1cardname3,p1cardname4,p1cardname5};

            Arrays.sort(player1desk);

            p1TotalPoint=Calculation(player1desk,player1desknames);//to determine player1's score

            p1TotalPointLabel.setText("Player 1 Total Score Is: "+p1TotalPoint);
        } // end of p1DeskCreate function

        public void p1DeskChange(){ // when player1 want to card change
            if (p1box1.isSelected()) {
                while(true) {// find a card until not selected before
                    temp= names[RandomIndex(names.length)];
                    if (AllOnDeskCards.contains(temp)) {
                        continue;
                    }
                    p1cardname1 = temp;
                    AllOnDeskCards.add(p1cardname1);
                    p1label1.setIcon(new ImageIcon(getClass().getResource(p1cardname1)));
                    break;
                }
            }
            if (p1box2.isSelected()) {
                while(true) { // find a card until not selected before
                    temp= names[RandomIndex(names.length)];
                    if (AllOnDeskCards.contains(temp)) {
                        continue;
                    }
                    p1cardname2 = temp;
                    AllOnDeskCards.add(p1cardname2);// adds card name to 'AllOnDeskCards'
                    p1label2.setIcon(new ImageIcon(getClass().getResource(p1cardname2)));
                    break;

                }
            }
            if (p1box3.isSelected()) {
                while(true) { // find a card until not selected before
                    temp= names[RandomIndex(names.length)];
                    if (AllOnDeskCards.contains(temp)) {
                        continue;
                    }
                    p1cardname3 = temp;
                    AllOnDeskCards.add(p1cardname3);// adds card name to 'AllOnDeskCards'
                    p1label3.setIcon(new ImageIcon(getClass().getResource(p1cardname3)));
                    break;
                }

            }
            if (p1box4.isSelected()) {
                while(true) { // find a card until not selected before
                    temp= names[RandomIndex(names.length)];
                    if (AllOnDeskCards.contains(temp)) {
                        continue;
                    }
                    p1cardname4 = temp;
                    AllOnDeskCards.add(p1cardname4);// adds card name to 'AllOnDeskCards'
                    p1label4.setIcon(new ImageIcon(getClass().getResource(p1cardname4)));
                    break;
                }

            }
            if (p1box5.isSelected()) {
                while(true) { // find a card until not selected before
                    temp= names[RandomIndex(names.length)];
                    if (AllOnDeskCards.contains(temp)) {
                        continue;
                    }
                    p1cardname5 = temp;
                    AllOnDeskCards.add(p1cardname5);// adds card name to 'AllOnDeskCards'
                    p1label5.setIcon(new ImageIcon(getClass().getResource(p1cardname5)));
                    break;
                }
            }

            //After changes preparation for point calculation

            //Create an array for player1's cards values
            int[] player1desk={hasmap.get(p1cardname1),hasmap.get(p1cardname2),hasmap.get(p1cardname3),hasmap.get(p1cardname4),
                    hasmap.get(p1cardname5)};

            //Create an array for player1's card names that he/she have
            String[] player1desknames={p1cardname1,p1cardname2,p1cardname3,p1cardname4,p1cardname5};

            Arrays.sort(player1desk);

            p1TotalPoint=Calculation(player1desk,player1desknames); //to determine player1's score

            p1TotalPointLabel.setText("Player 1 Total Score Is: "+p1TotalPoint);

        }// end of p1DeskChange function

        public void p2DeskCreate(){ // when player2 want to card change

            // Chooses randomly player2'cards, each card will be different
            p2cardname1 = names[RandomIndex(names.length)];
            while(AllOnDeskCards.contains(p2cardname1)){ // find a card until not selected before
                p2cardname1 = names[RandomIndex(names.length)];
            }
            AllOnDeskCards.add(p2cardname1); // adds card name to 'AllOnDeskCards'

            p2cardname2 = names[RandomIndex(names.length)];
            while(AllOnDeskCards.contains(p2cardname2)){ // find a card until not selected before
                p2cardname2 = names[RandomIndex(names.length)];
            }
            AllOnDeskCards.add(p2cardname2); // adds card name to 'AllOnDeskCards'

            p2cardname3 = names[RandomIndex(names.length)];
            while(AllOnDeskCards.contains(p2cardname3)){ // find a card until not selected before
                p2cardname3 = names[RandomIndex(names.length)];
            }
            AllOnDeskCards.add(p2cardname3); // adds card name to 'AllOnDeskCards'

            p2cardname4 = names[RandomIndex(names.length)];
            while(AllOnDeskCards.contains(p2cardname4)){ // find a card until not selected before
                p2cardname4 = names[RandomIndex(names.length)];
            }
            AllOnDeskCards.add(p2cardname4); // adds card name to 'AllOnDeskCards'

            p2cardname5 = names[RandomIndex(names.length)];
            while(AllOnDeskCards.contains(p2cardname5)){ // find a card until not selected before
                p2cardname5 = names[RandomIndex(names.length)];
            }
            AllOnDeskCards.add(p2cardname5); // adds card name to 'AllOnDeskCards'

            //Declare an image for each card.
            p2label1.setIcon(new ImageIcon(getClass().getResource(p2cardname1)));
            p2label2.setIcon(new ImageIcon(getClass().getResource(p2cardname2)));
            p2label3.setIcon(new ImageIcon(getClass().getResource(p2cardname3)));
            p2label4.setIcon(new ImageIcon(getClass().getResource(p2cardname4)));
            p2label5.setIcon(new ImageIcon(getClass().getResource(p2cardname5)));

            //Create an array for player2's cards values
            int[] player2desk={hasmap.get(p2cardname1),hasmap.get(p2cardname2),hasmap.get(p2cardname3),
                    hasmap.get(p2cardname4),hasmap.get(p2cardname5)};

            //Create an array for player2's card names that he/she have
            String[] player2desknames={p2cardname1,p2cardname2,p2cardname3,p2cardname4,p2cardname5};

            Arrays.sort(player2desk);

            p2TotalPoint=Calculation(player2desk,player2desknames); //to determine player2's score

            p2TotalPointLabel.setText("Player 2 Total Point Is: "+p2TotalPoint);
        } //end of p2DeskCreate function
        public void p2DeskChange(){
            if (p2box1.isSelected()) {
                while(true) { // find a card until not selected before
                    temp= names[RandomIndex(names.length)];
                    if (AllOnDeskCards.contains(temp)) {
                        continue;
                    }
                    p2cardname1 = temp;
                    AllOnDeskCards.add(p2cardname1);
                    p2label1.setIcon(new ImageIcon(getClass().getResource(p2cardname1)));
                    break;
                }
            }
            if (p2box2.isSelected()) {
                while(true) { // find a card until not selected before
                    temp= names[RandomIndex(names.length)];
                    if (AllOnDeskCards.contains(temp)) {
                        continue;
                    }
                    p2cardname2 = temp;
                    AllOnDeskCards.add(p2cardname2);
                    p2label2.setIcon(new ImageIcon(getClass().getResource(p2cardname2)));
                    break;
                }

            }
            if (p2box3.isSelected()) {
                while(true) { // find a card until not selected before
                    temp= names[RandomIndex(names.length)];
                    if (AllOnDeskCards.contains(temp)) {
                        continue;
                    }
                    p2cardname3 = temp;
                    AllOnDeskCards.add(p2cardname3);
                    p2label3.setIcon(new ImageIcon(getClass().getResource(p2cardname3)));
                    break;
                }
            }
            if (p2box4.isSelected()) {
                while(true) { // find a card until not selected before
                    temp= names[RandomIndex(names.length)];
                    if (AllOnDeskCards.contains(temp)) {
                        continue;
                    }
                    p2cardname4 = temp;
                    AllOnDeskCards.add(p2cardname4);
                    p2label4.setIcon(new ImageIcon(getClass().getResource(p2cardname4)));
                    break;
                }
            }
            if (p2box5.isSelected()) {
                while(true) { // find a card until not selected before
                    temp= names[RandomIndex(names.length)];
                    if (AllOnDeskCards.contains(temp)) {
                        continue;
                    }
                    p2cardname5 = temp;
                    AllOnDeskCards.add(p2cardname5);
                    p2label5.setIcon(new ImageIcon(getClass().getResource(p2cardname5)));
                    break;
                }
            }

            //After changes preparation for point calculation

            //Create an array for player2's cards values
            int[] player2desk={hasmap.get(p2cardname1),hasmap.get(p2cardname2),hasmap.get(p2cardname3),
                    hasmap.get(p2cardname4),hasmap.get(p2cardname5)};

            //Create an array for player2's card names that he/she have
            String[] player2desknames={p2cardname1,p2cardname2,p2cardname3,p2cardname4,p2cardname5};

            Arrays.sort(player2desk);

            p2TotalPoint=Calculation(player2desk,player2desknames); //to determine player2's score

            p2TotalPointLabel.setText("Player 2 Total Point Is: "+p2TotalPoint);

        }// end of p2DeskChange function

        public void middleCardCreate(){

            // Shows middle of cards in table.

            //Select cards differently from other players.
            middlecard1name = names[RandomIndex(names.length)];
            while(AllOnDeskCards.contains(middlecard1name)){ // find a card until not selected before
                middlecard1name = names[RandomIndex(names.length)];
            }
            AllOnDeskCards.add(middlecard1name);

            middlecard2name = names[RandomIndex(names.length)];
            while(AllOnDeskCards.contains(middlecard2name)){ // find a card until not selected before
                middlecard2name = names[RandomIndex(names.length)];
            }
            AllOnDeskCards.add(middlecard2name);

            middlecard3name = names[RandomIndex(names.length)];
            while(AllOnDeskCards.contains(middlecard3name)){ // find a card until not selected before
                middlecard3name = names[RandomIndex(names.length)];
            }
            AllOnDeskCards.add(middlecard3name);

            middlecard1.setIcon(new ImageIcon(getClass().getResource(middlecard1name)));
            middlecard2.setIcon(new ImageIcon(getClass().getResource(middlecard2name)));
            middlecard3.setIcon(new ImageIcon(getClass().getResource(middlecard3name)));


            // for LastCalculation all arrays seting up last time.

            //declares player1 desk card values.
            int[] player1desk={hasmap.get(p1cardname1),hasmap.get(p1cardname2),hasmap.get(p1cardname3),hasmap.get(p1cardname4),
                    hasmap.get(p1cardname5),hasmap.get(middlecard1name),hasmap.get(middlecard2name),hasmap.get(middlecard3name)};
            Arrays.sort(player1desk);

            //declares player1 card names
            String[] player1desknames={p1cardname1,p1cardname2,p1cardname3,p1cardname4,p1cardname5,middlecard1name,middlecard2name,middlecard3name};

            p1TotalPoint = LastCalculation(player1desk,player1desknames);
            p1TotalPointLabel.setText("Player 1 Total Score Is: "+p1TotalPoint);

            //declares player2 desk card values.
            int[] player2desk={hasmap.get(p2cardname1),hasmap.get(p2cardname2),hasmap.get(p2cardname3),
                    hasmap.get(p2cardname4),hasmap.get(p2cardname5),hasmap.get(middlecard1name),hasmap.get(middlecard2name),hasmap.get(middlecard3name)};
            Arrays.sort(player2desk);

            //declares player2 card names
            String[] player2desknames={p2cardname1,p2cardname2,p2cardname3,p2cardname4,p2cardname5,middlecard1name,middlecard2name,middlecard3name};

            p2TotalPoint = LastCalculation(player2desk,player2desknames);
            p2TotalPointLabel.setText("Player 2 Total Score Is: "+p2TotalPoint);

        }// end of middleCardCreate function
        public void middleCardClose(){
           // closes cards which are in the middle of table
            middlecard1.setIcon(new ImageIcon(getClass().getResource("Cards/back.png")));
            middlecard2.setIcon(new ImageIcon(getClass().getResource("Cards/back.png")));
            middlecard3.setIcon(new ImageIcon(getClass().getResource("Cards/back.png")));
        }

        // to determine all cards names
        private static final String[] names =
                {
                        "Cards/lacec.jpg", "Cards/2c.jpg", "Cards/3c.jpg", "Cards/4c.jpg",
                        "Cards/5c.jpg", "Cards/6c.jpg", "Cards/7c.jpg", "Cards/8c.jpg",
                        "Cards/9c.jpg", "Cards/10c.jpg", "Cards/jackc.jpg", "Cards/queenc.jpg",
                        "Cards/kingc.jpg",
                        "Cards/laces.jpg", "Cards/2s.jpg", "Cards/3s.jpg", "Cards/4s.jpg",
                        "Cards/5s.jpg", "Cards/6s.jpg", "Cards/7s.jpg", "Cards/8s.jpg",
                        "Cards/9s.jpg", "Cards/10s.jpg", "Cards/jacks.jpg", "Cards/queens.jpg",
                        "Cards/kings.jpg",
                        "Cards/laced.jpg", "Cards/2d.jpg", "Cards/3d.jpg", "Cards/4d.jpg",
                        "Cards/5d.jpg", "Cards/6d.jpg", "Cards/7d.jpg", "Cards/8d.jpg",
                        "Cards/9d.jpg", "Cards/10d.jpg", "Cards/jackd.jpg", "Cards/queend.jpg",
                        "Cards/kingd.jpg",
                        "Cards/laceh.jpg", "Cards/2h.jpg", "Cards/3h.jpg", "Cards/4h.jpg",
                        "Cards/5h.jpg", "Cards/6h.jpg", "Cards/7h.jpg", "Cards/8h.jpg",
                        "Cards/9h.jpg", "Cards/10h.jpg", "Cards/jackh.jpg", "Cards/queenh.jpg",
                        "Cards/kingh.jpg"

                };


    // to determine all card's value according to card names
    public void indicateHashMap() {  // giving values for every card.

            hasmap.put("Cards/lacec.jpg", 14);hasmap.put("Cards/2c.jpg", 2);hasmap.put("Cards/3c.jpg", 3);hasmap.put("Cards/4c.jpg", 4);
            hasmap.put("Cards/5c.jpg", 5);hasmap.put("Cards/6c.jpg", 6);hasmap.put("Cards/7c.jpg", 7);hasmap.put("Cards/8c.jpg", 8);
            hasmap.put("Cards/9c.jpg", 9);hasmap.put("Cards/10c.jpg", 10);hasmap.put("Cards/jackc.jpg", 11);hasmap.put("Cards/queenc.jpg", 12);
            hasmap.put("Cards/kingc.jpg", 13);hasmap.put("Cards/laces.jpg", 14);hasmap.put("Cards/2s.jpg", 2);hasmap.put("Cards/3s.jpg", 3);
            hasmap.put("Cards/4s.jpg", 4);hasmap.put("Cards/5s.jpg", 5);hasmap.put("Cards/6s.jpg", 6);hasmap.put("Cards/7s.jpg", 7);
            hasmap.put("Cards/8s.jpg", 8);hasmap.put("Cards/9s.jpg", 9);hasmap.put("Cards/10s.jpg", 10);hasmap.put("Cards/jacks.jpg", 11);
            hasmap.put("Cards/queens.jpg", 12);hasmap.put("Cards/kings.jpg", 13);hasmap.put("Cards/laced.jpg", 14);hasmap.put("Cards/2d.jpg", 2);
            hasmap.put("Cards/3d.jpg", 3);hasmap.put("Cards/4d.jpg", 4);hasmap.put("Cards/5d.jpg", 5);hasmap.put("Cards/6d.jpg", 6);
            hasmap.put("Cards/7d.jpg", 7);hasmap.put("Cards/8d.jpg", 8);hasmap.put("Cards/9d.jpg", 9);hasmap.put("Cards/10d.jpg", 10);
            hasmap.put("Cards/jackd.jpg", 11);hasmap.put("Cards/queend.jpg", 12);hasmap.put("Cards/kingd.jpg", 13);hasmap.put("Cards/laceh.jpg", 14);
            hasmap.put("Cards/2h.jpg", 2);hasmap.put("Cards/3h.jpg", 3);hasmap.put("Cards/4h.jpg", 4);hasmap.put("Cards/5h.jpg", 5);
            hasmap.put("Cards/6h.jpg", 6);hasmap.put("Cards/7h.jpg", 7);hasmap.put("Cards/8h.jpg", 8);hasmap.put("Cards/9h.jpg", 9);
            hasmap.put("Cards/10h.jpg", 10);hasmap.put("Cards/jackh.jpg", 11);hasmap.put("Cards/queenh.jpg", 12);hasmap.put("Cards/kingh.jpg", 13);
        } // end of the indicateHashMap.

    //create a random number
    public int RandomIndex(int size) {
            Random rand = new Random();
            return rand.nextInt(size);
        }
    }

