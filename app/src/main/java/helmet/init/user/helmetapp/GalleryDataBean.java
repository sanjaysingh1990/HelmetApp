package helmet.init.user.helmetapp;

import java.io.Serializable;

/**
 * Created by user on 14-07-2015.
 */
public class GalleryDataBean implements Serializable {


    String helmet_name;
    String helmet_image;
    String category_feature;
    String category_name;
    String helmet_id;
    String distributor_name,distributor_location,distributor_contact,latitude,longitude,distance,time;

    public String getDistributor_name() {
        return distributor_name;
    }

    public void setDistributor_name(String distributor_name) {
        this.distributor_name = distributor_name;
    }

    public String getDistributor_location() {
        return distributor_location;
    }

    public void setDistributor_location(String distributor_location) {
        this.distributor_location = distributor_location;
    }

    public String getDistributor_contact() {
        return distributor_contact;
    }

    public void setDistributor_contact(String distributor_contact) {
        this.distributor_contact = distributor_contact;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    String image;


    public String getHelmet_id() {
        return helmet_id;
    }

    public void setHelmet_id(String helmet_id) {
        this.helmet_id = helmet_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_feature() {
        return category_feature;
    }

    public void setCategory_feature(String category_feature) {
        this.category_feature = category_feature;
    }







    public String getHelmet_name() {
        return helmet_name;
    }

    public void setHelmet_name(String helmet_name) {
        this.helmet_name = helmet_name;
    }

    public String getHelmet_image() {
        return helmet_image;
    }

    public void setHelmet_image(String helmet_image) {
        this.helmet_image = helmet_image;
    }
}

