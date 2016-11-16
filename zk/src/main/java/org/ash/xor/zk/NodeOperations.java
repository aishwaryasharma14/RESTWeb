package org.ash.xor.zk;

import java.io.IOException;
import java.util.Scanner;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class NodeOperations {

	public static ZooKeeper zk; // creates a zookeeper class object
	public static ZooKeeperConnection zconn; // creates a connection object
	static String path;

	public static void createNode(String path, byte[] data) {
		try {
			zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteNode(String path) {
		try {
			zk.delete(path, zk.exists(path, true).getVersion());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateNode(String path, byte[] data){
		try {
			zk.setData(path, data, zk.exists(path, true).getVersion());
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {

		zconn = new ZooKeeperConnection();
		try {
			zk = zconn.connect("localhost");
			System.out.println("Connection Established!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the path to perform operations: ");
		path = "/" + sc.next();

		while (true) {

			System.out.println("Enter 1. Create 2.Delete 3.Update 4.Exit");
			int choice = sc.nextInt();
			
			
			if (choice == 1) {
				System.out.println("Enter the data to create the node : ");
				byte[] data = sc.next().getBytes();
				createNode(path, data);
				System.out.println("Node " + path.substring(1) + " created successfully!");
			} else if (choice == 2) {
				deleteNode(path);
				System.out.println("Node " + path.substring(1) + " deleted successfully!");
			} else if (choice == 3) {
				System.out.println("Enter to update the data");
				byte[] data = sc.next().getBytes();
				updateNode(path, data);
				System.out.println("Data updated successfully!");
			} else if (choice == 4){
				break;
			}

		}
		System.out.println("Thanks!");
	}
}
