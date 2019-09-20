class Hero {
  
  PVector velocity;
  
  float radius;
  
  Hero() {
  
    velocity = new PVector(5, -2); 
    
    radius = 50;
    
  }
  
  void displayHero() {
    
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
  
  float x() {
  
  return mouseX;
  
  }
  
  float y() {
  
  return mouseY;
    
  }
  
  float radius() {
  
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