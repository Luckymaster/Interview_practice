class Solution {
    
    public String addBinary(String a, String b){
        if(b.length() > a.length()){
            return Solve(b,a);
        }
        return Solve(a,b);
    }
    
    public String Solve(String a, String b) {
        char carry = '0';
        StringBuilder res = new StringBuilder();
        if(a.length() >= b.length()){
            int la = a.length()-1;
            int lb = b.length()-1;
            while(lb>=0){
                if(a.charAt(la) == b.charAt(lb) && '1' == a.charAt(la)){
                    if(carry == '1'){
                        res.append('1');
                        carry = '1';
                    }else{
                        res.append('0');
                        carry = '1';
                    }
                }else if(a.charAt(la) == b.charAt(lb) && '0' == a.charAt(la)){
                    if(carry == '1'){
                        res.append('1'); 
                        carry = '0';
                    }else{
                        res.append('0'); 
                    }
                }else{
                    if(carry == '1'){
                        res.append('0');
                        carry = '1';
                    }else{
                        res.append('1');
                    }
                }
                la--;
                lb--;
            }
            for(int i = la;i>=0;i--){
                
                if(a.charAt(i) == '1' && carry == '1'){
                    res.append('0');
                }else if(a.charAt(i) == '0' && carry == '1'){
                    res.append('1');
                    carry = '0';
                }else{
                     res.append(a.charAt(i));
                    carry = '0'; 
                }
            }
            if(carry == '1')res.append('1');
        }
        return res.reverse().toString();
    }
}
