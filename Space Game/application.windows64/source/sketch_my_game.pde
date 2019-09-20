
//Adding Audio

import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.effects.*;
import ddf.minim.signals.*;
import ddf.minim.spi.*;
import ddf.minim.ugens.*;

Minim minim;

AudioPlayer sou;


//Getting Random Enemie Location;

int getRandomY() {

return int(random(1000));

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


void setup() {
  
//Screen Setup
  
fullScreen();

smooth();

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

void draw() {
  
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

void mousePressed() {
  
  s.shoot = true;
}

boolean collisionBetween(Hero circle1, Enemy circle2) {
  
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