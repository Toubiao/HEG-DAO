package ch.hegarc.ig.daoPOC.dao.xml;

import ch.hegarc.ig.daoPOC.entity.Camp;
import ch.hegarc.ig.daoPOC.entity.Camps;
import ch.hegarc.ig.daoPOC.factory.AbstractDaoFactory;


import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XmlCampsGenerator {
    public static void main(String [ ] args){
        //Génére le fichier xml pour les camps
        List<Camp> CampsList = AbstractDaoFactory.getFactory("db").getCampDAO().findAll();
        Camps camps = new Camps(CampsList);



        try{
            File file = new File("./camps.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Camps.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            jaxbMarshaller.marshal(camps,file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
