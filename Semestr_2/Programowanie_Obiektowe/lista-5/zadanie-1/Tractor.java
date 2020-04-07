package zadanie.pkg1;

/**
 *
 * @author dawid
 */
public class Tractor implements Vehicles{
    String name;
    float mileage;
    float height;
    String id = "Tractor";
    
    Tractor(String id, float mil, float height)
    {
        this. name = id;
        this.mileage = mil;
        this.height = height;
        
    } 
    
    public void SetHeight(float hei){
        this.height = hei;
    }
    
    @Override
    public float getMileage(){
            return mileage;
        }
        
        @Override
    public int compareTo(Vehicles obj){
            float otherMileage = obj.getMileage();
            if (mileage < otherMileage) return -1;
            else if (mileage == otherMileage) return 0;
            else return 1;
        }
    
     @Override
         public String toString(){
            String result;
            result = id + "(" + name + ", " + mileage + ")";
            return result;
        }
            
}
