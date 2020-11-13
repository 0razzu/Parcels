package parcels.given.service;


import lombok.RequiredArgsConstructor;
import parcels.given.model.Parcel;
import parcels.given.storage.Warehouse;


@RequiredArgsConstructor
public class DeliveryService {
    private final Warehouse warehouse;
    
    
    public String addParcel(int weight, int length, int width, int height) {
        return warehouse.addParcel(new Parcel(weight, length, width, height));
    }
    
    
    public Parcel getParcel(String id) {
        return warehouse.getParcel(id);
    }
}
