# WIX1002 Fundamentals of Programming Assignment Project
**Project 3: Cinema Online Ticketing System**

**Tutorial Group: Group 5**

**Lecturer Name: Dr Nor Badrul Anuar bin Juma'at**

**Group Members :**

| **Name**                     | **Matric Number** |
| ---------------------------- | ----------------- |
| Iwan bin Amri                | S2132443          |
| Muhammad Idzhans Khairi      | U2000735          |
| Nor Aniq Haqym bin Nor Azman | S2132561          |
| Rifqi Fahim bin Rohanan      | U2000883          |
| Afiq Danish bin Affindi      | U2001419          |

# Technical Report
Project 3: Cinema Online Ticketing System

For this project, we will need to do a technical report (this report) and a managerial report. The project will be evaluated in three sections, the basic requirements, extra features and the reports.

## 1. Requirements and Explanation of the assigned project
### A. Introduction

Golden Screen Cinema (GSC) is a multiplex cinema chain and Malaysia's leading online cinema. However, due to the COVID-19 pandemic, GSC has been closed for nearly a year. Two previous attempts at reopening were both cancelled after new waves of coronavirus revealed that the government had failed to contain the outbreak. 

With the national immunisation programmes launched to curb the spread of COVID-19, 85 per cent of the adult population in the country has completed their COVID-19 vaccination, so the reopening of the cinema has been reconsidered. 

The Ministry of Health has given GSC permission to operate in states that are in phase one of the national recovery plan as of September 9, 2021. According to the SOP, cinemas will operate with a 50% seating capacity in the screening halls to ensure social distancing. As the food and beverages over the counter are not allowed, all F&B will have to be purchased online, and the cinema will only admit fully vaccinated guests aged 18 and above.

### B. Problem Statement

As the GSC software engineer team, you will need to implement the current SOP into the cinema’s online ticket booking system. The cinema ticket booking system will allow customers to purchase tickets and place food orders. Customers who order food online can collect them before entering the theatres.

### C. Basic Features

**1. Customer**
 + Showtimes
   * The system should display all the movies that are available. The customer can look up information about the movie (release date, casts, synopsis)
 + Book now
   * Select your preferred movie, day, time, and seat (available/unavailable). Seats that have been selected cannot be chosen. 
   * Implement social distancing for the seat (guests from the same family and residence are allowed to sit in pairs)
   * The system should display the ticket price.
 + Food & Beverages
   * The system displays all the F&B options and pricing.
 + Payment
   * The total expenses.
   * The system can only accept credit/debit card payments, practically eliminating any risk of having to deal with matters like tracking down the customer to properly pay for the tickets or food.
 + Ticket
   * The system will display the movie ticket (seat, hall, movie, timing)
**2. Staff**
 + Movie
   * The system enables the staff to add or remove the movie. The movie’s showtimes (day, time) can be added by the staff.
 + Seat
   * The system allows the staff to edit seat capacity according to each theatre of a different capacity.
 + Payment
   * The system allows the staff to set the price for the movie. The movie has varied price levels depending on the class (Student price, Classic, Premium).
 + Food & Beverages
   * The system allows the staff to add the food & beverages options and prices.
   
**Other requirements:**

**1. Login (Registration & Authentication)**
- A new customer can create a new account by providing some info such as email address, password, phone number, and name to create a GSC account.
- New staff can create a new account by providing some info such as email address, staff ID, password, full name, etc.
- Existing customers and staff can log in to the application by entering their login credentials (email and password).
- All the credentials should be kept in a secure location (offline or online). The users’ data should not vanish after each reboot.

### D. Sample Input & Output (CLI)

![image1](https://github.com/AfdaPrime/CineBook/blob/f48a9e8a69936f806b95fdf38a016dd8767e9512/sample%20input%20output%201.PNG)

![image2](https://github.com/AfdaPrime/CineBook/blob/f48a9e8a69936f806b95fdf38a016dd8767e9512/sample%20input%20output%202.PNG)

### E. Extra features
1. Implement GUI
- Humans love graphical interfaces, don’t they? Try to implement a graphical user interface and design it using your own ideas! There are a lot of tutorials and guidelines all over the internet. Don’t limit yourself to the lecture notes.
2. Database
- Well, to be honest, no one stores credentials in plain text files, especially for the GSC cinema ticketing booking system.
3. Payment with E-wallet
- Nowadays, everyone uses an E-wallet to pay for goods and services. Customers will appreciate it if you simplify the payment process by eliminating the need for them to enter their credit/debit card number and security code. Instead, they will scan and pay for the ticket.
4. Notification
- We are all preoccupied with our work or lives that we often forget about the event we planned for the next day. So, it is cool that the system can send notifications to the customer's email.
5. Download Ticket
- It is more convenient for the customer to download the ticket on their device and show it to the GSC staff before entering the theatres.
6. QR code E-ticket
- The QR code can store any type of information within the square code. This enables the GSC staff to examine the ticket, whether it is authenticated or not.

## Approaches
**The project will be separated into several parts**
1. Login and sign up of both customer and staff.
2. GUI (Graphical User Interface)
3. Database
   + Database for login and sign up(registration & authentication)
   + Database for movies list / movies branch
   + Database for hall seats / seat status
   + Database for booking data 
   + Database for movie ticket pricing
   + Database for F&B pricing
4. Payment
5. QR Code E - ticket
6. Email notification

As you can see we have added a few extra features such as a implementing a GUI, database, payment with E-wallet, notification and QR code E-ticket.

**Login and Sign Up**

Firstly, we decided to use a graphical interface for the login and sign up page which has to types which are the customer's site and the staff's side both of which can login or register their accounts in their respective pages. If the account exist then users can proceed from the login page and onwards to the next phase. If not then, users will have to make a new account in the sign up section. This applies for both customers and staffs. We store the accounts by using a database called Apache Derby which will be explained further in the database section.

**GUI (Graphical User Interface)**

We set up our GUI by using JavaFX to create the interfaces. However, during our process we had difficulties as we were not familiar with JavaFX. Thus, we had to look up and learn from online references from websites such as 'Stack Overflow', 'Tutorialspoint' and 'W3Schools'. In addition to that, we also learned from Youtube videos that are readily available on how to configure the JavaFX into Netbeans. The GUI covers a large part of the visible part of our program as it is what users are able to interact with. For the customers the GUI covers the login and sign up, movie showtimes, booking seats parts, buying food & beverages, payment and ticket display. while for the staff it the GUI covers login and sign up, movie add/remove, seating editor, payment price and food & beverages price.

**Database**

For the database we used Apache Derby to run our database. We also had difficulties in setting up adatabase because most of us are not familiar with implementing databases in projects. To solve that problem, we tried to learn the basic concepts from a website called 'homeandlearn'. We also used a few Youtube videos to configure the database. The database is basically the foundation of our program as it is used in almost all parts of our program. For example, login & sign up, movies list / movies branch, hall seats / seat status, booking data, movie ticket pricing and F&B pricing.

**Payment**

For payment we did payment with E-wallet which requires only a scan from QR code. There is no need to type in your credit/debit card number and security code. This we used JavaFX and zxing to create the QR code.

**QR Code E-ticket**

We used JavaFX and zxing to create our QR code. This we got from a Java-Buddy blogspot which explains on how to use zxing and produce our QR code. 

**Email notification**

We used java.mail properties to connect with gmail server for password and email username authentication, and then we send text about movie ticket information and attached with the the Qr code to the customer's email

## Description for the soulution

### Modules
1. App
   + Consists of GUI, payment methods, QR code generator
2. Database
   + Consists of database
4. SendEmail
   + Send notification to customer emails
5. loginandsignup
   + Login and sign up of customers and staffs

### Classess
**1.App**
+ FoodCourt.java
  - GUI for F&B items
+ JavaFX_QRCodeWriter.java
  - QR code generator
+ Main.fxml
  - Early stage of GUI
+ Main.java
  - Early stage of GUI to enter the movie selector area 
+ Payment.java
  - Payment for movie tickets and f&b
+ contoller.java
  - Control to go to other pages
+ dateSelector.java
  - Select the dates for movies
+ describtion.java
  - Movie descriptions
+ picker.java
  - Pick which movie to watch
+ seat.java
  - Select seats 
+ topBar.java
  - The top bar of the GUI

**2. Database**
+ Choose_Seats.java
  - Choose the seating for the movie
+ DBConnect.java
  - test class (for testing the connection to database purposes)
+ DeleteData.java
  - To delete any data in the database
+ Login.java
  - For login of customer and staff
  - Will compare the information entered with what exists
+ MakeSeats.java
  - Make seats and halls for movies
+ Signin.java
  - For customer and staff
  - Make new accounts for customers or staff
  - Will not accept overlapping information
+ UpdateData.java
  - Update any existing acounts information
+ test.java
  - test class

**3. SendEmail**
+ SendEmail.java
  - Send a notification to the email of the customer that scans the given QR code
+ text.java
  - Sends a text with the email

**4. loginandsignup**
+ Login.java
  - The start of the login & sign up GUI
+ LoginFXMLController.java
  - GUI for the customer login page
  - Will redirect to the main.java in App package if login is successful
  - Will go to SignUpFXMLController.java if sign up button is pressed
  - Will got to StaffLoginController.java if staff button is pressed
+ SignUpFXMLController.java
  - GUI for the sign up page
  - Will get the sign up info to create new account
  - Will return to LoginFXMLController.java if return button is pressed
+ StaffEditorController.java
  - Staff can add/remove movie, edit seats, change prices of tickets and f&b
+ StaffLoginController.java
  - GUI for the staff login page
  - Will redirect to the StaffEditorController.java if login is successful
  - Will go to StaffSignUpController.java if sign up button is pressed
  - Will return to LoginFXMLController.java if return button is pressed
+ StaffMovieController.java
  - Can add/remove movies here
+ StaffSignUpController.java
  - GUI for the staff sign up page
  - Will get the sign up info to create new staff account
  - Will return to StaffLoginController.java if return button is pressed


## Flowchart
![image3](https://github.com/AfdaPrime/CineBook/blob/f48a9e8a69936f806b95fdf38a016dd8767e9512/Assignment%20FOP%20Flowchart1.drawio.png)

![image4](https://github.com/AfdaPrime/CineBook/blob/b1c93bf30162f32a5cead725e8fd577b5e0f83c6/Assignment%20FOP%20Flowchart.drawio%20(1).png)

## Sample Output
![image5](https://github.com/AfdaPrime/CineBook/blob/1f3e2704ab242c72ffb7ff11c06c784173973cb9/output%201.jpeg)

![image6](https://github.com/AfdaPrime/CineBook/blob/1f3e2704ab242c72ffb7ff11c06c784173973cb9/output%202.jpeg)

![image7](https://github.com/AfdaPrime/CineBook/blob/1f3e2704ab242c72ffb7ff11c06c784173973cb9/output%203.jpeg)

![image8](https://github.com/AfdaPrime/CineBook/blob/1f3e2704ab242c72ffb7ff11c06c784173973cb9/output%204.jpeg)

![image9](https://github.com/AfdaPrime/CineBook/blob/1f3e2704ab242c72ffb7ff11c06c784173973cb9/output%205.jpeg)

![image10](https://github.com/AfdaPrime/CineBook/blob/1f3e2704ab242c72ffb7ff11c06c784173973cb9/output%206.jpeg)

![image11](https://github.com/AfdaPrime/CineBook/blob/1f3e2704ab242c72ffb7ff11c06c784173973cb9/output%207.jpeg)

![image12](https://github.com/AfdaPrime/CineBook/blob/1f3e2704ab242c72ffb7ff11c06c784173973cb9/output%208.jpeg)

![image13](https://github.com/AfdaPrime/CineBook/blob/1f3e2704ab242c72ffb7ff11c06c784173973cb9/output%209.jpeg)

# Managerial Report
**1.	The formation of the team**

Our team consists of five members, leader is Iwan Bin Amri and members are Muhammad Idzhans Khairi, Nor Aniq Haqym bin Nor Azman, Afiq Danish bin Affindi and Rifqi Fahim bin Rohanan. We formed our group by filling up our names in the grouping spreadsheet Dr. Badrul had prepared. Though none of us knew each other, we managed to cooperate with one another over time. The leader was selected after the topic of the assignment was determined. Iwan was elected leader because he had done a similar assignment during foundation which could act as a guideline on what needs to be done. Thus the group was formed and the workload was split up.

**2.	Role and assigned work for each of the members**

| **Group Member**             | **Role**                              |
| ---------------------------- | ------------------------------------- |
| Iwan bin Amri                | Leader, Sub-programmer, Report writing|
| Afiq Danish bin Affindi      | Lead-programmer, Project tester       |
| Muhammad Idzhans Khairi      | Lead-programmer, Project tester       |
| Nor Aniq Haqym bin Nor Azman | Sub-programmer, Report writing        |
| Rifqi Fahim bin Rohanan      | Sub-programmer, Report writing        |

|  **Group Member**            | **Assigned work**                      |
| ---------------------------- | -------------------------------------- |
| Iwan bin Amri                | Payment method, Qr-code, Report writing|
| Afiq Danish bin Affindi      | F&B purchase, Main java file, GUI      |
| Muhammad Idzhans Khairi      | Database, Movie booking                |
| Nor Aniq Haqym bin Nor Azman | Login and Register, GUI, Report writing|
| Rifqi Fahim bin Rohanan      | E-mail Notification, Report writing    |

**3. Project Timeline**

![Gantt Chart](https://github.com/AfdaPrime/CineBook/blob/main/gantt.png)

**4.	Problems and Solutions**

Problems Faced during the project
```
-	The online learning environment made it hard to get to know each other making cooperation among the group members difficult.

-	Difficulty in keeping track of each group members progress

-	The java programs written by each member could only be run on their own computers because of the libraries and programs required and different directories used. This made some of the earlier versions of the code written by members incompatible with the main program.

-	In order to fulfil the extra features we needed to study more in java topics that are not covered in class such as databases, GUI, QR-code and email-notifications.

-	Difficulty in contacting and meeting each other because 2 of the members do not live on campus and the rest do.

```

Solutions
```
-	We created a WhatsApp group to discuss and distribute the tasks as well as contact each other about the project.

-	We created a GitHub repository so we could keep track of the progress in the project as well as pull the project files that are uploaded by the members.

-	We did research on the extra features by looking up how to do them online

-	We compiled the entire project on persons laptop in order to have the full working program in one place, rather than each person having one part of the project working.

```

**5.	Other Issues**

-	The database for the project is not an online database and only works on our local machine.
-	Only the members on campus were able to do project testing as they had the laptop with the fully working program.

# Source Code
