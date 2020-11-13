package parcels.service;


import org.junit.jupiter.api.Test;
import parcels.given.model.Parcel;
import parcels.given.service.DeliveryService;
import parcels.given.storage.Warehouse;
import parcels.view.ParcelView;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestDeliveryService {
    private static final double EPS = 0.03;
    
    
    @Test
    void testMetricService() {
        DeliveryService deliveryService = new DeliveryService(new Warehouse());
        SpecializedDeliveryService metricService = new MetricDeliveryService(deliveryService);
        
        String id = metricService.addParcel(3, 30, 25, 19.5);
        Parcel parcel = deliveryService.getParcel(id);
        ParcelView metricParcel = metricService.getParcel(id);
        
        assertAll(
                () -> assertEquals(3000, parcel.getWeight()),
                () -> assertEquals(300, parcel.getLength()),
                () -> assertEquals(250, parcel.getWidth()),
                () -> assertEquals(195, parcel.getHeight()),
                () -> assertEquals(3, metricParcel.getWeight(), EPS),
                () -> assertEquals(30, metricParcel.getLength(), EPS),
                () -> assertEquals(25, metricParcel.getWidth(), EPS),
                () -> assertEquals(19.5, metricParcel.getHeight(), EPS)
        );
    }
    
    
    @Test
    void testImperialService() {
        DeliveryService deliveryService = new DeliveryService(new Warehouse());
        SpecializedDeliveryService imperialService = new ImperialDeliveryService(deliveryService);
        
        String id = imperialService.addParcel(8, 12, 10, 7.5);
        Parcel parcel = deliveryService.getParcel(id);
        ParcelView imperialParcel = imperialService.getParcel(id);
        
        assertAll(
                () -> assertEquals(3629, parcel.getWeight()),
                () -> assertEquals(305, parcel.getLength()),
                () -> assertEquals(254, parcel.getWidth()),
                () -> assertEquals(191, parcel.getHeight()),
                () -> assertEquals(8, imperialParcel.getWeight(), EPS),
                () -> assertEquals(12, imperialParcel.getLength(), EPS),
                () -> assertEquals(10, imperialParcel.getWidth(), EPS),
                () -> assertEquals(7.5, imperialParcel.getHeight(), EPS)
        );
    }
}
