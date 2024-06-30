public class Password {
    String value;
    int length;
    public Password(String s){
        value=s;
        length=s.length();
    }
    public int CharType(char ch){
        if(ch>=65&&ch<=90)
            return 1;
        if(ch>=97&&ch<=122)
            return 2;
        if(Character.isDigit(ch))
         return 3;
        else return 4;
    }
    public int PasswordStrength(){
        boolean usedUpper=false;
        boolean usedLower=false;
        boolean usedNum=false;
        boolean usedSym=false;
        int score=0;
        int type;
        for(int i=0;i<length;i++) {
            char ch = value.charAt(i);
            type = CharType(ch);
            if (type == 1) usedUpper = true;
            if (type == 2) usedLower = true;
            if (type == 3) usedNum = true;
            if (type == 4) usedSym = true;
        }
            if(usedUpper) score+=1;
            if(usedLower) score+=1;
            if(usedNum) score+=1;
            if(usedSym) score+=1;
            if(length>=8) score+=1;
            if(length>=16) score+=1;
        return score;
    }
    public String calculateScore(){
      int res=PasswordStrength();
      String message="";
      if(res==6) message="This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines";
      if(res==4||res==5) message="This is a good password :) but you can still do better";
      if(res==3) message="This is a medium password :/ try making it better";
      if(res<3) message="This is a weak password :( definitely find a new one";
      return message;
    }

    @Override
    public String toString() {
        return value;
    }
}
