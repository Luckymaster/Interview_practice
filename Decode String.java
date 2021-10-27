class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> num = new Stack<>();
        Stack<String> chsrstack = new Stack<>();
        String ans = "";
        List<Character> numList = Arrays.asList('1','2','3','4','5','6','7','8','9','0');
        int m = 0;
        String tmpString = "";
        String aux = "";
        for(int i=0;i<s.length();i++){
            if(numList.contains(s.charAt(i))){
                m = m*10 + Integer.valueOf(s.charAt(i)+"");
            }
            else if(s.charAt(i) != '[' && s.charAt(i) != ']' && !numList.contains(s.charAt(i))){
                aux+=s.charAt(i);
                //System.out.println("aux = " + aux);
            }
            else if(s.charAt(i) == '['){
                //System.out.println("charstack size = "+chsrstack.size() +" num size " + num.size());
                System.out.println("adding to atack m = " + m + " aux = " + aux);
                num.push(m);
                chsrstack.push(aux);
                m = 0;
                aux = "";
            }
            else if(s.charAt(i) == ']') {
                if(!"".equals(aux)){
                    chsrstack.push(aux);
                    aux = "";
                }
                m = getNum(num);
                String ss = getString(chsrstack);
                if(!chsrstack.isEmpty()){
                    tmpString = getModifiedString(m,ss);
                    ans = tmpString + ans;
                    System.out.println("Decoding it m but non empty = " + m + " ss = " + ans);
                }else{
                    ans+=getModifiedString(m,ans);
                }
            }
        }
        if(!chsrstack.isEmpty()){
            ans+=getString(chsrstack);
        }
        return ans;
    }
    
    String getString(Stack<String> chsrstack){
        String ss = chsrstack.pop();
        return ss;
    }
    
    int getNum(Stack <Integer> num){
        int a = num.pop();
        return a;
    }
    
    String getModifiedString(int n, String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(s);
        }
        return sb.toString();
    }
}
