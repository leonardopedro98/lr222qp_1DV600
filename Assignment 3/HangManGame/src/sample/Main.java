package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static javafx.scene.paint.Color.*;


public class Main extends Application {

    private static String[] words = {"SALVADOR", "BATTLER", "ROYAL", "BLOODBORNE", "GRAND", "LEAGUE", "LEGENDS", "PROGRESS", "TROPHIES", "BEGINNING", "COMMUNITY", "REDEMPTION", "PORTUGAL", "LEONARDO", "DICTIONARY", "FRANCE", "LOIC", "APPLICATION", "SPAIN", "BENGTH", "ANAS", "DONALD", "RUSSIA", "MAX", "YARO", "TABLE", "FISH", "TIGER", "FISH", "HELLO", "YESTERDAY", "HOTEL", "SCHOOL", "GAMES", "COMPUTER"};
    private static String Original;
    private static String[] Covered;
    private static String[] CopyC;
    private static ArrayList<String> WrongL = new ArrayList<String>();
    private static int countWrong = 0;

    @Override
    public void start(Stage hmg) throws Exception {


        Label title = new Label("HANGMAN GAME");
        title.setFont(Font.font("Showcard Gothic", 40.0));
        title.setLayoutX(270);
        title.setLayoutY(50);
        title.setTextFill(WHITE);

        Label leo = new Label(" Developed by Leonardo Pedro");
        leo.setFont(Font.font(10.0));
        leo.setLayoutX(0);
        leo.setLayoutY(580);
        leo.setTextFill(WHITE);


        Image HM = new Image(getClass().getResource("hangman-figure.png").toExternalForm());
        ImageView HMView = new ImageView(HM);
        HMView.setFitHeight(300);
        HMView.setFitWidth(300);
        HMView.setLayoutX(280);
        HMView.setLayoutY(150);
        HMView.setPreserveRatio(true);

        Button play = new Button("PLAY");
        play.setLayoutX(350);
        play.setLayoutY(500);
        play.setPrefWidth(120.0);
        play.setPrefHeight(35.0);
        play.setStyle("-fx-font-size: 20; ");
        play.setStyle("-fx-background-color:white;");


        Button EB = new Button("X");
        EB.setLayoutX(770);
        EB.setLayoutY(570);
        EB.setPrefWidth(25.0);
        EB.setPrefHeight(15.0);
        EB.setStyle("-fx-font-size: 40;");
        EB.setStyle("-fx-background-color:red;");


        Group root = new Group();
        root.getChildren().addAll(title, play, HMView, EB, leo);
        Scene scene = new Scene(root, 800, 600);
        scene.setFill(DARKBLUE);
        hmg.setScene(scene);
        hmg.setTitle("HangMan Game");
        hmg.show();


        Group root1 = new Group();
        Button M1 = new Button("Menu");
        M1.setLayoutX(725);
        M1.setLayoutY(570);
        M1.setPrefWidth(70.0);
        M1.setPrefHeight(15.0);
        M1.setStyle("-fx-font-size: 40;");
        M1.setStyle("-fx-background-color:white;");

        Image H = new Image(getClass().getResource("hang.png").toExternalForm());
        ImageView HView = new ImageView(H);
        HView.setFitHeight(300);
        HView.setFitWidth(300);
        HView.setLayoutX(450);
        HView.setLayoutY(150);
        HView.setPreserveRatio(true);

        Image H1 = new Image(getClass().getResource("head.png").toExternalForm());
        ImageView H1View = new ImageView(H1);
        H1View.setFitHeight(300);
        H1View.setFitWidth(300);
        H1View.setLayoutX(450);
        H1View.setLayoutY(150);
        H1View.setPreserveRatio(true);

        Image H2 = new Image(getClass().getResource("arm1.png").toExternalForm());
        ImageView H2View = new ImageView(H2);
        H2View.setFitHeight(300);
        H2View.setFitWidth(300);
        H2View.setLayoutX(450);
        H2View.setLayoutY(150);
        H2View.setPreserveRatio(true);

        Image H3 = new Image(getClass().getResource("arm2.png").toExternalForm());
        ImageView H3View = new ImageView(H3);
        H3View.setFitHeight(300);
        H3View.setFitWidth(300);
        H3View.setLayoutX(450);
        H3View.setLayoutY(150);
        H3View.setPreserveRatio(true);

        Image H4 = new Image(getClass().getResource("body.png").toExternalForm());
        ImageView H4View = new ImageView(H4);
        H4View.setFitHeight(300);
        H4View.setFitWidth(300);
        H4View.setLayoutX(450);
        H4View.setLayoutY(150);
        H4View.setPreserveRatio(true);

        Image H5 = new Image(getClass().getResource("leg1.png").toExternalForm());
        ImageView H5View = new ImageView(H5);
        H5View.setFitHeight(300);
        H5View.setFitWidth(300);
        H5View.setLayoutX(450);
        H5View.setLayoutY(150);
        H5View.setPreserveRatio(true);

        Image H6 = new Image(getClass().getResource("leg2.png").toExternalForm());
        ImageView H6View = new ImageView(H6);
        H6View.setFitHeight(300);
        H6View.setFitWidth(300);
        H6View.setLayoutX(450);
        H6View.setLayoutY(150);
        H6View.setPreserveRatio(true);



        Label guess = new Label("Gues a letter:");
        guess.setFont(Font.font("Showcard Gothic", 25.0));
        guess.setLayoutX(45);
        guess.setLayoutY(205);
        guess.setTextFill(WHITE);

        TextField Gs = new TextField();
        Gs.setLayoutX(240);
        Gs.setLayoutY(207);
        Gs.setPrefSize(25, 25);

        StackPane secondaryLayout = new StackPane();
        Scene secondScene = new Scene(secondaryLayout, 250, 150);
        Stage newWindow = new Stage();
        newWindow.setTitle("Choose one!");
        newWindow.setScene(secondScene);
        newWindow.setX(hmg.getX() + 285);
        newWindow.setY(hmg.getY() + 200);





        //Program


        Random randIndex = new Random();
        int index = randIndex.nextInt(words.length);
        Original = words[index];
        Covered = Original.split("");

        CopyC = createUnderScore(Covered);
        String underSc = printUnderScore(CopyC);


        //Print out fo underscores instead of letters
        Text UnderS = new Text();
        UnderS.setText(underSc);
        UnderS.setFont(Font.font("Showcard Gothic", 45));
        UnderS.setFill(WHITE);
        UnderS.setLayoutX(45);
        UnderS.setLayoutY(320);


        //Verifying letter
        Gs.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String Guess = Gs.getText();
                Gs.setText("");
                Guess = Guess.toUpperCase();
                String unders1 = "";

                //Replace spaces with correct guess letter
                boolean check = false;

                for (int j = 0; j < Covered.length; j++) {
                    //HERE
                    if (isletterinWord(Guess,j,Covered)) {
                        CopyC[j] = Guess;
                        check = true;

                    }
                }

                for (int k = 0; k<CopyC.length;k++){
                    unders1+= CopyC[k]+" ";
                    UnderS.setText(unders1);
                    UnderS.setFont(Font.font("Showcard Gothic",45));
                    UnderS.setLayoutX(45);
                    UnderS.setLayoutY(320);
                }


                if (check == false) {
                    countWrong++;
                    WrongL.add(Guess);
                    Text lives = new Text();
                    int count = 6 - countWrong;


                    if (countWrong == 1) {
                        root1.getChildren().add(H1View);
                    }
                    if (countWrong == 2) {
                        root1.getChildren().add(H2View);
                    }
                    if (countWrong == 3) {
                        root1.getChildren().add(H3View);
                    }
                    if (countWrong == 4) {
                        root1.getChildren().add(H4View);
                    }
                    if (countWrong == 5) {
                        root1.getChildren().add(H5View);
                    }
                    if (countWrong == 6) {
                        root1.getChildren().add(H6View);
                    }
                }
                if(Arrays.equals(CopyC, Covered) || countWrong == 7) {
                    Gs.setDisable(true);
                    newWindow.show();


                }


            }
        });





        root1.getChildren().addAll(M1, HView, guess, Gs, leo, UnderS);
        Scene Game = new Scene(root1, 800, 600);
        Game.setFill(DARKBLUE);


        EB.setOnAction(actionEvent -> Platform.exit());


        M1.setOnAction(actionEvent -> {
            hmg.close();
            hmg.setScene(scene);
            hmg.show();
        });

        play.setOnAction(e -> {
            hmg.close();

            hmg.setScene(Game);
            hmg.setTitle("HangMan Game");
            hmg.show();
        });

    }

    public String printUnderScore(String[] arr){
        String help="";
        for (int i = 0; i < arr.length; i++) {
             help=  help+ arr[i] + " ";
        }
        return help;
    }

    public String[] createUnderScore(String[] arr){

        String[] help = arr.clone();

        for (int i = 0; i < help.length; i++) {
            help[i] = help[i].replaceAll("[A-Za-z]", "_");
        }
        return help;
    }

    public boolean isletterinWord(String str,int position,String[] arr){
        String help = arr[position];
        if (str.equals(help)) {
            return true;
        }else
            return false;
    }

        public static void main (String[]args){
            launch(args);
        }
    }
