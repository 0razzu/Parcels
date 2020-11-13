package parcels.given.storage;


import parcels.given.model.Parcel;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class Warehouse {
    private final Map<String, Parcel> parcels = new HashMap<>();
    
    
    public String addParcel(Parcel parcel) {
        String id = UUID.randomUUID().toString();
        
        parcels.put(id, parcel);
        
        return id;
    }
    
    
    public Parcel getParcel(String id) {
        return parcels.get(id);
    }
}
