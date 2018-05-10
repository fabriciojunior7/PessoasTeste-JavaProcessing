PImage img1, img2;
Entidade man;
ArrayList<Entidade> pessoas = new ArrayList<Entidade>();
int total = 1;

void setup(){
  size(640, 480);
  frameRate(10);
  img1 = loadImage("p1.png");
  img2 = loadImage("p2.png");
  for(int i=0; i<total; i++){
    pessoas.add(new Entidade(round(random(0, width)), round(random(0, height-16))));
  }
}

void draw(){
  background(0);
  for(Entidade e : pessoas){
    e.desenhar();
  }
  texto();
}

void mousePressed(){
  pessoas.add(new Entidade(round(random(0, width)), round(random(0, height-16))));
}

void keyPressed(){
  if(pessoas.size() > 0){
    pessoas.remove(pessoas.size()-1);
  }
}

void texto(){
  fill(255);
  textSize(10);
  text("Fabricio Junior", 3, height-3);
  textSize(16);
  text(pessoas.size(), 3, 16);
}
