package helmet.init.user.helmetapp;

import java.io.Serializable;

/**
 * Created by user on 14-07-2015.
 */
public class GalleryDataBean implements Serializable {

    String url,name,id;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getUrl() {

        return url;
    }
    public void setUrl(String url)

    {
        this.url = url;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)

    {
        this.name = name;
    }


    String helmet_name,helmet_image;

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

