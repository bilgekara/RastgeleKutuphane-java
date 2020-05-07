package randomLibary;
/**
 *
 * @author Bilgenur
 */
public class rakamUret {
    private static  int next=3251;
    public  int sahteRand ()  // sahte sayÄ± Ã¼reteci
    {
        for(int i=0;i<3;i++){
            next=next-75;
        }
        next = ((next * next) / 100 ) % 10000 ;
        return next ;
    }
 
    public int myRand ( int min, int max ) 
    {
        return sahteRand() % (max+1-min) + min ; 
    }
}
