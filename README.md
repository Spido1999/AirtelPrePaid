# AirtelPrePaid
This repository contains the code for Airtel's prepaid customer portal. The portal allows customers to manage their prepaid accounts, select plans, add-on features, and more

User Stories
User Story 1: Search for Available Plans
•	Endpoint: GET /api/plans
•	Description: Customers can search for available prepaid plans.
•	Example Data:
•	Plan name: "Airtel-Basic"
•	Cost: 1000 RS
•	Details: 100 SMS, 500 calls, 5 GB


User Story 2: Top-Up with Selected Plan
•	Endpoint: POST /api/Craete
•	Description: Customers can top up their accounts with a selected plan.


User Story 3: Search for Add-On Features
•	Endpoint: GET /api/addOn
•	Description: Customers can search for available add-on features.
•	Example Data:
•	Feature 1: 10 GB data, Cost: 500 RS
•	Feature 2: 100 SMS, Cost: 1000 RS
•	Feature 3: 100 GB data, Cost: 2000 RS


User Story 4: Top-Up with Selected Add-Ons
•	Endpoint: POST /{customerId}/add-addOn
•	Description: Customers can top up their accounts with selected add-on features.


User Story 5: Remove Add-On Feature
•	Endpoint: POST /{customerId}/remove-addon
•	Description: Customers can remove add-on features from their accounts.


Project Details
•	Technology Stack: Spring Boot 3, Maven, Java 17
•	Database: You can use any database of your choice.
•	Code Coverage: Aim for 80% code coverage, and you can use the Jacoco plugin in your pom.xml.
•	Integration Testing: It's recommended to have integration tests using mockmvc.


Controllers
Plan Controller
•	Endpoint: /api
•	Description: Manages prepaid plans.
•	Endpoints:
•	GET /api/plans: Get all plans.
•	POST /api/Craete: Create a new plan.
•	GET /api/getPlan: Get plan by name or ID.
•	PUT /api/updatePlan/{planId}: Update a plan.
•	DELETE /api/deletePlan/{planId}: Delete a plan.

Add-On Controller
•	Endpoint: /api
•	Description: Manages add-on features.
•	Endpoints:
•	GET /api/addOn: Get all add-on features.
•	POST /api/addAddOn: Add a new add-on feature.
•	GET /api/getAddOn: Get add-on feature by name or ID.
•	PUT /api/updateAddOn/{addOnId}: Update an add-on feature.
•	DELETE /api/deleteAddOn/{addOnId}: Delete an add-on feature.

Customer Controller
•	Endpoint: /api
•	Description: Manages customer accounts and interactions.
•	Endpoints:
•	GET /api/getAllCustomer: Get all customers.
•	POST /api/createCustomer: Create a new customer.
•	PUT /api/update/{customerId}: Update customer information.
•	DELETE /api/delete/{customerId}: Delete a customer.
•	POST /{customerId}/select-plan: Select a plan for a customer.
•	POST /{customerId}/add-addOn: Add an add-on feature for a customer.
•	POST /{customerId}/remove-addon: Remove an add-on feature for a customer.


API Documentation
•	Please provide API contract details using Swagger, Postman, or any other documentation tool.
Security
•	I have implemented JWTfilter in the filter package this the basic filter which will check if the accessing ApI is properly Authenticated or not.
•	Project Setup
•	Follow the guidelines below to set up the project:
•	Clone this repository.
•	Configure your database.
•	Build the project using Maven.
•	Run the application.
