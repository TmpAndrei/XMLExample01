package org.andryushin;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.LinkedList;

public class AppCollection {
    public static final String xmlFilePatch = "src/main/resources/many.xml";

    public static void main(String[] args) {
        Tags tags = generateTags();
        System.out.println(tags);

        try {
            File xmlFile = new File(xmlFilePatch);
            System.out.println(xmlFile.getAbsolutePath());
            JAXBContext jaxbContext = JAXBContext.newInstance(Tags.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // print the output with nice alignment
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(tags, xmlFile);

            // you can use this to print the result in
            // standard output for debugging purposes
            // jaxbMarshaller.marshal(student, System.out);

            System.out.println("File was created succesfully");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static Tags generateTags() {
        Tag tag1 = new Tag();
        Tag tag2 = new Tag();
        Tag tag3 = new Tag();

        tag1.setId(102);
        tag1.setKks("11MKH17CP101||XQ03");
        tag1.setDescription("P of s");
        tag1.setShortName("P");
        tag1.setAnalog(true);
        tag1.setUnit("Pa");
        tag1.setMaxValue(250);
        tag1.setMinValue(0);

        tag2.setId(103);
        tag2.setKks("11MKH12CE101||XQ01");
        tag2.setDescription("W of s");
        tag2.setShortName("W");
        tag2.setAnalog(true);
        tag2.setUnit("Mg");
        tag2.setMaxValue(550);
        tag2.setMinValue(0);

        tag3.setId(107);
        tag3.setKks("12HLB21CG101||XB01");
        tag3.setDescription("Gen in");
        tag3.setShortName("Gi");
        tag3.setAnalog(false);

        LinkedList<Tag> list = new LinkedList<>();
        list.add(tag1);
        list.add(tag2);
        list.add(tag3);

        Tags tags = new Tags();
        tags.setId(101);
        tags.setGroup("My group");
        tags.setTags(list);

        return tags;
    }
}
