package parcels.view;


import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class ParcelView {
    private double weight;
    private double length;
    private double width;
    private double height;
}
