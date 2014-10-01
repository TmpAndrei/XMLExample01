package org.andryushin;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class App {
    public static final String xmlFileName = "list.xml";

    public static void main( String[] args )
    {
//        Tag tag = tagGenerate();
        Tag tag = unmarshal();
        System.out.println(tag);
//        marshal(tag);
    }

    private static Tag tagGenerate() {
        Tag tag = new Tag();
        tag.setId(100);
        tag.setKks("11MKA10CT201||XQ01");
        tag.setDescription("Temperature");
        tag.setShortName("T");
        tag.setAnalog(true);
        tag.setUnit("C");
        tag.setMinValue(0);
        tag.setMaxValue(300);
        return tag;
    }

    private static Tag unmarshal() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Tag.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

//            Tag tag = (Tag) jaxbUnmarshaller.unmarshal(xmlFile);
            Tag tag = (Tag) jaxbUnmarshaller.unmarshal(App.class.getClassLoader().getResourceAsStream(xmlFileName));
            return tag;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void marshal(Tag tag) {
        try {
            File xmlFile = new File(xmlFileName);
            System.out.println(xmlFile.getAbsolutePath());
            JAXBContext jaxbContext = JAXBContext.newInstance(Tag.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // print the output with nice alignment
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(tag, xmlFile);

            // you can use this to print the result in
            // standard output for debugging purposes
            // jaxbMarshaller.marshal(student, System.out);

            System.out.println("File was created succesfully");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
