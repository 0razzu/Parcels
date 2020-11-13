package parcels.service;


import lombok.RequiredArgsConstructor;
import parcels.given.model.Parcel;
import parcels.given.service.DeliveryService;
import parcels.view.ParcelView;

import static java.lang.Math.round;


/**
 * <p>weight in pounds,</p>
 * <p>length, width and height in inches</p>
 */
@RequiredArgsConstructor
public class ImperialDeliveryService implements SpecializedDeliveryService {
    private final DeliveryService deliveryService;
    
    
    @Override
    public String addParcel(double weight, double length, double width, double height) {
        return deliveryService.addParcel(
                (int) round(weight * 453.59237),
                (int) round(length * 25.4),
                (int) round(width * 25.4),
                (int) round(height * 25.4)
        );
    }
    
    
    @Override
    public ParcelView getParcel(String id) {
        Parcel parcel = deliveryService.getParcel(id);
        
        return new ParcelView(
                parcel.getWeight() / 453.59237,
                parcel.getLength() / 25.4,
                parcel.getWidth() / 25.4,
                parcel.getHeight() / 25.4
        );
    }
}
