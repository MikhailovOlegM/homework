package hotel;

public class Visitor {

  private String firstName;
  private String lastName;

  public Visitor(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }


  @Override
  public int hashCode() {
    return (firstName != null) ? takeChar() : 0;
  }

  private int takeChar() {
    int number;
    if (lastName.charAt(0) == lastName.toLowerCase().charAt(0)) {
      number = lastName.charAt(0) - 'a';
      return number;
    }
    number = lastName.charAt(0) - 'A';
    return number;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    Visitor visitor = (Visitor) obj;

    if (firstName != null ? !firstName.equals(visitor.firstName) : visitor.firstName != null) {
      return false;
    }
    return lastName != null ? lastName.equals(visitor.lastName) : visitor.lastName == null;
  }

  @Override
  public String toString() {
    return firstName + " " + lastName;
  }
}
