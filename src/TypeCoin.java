import java.util.Arrays;

public enum TypeCoin {

  //Constantes de los tipos de moneda
  FIFTY(50),
  ONE_HUNDRED(100),
  TWO_HUNDRED(200),
  FIVE_HUNDRED(500),
  ONE_THOUSAND(1000);

  private Integer valueCoin;

  TypeCoin(int valueCoin) {
    this.valueCoin = valueCoin;
  }

  public int getValueCoin() {
    return valueCoin;
  }

  //Calcular si la moneda es valida
  public static boolean validateExistsTypeCoin(Integer valueCoin){
    return Arrays.stream(TypeCoin.values()).anyMatch(v -> v.getValueCoin() == valueCoin);
  }

}
