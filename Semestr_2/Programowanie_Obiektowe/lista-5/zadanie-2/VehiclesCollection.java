package zadanie.pkg1;



import java.util.ArrayList;

/**
 *
 * @author dawid
 */



public class VehiclesCollection {
    ArrayList<Vehicles> listOfVehicles;
    
    VehiclesCollection(){
        listOfVehicles = new ArrayList<Vehicles>();
    }
    
    public void add(Vehicles vehicle){
        
        int count = listOfVehicles.size();
        
        if (count == 0){
            listOfVehicles.add(vehicle);
        }
        else if (vehicle.compareTo(listOfVehicles.get(0)) < 0){
            listOfVehicles.add(0, vehicle);
        }
        else if (vehicle.compareTo(listOfVehicles.get(count-1)) > 0){
            listOfVehicles.add(vehicle);
        }
        else {
            int i;
            for ( i = 0; i < count; i++){
                if (vehicle.compareTo(listOfVehicles.get(i)) > 0 &&
                        vehicle.compareTo(listOfVehicles.get(i+1)) < 0){
                    break;
                }
            }
            listOfVehicles.add(i, vehicle);
            
        }
    }
    
    @Override
    public String toString(){
        String result = "[";
        for(Vehicles veh : listOfVehicles){
            result += veh.toString();
            result += ", ";
        }
        result += "\b\b]";
        return result;
    }
    
    public Vehicles pop(){
        
        //if (listOfVehicles.size() == 0) throw new StringObjectOutOfBoundException();
        Vehicles result = listOfVehicles.remove(0);
        return result;
     
     } 

}


    

    

