public class Operation {
    String x = "";
    String y = "";
    private String exp = "";
    private String result = "";
    boolean firstNumber = true;
    public String getExp() {
        return exp;
    }
    public String setExp(String str) {
        return exp + str;
    }
    public void addNumber(String title){
        if (firstNumber==true)
            switch(title){
                case "1": x+=title;
                case "2": x+=title;
                case "3": x+=title;
                case "4": x+=title;
                case "5": x+=title;
                case "6": x+=title;
                case "7": x+=title;
                case "8": x+=title;
                case "9": x+=title;
                case "0":
                    if(x != "")
                        x+=title;
                case "-+":
                    if(x != "")
                        if (x.charAt(0)!='-')
                            x="-"+x;
                        else if(x.charAt(0)=='-')
                            x=x.substring(1);
            }
    }
    public String plus(){
        String result = Float.toString(Float.parseFloat(x) + Float.parseFloat(y));
        x = result;
        return result;
    }
    public String minus(){
        String result = Float.toString(Float.parseFloat(x) - Float.parseFloat(y));
        x = result;
        return result;
    }
    public String divide(){
        String result = Float.toString(Float.parseFloat(x)/Float.parseFloat(y));
        x = result;
        return result;
    }
    public String multiplication(){
        String result = Float.toString(Float.parseFloat(x) * Float.parseFloat(y));
        x = result;
        return result;
    }
    public String mod(){
        String result = Float.toString(Float.parseFloat(x) % Float.parseFloat(y));
        x = result;
        return result;
    }
    public String power(){
        String result = Double.toString(Math.pow(Double.parseDouble(x),  Double.parseDouble(y)));
        x = result;
        return result;
    }
}
