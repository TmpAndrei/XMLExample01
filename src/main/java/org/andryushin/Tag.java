package org.andryushin;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "tag")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tag {
    //todo: add constructor and validator
    @XmlAttribute
    private int id;
    @XmlElement(required = true)
    private String kks;
    @XmlElement(required = true)
    private String description;
    @XmlElement(required = true)
    private String shortName;
    @XmlElement(required = true)
    private boolean analog;
    @XmlElement(nillable = true)
    private String unit;
    @XmlElement(nillable = true)
    private int maxValue;

    @Override
    public String toString() {
        //todo: don't print unit, if analog = false
        return "Tag{" +
                "id=" + id +
                ", KKS='" + kks + '\'' +
                ", Description='" + description + '\'' +
                ", Short Name='" + shortName + '\'' +
                ", is analog=" + analog +
                ", unit='" + unit + '\'' +
                ", Max Value=" + maxValue +
                ", Min Value=" + minValue +
                '}';
    }

    @XmlElement(nillable = true)
    private int minValue;

    public String getKks() {
        return kks;
    }

    public void setKks(String kks) {
        this.kks = kks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAnalog() {
        return analog;
    }

    public void setAnalog(boolean analog) {
        this.analog = analog;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setShortName(String sortName) {
        this.shortName = sortName;
    }

    public String getSortName() {
        return shortName;
    }
}
