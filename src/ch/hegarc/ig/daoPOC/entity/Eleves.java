package ch.hegarc.ig.daoPOC.entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "eleves")
@XmlAccessorType(XmlAccessType.FIELD)
public class Eleves{
        //classe qui permet la generation du fichier xml
        @XmlElement(name = "eleve")
        List<Eleve> listeEleves;

        public Eleves() {

        }

        public Eleves(List<Eleve> listeEleves) {
            this.listeEleves = listeEleves;
        }

        public List<Eleve> getListeEleves() {
                return listeEleves;
        }

        public void setListeEleves(List<Eleve> listeEleves) {
                this.listeEleves = listeEleves;
        }

}
