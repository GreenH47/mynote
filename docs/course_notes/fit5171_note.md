# assignment 1
## requirement
This is a small software implemented in Java and your team has been contracted to validate the functional requirements and prove the quality of the Software. Using TDD approach, you can extend the codebase where needed
## main function code
### Airplane.java
here is the code inside Airplane.java
```java
package fit5171.monash.edu;  
  
/*  
* When some attribute of the airplane is being set, the following unit testing conditions need to be satisfied.  
1. Ensure all fields/details for an airplane like Airplane ID,  
* Airplane businessSitsNumber, crewSitsNumber, etc. are tested  
* 2. Seat number must be in the range [1, 300].  
* */  
public class Airplane  
{  
    private int airplaneID;  
    private String airplaneModel;  
    private int businessSitsNumber;  
    private int economySitsNumber;  
    private int crewSitsNumber;  
  
    public Airplane(int airplaneID, String airplaneModel, int businessSitsNumber, int economySitsNumber, int crewSitsNumber)  
    {  
        this.airplaneID=airplaneID;  
        this.airplaneModel = airplaneModel;  
        this.businessSitsNumber = businessSitsNumber;  
        this.economySitsNumber = economySitsNumber;  
        this.crewSitsNumber = crewSitsNumber;  
    }  
  
    public int getAirplaneID() {  
        return airplaneID;  
    }  
  
    public void setAirplaneID(int airplaneID) {  
        this.airplaneID = airplaneID;  
    }  
  
    public String getAirplaneModel() {  
        return airplaneModel;  
    }  
  
    public void setAirplaneModel(String airplaneModel) {  
        this.airplaneModel = airplaneModel;  
    }  
  
    public int getBusinessSitsNumber() {  
        return businessSitsNumber;  
    }  
  
    public void setBusinessSitsNumber(int businessSitsNumber) {  
        this.businessSitsNumber = businessSitsNumber;  
    }  
  
    public int getEconomySitsNumber() {  
        return economySitsNumber;  
    }  
  
    public void setEconomySitsNumber(int economSitsNumber) {  
        this.economySitsNumber = economSitsNumber;  
    }  
  
    public int getCrewSitsNumber() {  
        return crewSitsNumber;  
    }  
  
    public void setCrewSitsNumber(int crewSitsNumber) {  
        this.crewSitsNumber = crewSitsNumber;  
    }  
  
    public String toString()  
    {  
        return "Airplane{" +  
                "model=" + getAirplaneModel() + '\'' +  
                ", business sits=" + getBusinessSitsNumber() + '\'' +  
                ", economy sits=" + getEconomySitsNumber() + '\'' +  
                ", crew sits=" + getCrewSitsNumber() + '\'' +  
                '}';  
    }  
  
   public static Airplane getAirPlaneInfo(int airplane_id) {  
      // TODO Auto-generated method stub  
      return null;  
   }  
}
```
### Flight.java
here is the code inside Flight.java:  
```java
package fit5171.monash.edu;  
  
import java.sql.Timestamp;  
import java.util.Calendar;  
/*  
* When a flight is being added to the system, following conditions must be met.  
1. All fields are required. Note: Mock the behaviour of the Airplane * class while creating objects of the Flight class for unit testing.  
* 2. Date must be in DD/MM/YY format.  
* 3. Time must be in HH:MM:SS format.  
* 4. Ensure the same flight is not already in the system  
* */  
public class Flight {  
    private int flightID;  
    private String departTo;  
    private String departFrom;  
    private String code;  
    private String company;  
    private Timestamp dateFrom;  
    private Timestamp dateTo;  
    Airplane airplane;  
    public Flight(){}  
  
    public Flight(int flight_id, String departTo, String departFrom, String code, String company, Timestamp dateFrom,Timestamp dateTo, Airplane airplane)  
    {  
            this.flightID=flight_id;  
            this.departTo = departTo;  
            this.departFrom = departFrom;  
            this.code = code;  
            this.company = company;  
            this.airplane = airplane;  
            this.dateTo = dateTo;  
            this.dateFrom = dateFrom;  
    }  
  
    public int getFlightID() {  
        return flightID;  
    }  
  
    public void setFlightID(int flightid) {  
        this.flightID = flightid;  
    }  
  
    public String getDepartTo() {  
        return departTo;  
    }  
  
    public void setDepartTo(String departTo) {  
        //departTo and departFrom should not same  
        if (departFrom != null && departTo.equals(departFrom)) {  
            throw new IllegalArgumentException("Departure and Destination cities cannot be the same.");  
        }  
        this.departTo = departTo;  
    }  
  
    public String getDepartFrom() {  
        return departFrom;  
    }  
  
    public void setDepartFrom(String departFrom) {  
        //departTo and departFrom should not same  
        if (departTo != null && departFrom.equals(departTo)) {  
            throw new IllegalArgumentException("Departure and Destination cities cannot be the same.");  
        }  
        this.departFrom = departFrom;  
    }  
  
    public String getCode() {  
        return code;  
    }  
  
    public void setCode(String code) {  
        if (code == null || code.trim().length() == 0) {  
            throw new IllegalArgumentException("Flight code cannot be null.");  
        }  
        this.code = code;  
    }  
  
    public String getCompany() {  
        return company;  
    }  
  
    public void setCompany(String company) {  
        if (company == null || company.trim().length() == 0) {  
            throw new IllegalArgumentException("Company name cannot be null.");  
        }  
        this.company = company;  
    }  
  
    public Timestamp getDateFrom() {  
        return dateFrom;  
    }  
  
    public void setDateFrom(Timestamp dateFrom) {  
        //dateTo should later than dateFrom  
        if (dateTo != null && dateFrom.after(dateTo)) {  
            throw new IllegalArgumentException("Departure date cannot be after Arrival date.");  
        }  
        this.dateFrom = dateFrom;  
    }  
  
    public Timestamp getDateTo() {  
        return dateTo;  
    }  
  
    public void setDateTo(Timestamp dateTo) {  
        //dateTo should later than dateFrom  
        if (dateFrom != null && dateTo.before(dateFrom)) {  
            throw new IllegalArgumentException("Arrival date cannot be before Departure date.");  
        }  
        this.dateTo = dateTo;  
    }  
  
    public void setAirplane(Airplane airplane) {  
        this.airplane = airplane;  
    }  
  
    public Airplane getAirplane() {  
        return airplane;  
    }  
  
    public String toString()  
    {  
            return "Flight{" + airplane.toString() +  
                    ", date to=" +  getDateTo() + ", " + '\'' +  
                    ", date from='" + getDateFrom() + '\'' +  
                    ", depart from='" + getDepartFrom() + '\'' +  
                    ", depart to='" + getDepartTo() + '\'' +  
                    ", code=" + getCode() + '\'' +  
                    ", company=" + getCompany() + '\'' +  
                    ", code=" + getCode() + '\'' +  
                    '}';  
    }  
}
```
### Person.java
here is the code inside Person.java:  
```java
package fit5171.monash.edu;  
/*  
* Person When a person is being created or returned, test following:  
*  
1. All fields of a Person class are required to create a person.  
*  
2. The gender field has following options ‘Woman’, ‘Man’,’Non-binary|gender diverse’,  
* ‘Prefer not to say’ and ‘Other’.  
*  
3. The first name and last name should not start with a number or symbol and  
* can contain only small case and upper-case alphabet letters.  
* */  
public abstract class Person //abstract class Person  
{  
    private String firstName;  
    private String secondName;  
    private int age;  
    private String gender;  
  
    public Person(){}  
  
    public Person(String firstName, String secondName, int age, String gender){  
        this.age=age;  
        this.firstName=firstName;  
        this.secondName=secondName;  
        this.gender=gender;  
    }  
  
    public int getAge() {  
        return age;  
    }  
  
    public void setAge(int age) {  
        this.age = age;  
    }  
  
    public String getGender() {  
        return gender;  
    }  
  
    public void setGender(String gender) {  
        this.gender = gender;  
    }  
  
    public String getFirstName() {  
        return firstName;  
    }  
  
    public String getSecondName() {  
        return secondName;  
    }  
  
    public void setFirstName(String firstName) {  
        this.firstName = firstName;  
    }  
  
    public void setSecondName(String secondName) {  
        this.secondName = secondName;  
    }  
  
    @Override  
    public String toString()  
    {  
        return "Person{" +  
                "firstName='" + firstName + '\'' +  
                ", secondName='" + secondName + '\'' +  
                ", age=" + age +  
                ", gender='" + gender + '\'' +  
                '}';  
    }  
}
```
### Passenger.java
here is the code inside Passenger.java:  
```java
package fit5171.monash.edu;  
  
/*  
* When a passenger is being created or returned, test following:  
*  
1. All fields of a passenger are required.Note: Mock the behavior of  
* the Person class while creating objects of the Passenger class for unit testing.  
*  
2. Phone number follows a pattern. Within Australia, mobile phone numbers begin  
* with 04 or 05 – the Australian national trunk code" 0, plus the mobile indicator 4 or 5,  
* then followed by eight digits. This is generally written as 04XX XXX XXX within Australia  
* or as +61 4XX XXX XXX for aninternational audience.  
*  
3. The email follows a valid pattern “abc@domain.com”.  
*  
4. The passport number should not be more than 9 characters long.  
*  
5. When a passenger is being added, it must include the passenger’s First name,  
* Last Name, age,and gender following the person who is becoming a passenger  
* */  
public class Passenger extends Person  
{  
    private String email;  
    private String phoneNumber;  
    private String cardNumber;  
    private int securityCode;  
    private String passport;  
  
    public Passenger(){}  
  
    public Passenger(String firstName, String secondName, int age, String gender,String email, String phoneNumber, String passport, String cardNumber,int securityCode)  
    {  
        super();  
        this.securityCode=securityCode;  
        this.cardNumber=cardNumber;  
        this.passport=passport;  
        this.email=email;  
        this.phoneNumber=phoneNumber;  
    }  
  
    public String getEmail() {  
  
        return email;  
    }  
  
    public void setEmail(String email) {  
        //set email validation  
        if (email == null || !email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}")) {  
            throw new IllegalArgumentException("Invalid email address format");  
        }  
        this.email = email;  
    }  
  
    public String getFirstName() {  
        return super.getFirstName();  
    }  
  
    public String getSecondName() {  
        return super.getSecondName();  
    }  
  
    public void setSecondName(String secondName) {  
        super.setSecondName(secondName);  
    }  
  
    public void setFirstName(String firstName) {  
        super.setFirstName(firstName);  
    }  
  
    public String getPassport() {  
        return passport;  
    }  
  
    public void setGender(String gender) {  
        super.setGender(gender);  
    }  
  
    public String getPhoneNumber() {  
        return phoneNumber;  
    }  
  
    public int getSecurityCode() {  
        return securityCode;  
    }  
  
    public String getCardNumber() {  
        return cardNumber;  
    }  
  
    public void setCardNumber(String cardNumber) {  
        this.cardNumber = cardNumber;  
    }  
  
    public void setSecurityCode(int securityCode) {  
        this.securityCode = securityCode;  
    }  
  
    @Override  
    public void setAge(int age) {  
        super.setAge(age);  
    }  
  
    public void setPassport(String passport) {  
        this.passport = passport;  
    }  
  
    @Override  
    public String getGender() {  
        return super.getGender();  
    }  
  
    public void setPhoneNumber(String phoneNumber) {  
        //set phonenumber validation  
        if (phoneNumber == null || !phoneNumber.matches("^\\+(?:[0-9] ?){6,14}[0-9]$")) {  
            throw new IllegalArgumentException("Invalid phone number format");  
        }  
        this.phoneNumber = phoneNumber;  
    }  
  
    @Override  
    public int getAge() {  
        return super.getAge();  
    }  
  
    @Override  
    public String toString()  
    {  
        return "Passenger{" + " Fullname= "+ super.getFirstName()+" "+super.getSecondName()+  
                " ,email='" + email + '\'' +  
                ", phoneNumber='" + phoneNumber + '\'' +  
                ", passport='" + passport +  
                '}';  
    }  
}
```
### Ticket.java
here is the code inside Ticket.java:  
```java
package fit5171.monash.edu;  
/*  
* 1. Values for the ticket status must be ‘True’ or ‘False’ for  
* the booked and available ticketsrespectively.  
*  
2. Discount is always applied based on the age category of the passenger.  
*  
3. Price is always applied to a ticket.  
*  
4. The price and service tax is a valid value (Integer or real numbers etc.)  
*  
5. The service tax is always applied when a ticket is sold. Note: Mock the behavior  
* of the Flight and Passenger class, while creating objects of the Ticket class  
* for unit testing.  
*  
6. Test that Ticker class received valid information of flight and passenger.  
* */  
public class Ticket  
{  
    private int ticket_id;  
    private int price;  
    Flight flight;  
    private boolean classVip; //indicates if this is bussiness class ticket or not  
    private boolean status; //indicates status of ticket: if it is bought by someone or not  
    Passenger passenger;  
  
    public Ticket(int ticket_id,int price, Flight flight, boolean classVip, Passenger passenger)  
    {  
        this.ticket_id=ticket_id;  
        this.price = price;  
        this.flight = flight;  
        this.classVip = classVip;  
        this.status = false;  
        this.passenger=passenger;  
    }  
  
    public Ticket() {  
  
    }  
  
    public int getTicket_id() {  
        return ticket_id;  
    }  
  
    public void setTicket_id(int ticket_id) {  
        this.ticket_id = ticket_id;  
    }  
  
    public int getPrice() { return price; }  
  
    public void setPrice(int price)  
    {  
        if (price < 0) {  
            throw new IllegalArgumentException("Ticket price cannot be less than zero.");  
        }  
        this.price = price;  
        int age = passenger.getAge();  
        saleByAge(age); //changes price of the ticket according to the age category of passenger  
        serviceTax( ); //changes price by adding service tax to the ticket  
    }  
  
    public void saleByAge(int age)  
    {  
        int price = getPrice();  
        if(age < 15)  
        {  
  
            price-=(int)price*0.5;//50% sale for children under 15  
            this.price=price;  
  
        } else if(age>=60){  
            this.price=0; //100% sale for elder people  
        }  
    }  
  
    public Flight getFlight() {  
        return flight;  
    }  
  
    public void setFlight(Flight flight) {  
        this.flight = flight;  
    }  
  
    public boolean getClassVip() {  
        return classVip;  
    }  
  
    public void setClassVip(boolean classVip) {  
        this.classVip = classVip;  
    }  
  
    public boolean ticketStatus()  
    {  
        return status;  
    }  
  
    public void setTicketStatus(boolean status)  
    {  
        this.status = status;  
    }  
  
    public void serviceTax(){  
        this.price *= 1.12;  
    } //12% service tax  
  
    public Passenger getPassenger() {  
        return passenger;  
    }  
  
    public void setPassenger(Passenger passenger) {  
        this.passenger = passenger;  
    }  
  
    public String toString()  
    {  
        return"Ticket{" +'\n'+  
                "Price=" + getPrice() + "KZT, " + '\n' +  
                getFlight() +'\n'+ "Vip status=" + getClassVip() + '\n' +  
                getPassenger()+'\n'+ "Ticket was purchased=" + ticketStatus() + "\n}";  
    }  
}
```


### TicketSystem.java
here is the code inside TicketSystem.java:  
```java
package fit5171.monash.edu;  
import java.sql.*;  
import java.util.*;  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
import java.util.regex.PatternSyntaxException;  
  
/*  
* 1. When choosing a ticket, a valid city is used.  
*  
2. If a passenger chooses an already booked ticket it should display an error message.  
*  
3. Appropriate checks have been implemented to validate passenger information  
*  
4. Appropriate checks have been implemented to validate flight information  
*  
5. Appropriate checks have been implemented to validate ticket information  
*  
6. A correct value is displayed to the passenger when buying a ticket  
* */  
public class TicketSystem <T>  
{  
    Passenger passenger = new Passenger();  
    Ticket ticket = new Ticket();  
    Flight flight = new Flight();  
    Scanner in = new Scanner(System.in);  
  
    public TicketSystem()  
    {  
        passenger = new Passenger();  
        ticket = new Ticket();  
        flight = new Flight();  
    }  
  
  
    public void showTicket()  
    {  
        try  
        {  
            System.out.println("You have bought a ticket for flight " + ticket.flight.getDepartFrom() + " - " + ticket.flight.getDepartTo() + "\n\nDetails:");  
            System.out.println(this.ticket.toString());  
        }  
        catch (NullPointerException e)  
        {  
            return;  
        }  
    }  
  
    /**  
     *     * @param ticket_id  
     * @throws Exception  
     */    public void buyTicket(int ticket_id) throws Exception  
    //method for buying one ticket with direct flight  
    {  
        int flight_id = 0;  
  
        //select ticket where ticket_id="+ticket_id"  
        Ticket validTicket = TicketCollection.getTicketInfo(ticket_id);  
  
        //if there is a valid ticket id was input then we buy it, otherwise show message  
        if(validTicket != null)  
        {  
            System.out.println("This ticket does not exist.");  
            return;        }  
        else{  
            //select flight_id from ticket where ticket_id=" + ticket_id  
  
            flight_id = validTicket.getFlight().getFlightID();  
  
            try            {  
                System.out.println("Enter your First Name: ");  
                String firstName = "";  
                passenger.setFirstName(firstName);  
  
  
                System.out.println("Enter your Second name:");  
                String secondName = "";  
                passenger.setSecondName(secondName); //setting passengers info  
  
                System.out.println("Enter your age:");  
                Integer age = 0;  
                in.nextLine();  
                passenger.setAge(age);  
  
                System.out.println("Enter your gender: ");  
                String gender = "";  
                passenger.setGender(gender);  
  
                System.out.println("Enter your e-mail address");  
                String email = "";  
                passenger.setEmail(email);  
  
                System.out.println("Enter your phone number (+7):");  
                String phoneNumber = "";  
                passenger.setPhoneNumber(phoneNumber);  
  
                System.out.println("Enter your passport number:");  
                String passportNumber = "";  
                passenger.setPassport(passportNumber);  
  
                System.out.println("Do you want to purchase?\n 1-YES 0-NO");  
                int purch = in.nextInt();  
                if (purch == 0)  
                {  
                    return;  
                } else  
                {  
  
                    flight = FlightCollection.getFlightInfo(flight_id);  
  
                    int airplane_id = flight.getAirplane().getAirplaneID();  
  
                    Airplane airplane = Airplane.getAirPlaneInfo(airplane_id);  
  
                    ticket = TicketCollection.getTicketInfo(ticket_id);  
  
                    ticket.setPassenger(passenger);  
                    ticket.setTicket_id(ticket_id);  
                    ticket.setFlight(flight);  
                    ticket.setPrice(ticket.getPrice());  
                    ticket.setClassVip(ticket.getClassVip());  
                    ticket.setTicketStatus(true);  
                    if (ticket.getClassVip() == true)  
                    {  
                        airplane.setBusinessSitsNumber(airplane.getBusinessSitsNumber() - 1);  
                    } else  
                    {  
                        airplane.setEconomySitsNumber(airplane.getEconomySitsNumber() - 1);  
                    }  
  
                }  
                System.out.println("Your bill: " + ticket.getPrice() + "\n");  
  
                System.out.println("Enter your card number:");  
                String cardNumber = "";  
                passenger.setCardNumber(cardNumber);  
  
                System.out.println("Enter your security code:");  
                Integer securityCode = 0;  
                passenger.setSecurityCode(securityCode);  
  
  
            } catch (PatternSyntaxException patternException)  
            {  
                patternException.printStackTrace();  
            }  
        }  
    }  
  
    /**  
     *     * @param ticket_id_first  
     * @param ticket_id_second  
     * @throws Exception  
     */    @SuppressWarnings("null")  
    public void buyTicket(int ticket_id_first, int ticket_id_second) throws Exception{  
        //method for buying two tickets with transfer flight  
        int flight_id_first = 0;  
  
        int flight_id_second = 0;  
  
  
        System.out.println(ticket_id_first + " " + ticket_id_second);  
  
        Ticket validTicketfirst = TicketCollection.getTicketInfo(ticket_id_first);  
  
        Ticket validTicketSecond = TicketCollection.getTicketInfo(ticket_id_first);  
  
  
        System.out.println("Processing...");  
  
        //if there is a valid ticket id was input then we buy it, otherwise show message  
  
        if(validTicketfirst!=null || validTicketSecond!=null)  
        {  
            System.out.println("This ticket does not exist.");  
            return;        }  
  
        else  
        {  
            flight_id_first = validTicketfirst.getFlight().getFlightID();  
  
            flight_id_second = validTicketfirst.getFlight().getFlightID();  
  
  
            try            {  
                System.out.println("Enter your First Name: ");  
                String firstName = "";  
                passenger.setFirstName(firstName);  
  
  
                System.out.println("Enter your Second name:");  
                String secondName = "";  
                passenger.setSecondName(secondName); //setting passengers info  
  
                System.out.println("Enter your age:");  
                Integer age = 0;  
                in.nextLine();  
                passenger.setAge(age);  
  
                System.out.println("Enter your gender: ");  
                String gender = "";  
                //passenger.setGender(gender));  
  
                System.out.println("Enter your e-mail address");  
                String email = "";  
                passenger.setEmail(email);  
  
                System.out.println("Enter your phone number (+7):");  
                String phoneNumber = "";  
                passenger.setPhoneNumber(phoneNumber);  
  
                System.out.println("Enter your passport number:");  
                String passportNumber = "";  
                passenger.setPassport(passportNumber);  
  
                System.out.println("Do you want to purchase?\n 1-YES 0-NO");  
                int purch = in.nextInt();  
                if (purch == 0)  
                {  
                    return;  
                }  
                else  
                {  
  
                    //  "select * from flight, airplane where flight_id=" + flight_id_first + " and flight.airplane_id=airplane.airplane_id");  
                    Flight flight_first = FlightCollection.getFlightInfo(flight_id_first);  
  
                    int airplane_id_first = flight_first.getAirplane().getAirplaneID();  
  
                    Airplane airplane_first = Airplane.getAirPlaneInfo(airplane_id_first);  
  
                    Flight flight_second = FlightCollection.getFlightInfo(flight_id_second);  
  
                    int airplane_id_second = flight_second.getAirplane().getAirplaneID();  
  
                    Airplane airpairplane_second  = Airplane.getAirPlaneInfo(airplane_id_second);  
  
                    Ticket ticket_first = TicketCollection.getTicketInfo(ticket_id_first);  
  
                    Ticket ticket_second = TicketCollection.getTicketInfo(ticket_id_second);  
  
                    ticket_first.setPassenger(passenger);  
                    ticket_first.setTicket_id(ticket_id_first);  
                    ticket_first.setFlight(flight_first);  
                    ticket_first.setPrice(ticket_first.getPrice());  
                    ticket_first.setClassVip(ticket_first.getClassVip());  
                    ticket_first.setTicketStatus(true);  
  
                    if (ticket_first.getClassVip() == true)  
                    {  
                        airplane_first.setBusinessSitsNumber(airplane_first.getBusinessSitsNumber() - 1);  
                    } else  
                    {  
                        airplane_first.setEconomySitsNumber(airplane_first.getEconomySitsNumber() - 1);  
                    }  
  
                    System.out.println("--*-*-");  
  
                    ticket_second.setPassenger(passenger);  
                    ticket_second.setTicket_id(ticket_id_second);  
                    ticket_second.setFlight(flight_first);  
                    ticket_second.setPrice(ticket_second.getPrice());  
                    ticket_second.setClassVip(ticket_second.getClassVip());  
                    ticket_second.setTicketStatus(true);  
                    if (ticket_second.getClassVip() == true)  
                    {  
                        airpairplane_second.setBusinessSitsNumber(airpairplane_second.getBusinessSitsNumber() - 1);  
                    } else  
                    {  
                        airpairplane_second.setEconomySitsNumber(airpairplane_second.getEconomySitsNumber() - 1);  
                    }  
  
                    System.out.println("--*-*-");  
  
                    ticket.setPrice(ticket_first.getPrice() + ticket_second.getPrice());  
  
                    System.out.println("Your bill: " + ticket.getPrice() + "\n");  
  
                    System.out.println("Enter your card number:");  
  
                    String cardNumber = "";  
                    passenger.setCardNumber(cardNumber);  
  
                    System.out.println("Enter your security code:");  
                    Integer securityCode = 0;  
                    passenger.setSecurityCode(securityCode);  
  
                }  
            } catch (PatternSyntaxException patternException)  
            {  
                patternException.printStackTrace();  
            }  
        }  
  
    }  
  
    /**  
     *     * @param city1  
     * @param city2  
     * @throws Exception  
     */    public void chooseTicket(String city1, String city2) throws Exception  
    {  
        int counter = 1;  
        int idFirst = 0;  
        int idSecond = 0;  
  
        Flight flight = new Flight();  
  
        //search for direct flight from city1 to city2  
  
        flight = FlightCollection.getFlightInfo(city1, city2);  
  
  
        if(flight != null) {  
  
            TicketCollection.getAllTickets();  
  
            System.out.println("\nEnter ID of ticket you want to choose:");  
  
            int ticket_id = in.nextInt();  
  
            //validate ticker here  
  
            //buy ticket here            buyTicket(ticket_id);  
        }  
        else  
        //in case there is no direct ticket from city1 to city2  
        {  
            //SELECT a flight where depart_to = city2  
  
            Flight depart_to = FlightCollection.getFlightInfo(city2);  
  
            //and search for city with depart_from as connector city  
  
            String connectCity = depart_to.getDepartFrom();  
  
            //SELECT * from flight where depart_to = '" + connectCity + "' and depart_from = '" + city1+"'"  
  
            Flight flightConnectingTwoCities = FlightCollection.getFlightInfo(city1, connectCity);  
  
            if(flightConnectingTwoCities != null){  
  
                System.out.println("There is special way to go there. And it is transfer way, like above. Way №" + counter);  
  
                idFirst = depart_to.getFlightID();  
  
                idSecond = flightConnectingTwoCities.getFlightID();  
  
  
            }  
  
            counter++;  
  
            buyTicket(idFirst, idSecond); //pass two tickets and buy them  
  
            if(counter == 1)  
            {  
                System.out.println("There is no possible variants.");  
            }  
            return;  
        }  
  
    }  
}

```


### TicketCollection.java
here is the code inside TicketCollection.java:  
```java
package fit5171.monash.edu;  
  
import java.util.ArrayList;  
  
/*  
* 1. Whenever a ticket is being added to the TicketCollection, it must be validated.  
*  
2. When trying to get a ticket, the correct ticket is returned  
* */  
public class TicketCollection {  
     
   public static ArrayList<Ticket> tickets;  
  
   public static ArrayList<Ticket> getTickets() {  
      return tickets;  
   }  
  
   public static void addTickets(ArrayList<Ticket> tickets_db) {  
      TicketCollection.tickets.addAll(tickets_db);  
   }  
     
   public static void getAllTickets() {  
       //display all available tickets from the Ticket collection  
    }  
   public static Ticket getTicketInfo(int ticket_id) {  
       //SELECT a ticket where ticket id = ticket_id  
       return null;  
  
    }  
     
  
}

```
### FlightCollection.java
here is the code inside FlightCollection.java:  
```java
package fit5171.monash.edu;  
  
import java.util.ArrayList;  
  
/*  
* 1. When adding a flight into the system, test if  
* it conforms with the requirement as a flight and Flight Collection.  
*  
2. Valid city names must be used.  
*  
3. When trying to get flight information, a valid flight is returned  
* */  
public class FlightCollection {  
     
   public static ArrayList<Flight> flights;  
  
   public static ArrayList<Flight> getFlights() {  
      return flights;  
   }  
  
   public static void addFlights(ArrayList<Flight> flights) {  
      FlightCollection.flights.addAll(flights);  
   }  
     
   public static Flight getFlightInfo(String city1, String city2) {  
       //display the flights where there is a direct flight from city 1 to city2  
       return null;  
    }  
      
    public static Flight getFlightInfo(String city) {  
       //SELECT a flight where depart_to = city  
       return null;  
  
    }  
    public static Flight getFlightInfo(int flight_id) {  
       //SELECT a flight with a particular flight id  
       return null;  
  
    }  
      
  
}

```
## unit test
You will mock the external objects/functionalities, using a Java mocking library called mockito. The requirement of testing every class is under the validation chapter below.
### Validation
### Airplane.java
When some attribute of the airplane is being set, the following unit testing conditions need to be satisfied.
1. Ensure all fields/details for an airplane like Airplane ID, Airplane businessSitsNumber, crewSitsNumber, etc. are tested
2. Seat number must be in the range `[1, 300]`.
### Flight.java
When a flight is being added to the system, following conditions must be met.  
1. All fields are required.  Note: Mock the behaviour of the Airplane class while creating objects of the Flight class for unit testing.  
2. Date must be in DD/MM/YY format.  
3. Time must be in HH:MM:SS format.  
4. Ensure the same flight is not already in the system
### Person.java
When a person is being created or returned, test following:  
1. All fields of a Person class are required to create a person.  
2. The gender field has following options ‘Woman’, ‘Man’,’Non-binary|gender diverse’, ‘Prefer not to  say’ and ‘Other’.  
3. The first name and last name should not start with a number or symbol and can contain only small case and upper-case alphabet letters.
### Passenger
When a passenger is being created or returned, test following:  
1. All fields of a passenger are required.  Note: Mock the behavior of the Person class while creating objects of the Passenger class for  unit testing.  
2. Phone number follows a pattern. Within Australia, mobile phone numbers begin with 04 or 05 – the Australian national trunk code" 0, plus the mobile indicator 4 or 5, then followed by eight  digits. This is generally written as 04XX XXX XXX within Australia or as +61 4XX XXX XXX for an  international audience.  
3. The email follows a valid pattern “abc@domain.com”.  
4. The passport number should not be more than 9 characters long.  
5. When a passenger is being added, it must include the passenger’s First name, Last Name, age, and gender following the person who is becoming a passenger

### Ticket.java
When a ticket is being created, it needs to satisfy the following conditions.  
1. Values for the ticket status must be ‘True’ or ‘False’ for the booked and available tickets respectively.  
2. Discount is always applied based on the age category of the passenger.  
3. Price is always applied to a ticket.  
4. The price and service tax is a valid value (Integer or real numbers etc.)  
5. The service tax is always applied when a ticket is sold. Note: Mock the behavior of the Flight and Passenger class, while creating objects of the Ticket  class for unit testing.  
6. Test that Ticker class received valid information of flight and passenger.
### TicketSystem.java
1. When choosing a ticket, a valid city is used.  
2. If a passenger chooses an already booked ticket it should display an error message.  
3. Appropriate checks have been implemented to validate passenger information  
4. Appropriate checks have been implemented to validate flight information  
5. Appropriate checks have been implemented to validate ticket information  
6. A correct value is displayed to the passenger when buying a ticket.
### TicketCollection.java
1. Whenever a ticket is being added to the TicketCollection, it must be validated.  
2. When trying to get a ticket, the correct ticket is returned
### FlightCollection.java
1. When adding a flight into the system, test if it conforms with the requirement as a flight and Flight Collection.  
2. Valid city names must be used.  
3. When trying to get flight information, a valid flight is returned.

## pipeline
[tutorials / Java Maven Junit CI Helloworld · GitLab](https://gitlab.bio.di.uminho.pt/tutorials/java-maven-junit-ci-helloworld)  
[Tutorial: Create and run your first GitLab CI/CD pipeline | GitLab](https://docs.gitlab.com/ee/ci/quick_start/#ensure-you-have-runners-available)  

# assignment 2
## dependcy
[Java Downloads | Oracle](https://www.oracle.com/java/technologies/downloads/#java11-windows)  
[Download | SonarQube | Sonar](https://www.sonarsource.com/products/sonarqube/downloads/)  
[PostgreSQL Community DL Page](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)  
[Quickstart for maven users](https://pitest.org/quickstart/maven/)  

## setup 
1. install and set environment path for jdk17 to build up sonar server
2. install PostgreSQL and setup Create User from PgAdmin username=sonarqube password=12345678 Create table sonarqube
3. open /sonarqubefolder/conf/sonar.propertiesfiles add `sonar.jdbc.username=sonarqube sonar.jdbc.password=12345678 sonar.jdbc.url=jdbc:postgresql://localhost/sonarqube`  under `# User credentials.`  
4.  [Try out SonarQube](https://docs.sonarqube.org/latest/try-out-sonarqube/) follow the instruction to execute the analysis report for your project 



