package ch.hegarc.ig.daoPOC.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "camps")
@XmlAccessorType(XmlAccessType.FIELD)

public class Camps {
    //classe qui permet la generation du fichier xml
    @XmlElement(name = "camp")
    private List<Camp> listeCamps;

    public Camps(){

    }

    public List<Camp> getListeCamps() {
        return listeCamps;
    }

    public Camps(List<Camp> listeCamps) {
        this.listeCamps = listeCamps;
    }

    public void setListeCamps(List<Camp> listeCamps) {
        this.listeCamps = listeCamps;
    }
}
