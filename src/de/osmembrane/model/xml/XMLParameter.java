/*
 * This file is part of the OSMembrane project.
 * More informations under www.osmembrane.de
 * 
 * The project is licensed under the Creative Commons
 * Attribution-NonCommercial-ShareAlike 3.0 Unported License.
 * for more details about the license see
 * http://www.osmembrane.de/license/
 * 
 * Source: $HeadURL$ ($Revision$)
 * Last changed: $Date$
 */

package de.osmembrane.model.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Describes a task parameter.
 * 
 * <p>
 * Java class for XMLParameter complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
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
 *       &lt;attribute name="defaultParameter" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
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
 *             &lt;enumeration value="list"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="listType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="hasSpaces" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="booleanEncoding" default="yesno">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="yesno"/>
 *             &lt;enumeration value="truefalse"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="defaultValue" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMLParameter", propOrder = { "enumValue" })
public class XMLParameter extends XMLHasDescription {

	protected List<XMLEnumValue> enumValue;
	@XmlAttribute(required = true)
	protected String name;
	@XmlAttribute
	protected String friendlyName;
	@XmlAttribute
	protected Boolean required;
	@XmlAttribute
	protected Boolean defaultParameter;
	@XmlAttribute(required = true)
	protected String type;
	@XmlAttribute
	protected String listType;
	@XmlAttribute
	protected Boolean hasSpaces;
	@XmlAttribute
	protected String booleanEncoding;
	@XmlAttribute
	protected String defaultValue;

	/**
	 * Gets the value of the enumValue property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the enumValue property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getEnumValue().add(newItem);
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
		return ((this.enumValue != null) && (!this.enumValue.isEmpty()));
	}

	public void unsetEnumValue() {
		this.enumValue = null;
	}

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	public boolean isSetName() {
		return (this.name != null);
	}

	/**
	 * Gets the value of the friendlyName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFriendlyName() {
		return friendlyName;
	}

	/**
	 * Sets the value of the friendlyName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFriendlyName(String value) {
		this.friendlyName = value;
	}

	public boolean isSetFriendlyName() {
		return (this.friendlyName != null);
	}

	/**
	 * Gets the value of the required property.
	 * 
	 * @return possible object is {@link Boolean }
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
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setRequired(boolean value) {
		this.required = value;
	}

	public boolean isSetRequired() {
		return (this.required != null);
	}

	public void unsetRequired() {
		this.required = null;
	}

	/**
	 * Gets the value of the defaultParameter property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public boolean isDefaultParameter() {
		if (defaultParameter == null) {
			return false;
		} else {
			return defaultParameter;
		}
	}

	/**
	 * Sets the value of the defaultParameter property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setDefaultParameter(boolean value) {
		this.defaultParameter = value;
	}

	public boolean isSetDefaultParameter() {
		return (this.defaultParameter != null);
	}

	public void unsetDefaultParameter() {
		this.defaultParameter = null;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setType(String value) {
		this.type = value;
	}

	public boolean isSetType() {
		return (this.type != null);
	}

	/**
	 * Gets the value of the listType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getListType() {
		return listType;
	}

	/**
	 * Sets the value of the listType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setListType(String value) {
		this.listType = value;
	}

	public boolean isSetListType() {
		return (this.listType != null);
	}

	/**
	 * Gets the value of the hasSpaces property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public boolean isHasSpaces() {
		if (hasSpaces == null) {
			return false;
		} else {
			return hasSpaces;
		}
	}

	/**
	 * Sets the value of the hasSpaces property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setHasSpaces(boolean value) {
		this.hasSpaces = value;
	}

	public boolean isSetHasSpaces() {
		return (this.hasSpaces != null);
	}

	public void unsetHasSpaces() {
		this.hasSpaces = null;
	}

	/**
	 * Gets the value of the booleanEncoding property.
	 * 
	 * @return possible object is {@link String }
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
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBooleanEncoding(String value) {
		this.booleanEncoding = value;
	}

	public boolean isSetBooleanEncoding() {
		return (this.booleanEncoding != null);
	}

	/**
	 * Gets the value of the defaultValue property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * Sets the value of the defaultValue property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDefaultValue(String value) {
		this.defaultValue = value;
	}

	public boolean isSetDefaultValue() {
		return (this.defaultValue != null);
	}

}
