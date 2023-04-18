package model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    String image;
    String unit;
    String provider;
    Object price;
    String title;
    String promoDetails;
    String brand;
    boolean isPromo;
    String url;
}
