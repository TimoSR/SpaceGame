class Enemy {

  PVector location;
  PVector velocity;
  float radius;


  Enemy(PVector _location, PVector _velocity) {
    
    location = _location;
  
    velocity = _velocity;
    
    radius = 100;
  
  }
  
  
  void move() {

  location.add(velocity);
  
  
  
   if ( (location.x > width - 110)) {

      velocity.x =  velocity.x * -1 ;     
  }  
  
  

  if ( (location.y > height) || (location.y < 0) ) {


      velocity.y = velocity.y * -1 ;
  
    }
  
  }

  void bounce() {
        
  velocity.x =  velocity.x * -1 ;
  
  velocity.y = velocity.y * -1 ;
    
  }
  
  void display() {

  
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
  
  float x() {
  
  return location.x;
  
  }
  
  float y() {
  
  return location.y;
    
  }
  
  float radius() {
  
  return radius;
  
  }
  
  void reset(){
    
  
  if(location.x < 1900) {
  
    
    location.x = width - 110;
    
    location.y = random(height);
    
  
        }
    
    }
  
}