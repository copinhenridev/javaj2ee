package com.vladene.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

/**
 * @author henri.tala
 *
 */
@Entity
@DiscriminatorValue("D")
public class Deposit extends Operation {

}
