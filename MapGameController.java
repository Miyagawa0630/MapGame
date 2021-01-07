import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

public class MapGameController implements Initializable {
    public MapData mapData;
    public MoveChara chara;
    public GridPane mapGrid;
    public ImageView[] mapImageViews;
    public Label HP;
    public Label SCORE;
    int hp = 500;
    int score;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        HP.setText("HP:" + hp);
        SCORE.setText("  SCORE:" + score);
        mapData = new MapData(21, 15);
        chara = new MoveChara(1, 1, mapData);
        mapImageViews = new ImageView[mapData.getHeight()*mapData.getWidth()];
        for(int y=0; y<mapData.getHeight(); y++){
            for(int x=0; x<mapData.getWidth(); x++){
                int index = y*mapData.getWidth() + x;
                mapImageViews[index] = mapData.getImageView(x,y);
            }
        }
        drawMap(chara, mapData);
    }

    // Draw the map
    public void drawMap(MoveChara c, MapData m){
        int cx = c.getPosX();
        int cy = c.getPosY();
        mapGrid.getChildren().clear();
        for(int y=0; y<mapData.getHeight(); y++){
            for(int x=0; x<mapData.getWidth(); x++){
                int index = y*mapData.getWidth() + x;
                if (x==cx && y==cy) {
                    mapGrid.add(c.getCharaImageView(), x, y);
                } else {
                    mapGrid.add(mapImageViews[index], x, y);
                }
            }
        }
    }

    // Get users key actions
    // score and HP 
    public void keyAction(KeyEvent event){
        KeyCode key = event.getCode(); System.out.println("keycode:"+key);
        if (key == KeyCode.H){
        	leftButtonAction();
        }else if (key == KeyCode.J){
            downButtonAction(); 
        }else if (key == KeyCode.K){
            upButtonAction();
        }else if (key == KeyCode.L){
            rightButtonAction();
        }
    }

    // Operations for going the cat down
    public void upButtonAction(){
        printAction("UP");
        chara.setCharaDirection(MoveChara.TYPE_UP);
        chara.move(0, -1);
        drawMap(chara, mapData);
        hp = hp - 10;
        System.out.println("HP:"+ hp);
        HP.setText("HP:" + hp);
        score = 500 - (500-hp);
        System.out.println("SCORE:" + score);
        SCORE.setText("  SCORE:" + score);
        if(hp == 0){
            chara = new MoveChara(1,1,mapData);
            hp = 500;
            score = score - 500;
            System.out.println("GameOver!!");
        }
    }

    // Operations for going the cat down
    public void downButtonAction(){
        printAction("DOWN");
        chara.setCharaDirection(MoveChara.TYPE_DOWN);
        chara.move(0, 1);
        drawMap(chara, mapData);
        hp = hp - 10;
        System.out.println("HP:"+ hp);
        score = 500 - (500-hp);
        System.out.println("SCORE:" + score);
        HP.setText("HP:" + hp);
        SCORE.setText("  SCORE:" + score);
        if(hp == 0){
            chara = new MoveChara(1,1,mapData);
            hp = 500;
            score = score - 500;
            System.out.println("GameOver!!");
        }
    }

    // Operations for going the cat right
    public void leftButtonAction(){
        printAction("LEFT");
        chara.setCharaDirection(MoveChara.TYPE_LEFT);
        chara.move(-1, 0);
        drawMap(chara, mapData);
        hp = hp - 10;
        System.out.println("HP:"+ hp);
        score = 500 - (500-hp);
        System.out.println("SCORE:" + score);
        HP.setText("HP:" + hp);
        SCORE.setText("  SCORE:" + score);
        if(hp == 0){
            chara = new MoveChara(1,1,mapData);
            hp = 500;
            score = score - 500;
            System.out.println("GameOver!!");
        }
    }

    // Operations for going the cat right
    public void rightButtonAction(){
        printAction("RIGHT");
        chara.setCharaDirection(MoveChara.TYPE_RIGHT);
        chara.move(1, 0);
        drawMap(chara, mapData);
        hp = hp - 10;
        System.out.println("HP:"+ hp);
        score = 500 - (500-hp);
        System.out.println("SCORE:" + score);
        HP.setText("HP:" + hp);
        SCORE.setText("  SCORE:" + score);
        if(hp == 0){
            chara = new MoveChara(1,1,mapData);
            hp = 500;
            score = score - 500;
            System.out.println("GameOver!!");
        }
    }

    public void func1ButtonAction(ActionEvent event) {
        System.out.println("func1: Nothing to do");
    }

    // Print actions of user inputs
    public void printAction(String actionString) {
        System.out.println("Action: " + actionString);
    }

}
