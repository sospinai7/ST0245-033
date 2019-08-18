//Ejercicio factorial
public int factorial(int n) {
  if(n==1){
    return 1;
  }
  return n*factorial(n-1);
}

//Ejercicio bunnyEars 
public int bunnyEars(int bunnies) {
  if(bunnies==0){
    return 0;
  }
  return bunnyEars(bunnies-1)+2;
}

//Ejercicio fibonacci 
public int fibonacci(int n) {
  if(n==0 || n==1){
    return n;
  }
  
  return fibonacci(n-2)+fibonacci(n-1);
}

//bunnyEars2 
public int bunnyEars2(int bunnies) {
  if(bunnies == 0){
    return 0;
  }
  if(bunnies%2==0){
    return bunnyEars2(bunnies-1)+3;
  }
  return bunnyEars2(bunnies-1)+2;
}

//triangle 
public int triangle(int rows) {
  if(rows<2){
    return rows;
  }
  return triangle(rows-1)+rows;
}
