class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            if(!str.equals(""))
            sb.append(str);
            else
            sb.append("ش");
            sb.append("س");
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(str,"س");
        while (st.hasMoreTokens()){
            String currentToken = st.nextToken();
            if(currentToken.equals( "ش"))
            strs.add("");
            else
            strs.add(currentToken);
        }
        return strs;

    }
}
