

package zadanie.pkg1;
// @author Dawid Holewa 317898


public class Zadanie1 {
        public static void main(String[] args) {
        
            Car car1 = new Car("volvo", 100, 4);
            Car car2 = new Car("pasat", 200, 5) ; 
            Tractor tra1 = new Tractor("Saab", 150, 1);
            Bike bik1 = new Bike("Junak", 30, 2);
            Lorry lor1 = new Lorry("Scania", 1000, 1800);
            
            VehiclesCollection collect = new VehiclesCollection();
            collect.add(car2);
            collect.add(car1);
            collect.add(tra1); 
            collect.add(bik1);
            collect.add(lor1);
            System.out.println(collect);
            collect.pop();
            System.out.println(collect);
            
            
            
            
            
            
            
            
            
            
            
            
            
            
    }

}




