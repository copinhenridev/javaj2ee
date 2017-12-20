package com.vladene.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author henri.tala
 *
 */
@Entity
@DiscriminatorValue("W")
public class Withdrawal  extends Operation{

}
