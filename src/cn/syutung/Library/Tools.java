package cn.syutung.Library;


public class Tools {
   
    public static double sum(String StdIn){
        MyStack<Double> numbers = new MyStack<>(5);
        MyStack<String> yunsuanfu = new MyStack<>(5);
        int index = 0;
        
      
        for (int i = 0;i<StdIn.length();i++){
            String s = String.valueOf(StdIn.charAt(i));
            switch (s) {
                case "(":
                    yunsuanfu.push(s);
                    break;
                case "q":
                case "r":
                case "t":
                    break;
                case "s":
                    yunsuanfu.push("sqrt");
                    break;
                case "+":
                case "-":
                case "*": 
                case "x":
                case "/":
                    yunsuanfu.push(s);
                    break;

                case ")":
                        Double val = numbers.pop();
                        double result =0.0;
                        
                        while(!yunsuanfu.get().equals("(")){
                            String p =  yunsuanfu.pop();
                            switch (p) {
                                case "+" ->val =val + numbers.pop();
                                case "-" ->val = numbers.pop()-val;
                                case "*" ->val =numbers.pop() * val;
                                case "/" ->val =  numbers.pop() / val;
                                case "sqrt" ->val = Math.sqrt(val);
                                case "x" -> val =numbers.pop() * val; 
                                default -> val = val;
                            };
                        }
                        yunsuanfu.pop();
                        numbers.push(val);
                    break;
                default:
                    if(StdIn.charAt(i+1)!='+'||
                    StdIn.charAt(i+1)!='-'||
                    StdIn.charAt(i+1)!='*'||
                    StdIn.charAt(i+1)!='x'||
                    StdIn.charAt(i+1)!='/'||
                    StdIn.charAt(i+1)!=')'){
                        int k = i;
                        while(
                            StdIn.charAt(k+1)!='+'&&
                            StdIn.charAt(k+1)!='-'&&
                            StdIn.charAt(k+1)!='*'&&
                            StdIn.charAt(k+1)!='x'&&
                            StdIn.charAt(k+1)!='/'&&
                            StdIn.charAt(k+1)!=')'){
                                s+=String.valueOf(StdIn.charAt(k+1));
                                k++;
                        }
                        
                        numbers.push(Double.parseDouble(s));
                        i=k;
                    }else{
                        numbers.push(Double.parseDouble(s));

                    }
                    
                    break;
            }
        }
        return numbers.pop();
        
    }
}

