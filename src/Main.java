import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

  static List<Integer> alcancia = new ArrayList<>();
  static Scanner scanner = new Scanner(System.in);//Clase para pedir valor por consola
  static int coinToInsert = 0;
  static int findByCoinDenomination= 0;
  static int sumByCoinByDenomination = 0;

  public static void main(String[] args){

    boolean closed = false;
    int opcion;

    while(!closed){

      System.out.println("1. Insert Coin");
      System.out.println("2. Print coins");
      System.out.println("3. Print coins by count");
      System.out.println("4. Print Count Coin By denomination");
      System.out.println("5. Print Sum Count Coin By Denomination");
      System.out.println("Escribe una de las opciones");
      opcion = Integer.parseInt(scanner.nextLine());

      switch(opcion){
        case 1:
          insertCoin();
          break;
        case 2:
          printCoins();
          break;
        case 3:
          printCoinsByCount();
          break;
        case 4:
          printCountCoinByDenomination();
          break;
        case 5:
          printSumCountCoinByDenomination();
          break;
        default:
          System.out.println("No es una opción correcta");
      }
    }
  }

  public static void insertCoin(){
    System.out.println("Coin to insert:");
    coinToInsert = Integer.parseInt(scanner.nextLine());
    System.out.println("\n");
    if(TypeCoin.validateExistsTypeCoin(coinToInsert)){
      alcancia.add(coinToInsert);
    }
    else {
      System.out.println("The coin doesn't valid");
    }

  }
  // Imprime todas las monedas
  public static void printCoins(){
    System.out.println("----------------------------");
    System.out.println("Coins: \n");
    alcancia.forEach(coin -> System.out.println(coin));
  }

  //50    1
  //100   2
  //200   3
  //1000  4
  public static void printCoinsByCount(){

    System.out.println("-------------------------------------");
    System.out.println("Coins by denomination");
    Integer[] coinsArray = alcancia.toArray(new Integer[0]);
    Arrays.asList(coinsArray)
        .stream().collect(Collectors.groupingBy(s -> s))
        .forEach((k, v) -> System.out.println(k+" "+v.size()));
    System.out.println("-------------------------------------");
  }

  //Imprimir la moneda por denominación
  public static void printCountCoinByDenomination(){
    int ocurrencesCoin=0;
    System.out.println("What coin does you need to find count : ");
    findByCoinDenomination = Integer.parseInt(scanner.nextLine());
    if(TypeCoin.validateExistsTypeCoin(findByCoinDenomination)){
      ocurrencesCoin = Collections.frequency(alcancia, findByCoinDenomination);
      System.out.println("Ocurrences coin is equals to: " + ocurrencesCoin);
    }
    else {
      System.out.println("The coin doesn't exist");
    }
  }

  //Imprimo el total de esa moneda que solicito mirar cuantas hay
  public static void printSumCountCoinByDenomination(){
    int moneyTotal = 0;
    System.out.println("What coin does you need to sum all : ");
    sumByCoinByDenomination = Integer.parseInt(scanner.nextLine());
    if(TypeCoin.validateExistsTypeCoin(sumByCoinByDenomination)){
      moneyTotal = alcancia.stream().filter(x -> x.equals(sumByCoinByDenomination)).mapToInt(x -> x).sum();
      System.out.println("Value all for denomination is: " + moneyTotal);
    }
    else {
      System.out.println("The coin doesn't exist");
    }
  }

}
