package com.aurionpro.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ScmApp {

	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;

	Scanner scanner = new Scanner(System.in);

	public void connectToScmDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/organizationscmdb", "root", "root");
			statement = connection.createStatement();
			System.out.println("Connection is successful.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void query1() {
		String query1 = "select p.productid, p.name, p.description, p.supplierid, s.name from products p left join suppliers s on p.supplierid = s.supplierid";

		try {
			preparedStatement = connection.prepareStatement(query1);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int productId = resultSet.getInt("productid");
				String productName = resultSet.getString("p.name");
				String description = resultSet.getString("description");
				int supplierId = resultSet.getInt("supplierid");
				String supplierName = resultSet.getString("s.name");

				System.out.println(
						productId + "\t " + productName + "\t" + description + "\t" + supplierId + "\t" + supplierName);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void query2() {
		String query2 = "select o.orderid, o.orderdate, o.supplierid, od.orderdetailid, od.quantity, od.price, od.productid, p.name from orders o left join orderdetails od on o.orderid = od.orderid left join products p on od.productid = p.productid";

		try {
			preparedStatement = connection.prepareStatement(query2);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int orderId = resultSet.getInt("orderid");
				Date OrderDate = resultSet.getDate("orderdate");
				int supplierId = resultSet.getInt("supplierid");
				int orderDetailId = resultSet.getInt("orderdetailid");
				int quantity = resultSet.getInt("quantity");
				double price = resultSet.getDouble("price");
				int productId = resultSet.getInt("productid");
				String productName = resultSet.getString("name");

				System.out.println(orderId + "\t " + OrderDate + "\t" + supplierId + "\t" + orderDetailId + "\t"
						+ quantity + "\t" + price + "\t" + productId + "\t" + productName);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void query3() {
		String query3 = "select distinct s.supplierid, s.name, p.productid from suppliers s join products p on s.supplierid = p.supplierid where p.productid = 1";

		try {
			preparedStatement = connection.prepareStatement(query3);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int supplierId = resultSet.getInt("supplierid");
				String supplierName = resultSet.getString("name");
				int productId = resultSet.getInt("productid");

				System.out.println(supplierId + "\t" + supplierName + "\t" + productId);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void query4() {
		String query4 = "select p.productid, p.name, p.description, p.supplierid, i.inventoryid, i.quantityonhand from products p left join inventory i on p.productid = i.productid";

		try {
			preparedStatement = connection.prepareStatement(query4);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int productId = resultSet.getInt("productid");
				String productName = resultSet.getString("name");
				String description = resultSet.getString("description");
				int supplierId = resultSet.getInt("supplierid");
				int inventoryId = resultSet.getInt("inventoryid");
				int quantityOnHand = resultSet.getInt("quantityonhand");

				System.out.println(productId + "\t" + productName + "\t" + description + "\t" + supplierId + "\t"
						+ inventoryId + "\t" + quantityOnHand);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void query5() {
		String query5 = "select * from orders where month(orderdate) = month(curdate()) - 1";

		try {
			preparedStatement = connection.prepareStatement(query5);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int orderId = resultSet.getInt("orderid");
				Date orderDate = resultSet.getDate("orderdate");
				int supplierId = resultSet.getInt("supplierId");

				System.out.println(orderId + "\t" + orderDate + "\t" + supplierId);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void query6() {
		String query6 = "select productid, sum(quantity) as totalquantity from orderdetails group by productid";

		try {
			preparedStatement = connection.prepareStatement(query6);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int productId = resultSet.getInt("productid");
				int totalQuantity = resultSet.getInt("totalquantity");

				System.out.println(productId + "\t" + totalQuantity);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void query7() {
		String query7 = "select od.orderid, sum(od.quantity * od.price) as totalamount from orders o inner join orderdetails od on o.orderid = od.orderid group by od.orderid";

		try {
			preparedStatement = connection.prepareStatement(query7);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int orderId = resultSet.getInt("orderid");
				double totalAmount = resultSet.getDouble("totalamount");

				System.out.println(orderId + "\t" + totalAmount);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void query8() {
		String query8 = "select productid, name from products group by productid having count(distinct supplierid) > 1";

		try {
			preparedStatement = connection.prepareStatement(query8);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int productId = resultSet.getInt("productid");
				String productName = resultSet.getString("name");

				System.out.println(productId + "\t" + productName);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void query9() {
		String query9 = "select p.productid, p.name, avg(i.quantityonhand) as averageinventorylevel from products p join inventory i on p.productid = i.productid group by p.productid";

		try {
			preparedStatement = connection.prepareStatement(query9);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int productId = resultSet.getInt("productid");
				String productName = resultSet.getString("name");
				double averageInventoryLevel = resultSet.getDouble("averageinventorylevel");

				System.out.println(productId + "\t" + productName + "\t" + averageInventoryLevel);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void query10() {
		String query10 = "select s.supplierid, s.name, p.productid from suppliers s left join products p on s.supplierid = p.supplierid where p.productid is null";

		try {
			preparedStatement = connection.prepareStatement(query10);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int supplierId = resultSet.getInt("supplierid");
				String supplierName = resultSet.getString("name");
				int productId = resultSet.getInt("productid");

				System.out.println(supplierId + "\t" + supplierName + "\t" + productId);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertIntoSupplier() {
		System.out.println("Enter Supplier Details : ");
		System.out.println("Enter Supplier ID: ");
		int supplierId = scanner.nextInt();
		System.out.println("Enter Supplier Name: ");
		String name = scanner.next();
		scanner.nextLine();
		System.out.println("Enter Contact Info: ");
		String contactInfo = scanner.next();
		scanner.nextLine();
		System.out.println("Enter Address: ");
		String address = scanner.next();
		System.out.println();

		String query = "INSERT INTO suppliers (supplierid, name, contactinfo, address) VALUES (?, ?, ?, ?)";

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, supplierId);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, contactInfo);
			preparedStatement.setString(4, address);
			preparedStatement.executeUpdate();
			System.out.println("Supplier inserted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertIntoProduct() {
		System.out.println("Enter Product ID: ");
		int productId = scanner.nextInt();
		System.out.println("Enter Product Name: ");
		String name = scanner.next();
		scanner.nextLine();
		System.out.println("Enter Product Description: ");
		String description = scanner.next();
		scanner.nextLine();
		System.out.println("Enter Supplier ID: ");
		int supplierId = scanner.nextInt();

		String query = "INSERT INTO products (productid, name, description, supplierid) VALUES (?, ?, ?, ?)";

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, productId);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, description);
			preparedStatement.setInt(4, supplierId);
			preparedStatement.executeUpdate();
			System.out.println("Product inserted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void insertIntoOrder() {
		System.out.println("Enter Order ID: ");
		int orderId = scanner.nextInt();
		System.out.println("Enter Order Date (YYYY-MM-DD): ");
		String orderDate = scanner.next();
		scanner.nextLine();
		System.out.println("Enter Supplier ID: ");
		int supplierId = scanner.nextInt();

		String query = "INSERT INTO orders (orderid, orderdate, supplierid) VALUES (?, ?, ?)";

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, orderId);
			preparedStatement.setString(2, orderDate);
			preparedStatement.setInt(3, supplierId);
			preparedStatement.executeUpdate();
			System.out.println("Orders inserted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertIntoOrderDetail() {
		System.out.println("Enter Order Detail ID: ");
		int orderDetailId = scanner.nextInt();
		System.out.println("Enter Order ID: ");
		int orderId = scanner.nextInt();
		System.out.println("Enter Product ID: ");
		int productId = scanner.nextInt();
		System.out.println("Enter Quantity: ");
		int quantity = scanner.nextInt();
		System.out.println("Enter Price: ");
		double price = scanner.nextDouble();

		String query = "INSERT INTO orderdetails (orderdetailid, orderid, productid, quantity, price) VALUES (?, ?, ?, ?, ?)";

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, orderDetailId);
			preparedStatement.setInt(2, orderId);
			preparedStatement.setInt(3, productId);
			preparedStatement.setInt(4, quantity);
			preparedStatement.setDouble(5, price);
			preparedStatement.executeUpdate();
			System.out.println("Order Detail inserted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertIntoInventory() {
		System.out.println("Enter Inventory ID: ");
		int inventoryId = scanner.nextInt();
		System.out.println("Enter Product ID: ");
		int productId = scanner.nextInt();
		System.out.println("Enter Quantity on Hand: ");
		int quantityOnHand = scanner.nextInt();

		String query = "INSERT INTO inventory (inventoryid, productid, quantityonhand) VALUES (?, ?, ?)";

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, inventoryId);
			preparedStatement.setInt(2, productId);
			preparedStatement.setInt(3, quantityOnHand);
			preparedStatement.executeUpdate();
			System.out.println("Inventory inserted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getSuppliers() {
		String query = "SELECT * FROM suppliers";

		try {
			preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int supplierId = resultSet.getInt("supplierid");
				String name = resultSet.getString("name");
				String contactInfo = resultSet.getString("contactinfo");
				String address = resultSet.getString("address");

				System.out.println(supplierId + "\t" + name + "\t" + contactInfo + "\t" + address);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getProducts() {
		String query = "SELECT * FROM products";

		try {
			preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int productId = resultSet.getInt("productid");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				int supplierId = resultSet.getInt("supplierid");

				System.out.println(productId + "\t" + name + "\t" + description + "\t" + supplierId);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getOrders() {
		String query = "SELECT * FROM orders";

		try {
			preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int orderId = resultSet.getInt("orderid");
				String orderDate = resultSet.getString("orderdate");
				int supplierId = resultSet.getInt("supplierid");

				System.out.println(orderId + "\t" + orderDate + "\t" + supplierId);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getOrderDetails() {
		String query = "SELECT * FROM orderdetails";

		try {
			preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int orderDetailId = resultSet.getInt("orderdetailid");
				int orderId = resultSet.getInt("orderid");
				int productId = resultSet.getInt("productid");
				int quantity = resultSet.getInt("quantity");
				double price = resultSet.getDouble("price");

				System.out.println(orderDetailId + "\t" + orderId + "\t" + productId + "\t" + quantity + "\t" + price);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getInventory() {
		String query = "SELECT * FROM inventory";

		try {
			preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int inventoryId = resultSet.getInt("inventoryid");
				int productId = resultSet.getInt("productid");
				int quantityOnHand = resultSet.getInt("quantityonhand");

				System.out.println(inventoryId + "\t" + productId + "\t" + quantityOnHand);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void displayMenu() {
		boolean display = true;

		while (display) {
			System.out.println("Main Menu:");
			System.out.println("1. Execute Queries");
			System.out.println("2. Insert Data");
			System.out.println("3. Fetch Data");
			System.out.println("4. Exit");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				queryMenu();
				break;
			case 2:
				insertMenu();
				break;
			case 3:
				fetchMenu();
				break;
			case 4:
				display = false;
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}

		scanner.close();
	}

	private void queryMenu() {
		System.out.println("Query Menu:");
		System.out.println("1. Query 1");
		System.out.println("2. Query 2");
		System.out.println("3. Query 3");
		System.out.println("4. Query 4");
		System.out.println("5. Query 5");
		System.out.println("6. Query 6");
		System.out.println("7. Query 7");
		System.out.println("8. Query 8");
		System.out.println("9. Query 9");
		System.out.println("10. Query 10");
		System.out.println("11. Back to Main Menu");

		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			query1();
			break;
		case 2:
			query2();
			break;
		case 3:
			query3();
			break;
		case 4:
			query4();
			break;
		case 5:
			query5();
			break;
		case 6:
			query6();
			break;
		case 7:
			query7();
			break;
		case 8:
			query8();
			break;
		case 9:
			query9();
			break;
		case 10:
			query10();
			break;
		case 11:
			return;
		default:
			System.out.println("Invalid choice.");
		}
	}

	private void insertMenu() {
		System.out.println("Insert Menu:");
		System.out.println("1. Insert Supplier");
		System.out.println("2. Insert Product");
		System.out.println("3. Insert Order");
		System.out.println("4. Insert Order Detail");
		System.out.println("5. Insert Inventory");
		System.out.println("6. Back to Main Menu");

		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			insertIntoSupplier();
			break;
		case 2:
			insertIntoProduct();
			break;
		case 3:
			insertIntoOrder();
			break;
		case 4:
			insertIntoOrderDetail();
			break;
		case 5:
			insertIntoInventory();
			break;
		case 6:
			return;
		default:
			System.out.println("Invalid choice.");
		}
	}

	private void fetchMenu() {
		System.out.println("Fetch Menu:");
		System.out.println("1. Get Suppliers");
		System.out.println("2. Get Products");
		System.out.println("3. Get Orders");
		System.out.println("4. Get Order Details");
		System.out.println("5. Get Inventory");
		System.out.println("6. Back to Main Menu");

		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			getSuppliers();
			break;
		case 2:
			getProducts();
			break;
		case 3:
			getOrders();
			break;
		case 4:
			getOrderDetails();
			break;
		case 5:
			getInventory();
			break;
		case 6:
			return;
		default:
			System.out.println("Invalid choice.");
		}
	}
}
