package parcels.service;


import lombok.RequiredArgsConstructor;
import parcels.given.model.Parcel;
import parcels.given.service.DeliveryService;
import parcels.view.ParcelView;

import static java.lang.Math.round;


/**
 * <p>weight in kilograms,</p>
 * <p>length, width and height in centimeters</p>
 */
@RequiredArgsConstructor
public class MetricDeliveryService implements SpecializedDeliveryService {
    private final DeliveryService deliveryService;
    
    
    @Override
    public String addParcel(double weight, double length, double width, double height) {
        return deliveryService.addParcel(
                (int) round(weight * 1000),
                (int) round(length * 10),
                (int) round(width * 10),
                (int) round(height * 10)
        );
    }
    
    
    @Override
    public ParcelView getParcel(String id) {
        Parcel parcel = deliveryService.getParcel(id);
        
        return new ParcelView(
                parcel.getWeight() / 1000.,
                parcel.getLength() / 10.,
                parcel.getWidth() / 10.,
                parcel.getHeight() / 10.
        );
    }
}
