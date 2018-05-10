import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class pessoasTeste extends PApplet {

//Fabricio Junior - 09/05/2018

PImage img1, img2;
Entidade man;
ArrayList<Entidade> pessoas = new ArrayList<Entidade>();
int total = 1;

public void setup(){
  
  frameRate(10);
  img1 = loadImage("p1.png");
  img2 = loadImage("p2.png");
  for(int i=0; i<total; i++){
    pessoas.add(new Entidade(round(random(0, width)), round(random(0, height-16))));
  }
}

public void draw(){
  background(0);
  for(Entidade e : pessoas){
    e.desenhar();
  }
  texto();
}

public void mousePressed(){
  pessoas.add(new Entidade(round(random(0, width)), round(random(0, height-16))));
}

public void keyPressed(){
  if(pessoas.size() > 0){
    pessoas.remove(pessoas.size()-1);
  }
}

public void texto(){
  fill(255);
  textSize(10);
  text("Fabricio Junior", 3, height-3);
  textSize(16);
  text(pessoas.size(), 3, 16);
}
class Entidade{
  
  //Atributos
  int x, y;
  int velocidadeX, velocidadeY;
  int max;

  //Construtor
  Entidade(int x, int y){
    this.max = 2;
    this.x = x;
    this.y = y;
    this.velocidadeX = round(random(-this.max, this.max));
    this.velocidadeY = round(random(-this.max, this.max));
    if(this.velocidadeX == 0 && this.velocidadeY == 0){this.velocidadeX = 1;}
  }
  
  //Metodos
  public void desenhar(){
    this.mover();
    if(frameCount % 2 == 0){
      image(img1, this.x, this.y);
    }
    else{
      image(img2, this.x, this.y);
    }
  }
  
  public void mover(){
    this.reset();
    this.x += this.velocidadeX;
    this.y += this.velocidadeY;
  }
  
  public void reset(){
    if(this.x < -8 || this.x > width || this.y < -16 || this.y > height){
      this.x = round(random(0, width));
      this.y = round(random(0, height-16));
      this.velocidadeX = round(random(-this.max, this.max));
      this.velocidadeY = round(random(-this.max, this.max));
      if(this.velocidadeX == 0 && this.velocidadeY == 0){this.velocidadeX = 1;}
    }
  }

}
  public void settings() {  size(640, 480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "pessoasTeste" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
