class Point_System {

PFont font;

int initialTime;

int interval = 2000;

int score = 0;

int highscore;


Point_System() {

font = createFont("Arial", 30);

initialTime = millis();

textSize(50);

}

void display() {
  
if (millis() - initialTime > interval){
  
score+=10;

initialTime = millis();

}

text("Score", 100, 100);

text(score, 300, 100);

//text((millis()-initialTime)/1000, 10, height-20);


  }
  
void highscore() {

  highscore = max(score, highscore);

  text("Highscore: "+highscore, width/2 - 310, height/2 - 100);

  }
  
  void score() {
    
  text("Your Score:" +score,  width/2 - 310, height/2);  
  
  }
  
  void reset() {
    
     score = 0;
     
    }

}