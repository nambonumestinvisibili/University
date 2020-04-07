package zadanie.pkg1;

import java.util.Collections;
/**
 *
 * @author dawid
 */

 public interface Vehicles extends Comparable<Vehicles> {
     
     float getMileage();
     
     @Override
     int compareTo(Vehicles obj);

 }
