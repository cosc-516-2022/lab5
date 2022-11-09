[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=8655188&assignment_repo_type=AssignmentRepo)
# COSC 516 - Cloud Databases<br/>Lab 5 - Microsoft Azure Cosmos DB

## Setup
Create a Azure free tier account at: [https://azure.microsoft.com/en-us/free/](https://azure.microsoft.com/en-us/free/).

The free tier account allows for free trials forever and 12-months free offers from your sign up period. You will need an email address to use. The sign-up also asks for a credit card. If you do not have a credit card, then a pre-paid credit card with a small amount should work.

## Azure Portal
Login to Azure. In the Azure Portal, click on `More services` then select `Databases` category. Select `Azure Cosmos DB` and click `Create`.
<img src="img/1_azure_portal.png" alt="Azure Portal" width="800">
<img src="img/2_azure_cosmos_db.png" alt="Azure Cosmos Databases" width="800">

## Create Azure Cosmos DB Account
Select first option with `Azure Cosmos DB NoSQL` and click `Create`. 
<img src="img/3_azure_cosmos_db_apis.png" alt="Create Azure SQL DB account" width="800">

For `Resource group`, use existing or click `Create new` and use name `rg516`.
<br>
For `Account name` use something like `cosc516`. This name will be used as part of the DNS address for requests - so it must be unique.
<br>
For `Location` select `(US) West US`.
<br>
For `Capacity mode` select `Provisioned throughput`.
<br>
For `Apply Free Tier Discount` select `Apply`.
<br>
Check `Limit total account throughput` to avoid unexpected charges.
<br>
Click `Review + create` or explore remaining configurations and then create.
<img src="img/4_create_account_basics.png" alt="Create Azure Cosmos DB" width="800">

After deployment is complete, click `Go to resource`.
<img src="img/5_deployment_complete.png" alt="Deployment Complete" width="800">

## Configure Azure Cosmos DB Account
### Replicate data globally
Under settings in the left side menu, click `Replicate data globally`.
<br>
Set Configure regions Multi-region writes to `Enabled`
<img src="img/6_enable_multi_region_writes.png" alt="Enable Multi-region Writes" width="800">

Select another region to add to the Cosmos DB account.
<br>
Click `Save`.
<img src="img/7_add_region.png" alt="Add Region" width="800">
<br>

### Default consistency
Under settings in the left side menu, click `Default consistency`.
<br>
Select the `Bounded Staleness` consistency level.
<img src="img/8_bounded_staleness.png" alt="Replicate Data Globally" width="800">
<br>
Set `Maximum Lag (Time)` to `1 day`.
<br>
Set `Maximum Lag (Operations)` to `100000`.
<br>
Click `Save`.
<img src="img/9_default_consitency.png" alt="Default Consistency" width="800">
<br>

## Create the Database
From the Cosmos DB account home page, click `Data Explorer` in the left side menu.
<br>
Click the down arrow beside `New Container` and select `New Database`
<img src="img/10_new_database.png" alt="New Database" width="800">
<br>

Use `cosmos516` for the Database id.
<br>
Leave `Provision throughput` selected.
<br>
For throughput, select `Manual` and provision the database with `500 RU/s`.
<img src="img/11_create_database.png" alt="New Database" width="800">
<br>

## Create the Customer Container
First, set Database Max RU/s to 0 and ensure the `OK` button is activated.
<br>
For Database id, select `Use existing` and use `cosmos516`
<br>
For Container id, use `customer`.
<br>
For Partition key, use `/c_custkey`.
<br>
Click `OK`
<img src="img/12_create_customer_container.png" alt="Create Customer Container" width="800">

## Create the Orders Container
First, set Database Max RU/s to 0 and ensure the `OK` button is activated.
<br>
For Database id, select `Use existing` and use `cosmos516`
<br>
For Container id, use `orders`.
<br>
For Partition key, use `/o_custkey`.
<br>
Click `OK`
<img src="img/13_create_orders_container.png" alt="Create Orders Container" width="800">

## Tasks
To test your database, write Java code using VS Code. The file to edit is `CosmosDB.java`.  The test file is `TestCosmosDB.java`.  Fill in the methods requested (search for **TODO**).  Marks for each method are below.  You receive the marks if you pass the JUnit tests AND have followed the requirements asked in the question (including documentation and proper formatting).

- +1 mark - Write the method `connect()` to make a connection to the database.
- +2 marks - Write `drop()` to drop the containers from the database. 
- +4 marks - Write `load()` to recreate containers and load the data into the database.
- +2 marks - Write `query1()` to get customer by custkey.
- +3 marks - Write `query2()` to get number of customers in each market segment.
- +4 marks - Write `query3()` to get all urgent orders placed on or before July, 26, 1998 ordered by total price descending.
- +5 marks - Write `query4()` to get a customer and all orders by custkey.

**Total Marks: 20**

## Bonus Marks: (up to 2)
Up to +2 bonus marks for demonstrating some other feature of Cosmos DB.

## Submission
The lab can be marked immediately by the professor or TA by showing the output of the JUnit tests and by a quick code review.  Otherwise, submit the URL of your GitHub repository on Canvas. **Make sure to commit and push your updates to GitHub.**