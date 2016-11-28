package com.jbc.beans;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Contact {

  public abstract Long getId();
  public abstract String getFirstName();
  public abstract String getLastName();
  public abstract String getPhoneNumber();
  public abstract String getEmailAddress();

  /**
   * Prints the immutable value {@code Contact} with attribute values.
   * @return A string representation of the value
   */
//  @Override
//  public String toString() {
//    return "Contact TOTO {"
//        + "id=" + getId()
//        + ", firstName=" + getFirstName()
//        + ", lastName=" + getLastName()
//        + ", phoneNumber=" + getPhoneNumber()
//        + ", emailAddress=" + getEmailAddress()
//        + "}";
//  }


}

