public class Alphabet {
   public static final String UpperCase="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   public static final String LowerCase="abcdefghijklmnopqrstubwxyz";
   public static final String Number="0123456789";
   public static final String specialCharacter="!@#$%^&*_+-=?/~><.";
  private final StringBuilder pool;
  public Alphabet(boolean isUpper,boolean isLower,boolean isNumber,boolean isSpecial){
      pool=new StringBuilder();
      if(isUpper) pool.append(UpperCase);
      if(isLower) pool.append(LowerCase);
      if(isNumber) pool.append(Number);
      if(isSpecial) pool.append(specialCharacter);
  }
    public String getAlphabet() {
        return pool.toString();
    }

}
