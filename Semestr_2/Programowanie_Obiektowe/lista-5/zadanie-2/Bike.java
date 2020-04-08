package zadanie.pkg1;

/**
 *
 * @author dawid
 */
public class Bike implements Vehicles {
    String name;
    float mileage;
    int maxPeople;
    String id = "Bike";
    
    Bike(String id, float mil, int ppl){
            this.name = id;
            this.mileage = mil;
            this.maxPeople = ppl;
        }
        
        public int getNumberOfPeople(){
            return maxPeople;
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
