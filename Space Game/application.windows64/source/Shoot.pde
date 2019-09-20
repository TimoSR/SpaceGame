class Shoot {
  
  //DONE
  
  boolean shoot;
  
  float a = 680;
  
  
  Shoot() {
    
  }


  //The Shoot function

  void shoot() {

    if (shoot) {
      
      laserdetail();
      shoot = false;
      
    }
    
  }


  // Adding a look to the laser

  void laserdetail() {
    
    stroke(0, 255, 0);
    
    strokeWeight(5);
    
    line(mouseX + 75, mouseY - 25, width, mouseY - 15);
    
    line(mouseX + 75, mouseY + 25, width, mouseY + 15);
 
  }
  
  float x() {
  
    return width;
    
  }
  
  float y() {
  
    return mouseY +- 15;
  
  }
  
  float radius() {
  
    return mouseY +- 15;
    
  }
}