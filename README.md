# banking_project
project new
Overview
this project is backend of banking app, which is designed to fetch data from MYSQL Database and exposing data using RESTFUL API

Feature:-
* add an Account
* read all an Account
* update Account
* delete Account
this process would also be proformed on the customer table as well

the structure of the table 
<p align="center">
	<img src="image/screenshot(72).png" width="100px" height="100px">
</p>


### Database 
*below is an ERD diagram for the database table which will show the one to many and many to one relation from Account to Customer 
<p align="center">
	[Screenshot (76)](https://user-images.githubusercontent.com/111970129/198662259-6419dd6c-1671-4332-8fc9-89f09ba54da0.png)
="image/
</P>
the image is unable to upload due to some issues but i try uploading by dragging into the the README file try to upload it this way, but it you want to view the image is Screenshot (76) in the images file. 

##### Executing
using Postman using in CRUD
this method stand for Create, Read, Update,Delete. 
befor continue, there are a few thing has to be done constantly, for example Excuting sts, refreshing MySQL droping the Account and Customer Tabel constanting before Executing of runing STS also never repeatativtly runing spring boot application as it will use the same port and casue a error. also make sure port 8080 is always available.   
### Add Account.
<p align="center">
	<img src="image/addaccount.jpg" width="100px" height="100px">
</p>
image is is uable to load for some reason but the image is contain in the images file named addaccount.jpg. it show and account has being add from the resopens from Postman and MySQL data base.
### delete account
<p align="center">
	<img src="image/delete_account.jpg" width="100px" height="100px">
</p>
it show that by using delete in Postman request the account has being removes from Account Databas which while using this request 
### update account 
this is an put request under Postman which use to update entry in the account table 
<p align="center">
	<img src="image/update_account.jpg" width="100px" height="100px">
</p>
the image can be find in the image file for some reason is unable to properly showed but if more information is need the iamge is named update_account 
 ### readAll Account 
 this is an get request in Postman that directly extract information in the table but the problem of this request is that it can only be view using a localhost:8080/addAccount in an web browser
<p align="center">
	<img src="image/Screenshot(76).jpg" width="100px" height="100px">
</p> 
##### Juint testing 
CustomerController test
<p align="center">
	<img src="image/Screenshot(71).jpg" width="100px" height="100px">
</p> 

this test is used to check the rest controller is initialised

### CRUDE test 
this is a test that create a 




tool used:
*java
*sprint BOot (STS4)
*MySQL
*Maven
*GitHub
*git
