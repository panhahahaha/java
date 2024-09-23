public class binarysearch {

    public static void main(String [] args){

    }
    public static void search(int [] lst,int target){
        int length = lst.length;
        int middle = lst[length/2];
        int[] slicelst = new int[length];
        if (middle<target){
            for(int i = 0;i<length;i++){
                slicelst[i] = lst[i];
            }
            search(slicelst,target);
        }
        else{
            for(int i=middle;i>length;i++){
                slicelst[i] = lst[i];
            }
            search();
        }

    }
}
