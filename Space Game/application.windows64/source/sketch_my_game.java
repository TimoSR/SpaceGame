import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ddf.minim.*; 
import ddf.minim.analysis.*; 
import ddf.minim.effects.*; 
import ddf.minim.signals.*; 
import ddf.minim.spi.*; 
import ddf.minim.ugens.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sketch_my_game extends PApplet {


//Adding Audio








Minim minim;

AudioPlayer sou;


//Getting Random Enemie Location;

public int getRandomY() {

return PApplet.parseInt(random(1000));

}


Enemy e1;

PVector _location1 = new PVector(width - 110, getRandomY());

PVector _velocity1 = new PVector(random(20,30), - 2);

Enemy e2;

PVector _location2 = new PVector(width - 110, getRandomY());

PVector _velocity2 = new PVector(random(20,30), - 2);

Enemy e3;

PVector _location3 = new PVector(width - 110, getRandomY());

PVector _velocity3 = new PVector(random(20,30), - 2);

Enemy e4;

PVector _location4 = new PVector(width - 110, getRandomY());

PVector _velocity4 = new PVector(random(20,30), - 2);

Enemy e5;

PVector _location5 = new PVector(width - 110, getRandomY());

PVector _velocity5 = new PVector(random(20,30), - 2);

Enemy e6;

PVector _location6 = new PVector(width - 110, getRandomY());

PVector _velocity6 = new PVector(random(20,30), - 2);

Enemy e7;

PVector _location7 = new PVector(width - 110, getRandomY());

PVector _velocity7 = new PVector(random(20,30), - 2);


Background b;

//Shooting Hero

Hero h;

Shoot s;

int Gun_1;

int Gun_2;


//Score System

Point_System score;


//Game State

int Game_State = 1;


public void setup() {
  
//Screen Setup
  




//Cursor

noCursor();

//Sound

minim = new Minim(this);
  
sou = minim.loadFile("forever2001.mp3");

sou.loop();


//Setting Up Moving Starfield Background

b = new Background();

b.displayBackground();


//Setting Up Hero

h = new Hero();


//I now you can shoot!

s = new Shoot();


//Setting Up Enemy

e1  = new Enemy(_location1, _velocity1);

e2 = new Enemy(_location2, _velocity2);

e3 = new Enemy(_location3, _velocity3);

e4 = new Enemy(_location4, _velocity4);

e5 = new Enemy(_location5, _velocity5);

e6 = new Enemy(_location6, _velocity6);

e7 = new Enemy(_location7, _velocity7);

//Setting Up Score

score = new Point_System();

}

public void draw() {
  
  if (Game_State == 1) {
  
  //Drawing Background

  background(0);
  
  b.forces();
  
  //Score
  
  noFill(); 
  
  fill(0, 255, 0);
  
  score.display();
  
  //Drawing Hero
  
  h.displayHero();
  
  //Hero Shoot
  
  //s.shoot();
  
  //Drawing first Enemy
  
  e1.display();
  
  e1.move();
  
  //Drawing Second Enemy
  
  e2.display();
  
  e2.move();
  
  //Drawing Third Enemy
  
  e3.display();
  
  e3.move();
  
  //Drawing Enemy
  
  e4.display();
  
  e4.move();
  
  //Drawing Enemy
  
  e5.display();
  
  e5.move();
  
  //Drawing Enemy
  
  e6.display();
  
  e6.move();
  
  //Drawing Enemy
  
  e7.display();
  
  e7.move();
  
  }  

  //If colision
  
  if(collisionBetween(h,e1)) {

     println("Collision between Hero & Enemy 1");
     Game_State = 0;
     
  }  else if(keyPressed) {
  
    Game_State = 1;
    
  }
  
  if(collisionBetween(h,e2)) {

     println("Collision between Hero & Enemy 2");
     Game_State = 0;
     
  }  else if(keyPressed) {
  
    Game_State = 1;
    
  }
  
  if(collisionBetween(h,e3)) {

     println("Collision between Hero & Enemy 3");
     Game_State = 0;
     
  }  else if(keyPressed) {
  
    Game_State = 1;
    
  }

  if(collisionBetween(h,e4)) {

     println("Collision between Hero & Enemy 4");
     Game_State = 0;
     
  }  else if(keyPressed) {
  
    Game_State = 1;
    
  }
  
  if(collisionBetween(h,e5)) {

     println("Collision between Hero & Enemy 5");
     Game_State = 0;
     
  }  else if(keyPressed) {
  
    Game_State = 1;
    
  }
  
  if(collisionBetween(h,e6)) {

     println("Collision between Hero & Enemy 6");
     Game_State = 0;
     
  }  else if(keyPressed) {
  
    Game_State = 1;
    
}

  if(collisionBetween(h,e7)) {

     println("Collision between Hero & Enemy 7");
     Game_State = 0;
     
  }  else if(keyPressed) {
  
    Game_State = 1;
    
  }
  
  if(keyPressed) {
    
    score.reset();
    
    e1.reset();
    
    e2.reset();
    
    e3.reset();
    
    e4.reset();
  
    e5.reset();
    
    e6.reset();
    
    e7.reset();
    
    //text("OMG HACKS...", width/2 - 210, height/2);
    
    //text("Let GO! MOTHERFUCKER!", width/2 - 340, height/2 + 100);
    
  }
  
  if(Game_State == 0) {
  
  background(0);
  
  textSize(120);
  
  text("DEFEATED", width/2 - 310, height/2 - 200);
  
  textSize(50);
  
  score.highscore();
  
  score.score();
  
  text("Press Key to Start", width/2 - 240, height/2 + 300);
  
  } else {
  
    textSize(50);
  
  }

}

public void mousePressed() {
  
  s.shoot = true;
}

public boolean collisionBetween(Hero circle1, Enemy circle2) {
  
  float distance = dist(circle1.x(), circle1.y(), circle2.x(), circle2.y());
  return (distance < circle1.radius()+circle2.radius());
  
}
/*
void shot(int Gun_1, int Gun_2)
  {
    boolean strike = false;
    for (int i = 0; i < 5; i++)
    {
      if((Gun_1 >= (ballx[i]-ballSize/2)) && (shotX <= (ballx[i]+ballSize/2))) {
        strike = true;
        line(mouseX, 565, mouseX, bally[i]);
        ellipse(ballx[i], bally[i],
                ballSize+25, ballSize+25);
        ballx[i] = getRandomX();
        bally[i] = 0;


// update score
        score++;
      }    
    }
  
    if(strike == false)
    {
      line(mouseX, 565, mouseX, 0);
    }  
  
  }

*/

  





//Damage System

//Game Over
class Background {

  //DONE
  
float[] x = new float[100];

float[] y = new float[100];

float[] speed = new float[100];


Background() {
  
}


public void displayBackground() {

//Setting Up Moving Background

int i = 0;

while(i < 100) {

  x[i] = random(0, width);

  y[i] = random(0, height);

  speed[i] = random(1, 10);

  i = i + 1;

    }

  }
  

public void forces() {

//Universe
  
  int i = 0;
  
  while(i < 100) {
  
  float co = map(speed[i], 1, 5, 100, 255);
    
  stroke(co);  
    
  strokeWeight(speed[i]); 
  
  point(x[i], y[i]);
  
  x[i] = x[i] - speed[i] / 2;
  
  if(x[i] < 0) {
  
    x[i] = width;
    
    }
    
    i = i + 1;
    
    }

  }
  
}
class Enemy {

  PVector location;
  PVector velocity;
  float radius;


  Enemy(PVector _location, PVector _velocity) {
    
    location = _location;
  
    velocity = _velocity;
    
    radius = 100;
  
  }
  
  
  public void move() {

  location.add(velocity);
  
  
  
   if ( (location.x > width - 110)) {

      velocity.x =  velocity.x * -1 ;     
  }  
  
  

  if ( (location.y > height) || (location.y < 0) ) {


      velocity.y = velocity.y * -1 ;
  
    }
  
  }

  public void bounce() {
        
  velocity.x =  velocity.x * -1 ;
  
  velocity.y = velocity.y * -1 ;
    
  }
  
  public void display() {

  
  fill(255,0,0);

  noStroke();

  strokeWeight(2);
  
  ellipseMode(CENTER);

  ellipse(location.x, location.y, radius, radius);
  
  rect(location.x + 50, location.y - 50, 50, 50);
  
  rect(location.x - 50, location.y + 50, 50, 50);
  
  rect(location.x + 50, location.y + 50, 50, 50);

  rect(location.x - 50, location.y - 50, 50, 50);
  
  
  if(location.x < 0) {
  
    
    location.x = width - 110;
    
    location.y = random(height);
    
  
    }
  
  }
  
  public float x() {
  
  return location.x;
  
  }
  
  public float y() {
  
  return location.y;
    
  }
  
  public float radius() {
  
  return radius;
  
  }
  
  public void reset(){
    
  
  if(location.x < 1900) {
  
    
    location.x = width - 110;
    
    location.y = random(height);
    
  
        }
    
    }
  
}
class Hero {
  
  PVector velocity;
  
  float radius;
  
  Hero() {
  
    velocity = new PVector(5, -2); 
    
    radius = 50;
    
  }
  
  public void displayHero() {
    
  //Draw Nyan Cat
  
  noStroke();
  
  fill(175, 0, 255);

  rectMode(CENTER);
  
  rect(mouseX, mouseY, radius, radius);
  
  triangle(mouseX - 20, mouseY + 25, mouseX - 10, mouseY + 100, mouseX + 30, mouseY);
  
  triangle(mouseX - 20, mouseY - 25, mouseX - 10, mouseY - 100, mouseX + 30, mouseY);
  
  triangle(mouseX + 10, mouseY + 40, mouseX + 100, mouseY, mouseX + 10, mouseY - 40);
  
  triangle(mouseX - 50, mouseY + 40, mouseX + 100, mouseY, mouseX - 50, mouseY - 40);
  
  ellipse(mouseX + 50, mouseY - 25, 50, 50);
  
  ellipse(mouseX + 50, mouseY + 25, 50, 50);
  
  }
  
  public float x() {
  
  return mouseX;
  
  }
  
  public float y() {
  
  return mouseY;
    
  }
  
  public float radius() {
  
  return 50;
  
  }
  
  
  /*
  
  void shoot() {
  
  if(mousePressed == true) {
    
    stroke(255, 0, 0);
    
    strokeWeight(5);
    
    float x = mouseX + 5;
    
    float y = mouseY;
    
    line(mouseX, mouseY, x, y);
    
    }
    
    

  }
  
  */
  
}
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

public void display() {
  
if (millis() - initialTime > interval){
  
score+=10;

initialTime = millis();

}

text("Score", 100, 100);

text(score, 300, 100);

//text((millis()-initialTime)/1000, 10, height-20);


  }
  
public void highscore() {

  highscore = max(score, highscore);

  text("Highscore: "+highscore, width/2 - 310, height/2 - 100);

  }
  
  public void score() {
    
  text("Your Score:" +score,  width/2 - 310, height/2);  
  
  }
  
  public void reset() {
    
     score = 0;
     
    }

}
class Shoot {
  
  //DONE
  
  boolean shoot;
  
  float a = 680;
  
  
  Shoot() {
    
  }


  //The Shoot function

  public void shoot() {

    if (shoot) {
      
      laserdetail();
      shoot = false;
      
    }
    
  }


  // Adding a look to the laser

  public void laserdetail() {
    
    stroke(0, 255, 0);
    
    strokeWeight(5);
    
    line(mouseX + 75, mouseY - 25, width, mouseY - 15);
    
    line(mouseX + 75, mouseY + 25, width, mouseY + 15);
 
  }
  
  public float x() {
  
    return width;
    
  }
  
  public float y() {
  
    return mouseY +- 15;
  
  }
  
  public float radius() {
  
    return mouseY +- 15;
    
  }
}
  public void settings() { 
fullScreen(); 
smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "sketch_my_game" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
