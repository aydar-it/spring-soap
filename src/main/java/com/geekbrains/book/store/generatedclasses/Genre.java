//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.08.24 at 09:01:22 PM MSK 
//


package com.geekbrains.book.store.generatedclasses;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for genre.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="genre"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="DETECTIVE"/&gt;
 *     &lt;enumeration value="FICTION"/&gt;
 *     &lt;enumeration value="FANTASY"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "genre")
@XmlEnum
public enum Genre {

    DETECTIVE,
    FICTION,
    FANTASY;

    public String value() {
        return name();
    }

    public static Genre fromValue(String v) {
        return valueOf(v);
    }

}