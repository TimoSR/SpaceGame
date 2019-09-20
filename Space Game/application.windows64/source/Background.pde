class Background {

  //DONE
  
float[] x = new float[100];

float[] y = new float[100];

float[] speed = new float[100];


Background() {
  
}


void displayBackground() {

//Setting Up Moving Background

int i = 0;

while(i < 100) {

  x[i] = random(0, width);

  y[i] = random(0, height);

  speed[i] = random(1, 10);

  i = i + 1;

    }

  }
  

void forces() {

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