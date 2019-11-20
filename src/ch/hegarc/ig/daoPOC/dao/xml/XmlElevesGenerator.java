package ch.hegarc.ig.daoPOC.dao.xml;
import ch.hegarc.ig.daoPOC.entity.Eleve;
import ch.hegarc.ig.daoPOC.entity.Eleves;
import ch.hegarc.ig.daoPOC.factory.AbstractDaoFactory;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XmlElevesGenerator {
    public static void main(String [ ] args) {
        //génére le fichier xml pour les eleves
        List<Eleve> elevesList = AbstractDaoFactory.getFactory("db").getEleveDAO().findAll();
        Eleves eleves = new Eleves(elevesList);

        try {
            File file = new File("./eleves.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Eleves.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(eleves, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
