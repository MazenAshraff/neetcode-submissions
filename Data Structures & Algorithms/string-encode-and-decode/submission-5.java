class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        sb.append(strs.size());
        if(strs.size() > 0){
            sb.append(',');
        }
        StringBuilder finalString = new StringBuilder();
        for(int i = 0; i < strs.size(); i++){
            sb.append(strs.get(i).length());
            sb.append(',');
            finalString.append(strs.get(i));
        }
        sb.append(finalString);
        //System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str.equals("0")){
            return new ArrayList<>();
        }
        String listSize = getStringSize(str, 0);
        //System.out.println(listSize);
        Integer listSizeInt = Integer.parseInt(listSize);
        List<String> list = new ArrayList<>();
        int j = listSize.length() + 1;
        Queue<Integer> q = new LinkedList<>();
        int k = 0;
        while(k++ < listSizeInt){
        String stringSize = getStringSize(str, j);
        j+= stringSize.length()+1;
        q.add(Integer.parseInt(stringSize));
        }
        //System.out.println(q);
        while(!q.isEmpty()){
            int size = q.poll();
            list.add(str.substring(j, j+size));
            j+=size;
        }
        return list;
    }

    public String getStringSize(String k, int i){
        StringBuilder sb = new StringBuilder();
        while(i < k.length() && k.charAt(i)!=','){
            sb.append(k.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
