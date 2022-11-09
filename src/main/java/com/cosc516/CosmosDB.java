package com.cosc516;

import java.io.FileNotFoundException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import com.google.gson.Gson;
import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.CosmosDatabase;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.azure.cosmos.models.ThroughputProperties;
import com.azure.cosmos.util.CosmosPagedIterable;

public class CosmosDB {
	/**
	 * Cosmos DB endpoint
	 */
	// TODO: Fill in your Cosmos DB URI
	private static final String URI = "";

	/**
	 * Cosmos DB primary key
	 */
	// TODO: Fill in your Cosmos DB primary key
	private static final String PRIMARY_KEY = "";

	/**
	 * Cosmos DB client
	 */
	private CosmosClient cosmosClient;

	/**
	 * Cosmos DB database
	 */
	private CosmosDatabase cosmosDatabase;

	/**
	 * Cosmos DB containers
	 */
	private CosmosContainer customerContainer;
	private CosmosContainer ordersContainer;

	/**
	 * Main method
	 * 
	 * @param args
	 *             no arguments required
	 */
	public static void main(String[] args) throws Exception {
		CosmosDB qcosmos = new CosmosDB();
		try {
			qcosmos.connect();
			qcosmos.drop();
			qcosmos.load();
			qcosmos.sampleQuery(1337);
			qcosmos.query1(14694);
			qcosmos.query2();
			qcosmos.query3();
			qcosmos.query4(515);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			qcosmos.close();
		}
	}

	/**
	 * Connects to Azure Cosmos DB and returns the client.
	 * 
	 * @return
	 *         CosmosClient
	 */
	public CosmosClient connect() throws Exception {
		// TODO: Connect to Azure Cosmos DB
		System.out.println("\nConnecting to database.");

		return cosmosClient;
	}

	/**
	 * Closes connection to the database.
	 */
	public void close() {
		// TODO: Close the connection to the database
		System.out.println("\nClosing connection.");

	}

	/**
	 * Drops the containers from the database. Handle errors if containers do not
	 * exist.
	 * 
	 * @throws Exception
	 */
	public void drop() {
		// TODO: Drop all containers
		System.out.println("\nDropping all containers.");

		// Delete the customer container

		// Delete the orders container

	}

	/**
	 * Loads data into database.
	 * 
	 * @throws FileNotFoundException
	 */
	public void load() throws Exception {
		// TODO: Recreate each container and load them with data
		System.out.println("\nLoading Data.");
		Gson gson = new Gson();

		try {
			// Read customer data
			System.out.println("Reading customer data.");
			Reader reader = Files.newBufferedReader(Paths.get("src/data/customer.json"));
			Customer[] customers = gson.fromJson(reader, Customer[].class);

			// Create customer container and load data
			System.out.println("Loading customer data.");
			cosmosDatabase.createContainerIfNotExists("customer", "/c_custkey",
					ThroughputProperties.createManualThroughput(400));
			customerContainer = cosmosDatabase.getContainer("customer");
			for (Customer customer : customers) {
				customer.setId("" + customer.getC_custkey());
				customerContainer.createItem(customer);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		// TODO: Read the order data. Need to create an Order class to represent JSON
		// document. See Customer.java as an example.

	}

	/**
	 * Sample query returns customer by custkey
	 * 
	 * @throws Exception
	 *                   if an error occurs
	 */
	public String sampleQuery(int custkey) throws Exception {
		// TODO: Write query #1
		System.out.println("\nExecuting query1.");
		StringBuilder answer = new StringBuilder();

		// SQL query to get customer by custkey
		String sql = "SELECT * FROM c WHERE c.c_custkey = " + custkey;
		CosmosPagedIterable<Customer> response = customerContainer.queryItems(sql, new CosmosQueryRequestOptions(),
				Customer.class);
		if (response.iterator().hasNext()) {
			Customer customer = response.iterator().next();
			answer.append(new Gson().toJson(customer).toString());
		}

		// Print out json response and return it to calling function
		System.out.println(answer.toString());
		return answer.toString();
	}

	/**
	 * Sample query returns order by orderkey
	 * 
	 * @throws Exception
	 *                   if an error occurs
	 */
	public String query1(int orderkey) throws Exception {
		// TODO: Write query #1
		System.out.println("\nExecuting query1.");
		StringBuilder answer = new StringBuilder();

		// Print out json response and return it to calling function
		System.out.println(answer.toString());
		return answer.toString();
	}

	/**
	 * Query returns number of customers in each market segment
	 * 
	 * @throws Exception
	 *                   if an error occurs
	 */
	public String query2() throws Exception {
		// TODO: Write query #2
		System.out.println("\nExecuting query2.");
		String jsonCustomerReport = "";

		// Print out json response and return it to calling function
		System.out.println(jsonCustomerReport);
		return jsonCustomerReport;
	}

	/**
	 * Query returns all urgent orders placed on or before July, 26, 1998 ordered by
	 * total price descending
	 * 
	 * @throws Exception
	 *                   if an error occurs
	 */
	public String query3() throws Exception {
		// TODO: Write query #3
		System.out.println("\nExecuting query3.");
		String jsonOrders = "";

		// Print out json response and return it to calling function
		System.out.println(jsonOrders);
		return jsonOrders;
	}

	/**
	 * Query returns a customer and all orders by custkey
	 * 
	 * @throws Exception
	 *                   if an error occurs
	 */
	public String query4(int custkey) throws Exception {
		// TODO: Write query #4
		System.out.println("\nExecuting query4.");
		String jsonCustOrder = "";

		// Print out json response and return it to calling function
		System.out.println(jsonCustOrder);
		return jsonCustOrder;
	}
}