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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the de.osmembrane.model.xml package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _Parameter_QNAME = new QName(
			"http://osmembrane.de/model/xml", "parameter");
	private final static QName _Task_QNAME = new QName(
			"http://osmembrane.de/model/xml", "task");
	private final static QName _Function_QNAME = new QName(
			"http://osmembrane.de/model/xml", "function");
	private final static QName _FunctionGroup_QNAME = new QName(
			"http://osmembrane.de/model/xml", "functionGroup");
	private final static QName _InputPipe_QNAME = new QName(
			"http://osmembrane.de/model/xml", "inputPipe");
	private final static QName _OutputPipe_QNAME = new QName(
			"http://osmembrane.de/model/xml", "outputPipe");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: de.osmembrane.model.xml
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link XMLTask }
	 * 
	 */
	public XMLTask createXMLTask() {
		return new XMLTask();
	}

	/**
	 * Create an instance of {@link XMLOsmosisStructure }
	 * 
	 */
	public XMLOsmosisStructure createXMLOsmosisStructure() {
		return new XMLOsmosisStructure();
	}

	/**
	 * Create an instance of {@link XMLFunction }
	 * 
	 */
	public XMLFunction createXMLFunction() {
		return new XMLFunction();
	}

	/**
	 * Create an instance of {@link XMLEnumValue }
	 * 
	 */
	public XMLEnumValue createXMLEnumValue() {
		return new XMLEnumValue();
	}

	/**
	 * Create an instance of {@link XMLFunctionGroup }
	 * 
	 */
	public XMLFunctionGroup createXMLFunctionGroup() {
		return new XMLFunctionGroup();
	}

	/**
	 * Create an instance of
	 * {@link de.osmembrane.model.xml.XMLHasDescription.Description }
	 * 
	 */
	public de.osmembrane.model.xml.XMLHasDescription.Description createXMLHasDescriptionDescription() {
		return new de.osmembrane.model.xml.XMLHasDescription.Description();
	}

	/**
	 * Create an instance of {@link XMLParameter }
	 * 
	 */
	public XMLParameter createXMLParameter() {
		return new XMLParameter();
	}

	/**
	 * Create an instance of {@link XMLPipe }
	 * 
	 */
	public XMLPipe createXMLPipe() {
		return new XMLPipe();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link XMLParameter }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osmembrane.de/model/xml", name = "parameter")
	public JAXBElement<XMLParameter> createParameter(XMLParameter value) {
		return new JAXBElement<XMLParameter>(_Parameter_QNAME,
				XMLParameter.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link XMLTask }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osmembrane.de/model/xml", name = "task")
	public JAXBElement<XMLTask> createTask(XMLTask value) {
		return new JAXBElement<XMLTask>(_Task_QNAME, XMLTask.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link XMLFunction }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osmembrane.de/model/xml", name = "function")
	public JAXBElement<XMLFunction> createFunction(XMLFunction value) {
		return new JAXBElement<XMLFunction>(_Function_QNAME, XMLFunction.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link XMLFunctionGroup }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osmembrane.de/model/xml", name = "functionGroup")
	public JAXBElement<XMLFunctionGroup> createFunctionGroup(
			XMLFunctionGroup value) {
		return new JAXBElement<XMLFunctionGroup>(_FunctionGroup_QNAME,
				XMLFunctionGroup.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link XMLPipe }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osmembrane.de/model/xml", name = "inputPipe")
	public JAXBElement<XMLPipe> createInputPipe(XMLPipe value) {
		return new JAXBElement<XMLPipe>(_InputPipe_QNAME, XMLPipe.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link XMLPipe }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://osmembrane.de/model/xml", name = "outputPipe")
	public JAXBElement<XMLPipe> createOutputPipe(XMLPipe value) {
		return new JAXBElement<XMLPipe>(_OutputPipe_QNAME, XMLPipe.class, null,
				value);
	}

}
