public class MapUse {
    public static void main(String[] args){
        Map<String, Integer> map = new Map<String, Integer>();
        for(int i=0;i<20;i++){
            map.insert("abc" + i, i + 1);
            System.out.println("i = " + i + " lf = " + map.loadFactor());
        }
        map.removeKey("abc3");
        map.removeKey("abc7");
        for(int i=0;i<20;i++){
            System.out.println("abc"+i + " : " + map.getValue("abc"+i));
        }
    }

}
