class Entidade{
  
  //Atributos
  int x, y;
  int velocidadeX, velocidadeY;
  int max;

  //Construtor
  Entidade(int x, int y){
    this.max = 4;
    this.x = x;
    this.y = y;
    this.velocidadeX = round(random(-this.max, this.max));
    this.velocidadeY = round(random(-this.max, this.max));
    if(this.velocidadeX == 0 && this.velocidadeY == 0){this.velocidadeX = 1;}
  }
  
  //Metodos
  void desenhar(){
    this.mover();
    if(frameCount % 2 == 0){
      image(img1, this.x, this.y);
    }
    else{
      image(img2, this.x, this.y);
    }
  }
  
  void mover(){
    this.reset();
    this.x += this.velocidadeX;
    this.y += this.velocidadeY;
  }
  
  void reset(){
    if(this.x < -8 || this.x > width || this.y < -16 || this.y > height){
      this.x = round(random(0, width));
      this.y = round(random(0, height-16));
      this.velocidadeX = round(random(-this.max, this.max));
      this.velocidadeY = round(random(-this.max, this.max));
      if(this.velocidadeX == 0 && this.velocidadeY == 0){this.velocidadeX = 1;}
    }
  }

}
