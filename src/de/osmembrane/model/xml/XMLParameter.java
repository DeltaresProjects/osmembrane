//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.01.07 at 10:41:31 PM MEZ 
//


package de.osmembrane.model.xml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Describes a task parameter.
 * 
 * <p>Java class for XMLParameter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="XMLParameter">
 *   &lt;complexContent>
 *     &lt;extension base="{http://osmembrane.de/model/xml}XMLHasDescription">
 *       &lt;sequence>
 *         &lt;element name="enumValue" type="{http://osmembrane.de/model/xml}XMLEnumValue" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="friendlyName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="required" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="defaulXMLParameter" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="type" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="int"/>
 *             &lt;enumeration value="string"/>
 *             &lt;enumeration value="boolean"/>
 *             &lt;enumeration value="enum"/>
 *             &lt;enumeration value="filename"/>
 *             &lt;enumeration value="directory"/>
 *             &lt;enumeration value="uri"/>
 *             &lt;enumeration value="instant"/>
 *             &lt;enumeration value="bbox"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="booleanEncoding" default="yesno">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="yesno"/>
 *             &lt;enumeration value="truefalse"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="defaultValue" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMLParameter", propOrder = {
    "enumValue"
})
@SuppressWarnings(value = { "all" })
public class XMLParameter
    extends XMLHasDescription
    implements Serializable
{

    private final static long serialVersionUID = 2011010722410001L;
    protected List<XMLEnumValue> enumValue;
    @XmlAttribute(required = true)
    protected String name;
    @XmlAttribute
    protected String friendlyName;
    @XmlAttribute
    protected Boolean required;
    @XmlAttribute
    protected Boolean defaulXMLParameter;
    @XmlAttribute(required = true)
    protected String type;
    @XmlAttribute
    protected String booleanEncoding;
    @XmlAttribute
    protected String defaultValue;
    @XmlAttribute
    protected String value;

    /**
     * Gets the value of the enumValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the enumValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnumValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XMLEnumValue }
     * 
     * 
     */
    public List<XMLEnumValue> getEnumValue() {
        if (enumValue == null) {
            enumValue = new ArrayList<XMLEnumValue>();
        }
        return this.enumValue;
    }

    public boolean isSetEnumValue() {
        return ((this.enumValue!= null)&&(!this.enumValue.isEmpty()));
    }

    public void unsetEnumValue() {
        this.enumValue = null;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    public boolean isSetName() {
        return (this.name!= null);
    }

    /**
     * Gets the value of the friendlyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFriendlyName() {
        return friendlyName;
    }

    /**
     * Sets the value of the friendlyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFriendlyName(String value) {
        this.friendlyName = value;
    }

    public boolean isSetFriendlyName() {
        return (this.friendlyName!= null);
    }

    /**
     * Gets the value of the required property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isRequired() {
        if (required == null) {
            return false;
        } else {
            return required;
        }
    }

    /**
     * Sets the value of the required property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequired(boolean value) {
        this.required = value;
    }

    public boolean isSetRequired() {
        return (this.required!= null);
    }

    public void unsetRequired() {
        this.required = null;
    }

    /**
     * Gets the value of the defaulXMLParameter property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDefaulXMLParameter() {
        if (defaulXMLParameter == null) {
            return false;
        } else {
            return defaulXMLParameter;
        }
    }

    /**
     * Sets the value of the defaulXMLParameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDefaulXMLParameter(boolean value) {
        this.defaulXMLParameter = value;
    }

    public boolean isSetDefaulXMLParameter() {
        return (this.defaulXMLParameter!= null);
    }

    public void unsetDefaulXMLParameter() {
        this.defaulXMLParameter = null;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    public boolean isSetType() {
        return (this.type!= null);
    }

    /**
     * Gets the value of the booleanEncoding property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBooleanEncoding() {
        if (booleanEncoding == null) {
            return "yesno";
        } else {
            return booleanEncoding;
        }
    }

    /**
     * Sets the value of the booleanEncoding property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBooleanEncoding(String value) {
        this.booleanEncoding = value;
    }

    public boolean isSetBooleanEncoding() {
        return (this.booleanEncoding!= null);
    }

    /**
     * Gets the value of the defaultValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * Sets the value of the defaultValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultValue(String value) {
        this.defaultValue = value;
    }

    public boolean isSetDefaultValue() {
        return (this.defaultValue!= null);
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    public boolean isSetValue() {
        return (this.value!= null);
    }

}
