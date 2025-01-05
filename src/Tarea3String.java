import static java.lang.Character.*;

public class Tarea3String {

    
static boolean esCorrectoNIF (String nif){

    //Variable para devolver un booleano de acuerdo a si es válido o no el nif
    boolean valido;

    //Si la longitud no es 9 no es válido
    //Si es 9 sigue
    if(nif.length() != 9){
        valido = false;

        //Si lo anterior no se cumple de momento es válido, entonces se comprueba sí los 8 primeros caracteres no son todos dígitos
        //Si los 8 primeros caracteres son dígitos sigue, si no es inválido
    } else if (!(ochoPrimerosDigitos(nif))) {
        valido = false;

        //Si lo anterior no se cumple de momento es válido, entonces se comprueba sí el último caracter no es una letra
        //Si el último caracter es una letra sigue, si no es inválido
    } else if(!(isLetter(nif.charAt(8)))){
        valido = false;

        //Si lo anterior no se cumple de momento es válido, entonces se comprueba sí el último caracter no se corresponde con su letra correcta
        //Si es la letra correcta sigue, si no es inválido
    } else if (!(letraCorrecta(nif))) {
        valido = false;

        //Si todas las negaciones resultan ser falsas esto quiere decir que se cumplen todas las condiciones para ser un nif válido
        //Como resultado devuelve un verdadero
    } else{
        valido = true;
    }

    return valido;
}


private static boolean ochoPrimerosDigitos(String nif){

  //Si no se dice lo contrario hay 8 dígitos
  boolean valido = true;

  //Se mira caracter por caracter los 8 primeros
  for(int i = 0; i < 8; i++){

      //Si alguno no es un dígito ya no es correcto y se deja de comprobar
      if(!(isDigit(nif.charAt(i)))){
          valido = false;
          i = 8;
      }
  }

  return valido;
}

private static boolean letraCorrecta(String nif){

    //Selecciona los primeros 8 caracteres para los cálculos
    String digitos = nif.substring(0,7);

    //Selecciona la letra para comprobarla después y la pone en máyuscula
    char letra = nif.charAt(8);
    letra = toUpperCase(letra);

    //String (Array de char) con las letras válidas, cada una en la posición del módulo de 23 que le corresponde
    String letrasCorrectas = "TRWAGMYFPDXBNJZSQVHLCKE";

    //Convierte los dígitos a un entero en vez de String
    int num = Integer.parseInt(digitos);

    //Cálcula cúal es la posición de la letra correcta
    int posicion = num%23;

    //Variable con el resultado de sí la letra es válida o no
    boolean valido = false;

    //Si coincide es válida
    if(letrasCorrectas.charAt(posicion) == letra){
        valido = true;
    }

    return valido;
}



}
