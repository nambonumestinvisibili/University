package zadanie.pkg1;

/**
 *
 * @author dawid
 */
 public class Lorry implements Vehicles {
        String name;
        float mileage;
        float  capacity;
        String id = "Lorry";
        
        Lorry(String id, float mil, int cap){
            this.name = id;
            this.mileage = mil;
            this.capacity = cap;
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
