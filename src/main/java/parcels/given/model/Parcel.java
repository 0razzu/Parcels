package parcels.given.model;


import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Parcel {
    private int weight; // in grams
    private int length; // in millimeters
    private int width;  // in millimeters
    private int height; // in millimeters
}
