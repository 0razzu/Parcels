package parcels.service;


import parcels.view.ParcelView;


public interface SpecializedDeliveryService {
    String addParcel(double weight, double length, double width, double height);
    ParcelView getParcel(String id);
}
