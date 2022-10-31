# banking_project
## Junjie Tan 

### Overview
this project is backend of banking app, which is designed to fetch data from MYSQL Database and exposing data using RESTFUL API, also performing a Mockito test.

##### Feature
* add an Account
* read all an Account
* update Account
* delete Account

this process would also be proformed on the customer table as well if wanted futher detail try looking into the images file it will have the other test done using the CustomerController or service.

##### Project structure 
<p align="center">
	<img src="images/Screenshot (74).png" width="900px" height="600px">
</p>

### Database
below is an ERD diagram for the database table which will show the one to many and many to one relation from Account to Customer 
<p align="center">
	<img src="iamges/Screenshot (57).png" width="900px" height="600px">
</P>
this image shows the relationship of each table, which is designed so one customer would have many accounts.

### Executing
using Postman using CRUD
this method stand for Create, Read, Update,Delete.  

### Add Account
<p align="center">
	<img src="images/addaccount.jpg" width="900px" height="600px">
</p>
this is the Add account request which is called addAccount to create new account using Postman and add to MySQL data base, the addAccount is a PostMapping 

### Delete Account
<p align="center">
	<img src="images/delete_account.jpg" width="900px" height="600px">
</p>
it show that by using delete in Postman request the account has being removes from Account Databas which use the deleteAccount DeleteMapping in STS. 

### Update account. 
this is an put request under Postman which use to update entry in the account table 
<p align="center">
	<img src="images/update_account.jpg" width="900px" height="600px">
</p>
this image show the update request generated using Postman using the PutMapping in STS which updates MySQL account Database which can be use to change or add information. 

 ### ReadAll Account. 
 this is an get request in Postman that directly extract information in the table 
 
<p align="center">
	<img src="images/Screenshot (66).jpg" width="900px" height="600px">
</p> 
this is a getMapping in STS which the response was unable to generate all the information in the database, but it can be view in a browser using localhost:8080/addAccount

### JUNIT testing CustomerController test
<p align="center">
	<img src="images/Screenshot (71).jpg" width="900px" height="600px">
</p> 

this test is used to check the rest controller is initialised

### CRUDE test
the main purpose of this test is to create a automation Database which contain some data which allow the test to be perform while not effecting any MySQL data, in this test it is require to creat the a src/test/sql and project.sql file which contain some data, 
<p align="center">
	<img src="images/Screenshot (77).png" width="900px" height="600px">
</p> 
the reason the test failed was due to the data wasn't CRUD input in the AccountIntergration used to test the service was wrong causing a failure rather than an error which suggest that the test code was causing the issue, but i can manully add to the MySQL database which suggest i didn't connect to the java h2 Database properly which causes the issue.
<p align="center">
	<img src="images/Screenshot (78).png" width="900px" height="600px">
</p> 
which turns out it was add to my main Account database instead. 
<p align="center">
	<img src="images/Screenshot (79).png" width="900px" height="600px">
</p> 
after futher test only two out of the four test works with the account integration test code

### Instruction for executing project
there are a few thing that are very important and has to be constantly aware of, for example:

* Excuting sts, make sure to refreshing MySQL droping the Account and Customer Table before Executing of restarting STS, this is to ensure that the port wasn't repeatly used and cause compiling error.
* Esure never repeatativtly runing spring boot application. setting the server port in the application.properties.
* beware of the when naming the entity because STS, Postman and MySQL they unbelievably case senitive so one wrong letter will drive you mad makesure to check the entity name in sql before making a request.
* always run application on spring boot app rather than Java Application  

### Code for addAccount in Postman
{
    "accountBalance": 450,
    "accountName": "jason account",
    "numAccount": 2
}

### request for deleting account
localhost:8080/deleteAccount/1

### update Account 
localhost:8080/updateAccount/2
{
    "accountBalance": 450,
    "accountName": "jason account",
    "numAccount": 2
}

### read all account 
localhost:8080/allAccount
### CRUDE test insert command 
INSERT INTO `account` (Account_Balance, Num_Account, Account_Name) VALUES (2,234567,'kate' ),(23,2345672,'james'),(2000,234567,"john");

### manu sql entery
INSERT INTO project.account (Account_Balance, Num_Account, Account_Name) VALUES (2,234567,'kate' ),(23,2345672,'james'),(2000,234567,"john");



###### Future Revisions
in future i would like to practise adding images and write more README file to make sure i could get better at it. also i want to make sure make sure that i fix the issue with the my Mockito CRUD test to properly add the data into MySQL manually. in addition to do all the other things i also want to consider linking account to Account Balance creating a third table so it would contain withdraw and depositing money in a new table. i have also consider try to get other response in Postman for example in add a querry in my STS but i was never able to test it out.

you can check the code in the src main file in this git hub repository 


### Tool used :
* java
* sprint BOot (STS4)
* MySQL
* Maven
* GitHub
* git

